package d230808;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PokemonCenter {
	Random random = new Random();
	PokemonArchive pa;
	Pokemon pk;
	
	// ���� ������ ���ϸ��̸� �迭�� �ʵ�� �Ҵ�
	String[] pkName = {"���̸�", "������", "�̻��ؾ�"};
	
	Map<String, Object> statMap;
	Map<String, Object> inPokemonMap;
	Map<String, Integer> skillMap;
	List<String> typeList;
	
	// �����ڿ��� ���ϸ��ī�̺� �ν��Ͻ��� ���ڷ� �޾� �ʵ�� �Ҵ�
	public PokemonCenter(PokemonArchive pa) {
		this.pa = pa;
	}
	
	// ���ϸ� ���� �޼ҵ� ����, �ؿ� �� �޼ҵ带 Ȱ���Ͽ� ���ϸ� �ν��Ͻ��� ��ȯ
	
	
	
	// ���ϸ� ���� �ʱ�ȭ �޼ҵ� ����
	public void setStat(String pkName) {
		statMap = new LinkedHashMap<>();
		inPokemonMap = new LinkedHashMap<>();
		inPokemonMap = pa.pokemonMap.get(pkName);
		
		// ������ �ش� ���ϸ��� �⺻ ������ ������
		// hp, power, speed�� �⺻������ -10~+10�� ������ �����ϰ� ���õ�
		int hp = ((int) inPokemonMap.get("hp")) + (random.nextInt(21) - 10);
		int power = ((int) inPokemonMap.get("power")) + (random.nextInt(21) - 10);
		int speed = ((int) inPokemonMap.get("speed")) + (random.nextInt(21) - 10);
		
		statMap.put("pkName", pkName);
		statMap.put("hp", hp);
		statMap.put("power", power);
		statMap.put("type", inPokemonMap.get("type"));
		statMap.put("speed", speed);
		
		System.out.println("���� ü�� " + hp);
		System.out.println("�ɷ�â " + statMap.toString());
	}
	
	// ���ϸ� ��ų �ʱ�ȭ �޼ҵ� ����
	public void setSkill(String pkName) {
		skillMap = new LinkedHashMap<>();
		inPokemonMap = new LinkedHashMap<>();
		typeList =  new ArrayList<>();
		
		inPokemonMap = pa.pokemonMap.get(pkName);
		String type = (String) inPokemonMap.get("type");
		
		typeList = pa.typeMap.get(type);
		
		// ��ų�� Ÿ�Կ� �°� �����ϰ� 2���� ���õȴ�
		while(skillMap.size() < 2) {
			int randomIndex = random.nextInt(typeList.size());
			
			String skill = typeList.get(randomIndex);
			int skillPower = pa.skillMap.get(skill);
			
			skillMap.put(skill, skillPower);
		}
		
		System.out.println("��ųâ " + skillMap.toString());
	}
	
	// ���� �������̽��� ���߾� �߰� �޼ҵ� ����
	
	
	
}
