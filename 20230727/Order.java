// 20230727
package d230727;

public class Order {
	public String menu;  // �޴�
	private int order;  // ����
	private int order_price;  // �ֹ��ݾ�

	
	public Order(String menu, int order, int menu_price) {
		this.menu = menu;
		this.order = order;
		setOrderPrice(menu_price);
	}
	
	public void setOrderPrice(int menu_price) {
		this.order_price = menu_price * this.order;
		
	}
	
	public boolean runOrder(int deposit) {
		boolean runorder;
		
		if (deposit >= this.order_price) {
			System.out.println(deposit - this.order_price);
			runorder = true;
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
			runorder = false;
		}
		return runorder;
	}
	
	public int getOrderPrice() {
		return this.order_price;
	}
}
