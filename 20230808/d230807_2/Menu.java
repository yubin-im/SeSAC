package d230807_2;

// �����ڴ� �޴��̸�, ����, ������ �Է¹ް� �ʵ�� �Ҵ�
// ���� �ʵ�� ������ŭ�� �Ѱ������� ����

import java.util.HashMap;
import java.util.Map;

public class Menu {
	public String name;
	public int price;
	public int count;
	Map<String, Integer> menuMap;
	
	public Menu(String name, int count) throws KisokException {
		this.name = name;
		this.count = count;
		menuMap = new HashMap<String, Integer>();

		menuMap.put("������Ʈ", 4500);
		menuMap.put("ī���", 3500);
		menuMap.put("��ũƼ", 3500);
		menuMap.put("�Ƹ޸�ī��", 2000);
		
		if (name.equals("������Ʈ")) {
			price = menuMap.get(name) * count;
		} else if (name.equals("ī���")) {
			price = menuMap.get(name) * count;
		} else if (name.equals("��ũƼ")) {
			price = menuMap.get(name) * count;
		} else if (name.equals("�Ƹ޸�ī��")) {
			price = menuMap.get(name) * count;
		} else {
			price = 0;
			throw new KisokException(101);
		}

		
	}
	
}