// 20230726
// (����)�ǽ�4: ���������� ���� �����
package d230726;

import java.util.Scanner;

public class Ex4_ans {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���������� ���� �Դϴ�. ����:1, ����:2, ��:3");
		
		System.out.println("a ������ ��ȣ�� �������ּ���");
		int user_a = scanner.nextInt();
		System.out.println("b ������ ��ȣ�� �������ּ���");
		int user_b = scanner.nextInt();
		
		if (user_a == user_b) {
	    		System.out.println("�����ϴ�");
	    	} else if (user_a == 1) {
	        	if (user_b == 2)
	        	System.out.println("b�¸�");
	        	else
	        	System.out.println("a�¸�");
	    	} else if (user_a == 2) {
	        	if (user_b == 1)
	        		System.out.println("a�¸�");
	       		else
	        		System.out.println("b�¸�");
	    	} else if (user_a == 3){
	        	if (user_b == 1)
	        		System.out.println("b�¸�");
	        	else
	        		System.out.println("a�¸�");
	    	}  
	    	scanner.close();
	}

}
