package cn.scut.testjaxp;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JaxpTest {

	public static void main(String[] args) throws Exception {

		
		selectAll();
	}

	public static void selectAll() throws ParserConfigurationException,
			SAXException, IOException {
		// ��ȡ������
		DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = dBuilderFactory.newDocumentBuilder();
		// ���н���

		Document document = dBuilder.parse("src/person.xml");
		// ��ö���name��ǩ������
		NodeList nodeList = document.getElementsByTagName("name");
		// ����
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nameNode = nodeList.item(i);
			String nameString = nameNode.getTextContent();
			System.out.println(nameString);
		}
	}

}
