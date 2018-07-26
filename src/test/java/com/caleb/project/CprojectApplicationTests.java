package com.caleb.project;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CprojectApplicationTests {

	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void contextLoads() {
		System.out.println(jsonParse("{\"id\":1,\"nombre\":\"joel\"}").get("id"));
	}
	
	private Map<String, String> jsonParse(String jsonText) {
		try {
			Map<String, String> map = mapper.readValue(jsonText, new TypeReference<Map<String,String>>(){});
			return map;
		} catch (IOException e) {
			System.err.println(e.getMessage() + jsonText);
			return null;
		}
	}

}
