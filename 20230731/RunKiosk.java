package d230731;

import java.util.Scanner;

public class RunKiosk {
	
	public static void main(String[] args) throws KioskException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ű����ũ Ű�� �Է����ּ���(3)");
		int key = scanner.nextInt();

		if (Kiosk.key == key) {
			System.out.println("������� �Է����ּ���");
			int inventory = scanner.nextInt();
			Kiosk kiosk = new Kiosk(inventory);
			
			while (true) {
				System.out.println("1.��� 2.���� 3.���� �ֹ���� ��ȣ�� �Է����ּ���");
				int orderCode = scanner.nextInt();
				
				System.out.println("�޴��� ������ �Է����ּ���");
				String menu = scanner.next();
				if (menu.equals("����")) {
					System.out.println("���α׷��� ���� �մϴ�.");
					break;
				}
				int count = scanner.nextInt();

//				if (order == null) {
//					continue;
//				}
				
				try {
					Order order = kiosk.initOder(menu, count, orderCode);
					int deposit = scanner.nextInt();
					if (orderCode == 1) {
						System.out.println("�ּҸ� �Է����ּ���");
						String locate = scanner.next();
						((DeliveryOrder) order).setLocate(locate);
					} else if (orderCode == 2) {
						System.out.println("����ð��� �Է����ּ���");
						int time = scanner.nextInt();
						((TakeoutOrder) order).setTime(time);
					} else {
						System.out.println("�ֹ���ȣ�� �Է����ּ���");
						int orderNum = scanner.nextInt();
						((HereOrder) order).setOrderNum(orderNum);
					}
					order.runOrder(deposit);
				} catch (KioskException e) {
					continue;
				}	
			}
		} else {
			System.out.println("Ű����ũ Ű�� ���� �ʽ��ϴ�.");
		}
		scanner.close();
	}
}
