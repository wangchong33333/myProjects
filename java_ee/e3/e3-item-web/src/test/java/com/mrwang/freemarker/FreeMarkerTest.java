package com.mrwang.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTest {

	@Test
	public void testFreeMarker() throws Exception {
		Configuration configuration = new Configuration(Configuration.getVersion());
		configuration.setDirectoryForTemplateLoading(
				new File("C:\\myProjects\\java_ee\\e3-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
		configuration.setDefaultEncoding("utf-8");
		// Template template = configuration.getTemplate("hello.ftl");
		Template template = configuration.getTemplate("student.ftl");
		Map data = new HashMap<>();
		data.put("hello", "hello freemarker");
		Student student = new Student(1, "小明", 18, "武汉");
		data.put("student", student);

		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "小明1", 18, "武汉"));
		students.add(new Student(2, "小明2", 18, "武汉"));
		students.add(new Student(3, "小明3", 18, "武汉"));
		students.add(new Student(4, "小明4", 18, "武汉"));
		students.add(new Student(5, "小明5", 18, "武汉"));
		students.add(new Student(6, "小明6", 18, "武汉"));
		students.add(new Student(7, "小明7", 18, "武汉"));
		students.add(new Student(8, "小明8", 18, "武汉"));
		students.add(new Student(9, "小明9", 18, "武汉"));
		data.put("students", students);
		
		data.put("date", new Date());
		
		data.put("val", 123);
		// Writer out = new FileWriter(new File("E:\\Java ee\\freemarker\\hello.txt"));
		Writer out = new FileWriter(new File("E:\\Java ee\\freemarker\\student.html"));
		template.process(data, out);
		out.close();
	}
}
