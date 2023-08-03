package d230802;

public class TakeoutOrder extends Order{
	private OnTakeout onTakeout;
	private int time;
	Menu[] menus;
	
	interface OnTakeout{
		void successTakeout(int change, int time, Menu[] menus);
	}
	
	public void setOnTakeout(OnTakeout onTakeout) {
		this.onTakeout = onTakeout;
	}
	
	public TakeoutOrder(Menu[] menuArray) {
		super(menuArray);
		this.menus = menuArray;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onTakeout.successTakeout(change, time, menus);
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
		}
	}
	
	@Override
	public void setOrderPrice(Menu[] menuArray) {
		super.setOrderPrice(menuArray);
		this.orderPrice = this.orderPrice - 500;
		System.out.print("����ũ �ƿ��� 500�� ���εǾ� ");
		System.out.println(orderPrice + "�� �Դϴ�.");
	}
}