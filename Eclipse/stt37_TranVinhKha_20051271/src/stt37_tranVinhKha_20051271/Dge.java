package stt37_tranVinhKha_20051271;

public class Dge {
	public static void main(String[] args) {
		int n = 10;
		System.out.println("before calling change function, n = " + n);
		change(n);
		System.out.println("after calling change function, n = " + n);
	}
	
	public static void change(int n) {
		n = 5;
	}
}