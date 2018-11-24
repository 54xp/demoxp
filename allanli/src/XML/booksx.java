package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class booksx {
	public static void main(String[] args) throws Exception {
		//1.创建解析器工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.创建解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.创建文档对象
		Document document = builder.parse(new File("books.xml"));
		System.out.println("xml文档版本:"+document.getXmlVersion());
		System.out.println("xml文档的编码:"+document.getXmlEncoding());
	}
}
