package d230807_2;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	public String name;
	public int price;
	public int count;
	Map<String, Integer> menuMap = new HashMap<String, Integer>();
	
	public Menu(String name, int count) throws KisokException {
		this.name = name;
		this.count = count;
		menuMap = new HashMap<String, Integer>();
		
//		if (name.equals("������Ʈ")){
//			price = 4500;
//		} else if (name.equals("ī���") || name.equals("��ũƼ")){
//			price = 3500;
//		} else if (name.equals("�Ƹ޸�ī��")){
//			price = 2000;
//		} else {
//			price = 0;
//			throw new KisokException(101);
//		}
		
		menuMap.put("������Ʈ", 4500);
		menuMap.put("ī���", 3500);
		menuMap.put("��ũƼ", 3500);
		menuMap.put("�Ƹ޸�ī��", 2000);
		
		
		
	}
	
}