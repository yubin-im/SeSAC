// 20230727
package d230727;

public class Kiosk {
	public final static int KEY = 3;
	private int stock;  // �����
	
	// ������
	public Kiosk(int stock) {
		this.stock = stock;
	}
	
	public boolean isInventory(int order) {
		boolean isinventory;
		
		if (this.stock > order) {
			isinventory = true;
		} else {
			isinventory = false;
		}
		return isinventory;
	}
	
	public void subInventory(int order) {
		this.stock = this.stock - order;
	}
	
	public Order initOrder(String menu, int order) {
		int menu_price = 0;
		
		if (menu.equals("������Ʈ")) {
			menu_price = 4500;
		} else if (menu.equals("��ũƼ") || menu.equals("ī���")) {
			menu_price = 3500;
		} else if (menu.equals("�Ƹ޸�ī��")) {
			menu_price = 2000;
		} else {
			System.out.println("�޴��� �����ϴ�");
			return null;
		}
		
		if (menu_price > 0) {
			subInventory(order);
		}
		
		Order order1 = new Order(menu, order, menu_price);
		
		return order1;
	}

}
