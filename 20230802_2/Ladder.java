package d230802_2;

// 2���� �迭�� ��ٸ����� ����� �ʵ�� �����ϴ� ���
// ���������� ����� �迭�� �Է¹޾� �ʵ�� �����ϴ� ���

public class Ladder {
	int[][] map;
	int[] rankArray;
	
	public Ladder(int playerNum, int floorNum) {
		this.map = new int[playerNum][floorNum];
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
