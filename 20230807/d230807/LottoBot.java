package d230807;

//�ζ� ���ڸ� �̾� ��ø������ ����
//�̶� 6���� ���� ���ڴ� �ߺ��� ���� �ʾƾ� ��

import java.util.Random;
import java.util.TreeSet;

public class LottoBot {
	Random random = new Random();
	TreeSet<Integer> lottoSet = new TreeSet<Integer>();
	
	public LottoBot() {
		while (true) {
			lottoSet.add(random.nextInt(47));
			if (lottoSet.size() == 6) {
				break;
			}
		}
	}
	
	public static int getMatchCount(TreeSet<Integer> set1, TreeSet<Integer> set2) {
		int count = 0;
        for (int number : set1) {
            if (set2.contains(number)) {
                count++;
            }
        }
        return count;
	}


}
