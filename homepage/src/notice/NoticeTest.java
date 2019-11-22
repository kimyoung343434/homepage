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
			p("맞는비번");
		}else {
		p("틀린 비번");
		
	}
}





	private static void upViewcnt(NoticeDAO dao) {
		int no = 38;
		
		dao.upViewcnt(no);
		
	}





	private static void delete(NoticeDAO dao) {
		int no = 41;
		
		if(dao.delete(no)) {
			p("삭제 성공");
		}else {
			p("삭제 실패");
		}
		
	}





	private static void update(NoticeDAO dao) {
		int no = 38;
		NoticeDTO dto = dao.read(no);
		dto.setTitle("학원에서");
		dto.setContent("즐겁게 공부중입니다.");
		
		if(dao.update(dto)) {
			p("수정 성공");
		}else {
			p("수정 실패");
		}
		
	}





	private static void read(NoticeDAO dao) {
		int no = 4;
		
		NoticeDTO dto = dao.read(no);
		p(dto);
	}





	private static void create(NoticeDAO dao) {
		NoticeDTO dto = new NoticeDTO();
		dto.setTitle("공지사항!!!");
		dto.setContent("관리자만 글 등록가능");
		dto.setPasswd("1234");
		
		if(dao.create(dto)) {
			p("성공");
		}else {
			p("실패");
		}
		
	}





	private static void total(NoticeDAO dao) {
		Map map = new HashMap();
		map.put("col", "title");
		map.put("word", "야호");
		
		p("전체레코드갯수:" + dao.total(map));
		
	}





	private static void list(NoticeDAO dao) {
		Map map = new HashMap();
		map.put("col", "title");
		map.put("word", "말좀");
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
		p("번호:" + dto.getNo());
		p("id:" + dto.getId());
		p("제목:" + dto.getTitle());
		p("내용:" + dto.getContent());
		p("날짜:" + dto.getWdate());
		p("조회수:" + dto.getViewcnt());
	}
	private static void p(String string) {
		System.out.println(string);
	}
	
}

















