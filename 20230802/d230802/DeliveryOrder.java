package d230802;

public class DeliveryOrder extends Order{
	private OnDelivery onDelivery;
	private String locate;
	Menu[] menus;
	
	interface OnDelivery{
		void successDelivery(String locate, Menu[] menus);
	}

	public void setOnDelivery(OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public DeliveryOrder(Menu[] menuArray) {
		super(menuArray);
		this.menus = menuArray;
	}
	
	public void setLocate(String locate) {
		this.locate =locate;
	}
	
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change == 0) {
			onDelivery.successDelivery(locate, menus);
		} else {
			System.out.println("�ݾ��� ���� �ʽ��ϴ�.");
		}
	}
	
	@Override
	public void setOrderPrice(Menu[] menuArray) {
		super.setOrderPrice(menuArray);
		this.orderPrice = this.orderPrice + 3000;
		System.out.print("��޺� 3000�� �߰��Ǿ� ");
		System.out.println(orderPrice + "�� �Դϴ�.");
		System.out.println("��� �ֹ��� ��Ȯ�� �ݾ��� �������ּ���");
	}

}