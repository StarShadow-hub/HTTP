package org.apiPack;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class HTTPMethods {
	
	@Test
	public void get() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.queryParam("page", "2");
		Response res = reqSpec.request(Method.GET,"/api/users");
		ResponseBody body = res.getBody();
		String str = body.asPrettyString();
		System.out.println(str);
		int code = res.getStatusCode();
		Assert.assertEquals(200, code);
		System.out.println(code);
	}
	
	//@Test
	public void post() {
		RestAssured.baseURI= "https://reqres.in/";
		RequestSpecification requestspec = RestAssured.given();
		requestspec.header("Content-Type","application/json");
		HashMap m = new HashMap();
		m.put("name", "vijay");
		m.put("job", "QAE");
		requestspec.body(m);
		Response resp = requestspec.request(Method.POST,"/api/users");
		String st = resp.getBody().asPrettyString();
		System.out.println(st);
		int sta =resp.getStatusCode();
		System.out.println(sta);
		Assert.assertEquals(201, sta);		
	}

}
