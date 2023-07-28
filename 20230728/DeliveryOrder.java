package d230728;

public class DeliveryOrder extends Order{
	protected String locate;

	public DeliveryOrder(String menu, int count, int orderPrice) {
		super(menu, count, orderPrice);
	}

	@Override
	public boolean runOrder(int deposit) {
		boolean runOrder;
		
		if (deposit >= orderPrice) {
			System.out.println(deposit - orderPrice);
			runOrder = true;
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
			runOrder = false;
		}
		return runOrder;
	}
	
	public void setLocate(String address) {
		System.out.println(address + " �ּҷ� " + this.menu + " ��� �ֹ��� �Ϸ� �Ǿ����ϴ�.");
	}
	
	@Override
	public void setOrderPrice(int menuPrice) {
		super.setOrderPrice(menuPrice);
		menuPrice = menuPrice + 3000;
		System.out.println("��޺� 3000�� �߰��Ǿ� " + menuPrice + "�� �Դϴ�.");
		System.out.println("��� �ֹ��� ��Ȯ�� �ݾ��� �������ּ���");
		
	}
}
