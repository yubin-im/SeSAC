package d230810_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OTTArchive {
	Map<String, Map<String, Object>> contentM;
	Map<String, Map<String, String>> mediaM;

	public OTTArchive() {
		contentM = new LinkedHashMap<String, Map<String,Object>>();
		mediaM = new LinkedHashMap<String, Map<String,String>>();
		setArchive();
	}
	
	private void setArchive() {
		List<String[]> contents = readContentBase();
		List<String> casts = readCast();
		List<String> summarys = readSummary();
		List<String[]> medias = readMedia();

		for(int i=0;i<contents.size(); i++) {
			Map<String, Object> cm = new LinkedHashMap<String, Object>();
			String[] content = contents.get(i);
			cm.put("title",content[1]);
			cm.put("direc",content[2]);
			cm.put("year",content[3]);
			cm.put("type",content[4]);
			cm.put("views",Integer.valueOf(content[5]));
			cm.put("summary",summarys.get(i));
			cm.put("cast",casts.get(i));
			cm.put("medias",new ArrayList<String>());
			contentM.put(content[0], cm);
		}
		
		for(int i=0;i<medias.size(); i++) {
			Map<String, String> mdm = new LinkedHashMap<String, String>();
			String[] media = medias.get(i);
			
			mdm.put("title",media[1]);
			mdm.put("time",media[2]);
			mdm.put("cId",media[3]);
			mediaM.put(media[0], mdm);
			((List<String>) contentM.get(media[3]).get("medias")).add(media[0]);
		}
		
		//System.out.println(contentM.toString());
		//System.out.println(mediaM.toString());
	}
	
	private List<String[]> readContentBase() {
		try {
			FileReader fr = new FileReader("./�������⺻.txt");
			BufferedReader bin = new BufferedReader(fr);
			
			List<String[]> list = new ArrayList<>();
			while(true) {
				String line = bin.readLine();
				if (line == null) {
					break;
				}
				String[] content = line.split(" ");
				list.add(content);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	private List<String> readCast() {
		try {
			FileReader fr = new FileReader("./�������⿬.txt");
			BufferedReader bin = new BufferedReader(fr);
			List<String> list = new ArrayList<>();
			while(true) {
				String line = bin.readLine();
				if (line == null) {
					break;
				}
				list.add(line);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	private List<String> readSummary() {
		try {
			FileReader fr = new FileReader("./�������ٰŸ�.txt");
			BufferedReader bin = new BufferedReader(fr);
			List<String> list = new ArrayList<>();
			while(true) {
				String line = bin.readLine();
				if (line == null) {
					break;
				}
				list.add(line);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	private List<String[]> readMedia() {
		try {
			FileReader fr = new FileReader("./����.txt");
			BufferedReader bin = new BufferedReader(fr);
			
			List<String[]> list = new ArrayList<>();
			while(true) {
				String line = bin.readLine();
				if (line == null) {
					break;
				}
				String[] media= line.split(" ");
				list.add(media);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
}