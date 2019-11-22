package join;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JoinDAO dao = new JoinDAO();
		
		//create(dao);
		//idCheck(dao);
		//telCheck(dao);
		//passCheck(dao);
			//list(dao);
		//total(dao);
		//read(dao);
		//updateFile(dao);
		//updatePw(dao);
		//update(dao);
		//loginCheck(dao);
		//delete(dao);
		//findID(dao);
		//findPasswd(dao);
		grade(dao);

	}
	
	
	
	
	
	
	
	private static void grade(JoinDAO dao) {
		String grade = dao.getGrade("user1");
		p(grade);
		
		}



	private static void telCheck(JoinDAO dao) {
		if(dao.duplicatedTel("444-4444")) {
			p("중복된 전화번호");
		}else {
			p("사용가능한 전화번호");
		}
		
	}







	private static void findPasswd(JoinDAO dao) {
		Map map = new HashMap();
		map.put("mname", "김근영");
		map.put("id", "ttt");
		
		String passwd = dao.findPasswd(map);
		p("비밀번호 : " + passwd);
		
	}







	private static void findID(JoinDAO dao) {
		Map map = new HashMap();
		map.put("mname", "김근영");
		map.put("tel", "444-4444");
		
		String id = dao.findID(map);
		p("아이디 : " + id);
		
	}







	private static void delete(JoinDAO dao) {
		if(dao.delete("admin10")) {
			p("삭제성공");
		}else {
			p("삭제실패");
		}
		
	}







	private static void loginCheck(JoinDAO dao) {
		Map map = new HashMap();
		map.put("id", "admin");
		map.put("pw", "9999");
		
		if(dao.loginCheck(map)) {
			p("로그인성공");
		}else {
			p("로그인실패");
		}
		
	}







	private static void update(JoinDAO dao) {
		JoinDTO dto = dao.read("admin");
		
		dto.setTel("010-2222-3333");
		dto.setAddress1("대구시 달서구 송현동");
		dto.setAddress2("청구그린1차");
		
		if(dao.update(dto)) {
			p("정보 수정을 성공했습니다.");
		}else {
			p("정보 수정을 실패했습니다.");
		}
		
		
	}







	private static void updatePw(JoinDAO dao) {
		Map map = new HashMap();
		map.put("id", "admin");
		map.put("pw", "1111");
		
		if(dao.updatePw(map)) {
			p("비번 변경 성공");
		}
		
	}







	private static void updateFile(JoinDAO dao) {
		Map map = new HashMap();
		map.put("id", "admin");
		map.put("fname", "bbb.jpg");
		
		if(dao.updateFile(map)) {
			p("사진 수정성공");
		}else {
			p("사진 수정실패");
		}
		
	}





	private static void read(JoinDAO dao) {
		JoinDTO dto = dao.read("admin");
		p(dto);
		
	}




	private static void total(JoinDAO dao) {
		Map map = new HashMap();
		map.put("col", "mname");
		map.put("word", "김근우");
		
		p("전체 레코드 갯수:" + dao.total(map));
		
	}







	private static void list(JoinDAO dao) {
		Map map = new HashMap();
		map.put("col", "mname");
		map.put("word", "김근우");
		map.put("sno", 1);
		map.put("eno", 3);
		
		List<JoinDTO>list = dao.list(map);
		Iterator<JoinDTO>iter = list.iterator();
		
		while(iter.hasNext()) {
			JoinDTO dto = iter.next();
			p(dto);
			p("--------");
		}
		
		
	}







	private static void passCheck(JoinDAO dao) {
		Map map = new HashMap();
		map.put("id", "admin");
		map.put("passwd", "1111");
		
		if(dao.passCheck(map)) {
			p("올바른 비번");
		}else {
			p("잘못된 비번");
		}
		
		
	}







	private static void idCheck(JoinDAO dao) {
		if(dao.duplicatedId("user4")){
			p("중복된 아이디");
		}else {
			p("사용가능한 아이디");
		}
		
	}







	private static void create(JoinDAO dao) {
		JoinDTO dto = new JoinDTO();
		
		dto.setId("kimyoung5");
		dto.setMname("김근영");
		dto.setTel("010-6666-7777");
		dto.setZipcode("12345");
		dto.setAddress1("서울시 용산구 용문동");
		dto.setAddress2("빌라");
		dto.setFname("house.jpg");
		
		if(dao.create(dto)){
			p("성공");
		}else {
			p("실패");
		}
		
	}







	private static void p(JoinDTO dto) {
		p("id:" + dto.getId());
		p("이름:" + dto.getMname());
		p("우편번호:" + dto.getZipcode());
		p("전화번호:" + dto.getTel());
		p("주소:" + dto.getAddress1());
		p("상세주소:" + dto.getAddress2());
		p("사진:" + dto.getFname());
		
	}
	
	private static void p(String string) {
		System.out.println(string);
	}

}
