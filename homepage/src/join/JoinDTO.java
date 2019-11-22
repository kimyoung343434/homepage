package join;

public class JoinDTO {
	
	private String id        ;
	private String    mname      ;
	private String    zipcode    ;
	private String    address1   ;
	private String    address2   ;
	private String    tel        ;
	private String    fname      ;
	private String passwd;
	private String grade;
	
	public JoinDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JoinDTO(String id, String mname, String zipcode, String address1, String address2, String tel, String fname,
			String passwd, String grade) {
		super();
		this.id = id;
		this.mname = mname;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.tel = tel;
		this.fname = fname;
		this.passwd = passwd;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "JoinDTO [id=" + id + ", mname=" + mname + ", zipcode=" + zipcode + ", address1=" + address1
				+ ", address2=" + address2 + ", tel=" + tel + ", fname=" + fname + ", passwd=" + passwd + ", grade="
				+ grade + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	

}






