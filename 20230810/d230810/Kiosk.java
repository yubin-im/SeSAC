package d230810;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import d230810.DeliveryOrder.OnDelivery;
import d230810.HereOrder.OnHere;
import d230810.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private Deque<Order> orderQ;
	private Map<String,Integer> menuPriceMap;
	private Map<String,Integer> inventoryMap;

	
	public Kiosk(int inventory) {
		orderQ = new ConcurrentLinkedDeque<Order>();
		menuPriceMap = new HashMap<String, Integer>();
		inventoryMap = new HashMap<String, Integer>();
		
		menuPriceMap.put("������Ʈ", 4500);
		menuPriceMap.put("��ũƼ", 3500);
		menuPriceMap.put("ī���", 3500);
		menuPriceMap.put("�Ƹ޸�ī��", 2000);

		inventoryMap.put("������Ʈ", inventory);
		inventoryMap.put("��ũƼ", inventory);
		inventoryMap.put("ī���", inventory);
		inventoryMap.put("�Ƹ޸�ī��", inventory);
		
	}

	public void offerOrder(Order order) {
		orderQ.offerLast(order);
	}
	
	public Deque<Order> getOrderQ() {
		return orderQ;
	}

	public Menu getMenu(String name, int count) throws KisokException {
		if (menuPriceMap.containsKey(name)) {
			return new Menu(name, menuPriceMap.get(name), count);
		} else {
			throw new KisokException(101);
		}
	}
	
	public void subInventory(List<Menu> menus) {
		for (Menu m : menus) {
			int inv = inventoryMap.get(m.name);
			inventoryMap.replace(m.name, inv-m.count);
		}
		
		System.out.print("���� ����Ȳ: ");
		System.out.println(inventoryMap.toString());
	}
	
	private boolean isInventory(List<Menu> menus) {
		for (Menu m : menus) {
			int inv = inventoryMap.get(m.name);
			if (inv < m.count ) {
				return false;
			}
		}
		return true;
	}
	
	public Order initOder(List<Menu> menus, int orderType) throws KisokException {
	
		if (isInventory(menus)) {
			if (orderType == 1) {
				DeliveryOrder order = new DeliveryOrder(menus);
				order.setOnDelivery(this);
				return order;
			} else if (orderType == 2){
				TakeoutOrder order = new TakeoutOrder(menus);
				order.setOnTakeout(this);
				return order;
			} else {
				HereOrder order = new HereOrder(menus);
				order.setOnHere(this);
				return order;
			}
		} else {
			System.out.println("��� �����մϴ�.");
			throw new KisokException(102);
		}
	}
	
	@Override
	public void successDelivery(String locate, List<Menu> menus) {
		System.out.println(locate + " �ּҷ� ��� �ֹ��� �Ϸ� �Ǿ����ϴ�.");
		System.out.println("�ֹ� ����----------------- ");
		for (Menu m : menus) {
			System.out.println(m.name + " " + m.count + "��");
		}
		System.out.println("------------------------");
		subInventory(menus);		
	}
	@Override
	public void successHere(int change, int orderNum, List<Menu> menus) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(orderNum+ " �ֹ���ȣ�� �ֹ� �Ϸ�Ǿ����ϴ�.");
		System.out.println("�ֹ� ����----------------- ");
		for (Menu m : menus) {
			System.out.println(m.name + " " + m.count + "��");
		}
		System.out.println("------------------------");
		subInventory(menus);		
	}
	@Override
	public void successTakeout(int change, int time, List<Menu> menus) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(time+ " ���� �����ֹ� �Ϸ�Ǿ����ϴ�.");
		System.out.println("�ֹ� ����----------------- ");
		for (Menu m : menus) {
			System.out.println(m.name + " " + m.count + "��");
		}
		System.out.println("------------------------");
		subInventory(menus);	
	}
	
	@Override
	public void outDelivery(String locate, List<Menu> menus) {
		System.out.println("-------------------------");
		System.out.println("�ֹ� �Ͻ� "+menus.size() +"�� �޴� ");
		System.out.println(locate + " �ּҷ� ����� ���۵Ǿ����ϴ�.");
		System.out.println("-------------------------");

	}
	
	@Override
	public void outHere(int orderNum, List<Menu> menus) {
		System.out.println("-------------------------");
		System.out.println(orderNum + "�� ����");
		System.out.println("�ֹ� �Ͻ� "+menus.size() +"�� �޴� ���Խ��ϴ�.");
		System.out.println("-------------------------");
	}
	
	@Override
	public void outTakeout(int time, List<Menu> menus) {
		System.out.println("-------------------------");
		System.out.println("�ֹ� �Ͻ� "+menus.size() +"�� �޴� ");
		System.out.println(time +"�� ���� �����ֹ� ���Խ��ϴ�.");
		System.out.println("-------------------------");

	}
	
}

class KisokException extends Exception {
	public int code;
	
	public KisokException(int code) {
		 this.code = code;
	}
}