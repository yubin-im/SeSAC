// 20230726
// �ǽ�6: �ζ� ��ȣ �̱�
// 6���� 0~46�� ������ ���ڸ� 5ȸ �̴� �ζǹ�ȣ �̱� �����
// ��ø for �� �̿�, ������ ���� �̱�
package d230726;

import java.util.Random;

public class Ex6 {
	public static void main(String[] args) {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		for (int i =1; i <= 5; i++) {
			System.out.print(i + " ��° �ζ� �̱� : ");
			
			for (int j = 1; j <= 6; j++) {
				System.out.print(random.nextInt(46) + " ");
			}
			System.out.println();
		}
	}
}
