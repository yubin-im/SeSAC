package d230804;

// Ű����ũ�� �ֹ� ��⿭ �߰��ϱ�
// �ֹ��� ��������� �ֹ� ��⿭�� �߰� �ȴ�.
// �ֹ� ��⿭�� �ֹ��� 3�� �̻��̸� ���� ó�� �߰��� �ֹ��� �����ϰ� ������ ����Ѵ�.
/* ���: 00�ּҷ� ����� ���۵Ǿ����ϴ�.
 * ����: �����ֹ��Ͻ� �޴� ���Խ��ϴ�.
 * ����: 00��ȣ �ֹ� �޴� ���Խ��ϴ�.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RunKiosk {
	
	public static void main(String[] args) throws KioskException {
		Scanner scanner = new Scanner(System.in);
		String input_menu = null;		
		// WaitOrder waitOrder = new WaitOrder();
		Queue<Order> waitqueue = new LinkedList<Order>();
		
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
				//
				List<Menu> menuArray = new ArrayList<Menu>();
				
				int menuCount = 0;
				
				while (menuCount < 10) {
					System.out.println("�޴� �Ǵ� �ֹ��� �Է����ּ���");
					input_menu = scanner.next();
					
					if (input_menu.equals("�ֹ�")) {
						break;
					}	
					menuArray.add(new Menu(input_menu));
					menuCount++;
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
					
					// �ֹ� ��⿭ �߰�
					waitqueue.offer(order);
					
					if (waitqueue.size() >= 3) {	
						Order pollOrder = waitqueue.poll();
						pollOrder.outOrder();
						
					}
					
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
