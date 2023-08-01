package d230731;

public class DeliveryOrder extends Order{
	private OnDelivery onDelivery;
	private String locate;
	
	interface OnDelivery{
		void successDelivery(String locate, String menu, int count);
	}

	public void setOnDelivery(OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public DeliveryOrder(String menu, int count, int price) {
		super(menu, count, price);
	}
	
	public void setLocate(String locate) {
		this.locate =locate;
	}
	
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change == 0) {
			onDelivery.successDelivery(locate, menu, count);
		} else {
			System.out.println("�ݾ��� ���� �ʽ��ϴ�.");
		}
	}
	
	@Override
	public void setOrderPrice(int price) {
		// TODO Auto-generated method stub
		this.orderPrice = price * count + 3000;
		System.out.print("��޺� 3000�� �߰��Ǿ� ");
		System.out.println(orderPrice + "�� �Դϴ�.");
		System.out.println("��� �ֹ��� ��Ȯ�� �ݾ��� �������ּ���");
	}

}