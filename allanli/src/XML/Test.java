package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {
	public static void main(String[] args) throws Exception {
		//1.创建解析器工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.创建解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.创建文档对象
		Document document = builder.parse(new File("books.xml"));
		//获取根元素节点
		Element element = document.getDocumentElement();
		System.out.println(element.getTagName());
		//根据元素名称获取对象
		NodeList list = document.getElementsByTagName("Book");
		System.out.println("一共有"+list.getLength()+"本书");
		//遍历每一本书
		for(int i=0;i<list.getLength();i++){
			System.out.println("===============开始遍历"+(i+1)+"本书的内容============");
			Node book = list.item(i);
			//获取book节点的所有属性集合
			NamedNodeMap attrs = book.getAttributes();
			System.out.println("第"+(i+1)+"本书有"+attrs.getLength()+"个属性");
			//遍历属性
			for(int j =0;j<attrs.getLength();j++){
				Node attr = attrs.item(j);
				//获取属性名和属性值
				System.out.print("属性名："+attr.getNodeName());
				System.out.print("属性值："+attr.getNodeValue());
			}
			//解析Book节点的子节点
			NodeList children = book.getChildNodes();
			System.out.println("第"+(i+1)+"本书有"+children.getLength()+"子节点");
			for(int k=0;k<children.getLength();k++){
				//System.out.println(children.item(k).getNodeName()+"类型:"+children.item(k).getNodeType());
				Node node = children.item(k);		
				if(1==node.getNodeType()){
					//元素节点
					System.out.println(node.getNodeValue()); //元素节点的nodevalue为空
					System.out.println(node.getFirstChild());
				}
			}
			System.out.println("==========结束遍历"+(i+1)+"本书的内容");
		}
	}
}
