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
		// 获取解析器
		DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = dBuilderFactory.newDocumentBuilder();
		// 进行解析

		Document document = dBuilder.parse("src/person.xml");
		// 获得多有name标签的内容
		NodeList nodeList = document.getElementsByTagName("name");
		// 遍历
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nameNode = nodeList.item(i);
			String nameString = nameNode.getTextContent();
			System.out.println(nameString);
		}
	}

}
