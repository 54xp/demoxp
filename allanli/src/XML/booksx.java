package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class booksx {
	public static void main(String[] args) throws Exception {
		//1.������������������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.��������������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.�����ĵ�����
		Document document = builder.parse(new File("books.xml"));
		System.out.println("xml�ĵ��汾:"+document.getXmlVersion());
		System.out.println("xml�ĵ��ı���:"+document.getXmlEncoding());
	}
}
