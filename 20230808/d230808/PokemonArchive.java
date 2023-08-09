package d230808;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PokemonArchive {
	// ���ο��� �Է¹��� �迭�κ��� ������ ���� 3���� �� ������ �ʵ� �Ҵ�
	// ���ϸ��̸�= ���θ�(hp= hp��, power= power��, speed= speed��, type= type��)
	Map<String, Map<String, Object>> pokemonMap; 
	// ��ų�̸�= skillpower
	Map<String, Integer> skillMap;
	// type��= �ش� Ÿ�� ��ų�̸��� ����Ʈ
	Map<String, List<String>> typeMap;
	
	
	// ������ �Ǵ� �޼ҵ带 Ȱ���Ͽ� �ʱ�ȭ
	public PokemonArchive(int[][] pkStat, String[] pkType, String[] pks, String[] skills, int[] skillPower, String[][] skillType) {
		pokemonMap = new LinkedHashMap<String, Map<String, Object>>();
		skillMap = new LinkedHashMap<String, Integer>();
		typeMap = new LinkedHashMap<String, List<String>>();
		
		// pokemonMap �� ����
		for (int i = 0; i < pks.length; i++) {
			// pokemonMap ���� ���θ� ����
			Map<String, Object> inPokemonMap = new LinkedHashMap<>();
			
			inPokemonMap.put("hp", pkStat[i][0]);
			inPokemonMap.put("power", pkStat[i][1]);
			inPokemonMap.put("speed", pkStat[i][2]);
			inPokemonMap.put("type", pkType[i]);
			
			pokemonMap.put(pks[i], inPokemonMap);
		}
		
		// skillMap �� ����
		for (int i = 0; i < skills.length; i++) {
			skillMap.put(skills[i], skillPower[i]);
		}
		
		// typeMap �� ����
		// ��ų ����Ʈ ����
		ArrayList<String> waterList = new ArrayList<String>();
		ArrayList<String> fireList = new ArrayList<String>();
		ArrayList<String> grassList = new ArrayList<String>();
		
		for (int i = 0; i < skillType.length; i++) {
			for (String type: skillType[i]) {
				if (type == "��") {
					waterList.add(skills[i]);
				} else if (type == "��") {
					fireList.add(skills[i]);
				} else if (type == "Ǯ") {
					grassList.add(skills[i]);
				}
			}
		}
		
		typeMap.put("��", waterList);
		typeMap.put("��", fireList);
		typeMap.put("Ǯ", grassList);
		
		
		
		// Ȯ�ο�
//		System.out.println("pokemonMap Ȯ��: \n" + pokemonMap.toString());
//		System.out.println("skillMap Ȯ��: \n" + skillMap.toString());
//		System.out.println("typeMap Ȯ��: \n" + typeMap.toString());
//		System.out.println();
		
	}

}
