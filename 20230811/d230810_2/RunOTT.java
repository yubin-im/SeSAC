package d230810_2;

// OTT ����� (�����ø���)

import java.util.Scanner;

public class RunOTT {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// ����ڴ� ������ ���� ������ ����� �����Ͽ� �� �� �ִ�.
		System.out.println("1. ������ ���� \n2. ��ȭ ������ \n3. �ø��� ������ \n4. ���ɸ�� ������ \n");
		System.out.print("������ ��ȣ�� �Է����ּ���: ");
		int runCode = scanner.nextInt();
		System.out.println();
		
		
		if (runCode == 1) {
			// ���� �������� ��ȭ, �ø��� �� �� ǥ��ȴ�.
			System.out.println("������ ����!");
			
		} else if (runCode == 2) {
			// ��ȭ ������ ����� ��ȭ �������� ǥ��ȴ�.
			MovieContents mc = new MovieContents();
			mc.movieContentsList();
			
		} else if (runCode == 3) {
			// �ø��� ������ ����� �ø��� �������� ǥ��ȴ�.
			SeriesContents sc = new SeriesContents();
			sc.seriesContentsList();
			
		} else if (runCode == 4) {
			// ���� �������� ��ȭ, �ø��� �� �� ǥ��ȴ�.
			
		}
		
		

		
		scanner.close();
	}

}
