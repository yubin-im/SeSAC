package d230803;

// 2���� �迭�� ��ٸ����� ����� �ʵ�� �����ϴ� ���
// ���������� ����� �迭�� �Է¹޾� �ʵ�� �����ϴ� ���

import java.util.Random;

public class Ladder {
	Random random = new Random();

	int[][] map;
	int[] rankArray;
	
	public Ladder(int floorNum, int playerNum) {
		this.map = new int[floorNum][playerNum];
		this.rankArray = new int[playerNum];
			
		// [�Է�����][�÷��̾��] ũ���� map �����
		// 1�� �������� 2�� �;���, 1���� 2�� ���� �ȵ�, 4���� 1�� ���� �ȵ�
		for(int i = 0; i < floorNum; i++) {
			for(int j = 0; j < playerNum; j++) {
				map[i][j] = random.nextInt(3);
				if (j != 0) {
					if (map[i][j-1] == 1) {
						map[i][j] = 2;
					}
				}

				if (j != 0) {
					if (map[i][j-1] == 2) {
						map[i][j] = 0;
					}
				}
				
				if (map[i][0] == 2) {
					map[i][0] = random.nextInt(2);
				}
				if (map[i][playerNum-1] == 1) {
					int not1 = random.nextInt(2);
					map[i][playerNum-1] = (not1 == 0) ? 0 : 2;
				}
			}
		}
	}

	public int[] getRankArray() {
		return rankArray;
	}

	public void setRankArray(int[] rankArray) {
		this.rankArray = rankArray;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}


}
