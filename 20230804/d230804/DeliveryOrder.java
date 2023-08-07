package d230804;

import java.util.ArrayList;
import java.util.List;

public class DeliveryOrder extends Order{
	private OnDelivery onDelivery;
	private String locate;
	List<Menu> menuArray = new ArrayList<Menu>();
	
	interface OnDelivery{
		void successDelivery(String locate, List<Menu> menuArray);
	}

	public void setOnDelivery(OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public DeliveryOrder(List<Menu> menuArray) {
		super(menuArray);
		this.menuArray = menuArray;
	}
	
	public void setLocate(String locate) {
		this.locate = locate;
	}
	
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change == 0) {
			onDelivery.successDelivery(locate, menuArray);
		} else {
			System.out.println("�ݾ��� ���� �ʽ��ϴ�.");
		}
	}
	
	@Override
	public void setOrderPrice(List<Menu> menuArray) {
		super.setOrderPrice(menuArray);
		this.orderPrice = this.orderPrice + 3000;
		System.out.print("��޺� 3000�� �߰��Ǿ� ");
		System.out.println(orderPrice + "�� �Դϴ�.");
		System.out.println("��� �ֹ��� ��Ȯ�� �ݾ��� �������ּ���");
	}

}