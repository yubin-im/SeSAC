// 20230726
// �ǽ�7: ������ Ű����ũ �����2
package d230726;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int price = 0;
		
		while (true) {
			System.out.println("�޴� ���� �Է�");
			
			String menu = scanner.next();			
			if (menu.equals("����")) {
				System.out.println("���α׷� ����");
				break;
			}
			int num = scanner.nextInt();
			
			if (menu.equals("������Ʈ")) {
				price = 4500 * num;
			} else if (menu.equals("��ũƼ") || menu.equals("ī���")) {
				price = 3500 * num;
			} else if (menu.equals("�Ƹ޸�ī��")) {
				price = 2000 * num;
			} else {
				System.out.println("�޴��� �����ϴ�");
				continue;
			}
			
			if (price != 0) {
				System.out.println("�Ѱ����� " + price + "���Դϴ�");
				int money = scanner.nextInt();
				int change = money - price;
				
				if (change >= 0) {
					System.out.println("�ܵ� " + change + "�� �Դϴ�");
					for(int i=1; i<=num; i++) {
						System.out.println(menu + " ���Խ��ϴ�.");
					}
				} else {
					System.out.println("�ݾ��� �����մϴ�");
				}
			}
		}
		scanner.close();
	}
}
