// 20230726
// �ǽ�3: ��Ͽ� �ִ� ���Ḧ �Է��ϸ� �ش� ������ ������ ��µ˴ϴ�.
package d230726;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// ���� ����
		int sy = 4500;
		int mt = 3500;
		int cl = 3500;
		int ia = 2000;
		
		System.out.print("���� �޴� �Է�: ");
		String menu = scanner.next();
		
		if (menu.equals("������Ʈ")) {
			System.out.print(menu + "�� " + sy + "���Դϴ�");
			int money = scanner.nextInt();
			if (money >= sy) {
				System.out.println("�ܵ� " + (money - sy) + "���Դϴ�");
				} else {
					System.out.println("�ݾ��� �����մϴ�");
				}
		} else if (menu.equals("��ũƼ")) {
			System.out.print(menu + "�� " + mt + "���Դϴ�");
			int money = scanner.nextInt();
			if (money >= mt) {
				System.out.println("�ܵ� " + (money - mt) + "���Դϴ�");
				} else {
					System.out.println("�ݾ��� �����մϴ�");
				}
		} else if (menu.equals("ī���")) {
			System.out.print(menu + "�� " + cl + "���Դϴ�");
			int money = scanner.nextInt();
			if (money >= cl) {
				System.out.println("�ܵ� " + (money - cl) + "���Դϴ�");
				} else {
					System.out.println("�ݾ��� �����մϴ�");
				}
		} else if (menu.equals("�Ƹ޸�ī��")) {
			System.out.print(menu + "�� " + ia + "���Դϴ�");
			int money = scanner.nextInt();
			if (money >= ia) {
				System.out.println("�ܵ� " + (money - ia) + "���Դϴ�");
				} else {
					System.out.println("�ݾ��� �����մϴ�");
				}
		} else {
			System.out.println("�޴��� �����ϴ�");
		}
		scanner.close();
	}
}
