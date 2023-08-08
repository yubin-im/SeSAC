package d230807_2;

// Ű����ũ �ǽ��� �ʱ��� �߰�

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunKiosk {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ű����ũ Ű�� �Է����ּ���");
		int key = scanner.nextInt();
		
		if (Kiosk.key == key) {
			System.out.println("������� �Է����ּ���");
			int inventory = scanner.nextInt();
			
			Kiosk kiosk = new Kiosk(inventory);
			while (true) {
				try {
					System.out.println("1.��� 2.���� 3.���� 4.���� �ֹ���� ��ȣ�� �Է����ּ���");
					int orderCode = scanner.nextInt();
					if (orderCode == 4) {
						System.out.println("���α׷��� ���� �մϴ�.");
						break; 
					}
					
					List<Menu> menus = new ArrayList<Menu>();
					while (true) {
						System.out.println("<�޴� ����> �Ǵ� <�ֹ�>�� �Է����ּ���");
						String menu = scanner.next();
						if (menu.equals("�ֹ�")) {
							break;
						}
						int count = scanner.nextInt();
						menus.add(new Menu(menu, count));
					}
					
					Order order = kiosk.initOder(menus,
							orderCode);
					
					int deposit = scanner.nextInt();
					if (order.orderType == 1) {
						System.out.println("�ּҸ� �Է����ּ���");
						String locate = scanner.next();
						((DeliveryOrder) order).setLocate(locate);
					} else if (order.orderType == 2) {
						System.out.println("����ð��� �Է����ּ���");
						int time = scanner.nextInt();
						((TakeoutOrder) order).setTime(time);
					} else {
						System.out.println("�ֹ���ȣ�� �Է����ּ���");
						int orderNum = scanner.nextInt();
						((HereOrder) order).setOrderNum(orderNum);
					}
					order.runOrder(deposit);
					kiosk.offerOrder(order);
					kiosk.outOrder();
				} catch (KisokException e) {
					System.out.println("error code: " + e.code);
				}
			}
			
		} else {
			System.out.println("Ű����ũ Ű�� ���� �ʽ��ϴ�.");
		}

		scanner.close();
	}

}