package d230803_2;

public class Menu {
	protected int syog = 4500;
	protected int lat = 3500;
	protected int mtea = 3500;
	protected int ame = 2000;
	protected int price;
	String menu;
	
	public Menu(String menu) throws KioskException{
		this.menu = menu;
		
		if (menu.equals("������Ʈ")){
			price = this.syog;
		} else if (menu.equals("ī���")){
			price = this.lat;
		} else if (menu.equals("��ũƼ")) {
			price = this.mtea;
		} else if (menu.equals("�Ƹ޸�ī��")){
			price = this.ame;
		} else {
			price = 0;
		}
		
		if (price == 0) {
			System.out.println("�޴��� �����ϴ�.");
			throw new KioskException("error code", 102);
		}
		
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getPrice() {
		return price;
	}
	
}
