package stt37_tranVinhKha_20051271;

public class FullName {
	private String lastname;
	private String firstname;
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) throws Exception {
		if (lastname.isEmpty()) throw new Exception("Chuoi khong duoc rong");
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) throws Exception {
		if (firstname.isEmpty()) throw new Exception("Chuoi khong duoc rong");
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
	public FullName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FullName(String lastname, String firstname) throws Exception {
		super();
		setLastname(lastname);
		setFirstname(firstname);
	}
	
	
}
