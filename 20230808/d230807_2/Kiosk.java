package d230807_2;

// Ű����ũ Ŭ������ �� ���� �ʱ��� �߰�
// �޴� �̸��� ������ ���εǾ� �ִ� �ʱ���
// �޴� �̸��� ��� ������ ���εǾ� �ִ� �ʱ���
// �޴� �̸��� ������ �����Ͽ� Ű����ũ �����ڿ��� �ʱ�ȭ
// �޴� �̸��� ����ڰ� �Է��� ��� ������ ���� �ʱ�ȭ (Ű����ũ ������)

// Ű����ũ���� �߰��� MenuŬ������ �ν��Ͻ��� ����� ��ȯ�ϴ� �޼ҵ� ���� (���θ޼ҵ忡�� Menu �����ʱ�ȭ X)

// �ʱ����� Ȱ���Ͽ� isInventory�� subInventory �޼ҵ� ����
// �ֹ��� �ִ� �޴� ����Ʈ�� �ݺ��Ͽ� ���� üũ�ϴ� ������� ����

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
	// Ű����ũ Ŭ������ �� ���� �ʱ��� �߰�(�޴��̸��� ����, �޴��̸��� �����)
	Map<String, Integer> menuMap;
	Map<String, Integer> invenMap;
	
	// �޴� �̸��� ����ڰ� �Է��� ��� ������ ���� �ʱ�ȭ (Ű����ũ ������)
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
	
	// MenuŬ������ �ν��Ͻ��� ����� ��ȯ�ϴ� �޼ҵ� ����
	public int getPrice(String name, int count) throws KisokException{
		Menu menu = new Menu(name, count);
		return menu.price;
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

	public void offerOrder(Order order) {
		orderQ.offerLast(order);
	}
	
	public void outOrder() {
		if (orderQ.size() >= 3) {
			Order order = orderQ.pollFirst();
			order.outOrder();
		}
	}
	
	// �ʱ����� Ȱ���Ͽ� isInventory�� subInventory �޼ҵ� ����
	public void subInventory(List<Menu> menus) {
		for (Menu m: menus) {
			int inv = invenMap.get(m.name);
			invenMap.replace(m.name, inv - m.count);
		}
		
		System.out.print("���� ����Ȳ: ");
		System.out.println(invenMap.toString());
		
	}
	
	// �ֹ��� �ִ� �޴� ����Ʈ�� �ݺ��Ͽ� ���� üũ�ϴ� ������� ����
	private boolean isInventory(List<Menu> menus) {
		for (Menu m: menus) {
			int inv = invenMap.get(m.name);
			if (inv < m.count) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void successDelivery(String locate, List<Menu> menus) {
		System.out.println(locate + " �ּҷ� ��� �ֹ��� �Ϸ� �Ǿ����ϴ�.");
		System.out.print("�ֹ� ����--------------\n");
		for (Menu m: menus) {
			System.out.println(m.name + " " + m.count + "��");
		}
		System.out.println("---------------------");
		subInventory(menus);		
	}
	@Override
	public void successHere(int change, int orderNum, List<Menu> menus) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(orderNum+ " �ֹ���ȣ�� �ֹ� �Ϸ�Ǿ����ϴ�.");
		System.out.print("�ֹ� ����--------------\n");
		for (Menu m: menus) {
			System.out.println(m.name + " " + m.count + "��");
		}
		System.out.println("---------------------");
		subInventory(menus);		
	}
	@Override
	public void successTakeout(int change, int time, List<Menu> menus) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(time+ " ���� �����ֹ� �Ϸ�Ǿ����ϴ�.");
		System.out.print("�ֹ� ����--------------\n");
		for (Menu m: menus) {
			System.out.println(m.name + " " + m.count + "��");
		}
		System.out.println("---------------------");
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