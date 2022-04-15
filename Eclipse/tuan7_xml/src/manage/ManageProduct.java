package manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.Product;
import entity.Supplier;

public class ManageProduct {
	private static String fileName = "D:\\product.xml";
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public ManageProduct() {
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
	
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> ls = new ArrayList<Product>();
		
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		
		int pLeng = pList.getLength();
		for (int i = 0; i < pLeng; i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			String name = pNode.getElementsByTagName("name").item(0).getTextContent();
			String manufacture = pNode.getElementsByTagName("manufacture").item(0).getTextContent();
			String description = pNode.getElementsByTagName("description").item(0).getTextContent();
			
			Element sNode = (Element) pNode.getElementsByTagName("supplier").item(0);
			String supplierName = sNode.getElementsByTagName("name").item(0).getTextContent();
			String country = sNode.getElementsByTagName("country").item(0).getTextContent();
			String website = sNode.getElementsByTagName("website").item(0).getTextContent();
			
			Supplier supplier = new Supplier(supplierName, country, website);
			
			String sPrice = pNode.getElementsByTagName("price").item(0).getTextContent();
			double price = 0.0;
			try {
				price = Double.valueOf(sPrice);
				
			} catch (NumberFormatException e) {}
			
			Product p = new Product(productID, name, manufacture, description, supplier, price);
			ls.add(p);
			
		}
		
		return ls;
	}
	
}
