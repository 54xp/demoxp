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
		//1.������������������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.��������������
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.�����ĵ�����
		Document document = builder.parse(new File("books.xml"));
		//��ȡ��Ԫ�ؽڵ�
		Element element = document.getDocumentElement();
		System.out.println(element.getTagName());
		//����Ԫ�����ƻ�ȡ����
		NodeList list = document.getElementsByTagName("Book");
		System.out.println("һ����"+list.getLength()+"����");
		//����ÿһ����
		for(int i=0;i<list.getLength();i++){
			System.out.println("===============��ʼ����"+(i+1)+"���������============");
			Node book = list.item(i);
			//��ȡbook�ڵ���������Լ���
			NamedNodeMap attrs = book.getAttributes();
			System.out.println("��"+(i+1)+"������"+attrs.getLength()+"������");
			//��������
			for(int j =0;j<attrs.getLength();j++){
				Node attr = attrs.item(j);
				//��ȡ������������ֵ
				System.out.print("��������"+attr.getNodeName());
				System.out.print("����ֵ��"+attr.getNodeValue());
			}
			//����Book�ڵ���ӽڵ�
			NodeList children = book.getChildNodes();
			System.out.println("��"+(i+1)+"������"+children.getLength()+"�ӽڵ�");
			for(int k=0;k<children.getLength();k++){
				//System.out.println(children.item(k).getNodeName()+"����:"+children.item(k).getNodeType());
				Node node = children.item(k);		
				if(1==node.getNodeType()){
					//Ԫ�ؽڵ�
					System.out.println(node.getNodeValue()); //Ԫ�ؽڵ��nodevalueΪ��
					System.out.println(node.getFirstChild());
				}
			}
			System.out.println("==========��������"+(i+1)+"���������");
		}
	}
}
