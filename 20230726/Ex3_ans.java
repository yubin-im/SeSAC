// 20230726
// (����)�ǽ�3: ��Ͽ� �ִ� ���Ḧ �Է��ϸ� �ش� ������ ������ ��µ˴ϴ�.
package d230726;

import java.util.Scanner;

public class Ex3_ans {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� �޴� �Է�: ");
		String menu = scanner.next();
		
		int price = 0;
		
		switch(menu) {
			case "������Ʈ":{
				price = 4500;
				break;
			}
			case "��ũƼ":
			case "ī���":{
				price = 3500;
				break;
			}
			case "�Ƹ޸�ī��":{
				price = 2000;
				break;
			}
			default:{
				System.out.println("�޴��� �����ϴ�");
			}
		}
		
		/* if�� ���
		if (menu.equals("������Ʈ")) {
			price = 4500;
		} else if (menu.equals("ī���") || menu.equals("��ũƼ")) {
			price = 3500;
		} else if (menu.equals("�Ƹ޸�ī��")) {
			price = 2000;
		} else {
			System.out.println("�޴��� �����ϴ�");
		}
		 */
		
		if(price != 0) {
			System.out.println(menu + "�� " + price + "���Դϴ�");
			int money = scanner.nextInt();
			int change = money - price;
			
			if (change >= 0) {
				System.out.println("�ܵ� " + change + "���Դϴ�");
			} else {
				System.out.println("�ݾ��� �����մϴ�");
			}
		}
		scanner.close();
	}                                                                                                                                                                                                                                                        
}
