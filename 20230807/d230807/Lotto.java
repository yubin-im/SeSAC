package d230807;

//1���� ��÷ �ζǹ�ȣ �����ϰ� ����
//�ζ� ��ȣ�� ���Ͽ� ����� ��ȯ
//1�� ���θ���, 2�� 1������ ����, 3�� 2������ ����, 4�� 3������ ����
//�ζǺ��� ���� ������ �ζǹ�ȣ�� ��� ���, 4�� ���Ĵ� ������ ���

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Lotto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashSet<TreeSet<Integer>> lottoSets = new HashSet<>();
		
		System.out.println("�ζǸ� � �����Ͻðڽ��ϱ�?");
		int setCount = scanner.nextInt();

		// ����ڰ� �Է��� Ƚ����ŭ�� �ζ� ����
		for (int i = 0; i < setCount; i++) {
			LottoBot lottoBot = new LottoBot();
			TreeSet<Integer> lottoSet = lottoBot.lottoSet;
			lottoSets.add(lottoSet);
		}

		// ���� 1���� ���� �ζǹ�ȣ ����
		LottoBot lottoBot = new LottoBot();
		TreeSet<Integer> mainLotto = lottoBot.lottoSet;
		
		
		// ���� �ζǿ� ������ �ζ� ��ȣ�� ��		
		for (TreeSet<Integer> lottoSet: lottoSets) {
			int matchCount = LottoBot.getMatchCount(lottoSet, mainLotto);
			
			if (matchCount == 3) {
	            System.out.println("4 ��!");
	        } else if (matchCount == 4) {
	            System.out.println("3 ��!");
	        } else if (matchCount == 5) {
	            System.out.println("2 ��!");
	        } else if (matchCount == 6) {
	            System.out.println("1 ��!");
	        } else {
	            System.out.println("��!");
	        }
		}


		// Ȯ�ο� ���
		System.out.println("---------------------------------");
		System.out.println("���� 1���� �ζǹ�ȣ: ");
		for(Integer n : mainLotto) {
			System.out.print(n + " ");
		}
		System.out.println("\n");
		
		System.out.println("lottoSets: ");
		for (TreeSet<Integer> lottoSet: lottoSets) {
            System.out.println(lottoSet);
        }
		
		scanner.close();		
	}
			
		
}
	
	
	


