package com.restapi.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.client.RestClient;

public class GetAPITest extends TestBase {

	public static TestBase testBase;
	public String url;
	public String apiUrl;
	public static String completeUrl;
	CloseableHttpResponse closeableHttpResponse;

	@BeforeMethod
	public void setUp() {
		System.out.println("setUP");
		testBase = new TestBase();
		String url = prop.getProperty("url");
		System.out.println("url:" + url);
		String apiUrl = prop.getProperty("serviceurl");

		completeUrl = url + apiUrl;
		System.out.println("completeURL:" + completeUrl);

	}

	@Test(priority = 1, enabled = false)
	public void getAPITTest() {

		RestClient restClient = new RestClient();
		System.out.println("completeURL:" + completeUrl);

		if (completeUrl != null) {
			restClient.get(GetAPITest.completeUrl);

		} else {
			System.out.println("complete URL is null");
		}

		// Assert.assertEquals(statusCode, "200");
	}

	@Test(priority = 2, enabled = true)
	public void getAPITTesting() throws ClientProtocolException, IOException {
		RestClient restClient = new RestClient();
		closeableHttpResponse = restClient.getResponse(GetAPITest.completeUrl);

		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();

		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status Code is not 200");

	}

}
