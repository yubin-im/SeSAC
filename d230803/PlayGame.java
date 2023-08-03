package d230803;

import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("�÷��̾���� ��ٸ� ������ �Է��� �ּ���");
		int playerNum = scanner.nextInt();
		int floorNum = scanner.nextInt();
		
		Ladder ladder = new Ladder(floorNum, playerNum);
		int[] rankArray = ladder.getRankArray();
		int[][] map = ladder.getMap();
		
		System.out.println("�÷��̾����ŭ ����� �����ּ���");
		for (int i = 0; i < playerNum; i++) {
			int rank = scanner.nextInt();
			rankArray[i] = rank;
		}
		
		
		

		
		System.out.println("-----Ȯ�ο� map:");
		for(int[] vec: map) {
			for(int i: vec) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
		System.out.println("-----Ȯ�ο� rankArray:");
		for(int i: rankArray) {
			System.out.print(i + " ");
		}
		
		
		scanner.close();
	}
}
