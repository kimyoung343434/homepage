package guest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GuestTest {

	public static void main(String[] args) {
		GuestDAO dao = new GuestDAO();
		
		total(dao);
		//create(dao);
		//read(dao);
		//list(dao);
		//update(dao);
		//delete(dao);
		//upViewcnt(dao);
		//passCheck(dao);
		
	}
	
	
	
	

	
	
	
	
	
	private static void total(GuestDAO dao) {
		Map map = new HashMap();
		map.put("col", "wname");
		map.put("word", "�浿");
		
		p("���ڵ尹��:" + dao.total(map));
		
	}










	private static void passCheck(GuestDAO dao) {
		Map map = new HashMap();
		map.put("guestno", 1);
		map.put("passwd", "1234");
		if(dao.passCheck(map)) {
			p("�ùٸ� ����Դϴ�.");
		}else {
			p("�߸��� ����Դϴ�.");
		}
		
	
	}


	private static void upViewcnt(GuestDAO dao) {
		int guestno = 6;
		dao.upViewcnt(guestno);
		
//		if(dao.upViewcnt(guestno)) {
//			p("����");
//		}else {
//			p("����");
//		}
		
	}




	private static void delete(GuestDAO dao) {
		int guestno = 4;
		
		if(dao.delete(guestno)) {
			p("����");
		}else {
			p("����");
		}
		
	}



	private static void update(GuestDAO dao) {
		GuestDTO dto = dao.read(2);
		dto.setTitle("�ݿ�����");
		dto.setContent("������ ����");
		dto.setWname("��浿");
		
		if(dao.update(dto)) {
			p("����");
		}else {
			p("����");
		}
	}


	
	private static void list(GuestDAO dao) {
		Map map = new HashMap();
		map.put("col", "wname");
		map.put("word", "�浿");
		map.put("sno", 1);
		map.put("eno", 5);
		
		
		
			List <GuestDTO> list = dao.list(map);
			
			Iterator<GuestDTO> iter = list.iterator();
			
			while(iter.hasNext()){
				
				GuestDTO dto = iter.next();
				p(dto);
				p("---------------------------");
			}
			
	}








	private static void read(GuestDAO dao) {
		int guestno = 2;
		GuestDTO dto = dao.read(guestno);
		p(dto);
		
	}


	private static void create(GuestDAO dao) {
		GuestDTO dto = new GuestDTO();
		dto.setTitle("��ٿ�");
		dto.setContent("������ �ݿ���");
		dto.setWname("����");
		dto.setPasswd("1234");
		
		
		if(dao.create(dto)){
			p("����");
		}else {
			p("����");
		}
	}


	
	private static void p(GuestDTO dto) {
		p("��ȣ:" + dto.getGuestno());
		p("�۾���:" + dto.getWname());
		p("����:" + dto.getTitle());
		p("����" + dto.getContent());
		p("��ȸ��:" + dto.getViewcnt());
		p("��¥:" + dto.getWdate());
	}
	private static void p(String string) {
		System.out.println(string);
		
	}

}
