// 20230726
// �ǽ�5: for ���� �̿��Ͽ� 19�� �����, �������� ���ڰ� Ȧ���� ��츸 ����ϱ�
package d230726;

public class Ex5 {

	public static void main(String[] args) {
		int dan = 0;
		
		for(int i=1; i<20; i++) {
			if (i % 2 == 1) {
				dan = 19 * i;
				System.out.println("19 X " + i + " = " + dan);
			}
		}
	}
}
