// 20230725_7����
// �ǽ�2: Scanner�� ���� ��(sec) ���� �Է¹ް� �Է¹��� �ʸ� ��, ��, �ʷ� �����Ͽ� ����ϴ� ���α׷� �����

package test;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("��ȯ�� �ʸ� ������ �Է��ϼ���: ");
		int input_sec = scanner.nextInt();
		
		int time = (input_sec/60) / 60;
		int min = (input_sec/60) % 60;
		int sec = input_sec % 60;
		
		System.out.println("��ȯ�� ������ �ð�:" + time + " ��:" + min + " ��:" + sec + " �Դϴ�.");
		
		scanner.close();
	}

}
