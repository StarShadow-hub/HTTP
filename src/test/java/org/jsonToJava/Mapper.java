package org.jsonToJava;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File f = new File("src\\test\\resources\\JsonFiles\\input.json");
		ObjectMapper om = new ObjectMapper();
		Deserial value = om.readValue(f, Deserial.class);
		ArrayList<user> data = value.getData();
		user user = data.get(1);
		String first_name = user.getFirst_name();
		System.out.println(first_name);
			
	}

}
