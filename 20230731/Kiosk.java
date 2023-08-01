package d230731;

import d230731.DeliveryOrder.OnDelivery;
import d230731.HereOrder.OnHere;
import d230731.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private int inventory;
	
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}
	
	public Order initOder(String menu, int count, int orderType) throws KioskException{
		int price = 0;
	
		if (menu.equals("������Ʈ")){
			price = 4500;
		} else if (menu.equals("ī���") || menu.equals("��ũƼ")){
			price = 3500;
		} else if (menu.equals("�Ƹ޸�ī��")){
			price = 2000;
		} else {
			price = 0;
		}
		
		if (price == 0) {
			System.out.println("�޴��� �����ϴ�.");
			throw new KioskException("error code", 102);
		} 
	
		if (isInventory(count)) {
			if (orderType == 1) {
				DeliveryOrder order = new DeliveryOrder(menu, count, price);
				order.setOnDelivery(this);
				return order;
			} else if (orderType == 2){
				TakeoutOrder order = new TakeoutOrder(menu, count, price);
				order.setOnTakeout(this);
				return order;
			} else {
				HereOrder order = new HereOrder(menu, count, price);
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
	public void successDelivery(String locate, String menu, int count) {
		System.out.print(locate + " �ּҷ� ");
		System.out.println(menu + " ��� �ֹ��� �Ϸ� �Ǿ����ϴ�.");		
		subInventory(count);		
	}
	@Override
	public void successHere(int change, int orderNum, String menu, int count) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.print(orderNum+ " �ֹ���ȣ�� ");
		System.out.println(menu + " �ֹ� �Ϸ�Ǿ����ϴ�.");
		subInventory(count);

	}
	@Override
	public void successTakeout(int change, int time, String menu, int count) {
		System.out.println("�ܵ� "+change+"�Դϴ�. ");
		System.out.print(time+ " ���� ");
		System.out.println(menu + " �����ֹ� �Ϸ�Ǿ����ϴ�.");		
		subInventory(count);
	}
	
}
