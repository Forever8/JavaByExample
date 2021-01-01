package com.javabyexample.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabyexample.json.domain.Address;
import com.javabyexample.json.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
class JsonApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void createFile() throws IOException {
		Path path = Paths.get("src/test/resources/data.json");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}
		BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
		bufferedWriter.write("{\"name\": \"Wishing\"}");
		bufferedWriter.flush();
	}

	@Test
	void parse() throws JsonProcessingException {
		String str = "{\"name\":\"Wishing\",\"email\":\"forever8@163.com\",\"address\":{\"country\":\"China\",\"province\":\"Guangdong\",\"city\":\"Guangzhou\"}}";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(str);
		System.out.println(jsonNode.toString());
		Assertions.assertEquals(jsonNode.get("name").toString(), "\"Wishing\"");
		Assertions.assertEquals(jsonNode.get("email").toString(), "\"forever8@163.com\"");
		Assertions.assertNull(jsonNode.get("invalid"));
		Assertions.assertEquals(jsonNode.get("address").get("country").toString(), "\"China\"");
	}

	@Test
	void stringify() throws JsonProcessingException {
		Address address = new Address();
		address.setCountry("China");
		address.setProvince("Guangdong");
		address.setCity("Guangzhou");
		address.setPostalCode("510000");

		User user = new User();
		user.setName("Wishing");
		user.setEmail("forever8@163.com");
		user.setAddress(address);

		ObjectMapper objectMapper = new ObjectMapper();
		String userString = objectMapper.writeValueAsString(user);
		System.out.println(userString);
	}
}
