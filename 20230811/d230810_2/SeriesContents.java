package d230810_2;

import java.util.List;

public class SeriesContents extends Contents{
	protected List<String> episodesID;
	
	Media md = new Media();
	
	public SeriesContents() {
		super();
		super.setTypeList();
	}

	
	public void setSeriesContents(String contentID) {
		setDetailContents(contentID);
		System.out.println("����: " + title);
		System.out.println("�ٰŸ�: " + summary);
		System.out.println("����: " + direc);
		System.out.println("����: " + year);
		System.out.println("�⿬: " + cast);
		System.out.println(type);
		System.out.println("0. ���ϱ�");
	}
	
	// �ø��� ������ ��ü ��� ���
	public void seriesContentsList() {
		System.out.println("�ø��� ������ ���!\n----------------------------------------");
		for (int i = 0; i < seriesTypeList.size(); i++) {
			String contentID = seriesTypeList.get(i);
			setSeriesContents(contentID);
			System.out.println();
			
			md.seriesMediaList(contentID);
			System.out.println("----------------------------------------");
		}

	}

	
}
