package d230804_2;

/* 
 * ������ ���۵Ǹ� ���(����)�� �� �� �ִ� ���� ������ �Է�
 * ����� 1~���ΰ���*2 �� �� �� ������ ���� ���´�
 * ����� ������ ����� ���� ���� ��ȣ�� �Է��Ѵ�
 * ���� ���ο� ���� ��ϰ� 2���� ���������� ���� �ش� 2�� ����� ���ŵȴ�
 * �ϳ��� �����̶� ��� ����� ������ 5�� �̻��̸� ���� ����
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// ���� ������ŭ deque ����

public class PlayTetris {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());

		System.out.println("����� �� ������ ������ �Է��ϼ���");
		int lineNum = scanner.nextInt();

		BlockMap blockMap = new BlockMap(lineNum);

		while (true) {
			blockMap.showmap();
			int block = random.nextInt(lineNum*2)+1;
			System.out.println(block+" ����� �� ������ ��ȣ�� �Է��ϼ���");
			int onNum = scanner.nextInt();
			if (blockMap.onBlock(onNum, block)) {
				System.out.print(blockMap.getCount()+" ȸ ���� ");
				System.out.println(onNum+" ������ ��á���ϴ�.");
				blockMap.showmap();
				break;
			}

		}

	}
}
