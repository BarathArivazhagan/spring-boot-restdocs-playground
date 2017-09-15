package com.barath.app;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootRestdocsPlaygroundApplicationTests {

	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("/target/docs");

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveUser() throws Exception{

		this.mockMvc.perform(MockMvcRequestBuilders.post("/user/create").param("userName","barath"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcRestDocumentation.document("index"));
	}

}
