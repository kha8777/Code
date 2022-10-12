package Entity;

public class TKDuAn {
	private String TK;

	public TKDuAn(String tK) {
		super();
		TK = tK;
	}
	public TKDuAn() {
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
