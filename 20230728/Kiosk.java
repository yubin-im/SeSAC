package d230728;

public class Kiosk {
	protected int inventory;
	
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}
	
	public Order initOrder(String menu, int count) {
		int menuPrice = 0;
		
		if (menu.equals("������Ʈ")) {
			menuPrice = 4500;
		} else if (menu.equals("��ũƼ") || menu.equals("ī���")) {
			menuPrice = 3500;
		} else if (menu.equals("�Ƹ޸�ī��")) {
			menuPrice = 2000;
		} else {
			System.out.println("�޴��� �����ϴ�");
			return null;
		}
		
		if (menuPrice > 0) {
			subInventory(count);
		}
		
		Order order = new Order(menu, count, menuPrice);
		
		return order;
	}
	
	public boolean isInventory(int count) {
		boolean isInventory;
		
		if (this.inventory > count) {
			isInventory = true;
		} else {
			isInventory = false;
		}
		return isInventory;
	}
	
	
	public void subInventory(int count) {
		this.inventory = this.inventory - count;
	}

}
