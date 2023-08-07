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
		List<Deque<Integer>> dequeList = new ArrayList<>();
		
		System.out.println("����� �� ������ ������ �Է��ϼ���");
		int lineNum = scanner.nextInt();
		
		System.out.println("----------------------");
		int blockNum = random.nextInt(lineNum) + 1;
		System.out.println(blockNum + " ����� �� ������ ��ȣ�� �Է��ϼ���");
		
		
		
		for(int i = 0; i < lineNum; i++) {
			Deque<Integer> intDeque = new LinkedList<>();
			
			
			for(int j = 0; j < 5; j++) {
				intDeque.add(blockNum);
			}
			
			dequeList.add(intDeque);
		}
		
		
		
		for (int i = 0; i < dequeList.size(); i++) {
            Deque<Integer> intDeque = dequeList.get(i);
            System.out.println();
		}
		
		
		
		scanner.close();
	}
}
