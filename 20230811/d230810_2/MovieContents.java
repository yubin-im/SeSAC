package d230810_2;

public class MovieContents extends Contents{
	protected String mainID;
	protected String trailerID;
	
	Media md = new Media();
	
	
	public MovieContents() {
		super();
		super.setTypeList();
	}
	
	
	public void setMovieContents(String contentID) {
		setDetailContents(contentID);
		System.out.println("����: " + title);
		System.out.println("�ٰŸ�: " + summary);
		System.out.println("����: " + direc);
		System.out.println("����: " + year);
		System.out.println("�⿬: " + cast);
		System.out.println(type);
		System.out.println("0. ���ϱ�");
	}
	
	// ��ȭ ������ ��� ��ü ���
	public void movieContentsList() {
		System.out.println("��ȭ ������ ���!\n----------------------------------------");
		for (int i = 0; i < movieTypeList.size(); i++) {
			String contentID = movieTypeList.get(i);
			setMovieContents(contentID);
			System.out.println();
			
			md.movieMediaList(contentID);
			System.out.println("----------------------------------------");
		}
		
	}
	

}
