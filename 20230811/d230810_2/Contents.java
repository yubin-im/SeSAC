package d230810_2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Contents {
	protected String contentID;
	protected String title;
	protected String direc;
	protected String summary;
	protected String cast;
	protected String year;
	protected int views;
	protected String type;
	protected List<String> medias;
	
	Map<String, Object> inContentM;
	List<String> movieTypeList;
	List<String> seriesTypeList;
	
	OTTArchive oa = new OTTArchive();
	
	
	public Contents() {

	}
	
	
	public void setDetailContents(String contentID) {
		inContentM = new LinkedHashMap<>();
		inContentM = oa.contentM.get(contentID);
		
		this.title = (String) inContentM.get("title");
		this.direc = (String) inContentM.get("direc");
		this.year = (String) inContentM.get("year");
		this.summary = (String) inContentM.get("summary");
		this.cast = (String) inContentM.get("cast");
		this.views = (int) inContentM.get("views");
		this.type = (String) inContentM.get("type");
		this.medias = (List<String>) inContentM.get("medias");	
	}
	
	
	// ��ȭ, �ø��� Ÿ���� ������ ID ����Ʈ �ޱ�
	public void setTypeList() {
		movieTypeList = new ArrayList<String>();
		seriesTypeList = new ArrayList<String>();
		
		for (String id: oa.contentM.keySet()) {
			inContentM = oa.contentM.get(id);
			String type = (String) inContentM.get("type");
			
			if (type.equals("��ȭ")) {
				movieTypeList.add(id);
			} else if (type.equals("�ø���")) {
				seriesTypeList.add(id);
			}
		}
	}

	
	// ���� ���̵� ����Ʈ ��ȯ
	public List<String> getMedias(String contentID) {
		setDetailContents(contentID);
		return medias;
	}
	
}




