package Entity;

public class TKNhanSuDaThamGia {
	private String TK;

	public TKNhanSuDaThamGia(String tK) {
		super();
		TK = tK;
	}
	public TKNhanSuDaThamGia() {
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
