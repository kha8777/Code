package Entity;

public class TKNhanSuChuaThamGia {
	private String TK;

	public TKNhanSuChuaThamGia(String tK) {
		super();
		TK = tK;
	}
	public TKNhanSuChuaThamGia() {
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
