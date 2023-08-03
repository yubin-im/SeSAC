package d230803_2;

// �ǽ��� Ű����ũ�� Menu �迭�� Menu ����Ʈ�� �����ϱ�

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunKiosk {
	
	public static void main(String[] args) throws KioskException {
		Scanner scanner = new Scanner(System.in);
		String input_menu = null;
		
		System.out.println("Ű����ũ Ű�� �Է����ּ���(3)");
		int key = scanner.nextInt();
		
		if (Kiosk.key == key) {
			System.out.println("������� �Է����ּ���");
			int inventory = scanner.nextInt();
			Kiosk kiosk = new Kiosk(inventory);
			
			while (true) {
				System.out.println("1.��� 2.���� 3.���� 4.���� �ֹ���� ��ȣ�� �Է����ּ���");
				int orderType = scanner.nextInt();
				
				if (orderType == 4) {
					System.out.println("���α׷��� ���� �մϴ�.");
					break;
				}
				List<Menu> menuArray = new ArrayList<Menu>();
				
				int count = 0;
				
				while (count < 10) {
					System.out.println("�޴� �Ǵ� �ֹ��� �Է����ּ���");
					input_menu = scanner.next();
					
					if (input_menu.equals("�ֹ�")) {
						break;
					}	
					menuArray.add(new Menu(input_menu));
					count++;
				}
					
				try {
					Order order = kiosk.initOder(menuArray, orderType);
					int deposit = scanner.nextInt();
					if (orderType == 1) {
						System.out.println("�ּҸ� �Է����ּ���");
						String locate = scanner.next();
						((DeliveryOrder) order).setLocate(locate);
					} else if (orderType == 2) {
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
					System.out.println("error code: " + e.code);
				}	
			}
		} else {
			System.out.println("Ű����ũ Ű�� ���� �ʽ��ϴ�.");
		}
		scanner.close();
	}
}
