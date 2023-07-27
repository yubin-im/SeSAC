// 20230727
package d230727;

import java.util.Scanner;

public class Kiosk_main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Ű����ũ Ű�� �Է����ּ���");
		int key = scanner.nextInt();
		
		if(Kiosk.KEY == key) {
			System.out.println("���� ������� �Է����ּ���");
			int stock = scanner.nextInt();
			
			while (true) {
				System.out.println("�޴��� ������ �Է����ּ���");
				String menu = scanner.next();
				if (menu.equals("����")) {
					System.out.println("���α׷� ����");
					break;
				}
				int order = scanner.nextInt();
				
				Kiosk kiosk = new Kiosk(stock);
				
				if (kiosk.isInventory(order) == true) {
					Order order1 = kiosk.initOrder(menu, order);
					if (order1 != null) {
						System.out.println(order1.getOrderPrice() + "�� �Դϴ�");
						
						int deposit = scanner.nextInt();
						
						if (order1.runOrder(deposit) == true) {
							int change = deposit - order1.getOrderPrice();
							System.out.print("�ܵ� " + change + "�� ");
							System.out.println(menu + " ���Խ��ϴ�.");
							}
					} else if (order1 == null){
						continue;
						}
				} else {
					System.out.println("��� �����մϴ�.");
				}

			}	
			
		}
		scanner.close();

	}

}
