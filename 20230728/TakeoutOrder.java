package d230728;

public class TakeoutOrder extends Order{
	protected int time;

	public TakeoutOrder(String menu, int count, int menuPrice) {
		super(menu, count, menuPrice);
	}

	@Override
	public boolean runOrder(int deposit) {
		return super.runOrder(deposit);
	}
	
	public void setTime(int time) {
		System.out.println(time + " �е� " + this.menu + " �����ֹ� �Ϸ�Ǿ����ϴ�.");
	}

	@Override
	public void setOrderPrice(int menuPrice) {
		super.setOrderPrice(menuPrice);
		menuPrice = menuPrice - 500;
		System.out.println("����ũ �ƿ��� 500�� ���εǾ� " + menuPrice + "�� �Դϴ�.");
	}
	
	

}
