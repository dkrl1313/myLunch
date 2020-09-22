package com.kakao.local.service;

import lombok.extern.slf4j.Slf4j;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.kakao.local.domain.ResponseVO;

import java.util.Map;

@Slf4j
@Service
public class SearchKeywordService {

    private static final String REST_API_KEY = "KakaoAK 60d55acefee456b6abba9ee400a78b54";
    private static final String REST_API_URL = "https://dapi.kakao.com/v2/local/search/keyword.json";

	public ResponseVO callKaKaoLocalApi(
			double xLng, double yLat, String query,
			Integer page, Integer size, String sort, String cateCode, String rad ) {

		String uri;
        RestTemplate restTemplate = new RestTemplate();

        // Set Headers
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", REST_API_KEY);

        // Set Param
        UriComponentsBuilder builder = null;
        builder = UriComponentsBuilder
				.fromHttpUrl(REST_API_URL)
		        .queryParam("page", page)
		        .queryParam("size", size)
		        .queryParam("sort", sort)
		        .queryParam("category_group_code", cateCode)
		        .queryParam("x", xLng)
		        .queryParam("y", yLat)
		        .queryParam("radius", rad);
        
        // Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        ParameterizedTypeReference<Map<String, Object>> typeRef = new ParameterizedTypeReference<Map<String, Object>>() {};

        // 한글 
        uri = builder.encode().toUriString() + "&query=" + query;
//        log.info(uri);
        
        ResponseEntity<ResponseVO> response = restTemplate.exchange(
        		uri,
				HttpMethod.GET,
				entity,
				ResponseVO.class);
        
        ResponseVO res = new ResponseVO();
        res.setStatus(response.getStatusCode().toString());
        res.setDocuments(response.getBody().getDocuments());
        
         
        return res;
    }
}

