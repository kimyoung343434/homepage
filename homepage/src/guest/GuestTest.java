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
		map.put("word", "길동");
		
		p("레코드갯수:" + dao.total(map));
		
	}










	private static void passCheck(GuestDAO dao) {
		Map map = new HashMap();
		map.put("guestno", 1);
		map.put("passwd", "1234");
		if(dao.passCheck(map)) {
			p("올바른 비번입니다.");
		}else {
			p("잘못된 비번입니다.");
		}
		
	
	}


	private static void upViewcnt(GuestDAO dao) {
		int guestno = 6;
		dao.upViewcnt(guestno);
		
//		if(dao.upViewcnt(guestno)) {
//			p("성공");
//		}else {
//			p("실패");
//		}
		
	}




	private static void delete(GuestDAO dao) {
		int guestno = 4;
		
		if(dao.delete(guestno)) {
			p("성공");
		}else {
			p("실패");
		}
		
	}



	private static void update(GuestDAO dao) {
		GuestDTO dto = dao.read(2);
		dto.setTitle("금요일은");
		dto.setContent("열심히 하자");
		dto.setWname("김길동");
		
		if(dao.update(dto)) {
			p("성공");
		}else {
			p("실패");
		}
	}


	
	private static void list(GuestDAO dao) {
		Map map = new HashMap();
		map.put("col", "wname");
		map.put("word", "길동");
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
		dto.setTitle("김근영");
		dto.setContent("오늘은 금요일");
		dto.setWname("이지");
		dto.setPasswd("1234");
		
		
		if(dao.create(dto)){
			p("성공");
		}else {
			p("실패");
		}
	}


	
	private static void p(GuestDTO dto) {
		p("번호:" + dto.getGuestno());
		p("글쓴이:" + dto.getWname());
		p("제목:" + dto.getTitle());
		p("내용" + dto.getContent());
		p("조회수:" + dto.getViewcnt());
		p("날짜:" + dto.getWdate());
	}
	private static void p(String string) {
		System.out.println(string);
		
	}

}
