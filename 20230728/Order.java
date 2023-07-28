package d230728;

public class Order {
	protected String menu;
	protected int count;
	protected int orderPrice;
	
	// ������
	public Order(String menu, int count, int menuPrice) {
		this.menu = menu;
		this.count = count;
		setOrderPrice(menuPrice);
	}
	
	public boolean runOrder(int deposit) {
		boolean runOrder;
		
		if (deposit >= this.orderPrice) {
			System.out.println(deposit - this.orderPrice);
			runOrder = true;
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
			runOrder = false;
		}
		return runOrder;
	};
	
	public void setOrderPrice(int menuPrice) {
		this.orderPrice = menuPrice * this.count;
	};
	
	public int getOrderPrice() {
		return this.orderPrice;
	};

}
