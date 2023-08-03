package d230803_3;

import java.util.ArrayList;
import java.util.List;

public class TakeoutOrder extends Order{
	private OnTakeout onTakeout;
	private int time;
	List<Menu> menuArray = new ArrayList<Menu>();
	
	interface OnTakeout{
		void successTakeout(int change, int time, List<Menu> menuArray);
	}
	
	public void setOnTakeout(OnTakeout onTakeout) {
		this.onTakeout = onTakeout;
	}
	
	public TakeoutOrder(List<Menu> menuArray) {
		super(menuArray);
		this.menuArray = menuArray;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onTakeout.successTakeout(change, time, menuArray);
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
		}
	}
	
	@Override
	public void setOrderPrice(List<Menu> menuArray) {
		super.setOrderPrice(menuArray);
		this.orderPrice = this.orderPrice - 500;
		System.out.print("����ũ �ƿ��� 500�� ���εǾ� ");
		System.out.println(orderPrice + "�� �Դϴ�.");
	}
}