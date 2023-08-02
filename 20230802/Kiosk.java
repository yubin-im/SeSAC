package d230802;

import d230802.DeliveryOrder.OnDelivery;
import d230802.HereOrder.OnHere;
import d230802.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private int inventory;
	
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}
	
	public Order initOder(Menu[] menuArray, int orderType) throws KioskException{

		if (isInventory(menuArray.length)) {
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
	public void successDelivery(String locate, Menu[] menus) {
		System.out.println(locate + " �ּҷ� ��� �ֹ��� �Ϸ� �Ǿ����ϴ�.");
		System.out.println("�ֹ� ����: ");
		for(Menu menu: menus) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		// subInventory(count);		
	}
	@Override
	public void successHere(int change, int orderNum, Menu[] menus) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(orderNum+ "�� �ֹ���ȣ�� �ֹ� �Ϸ�Ǿ����ϴ�. ");
		System.out.println("�ֹ� ����: ");
		for(Menu menu: menus) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		// subInventory(count);

	}
	@Override
	public void successTakeout(int change, int time, Menu[] menus) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.println(time+ " ���� �����ֹ� �Ϸ�Ǿ����ϴ�.");
		System.out.println("�ֹ� ����: ");
		for(Menu menu: menus) {
			System.out.print(menu.menu + " ");
		}
		System.out.println("");
		// subInventory(count);
	}
	
}
