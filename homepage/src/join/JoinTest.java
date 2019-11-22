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
			p("�ߺ��� ��ȭ��ȣ");
		}else {
			p("��밡���� ��ȭ��ȣ");
		}
		
	}







	private static void findPasswd(JoinDAO dao) {
		Map map = new HashMap();
		map.put("mname", "��ٿ�");
		map.put("id", "ttt");
		
		String passwd = dao.findPasswd(map);
		p("��й�ȣ : " + passwd);
		
	}







	private static void findID(JoinDAO dao) {
		Map map = new HashMap();
		map.put("mname", "��ٿ�");
		map.put("tel", "444-4444");
		
		String id = dao.findID(map);
		p("���̵� : " + id);
		
	}







	private static void delete(JoinDAO dao) {
		if(dao.delete("admin10")) {
			p("��������");
		}else {
			p("��������");
		}
		
	}







	private static void loginCheck(JoinDAO dao) {
		Map map = new HashMap();
		map.put("id", "admin");
		map.put("pw", "9999");
		
		if(dao.loginCheck(map)) {
			p("�α��μ���");
		}else {
			p("�α��ν���");
		}
		
	}







	private static void update(JoinDAO dao) {
		JoinDTO dto = dao.read("admin");
		
		dto.setTel("010-2222-3333");
		dto.setAddress1("�뱸�� �޼��� ������");
		dto.setAddress2("û���׸�1��");
		
		if(dao.update(dto)) {
			p("���� ������ �����߽��ϴ�.");
		}else {
			p("���� ������ �����߽��ϴ�.");
		}
		
		
	}







	private static void updatePw(JoinDAO dao) {
		Map map = new HashMap();
		map.put("id", "admin");
		map.put("pw", "1111");
		
		if(dao.updatePw(map)) {
			p("��� ���� ����");
		}
		
	}







	private static void updateFile(JoinDAO dao) {
		Map map = new HashMap();
		map.put("id", "admin");
		map.put("fname", "bbb.jpg");
		
		if(dao.updateFile(map)) {
			p("���� ��������");
		}else {
			p("���� ��������");
		}
		
	}





	private static void read(JoinDAO dao) {
		JoinDTO dto = dao.read("admin");
		p(dto);
		
	}




	private static void total(JoinDAO dao) {
		Map map = new HashMap();
		map.put("col", "mname");
		map.put("word", "��ٿ�");
		
		p("��ü ���ڵ� ����:" + dao.total(map));
		
	}







	private static void list(JoinDAO dao) {
		Map map = new HashMap();
		map.put("col", "mname");
		map.put("word", "��ٿ�");
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
			p("�ùٸ� ���");
		}else {
			p("�߸��� ���");
		}
		
		
	}







	private static void idCheck(JoinDAO dao) {
		if(dao.duplicatedId("user4")){
			p("�ߺ��� ���̵�");
		}else {
			p("��밡���� ���̵�");
		}
		
	}







	private static void create(JoinDAO dao) {
		JoinDTO dto = new JoinDTO();
		
		dto.setId("kimyoung5");
		dto.setMname("��ٿ�");
		dto.setTel("010-6666-7777");
		dto.setZipcode("12345");
		dto.setAddress1("����� ��걸 �빮��");
		dto.setAddress2("����");
		dto.setFname("house.jpg");
		
		if(dao.create(dto)){
			p("����");
		}else {
			p("����");
		}
		
	}







	private static void p(JoinDTO dto) {
		p("id:" + dto.getId());
		p("�̸�:" + dto.getMname());
		p("�����ȣ:" + dto.getZipcode());
		p("��ȭ��ȣ:" + dto.getTel());
		p("�ּ�:" + dto.getAddress1());
		p("���ּ�:" + dto.getAddress2());
		p("����:" + dto.getFname());
		
	}
	
	private static void p(String string) {
		System.out.println(string);
	}

}
