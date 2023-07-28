package d230728;

import java.util.Scanner;

public class RunKiosk {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int deposit = 0;
		
		System.out.println("������� �Է����ּ���");
		int inventory = scanner.nextInt();
		Kiosk kiosk = new Kiosk(inventory);
		
		while (true) {
			System.out.println("1.��� 2.���� 3.���� �ֹ���� ��ȣ�� �Է����ּ���");
			int orderWay = scanner.nextInt();
			
			System.out.println("�޴��� ������ �Է����ּ���");
			String menu = scanner.next();
			int count = scanner.nextInt();
			
			if (kiosk.isInventory(count) == true) {
				Order order = kiosk.initOrder(menu, count);
				int orderPrice = order.orderPrice;
				
				if (order != null) {
					if (orderWay == 1) {
						DeliveryOrder dO = new DeliveryOrder(menu, count, orderPrice);
						//dO.setOrderPrice(orderPrice);
						deposit = scanner.nextInt();
						
						System.out.println("�ּҸ� �Է����ּ���");
						String address = scanner.next();
						dO.setLocate(address);

					} else if (orderWay == 2) {
						TakeoutOrder tO = new TakeoutOrder(menu, count, orderPrice);
						//tO.setOrderPrice(orderPrice);
						deposit = scanner.nextInt();
						
						if (order.runOrder(deposit) == true) {
							System.out.println("����ð��� �Է����ּ���");
							int time = scanner.nextInt();
							
							System.out.println("�ܵ� " + (deposit - (orderPrice-500)) + "�Դϴ�.");
							tO.setTime(time);
							
							System.out.println("�ֹ���ȣ�� �Է����ּ���");
							int orderNum = scanner.nextInt();
							tO.runOrder(orderNum);
						}
							
					} else if (orderWay == 3) {
						System.out.println(orderPrice + "�� �Դϴ�.");
						deposit = scanner.nextInt();
						
						System.out.println("�ֹ���ȣ�� �Է����ּ���");
						int orderNum = scanner.nextInt();
						
						HereOrder hO = new HereOrder(menu, count, orderPrice);
						if (order.runOrder(deposit) == true) {
							System.out.println("�ܵ� " + (deposit - order.getOrderPrice()) + "�Դϴ�.");
							hO.setOrderNum(orderNum);
						}
					}
				}
			} else {
				System.out.println("��� �����մϴ�.");
			}
		}
	}
}
