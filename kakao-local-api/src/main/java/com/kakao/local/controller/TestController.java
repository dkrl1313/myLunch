package com.kakao.local.controller;

import com.kakao.local.domain.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	private static final String REST_API_KEY = "KakaoAK 60d55acefee456b6abba9ee400a78b54";


	// 주소 받아서 kakao api 결과 응답
	// X: 126.87880659999999, Y: 37.4730911
	@RequestMapping(value="/callApi", method = RequestMethod.GET)
	public ResponseEntity<Map> callKaKaoLocalApi(
			@RequestParam("xLng") double xLng
			, @RequestParam("yLat") double yLat) {
		logger.info("callKaKaoLocalApi controller");

		ResponseVO responseVO = new ResponseVO();

		final String url = "https://dapi.kakao.com/v2/local/search/keyword.json";

		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(url, String.class);

		// Set Headers
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", REST_API_KEY);

		// Set Param
		UriComponentsBuilder builder = null;
		try {
			builder = UriComponentsBuilder.fromHttpUrl(url)
					.queryParam("page", 5)
					.queryParam("size", 15)
					.queryParam("sort", "accuracy")
					.queryParam("query", URLEncoder.encode("맛집","UTF-8"))
					.queryParam("category_group_code", "FD6")
					.queryParam("x", xLng)
					.queryParam("y", yLat)
					.queryParam("radius", "500");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// Create a new HttpEntity
		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Map> response = restTemplate.exchange(builder.encode().toUriString(),
				HttpMethod.GET,
				entity,
				Map.class);

		System.out.println(response);
		return response;
	}

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(){
		return "test";
	}
}
