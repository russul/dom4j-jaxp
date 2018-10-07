package cn.scut.operator.impl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import cn.scut.info.Student;
import cn.scut.operator.StuOperator;

public class StuOperatorImpl implements StuOperator {

	@Override
	public void addStudent(Student student) {

		
//		1������������
//		2����ø�Ԫ�أ�student��
//		3.�����ı�����ֵage��name��ID
//		4������Ԫ�أ���ǩ��age��name��ID
//		5�����ı���ӳ�Ϊ��ӦԪ�ص��ӽڵ�
//		6�����stuԪ��
//		7����Ԫ�أ���ǩ��age��name��ID��ӵ�stu����
//		8����stu��ӳ�Ϊstudent���ӽڵ�
//		9����д��xml�ļ���
//		ע�⣺jaxp��ʽ���û�и�ʽ�����ܣ�����dom4j�������е�
		// TODO Auto-generated method stub
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document document = null;
		try {
			dBuilder = dFactory.newDocumentBuilder();
			document = dBuilder.parse("src/Student.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		NodeList nodeList = document.getElementsByTagName("student");
		Element stu = document.createElement("stu");

		Text idText = document.createTextNode(student.getId());
		Element idElement = document.createElement("id");
		idElement.appendChild(idText);

		Text nameText = document.createTextNode(student.getName());
		Element nameElement = document.createElement("name");
		nameElement.appendChild(nameText);

		Text ageText = document.createTextNode(student.getAge());
		Element ageElement = document.createElement("age");
		ageElement.appendChild(ageText);

		stu.appendChild(idElement);
		stu.appendChild(nameElement);
		stu.appendChild(ageElement);
		Node node = nodeList.item(0);
		node.appendChild(stu);

		// 回写到xml中
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			transformer.transform(new DOMSource(document), new StreamResult(
					"src/Student.xml"));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(String id) {

		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document document = null;
		try {
			dBuilder = dFactory.newDocumentBuilder();
			document = dBuilder.parse("src/Student.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}

		NodeList nodeList = document.getElementsByTagName("id");
		for (int i = 0; i < nodeList.getLength(); i++) {
			NodeList idNodeList = nodeList.item(i).getChildNodes();
			Node idNode = idNodeList.item(0);
			if ((idNode.getTextContent().equals(id))) {
				NodeList nodeList1 = document.getElementsByTagName("student");
				nodeList1.item(0).removeChild(nodeList.item(i).getParentNode());
			}

		}

		// ��д��xml�ļ���
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			transformer.transform(new DOMSource(document), new StreamResult(
					"src/Student.xml"));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
