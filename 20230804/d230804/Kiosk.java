package d230804;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import d230804.DeliveryOrder.OnDelivery;
import d230804.HereOrder.OnHere;
import d230804.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private int inventory;
	List<Menu> menuArray = new ArrayList<Menu>();
	Queue<Order> waitqueue = new LinkedList<Order>();
	
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}
	
	public Order initOder(List<Menu> menuArray, int orderType) throws KioskException{

		if (isInventory(menuArray.size())) {
			if (orderType == 1) {
				DeliveryOrder order = new DeliveryOrder(menuArray);
				order.setOnDelivery(this);
				return order;
			} else if (orderType == 2){
				TakeoutOrder order = new TakeoutOrder(menuArray);
				order.setOnTakeout(this);
				return order;
			} else {
				HereOrder order = new HereOrder(menuArray);
				order.setOnHere(this);
				return order;
			}
		} else {
			System.out.println("��� �����մϴ�.");
			throw new KioskException("error code", 101);
		}
	}
	
	private boolean isInventory(int count) {
		if (inventory >= count) {
			return true;
		} else {
			return false;
		}
	}
		
	public void subInventory(int count) {
		inventory -= count;
	}
	
	@Override
	public void successDelivery(String locate, List<Menu> menuArray) {
		System.out.println(locate + " �ּҷ� ��� �ֹ��� �Ϸ� �Ǿ����ϴ�.");
		System.out.print("�ֹ� ����: ");
		for(Menu menu: menuArray) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		subInventory(menuArray.size());
	}
	
	@Override
	public void successHere(int change, int orderNum, List<Menu> menuArray) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(orderNum+ "�� �ֹ���ȣ�� �ֹ� �Ϸ�Ǿ����ϴ�. ");
		System.out.print("�ֹ� ����: ");
		for(Menu menu: menuArray) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		subInventory(menuArray.size());
	}
	
	@Override
	public void successTakeout(int change, int time, List<Menu> menuArray) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(time+ " ���� �����ֹ� �Ϸ�Ǿ����ϴ�.");
		System.out.print("�ֹ� ����: ");
		for(Menu menu: menuArray) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		subInventory(menuArray.size());
	}
	
}
