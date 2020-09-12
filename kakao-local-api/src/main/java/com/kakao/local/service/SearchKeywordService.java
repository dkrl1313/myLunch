package com.kakao.local.service;

import com.kakao.local.domain.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@Slf4j
@Service
public class SearchKeywordService {

    private static final String REST_API_KEY = "KakaoAK 60d55acefee456b6abba9ee400a78b54";
    private static final String REST_API_URL = "https://dapi.kakao.com/v2/local/search/keyword.json";

    public ResponseEntity<Map> callKaKaoLocalApi(double xLng, double yLat) {

        RestTemplate restTemplate = new RestTemplate();

        // Set Headers
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", REST_API_KEY);

        // Set Param
        UriComponentsBuilder builder = null;
            
        builder = UriComponentsBuilder
				.fromHttpUrl(REST_API_URL)
		        .queryParam("page", 5)
		        .queryParam("size", 15)
		        .queryParam("sort", "accuracy")
		        .queryParam("category_group_code", "FD6")
		        .queryParam("x", xLng)
		        .queryParam("y", yLat)
		        .queryParam("radius", "500");
        
        // Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        ParameterizedTypeReference<Map<String, Object>> typeRef = new ParameterizedTypeReference<Map<String, Object>>() {};

        // 한글 
        uri = builder.encode().toUriString() + "&query=" + query;
//        log.info(uri);
        
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
        		uri,
				HttpMethod.GET,
				entity,
				typeRef);
        
        return response;
    }
}
