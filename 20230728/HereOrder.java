package d230728;

public class HereOrder extends Order{
	protected int orderNum;

	public HereOrder(String menu, int count, int menuPrice) {
		super(menu, count, menuPrice);
	}

	@Override
	public boolean runOrder(int deposit) {
		return super.runOrder(deposit);
	}
	
	public void setOrderNum(int orderNum) {
		System.out.println(orderNum + " �ֹ���ȣ�� " + this.menu + " �ֹ� �Ϸ� �Ǿ����ϴ�.");
	}


}
