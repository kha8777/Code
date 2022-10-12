package manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.SinhVien;

public class DanhSachSinhVien {
	private static String fileName = "D:\\sinhvien.xml";
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public DanhSachSinhVien() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(fileName);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<SinhVien> getDS() {
		ArrayList<SinhVien> ls = new ArrayList<SinhVien>();
		
		Element root = document.getDocumentElement();
		NodeList dssv = root.getElementsByTagName("sinhvien");
		
		for (int i = 0; i < dssv.getLength(); i++) {
			Element sv = (Element) dssv.item(i);
			String ma = sv.getAttribute("id");
			String hoten = sv.getElementsByTagName("hoten").item(0).getTextContent();
			String lop = sv.getElementsByTagName("lop").item(0).getTextContent();
			String noisinh = sv.getElementsByTagName("noisinh").item(0).getTextContent();
			String monhoc = sv.getElementsByTagName("monhoc").item(0).getTextContent();
			
			SinhVien s = new SinhVien(Integer.parseInt(ma), hoten, lop, noisinh, monhoc);
			ls.add(s);
			
		}
		
		return ls;
	}
	
	public void themSinhVien(SinhVien s) {
		Element root = document.getDocumentElement();
		
		Element sv = document.createElement("sinhvien");
		root.appendChild(sv);
		sv.setAttribute("id", s.getMa() + "");
		
		Node hoten = document.createElement("hoten");
		sv.appendChild(hoten);
		hoten.setTextContent(s.getHoten());
		
		Node lop = document.createElement("lop");
		sv.appendChild(lop);
		lop.setTextContent(s.getLop());
		
		Node noisinh = document.createElement("noisinh");
		sv.appendChild(noisinh);
		noisinh.setTextContent(s.getNoisinh());
			
		Node monhoc = document.createElement("monhoc");
		sv.appendChild(monhoc);
		monhoc.setTextContent(s.getMonhoc());
			
	}
	
	public void xoaSinhVien(String ma) {
		Element root = document.getDocumentElement();
		
		NodeList dssv = root.getElementsByTagName("sinhvien");
		for (int i = 0; i < dssv.getLength(); i++) {
			Element sv = (Element) dssv.item(i);
			String macanxoa = sv.getAttribute("id");
			if (macanxoa.equalsIgnoreCase(ma)) {
				sv.getParentNode().removeChild(sv);
				break;
			}
		}
	}
	
	public void capNhatLop(int ma, String lop) {
		Element root = document.getDocumentElement();
		
		NodeList dssv = root.getElementsByTagName("sinhvien");
		for (int i = 0; i < dssv.getLength(); i++) {
			Element sv = (Element) dssv.item(i);
			int macapnhat = Integer.parseInt(sv.getAttribute("id"));
			if (macapnhat == ma) {
				Node lopNode = sv.getElementsByTagName("lop").item(0);
				lopNode.setTextContent(lop);
				break;
			}
		}
	}
	
	public void writeXMLFile() {
		TransformerFactory fac = null;
		Transformer transformer = null;
		try {
			fac = TransformerFactory.newInstance();
			transformer = fac.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(fileName));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
