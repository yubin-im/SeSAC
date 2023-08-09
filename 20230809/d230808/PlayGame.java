package d230808;

import java.util.Random;
import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		String[] skills = {"�����ġ��", "������", "���¢��", "���̵������", "������", "�ĵ�Ÿ��", "�Ҵ빮��", "��Ʈ������", "�ֶ��", "Ǯ����"};
		int[] skillPower = {60, 50, 20, 100, 90, 90, 120, 70, 110, 80};
		String[][] skillType = {{"��", "��", "Ǯ"}, {"��", "Ǯ"}, {"��", "��", "Ǯ"}, {"��"}, {"��"}, {"��"}, {"��"}, {"��"}, {"Ǯ"}, {"Ǯ"}};
		
		String[] pks = {"������", "���̸�", "�̻��ؾ�", "�ѹ���", "����Ĵ�", "����"};
		String[] pkType = {"��", "��", "Ǯ", "Ǯ", "��", "��"};
		// pkStat�� ���� �迭�� {hp, power, speed}
		int[][] pkStat = {{250, 90, 90}, {150, 120, 90}, {200, 100, 90}, {150, 80, 80}, {160, 80, 80}, {150, 90, 100}};
		
		
		PokemonArchive pa = new PokemonArchive(pkStat, pkType, pks, skills, skillPower, skillType);
		PokemonCenter pc = new PokemonCenter(pa);
		
		// ���̸�, ������, �̻��ؾ� �߿��� �Ѹ����� �����ϰ� ����
		String pkName = pc.pkName[random.nextInt(3)];
		System.out.println("���̸�, ������, �̻��ؾ��� �÷��̾��� ���ϸ��� �̽��ϴ�.");
		System.out.println(pkName + "�� �̸��� �Է����ּ���");
		
		String pkNname = scanner.next();
		System.out.println(pkNname + "�� �����Դϴ�.");
		
		pc.setStat(pkName);
		pc.setSkill(pkName);
		
		
		
		
		
		scanner.close();
	}
}
