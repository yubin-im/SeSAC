package d230801;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		// �����, ��ǻ�� �迭 �ʱ�ȭ
		int[] playerArray = new int[4];
		int[] computerArray = new int[4];
		
		System.out.println("ī�尡 �й�˴ϴ�.");
		
		// �����, ��ǻ�� �迭 ���� �� ����
		for (int i=0; i<playerArray.length; i++) {
			playerArray[i] = random.nextInt(10) + 1;
			computerArray[i] = random.nextInt(10) + 1;
			System.out.print(playerArray[i] + " ");
		}
		
		// ����� ī�� ���� �ε��� �ޱ�
		System.out.println("�ΰ��� ī�带 �������ּ��� (�ε��� ������ �Է�)");
		int playerindex1 = scanner.nextInt();
		int playerindex2 = scanner.nextInt();
		
		// ����ڰ� ������ ī�� �� ��
		int playerValue = playerArray[playerindex1] + playerArray[playerindex2];
		
		// ��ǻ���� ī�� �� �� ���� ���� �� 2���� ��
		int computerNum1 = 0;
		int computerNum2 = 0;
		for (int j: computerArray) {
			if (j > computerNum1) {
				computerNum2 = computerNum1;
				computerNum1 = j;
			}
			else if (j > computerNum2) {
				computerNum2 = j;
			}
		}
		int computerValue = computerNum1 + computerNum2;
		
		System.out.print(playerValue + " vs " + computerValue);
		
		// ����ڿ� ��ǻ���� ī�� �� ��
		if (playerValue > computerValue) {
			System.out.println(" �÷��̾��� �¸� �Դϴ�.");
		} else if (playerValue < computerValue) {
			System.out.println(" ��ǻ���� �¸� �Դϴ�.");
		} else {
			System.out.println(" �����Դϴ�.");
		}
		
		
		System.out.println("-------------------Ȯ�ο�-------------------");
		System.out.println("��ǻ�� �÷��̾� �迭: ");
		for (int j: computerArray) {
			System.out.print(j + " ");
		}
		System.out.println();
		System.out.println("��ǻ�� �÷��̾� �迭 �� ���� ���� �� 2��: " + computerNum1 + ", " + computerNum2);
		
		scanner.close();
	}
}
