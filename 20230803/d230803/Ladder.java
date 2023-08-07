package d230803;

// 2���� �迭�� ��ٸ����� ����� �ʵ�� �����ϴ� ���
// ���������� ����� �迭�� �Է¹޾� �ʵ�� �����ϴ� ���

import java.util.Random;

public class Ladder {
	int[][] map;
	int[] rankArray;
	private int playerNum;
	private int floorNum;
	
	public Ladder(int playerNum, int floorNum) {
		this.map = new int[playerNum][floorNum];
		this.rankArray = new int[playerNum];
		this.playerNum = playerNum;
		this.floorNum = floorNum;
		setLadder();
	}

	private void setLadder() {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());

		for (int i = 0; i < floorNum; i++) {
			for (int j = 0; j < playerNum; j++) {
				map[i][j] = 0;
			}
			int ladder = random.nextInt(playerNum-1);
			map[i][ladder] = 1;
			map[i][ladder+1] = 2;
		}
	}

	public void setRank(int[] rankArray) {
		this.rankArray = rankArray;
	}

	public void show() {
		for (int i = 0; i < floorNum; i++) {
			for (int j = 0; j < playerNum; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}


}
