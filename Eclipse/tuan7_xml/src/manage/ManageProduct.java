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
		
		for (int i = 0; i < pList.getLength(); i++) {
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
	
	public void addProduct(Product p) {
		Element root = document.getDocumentElement();
		
		Element pNode = document.createElement("product");
		root.appendChild(pNode);
		pNode.setAttribute("id", p.getProductID());
		
		Node name = document.createElement("name");
		pNode.appendChild(name);
		name.setTextContent(p.getProductName());
		
		Node manufacture = document.createElement("manufacture");
		pNode.appendChild(manufacture);
		manufacture.setTextContent(p.getManufacture());
		
		Node description = document.createElement("description");
		pNode.appendChild(description);
		description.setTextContent(p.getDescription());
		
			Element sNode = document.createElement("supplier");
			pNode.appendChild(sNode);
			
			Node sName = document.createElement("name");
			sNode.appendChild(sName);
			sName.setTextContent(p.getSupplier().getName());
			
			Node country = document.createElement("country");
			sNode.appendChild(country);
			country.setTextContent(p.getSupplier().getCountry());
			
			Node website = document.createElement("name");
			sNode.appendChild(website);
			website.setTextContent(p.getSupplier().getWebsite());
			
		Node price = document.createElement("price");
		pNode.appendChild(price);
		price.setTextContent(p.getPrice() + "");
			
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
