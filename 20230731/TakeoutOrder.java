package d230731;

public class TakeoutOrder extends Order{
	private OnTakeout onTakeout;
	private int time;
	
	interface OnTakeout{
		void successTakeout(int change, int time, String menu, int count);
	}
	
	public void setOnTakeout(OnTakeout onTakeout) {
		this.onTakeout = onTakeout;
	}
	
	public TakeoutOrder(String menu, int count, int price) {
		super(menu, count, price);
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onTakeout.successTakeout(change, time, menu, count);
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
		}
	}
	
	@Override
	public void setOrderPrice(int price) {
		// TODO Auto-generated method stub
		this.orderPrice = price * count + -500;
		System.out.print("����ũ �ƿ��� 500�� ���εǾ� ");
		System.out.println(orderPrice + "�� �Դϴ�.");
	}
}