package com.restapi.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.restapi.base.TestBase;

public class RestClient {

	// 1. Get method

	public void get(String url) {
		System.out.println("inside get method");
		int statusCode = 0;

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url); // http GET Request
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet); // hit the http url

			// StatusCode
			statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status Code: " + statusCode);

			// Response String
			String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			JSONObject responseJson = new JSONObject(responseString);
			System.out.println("Response Json from API:" + responseJson);

			// Headers
			Header[] headersArray = httpResponse.getAllHeaders();
			HashMap<String, String> allHeaders = new HashMap<String, String>();

			for (Header header : headersArray) {
				allHeaders.put(header.getName(), header.getValue());

			}

			System.out.println("HeadersArra--->>" + allHeaders);

		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public CloseableHttpResponse getResponse(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);

		return closeableHttpResponse;

	}

};