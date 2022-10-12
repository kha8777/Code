package Entity;

public class TKDuAnDaHoanThanh {
private String TK;

public TKDuAnDaHoanThanh(String tK) {
	super();
	TK = tK;
}
public TKDuAnDaHoanThanh() {
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
