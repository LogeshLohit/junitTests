package com.logesh.JPATest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logesh.xml.Employee;
import com.logesh.xml.EmployeeController;
import com.logesh.xml.EmployeeRunner;
import com.logesh.xml.EmployeeService;

import jdk.net.SocketFlow.Status;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeRunner.class)
//@WebMvcTest(controllers = EmployeeController.class)
@AutoConfigureMockMvc
public class JpaTestApplicationTests {
//	@Autowired
//	private CarShowRoomService svc;

	
	@Autowired
	private MockMvc mvc;

	
	@MockBean
	private EmployeeService svc;
	
	//private JacksonTester<Employee> json;

//	@Before
//	public void setUp() {
//		JacksonTester.initFields(this, new ObjectMapper());
//	}

//	@Autowired
//	private EmployeeController cont;
//
//	@Before
//	public void run() {
//		// TODO Auto-generated constructor stub
//		cont = new EmployeeController();
//	}
//
//	@Test
//	public void contextLoads() {
//		System.out.println("test");
////	svc.getDtls();///
//
//		String resp = cont.greet();
//		System.out.println(resp);
//		assertThat(resp).isEqualTo("Hello");
//		// assertThat(resp).isEqualTo("Hello World");
//		System.out.println("----");
//	}
//
	@Test
	public void empTest() throws Exception {
		System.out.println("here");
		
		MockHttpServletResponse resp = 
		mvc.perform(get("/employees").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		System.out.println(resp.getContentAsString());
		assertThat(resp.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

}
