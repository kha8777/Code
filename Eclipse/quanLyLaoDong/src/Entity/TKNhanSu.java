package Entity;

public class TKNhanSu {
	private String TK;

	public TKNhanSu (String tK) {
		super();
		TK = tK;
	}
	public TKNhanSu () {
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
