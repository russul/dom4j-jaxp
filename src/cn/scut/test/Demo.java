package cn.scut.test;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo {
	public static void main(String[] args) {
		SAXReader saxReader = new SAXReader();
		Document doc=null;
		try {
			InputStream in = Class.forName("cn.scut.test.Demo").getClass()
					.getResourceAsStream("/student.xml");
			doc = saxReader.read(in);
			Element root=doc.getRootElement();
			System.out.println(root.getName());
			List<Node> arrlList=doc.selectNodes("//student/@name");
			for(int i=0;i<arrlList.size();i++){
				System.out.println(((Attribute)arrlList.get(i)).getData());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
