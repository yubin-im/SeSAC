package d230808;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonArchive {
	// ���ο��� �Է¹��� �迭�κ��� ������ ���� 3���� �� ������ �ʵ� �Ҵ�
	// ���ϸ��̸�= ��(hp, power, speed, type) ������ ��
	Map<String, Map<String, Integer>> pokemonMap; 
	// ��ų�̸�= skillpower ������ ��
	Map<String, Integer> skillMap;
	// type��= �ش� Ÿ�� ��ų�̸��� ����Ʈ
	Map<String, List<String>> typeMap;
	
	
	// ������ �Ǵ� �޼ҵ带 Ȱ���Ͽ� �ʱ�ȭ
	public PokemonArchive(Map<String, Map<String, Integer>> pokemonMap, Map<String, Integer> skillMap,
			Map<String, List<String>> typeMap) {
		pokemonMap = new HashMap<String, Map<String, Integer>>();
		skillMap = new HashMap<String, Integer>();
		typeMap = new HashMap<String, List<String>>();
		
		
		
	}
	
	
	
	
	

}
