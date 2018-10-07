package cn.scut.test;

import cn.scut.info.Student;
import cn.scut.operator.impl.*;

public class StudentTest {
	public static void main(String[] args) throws Exception {
		Student student=new Student();
		student.setId("010");
		student.setName("Tim");
		student.setAge("23");
		StuOperatorImpl so = new StuOperatorImpl();
		so.addStudent(student);
		so.deleteStudent("002");
		
	}
	
	
}
