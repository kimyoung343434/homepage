package notice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NoticeTest {

	public static void main(String[] args) {
		NoticeDAO dao = new NoticeDAO();
		
		//total(dao);
		list(dao);
		//create(dao);
		//read(dao);
		//update(dao);
		//delete(dao);
		//passCheck(dao);
		//upViewcnt(dao);
		//grade(dao);
		
	}
	
	
	
	
	
	private static void grade(NoticeDAO dao) {
		String grade = dao.getGrade("user2");
		p(grade);
		
	}





	private static void passCheck(NoticeDAO dao) {
		Map map = new HashMap();
		map.put("no", 4);
		map.put("passwd", "1234");
		
		if(dao.passCheck(map)) {
			p("�´º��");
		}else {
		p("Ʋ�� ���");
		
	}
}





	private static void upViewcnt(NoticeDAO dao) {
		int no = 38;
		
		dao.upViewcnt(no);
		
	}





	private static void delete(NoticeDAO dao) {
		int no = 41;
		
		if(dao.delete(no)) {
			p("���� ����");
		}else {
			p("���� ����");
		}
		
	}





	private static void update(NoticeDAO dao) {
		int no = 38;
		NoticeDTO dto = dao.read(no);
		dto.setTitle("�п�����");
		dto.setContent("��̰� �������Դϴ�.");
		
		if(dao.update(dto)) {
			p("���� ����");
		}else {
			p("���� ����");
		}
		
	}





	private static void read(NoticeDAO dao) {
		int no = 4;
		
		NoticeDTO dto = dao.read(no);
		p(dto);
	}





	private static void create(NoticeDAO dao) {
		NoticeDTO dto = new NoticeDTO();
		dto.setTitle("��������!!!");
		dto.setContent("�����ڸ� �� ��ϰ���");
		dto.setPasswd("1234");
		
		if(dao.create(dto)) {
			p("����");
		}else {
			p("����");
		}
		
	}





	private static void total(NoticeDAO dao) {
		Map map = new HashMap();
		map.put("col", "title");
		map.put("word", "��ȣ");
		
		p("��ü���ڵ尹��:" + dao.total(map));
		
	}





	private static void list(NoticeDAO dao) {
		Map map = new HashMap();
		map.put("col", "title");
		map.put("word", "����");
		map.put("sno", 1);
		map.put("eno", 5);
		
		List<NoticeDTO>list = dao.list(map);
		Iterator<NoticeDTO>iter = list.iterator();
		
		while(iter.hasNext()) {
			NoticeDTO dto = iter.next();
			p(dto);
			p("------------------");
		}
		
	}




	private static void p(NoticeDTO dto) {
		p("��ȣ:" + dto.getNo());
		p("id:" + dto.getId());
		p("����:" + dto.getTitle());
		p("����:" + dto.getContent());
		p("��¥:" + dto.getWdate());
		p("��ȸ��:" + dto.getViewcnt());
	}
	private static void p(String string) {
		System.out.println(string);
	}
	
}

















