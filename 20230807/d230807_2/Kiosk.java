package d230807_2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import d230807_2.DeliveryOrder.OnDelivery;
import d230807_2.HereOrder.OnHere;
import d230807_2.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private int inventory;
	private Deque<Order> orderQ;
	Map<String, Integer> menuMap;
	Map<String, Integer> invenMap;

	public Kiosk(int inventory) {
		this.inventory = inventory;
		orderQ = new LinkedList<Order>();
		menuMap = new HashMap<String, Integer>();
		invenMap = new HashMap<String, Integer>();
		
		invenMap.put("������Ʈ", inventory);
		invenMap.put("ī���", inventory);
		invenMap.put("��ũƼ", inventory);
		invenMap.put("�Ƹ޸�ī��", inventory);
	}
	
	public Order initOder(List<Menu> menus, int orderType) throws KisokException {
	
		if (isInventory(menus.size())) {
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

	public void offerOrder(Order order) {
		orderQ.offerLast(order);
	}
	
	public void outOrder() {
		if (orderQ.size() >= 3) {
			Order order = orderQ.pollFirst();
			order.outOrder();
		}
	}
	
	public void subInventory(int count) {
		inventory -= count;
	}
	
	private boolean isInventory(int count) {

		if (inventory >= count) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void successDelivery(String locate, List<Menu> menus) {
		System.out.println(locate + " �ּҷ� ��� �ֹ��� �Ϸ� �Ǿ����ϴ�.");
		System.out.print("�ֹ� ���� : ");
		for (Menu m : menus) {
			System.out.print(m.name + " ");
		}
		System.out.println("");
		subInventory(menus.size());		
	}
	@Override
	public void successHere(int change, int orderNum, List<Menu> menus) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(orderNum+ " �ֹ���ȣ�� �ֹ� �Ϸ�Ǿ����ϴ�.");
		System.out.print("�ֹ� ���� : ");
		for (Menu m : menus) {
			System.out.print(m.name + " ");
		}
		System.out.println("");
		subInventory(menus.size());		
	}
	@Override
	public void successTakeout(int change, int time, List<Menu> menus) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(time+ " ���� �����ֹ� �Ϸ�Ǿ����ϴ�.");
		System.out.print("�ֹ� ���� : ");
		for (Menu m : menus) {
			System.out.print(m.name + " ");
		}
		System.out.println("");
		subInventory(menus.size());	
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