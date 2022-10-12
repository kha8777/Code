package Entity;

public class TKPhongBan {
	private String TK;

	public TKPhongBan (String tK) {
		super();
		TK = tK;
	}
	public TKPhongBan () {
		this("");
		// TODO Auto-generated constructor stub
	}
	
	public String getTK() {
		return TK;
	}
	public void setTK(String tK) {
		TK = tK;
	}
	@Override
	public String toString() {
		return TK ;
	}
}
