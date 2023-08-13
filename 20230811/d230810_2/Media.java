package d230810_2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Media {
	protected String mediaID;
	protected String mediaTitle;
	protected String mediaTime;
	protected String contentID;
	
	Map<String, String> inMediaM;
	List<String> mediaList;
	
	OTTArchive oa = new OTTArchive();
	Contents c = new Contents();
	
	
	public Media() {

	}
	
	
	public void setMedia(String mediaID) {
		inMediaM = new LinkedHashMap<>();
		inMediaM = oa.mediaM.get(mediaID);
		
		this.mediaTitle = inMediaM.get("title");
		this.mediaTime = inMediaM.get("time");
		this.contentID = inMediaM.get("cId");
	}
	
	// ��ȭ ���� ��� ���
	public void movieMediaList(String contentID) {
		mediaList = c.getMedias(contentID);
		
		for (int i = 0; i < mediaList.size(); i++) {
			mediaID = mediaList.get(i);
			setMedia(mediaID);
			
			System.out.println((i+1) + ".--------------");
			System.out.println("����: " + mediaTitle);
			System.out.println("���� �ð�: " + mediaTime);
		}
		System.out.println("--------------");
		System.out.println();	
			
	}
	
	// �ø��� ȸ���� ���� ���� ��� ���
	public void seriesMediaList(String contentID) {
		mediaList = c.getMedias(contentID);
		
		for (int i = 0; i < mediaList.size(); i++) {
			mediaID = mediaList.get(i);
			setMedia(mediaID);
			
			System.out.println((i+1) + ".--------------");
			System.out.println((i+1) + "ȸ ����");
			System.out.println("�ø��� ����: " + mediaTitle);
			System.out.println("���� �ð�: " + mediaTime);
		}
		System.out.println("--------------");
		System.out.println();	
		
	}
		

}
