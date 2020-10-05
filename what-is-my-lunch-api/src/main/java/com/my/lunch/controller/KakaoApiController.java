package com.my.lunch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kakao.local.domain.ResponseVO;
import com.kakao.local.service.SearchKeywordService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api")
public class KakaoApiController {
	
	@Autowired
    private SearchKeywordService searchKeywordService;

	@ResponseBody
	@RequestMapping(value = "/kakao", method=RequestMethod.GET)
	public ResponseVO mainList(
			@RequestParam(value="xLng") double xLng, 
			@RequestParam(value="yLat") double yLat, 
			@RequestParam(value="query") String query,
			@RequestParam(value="page") Integer page, 
			@RequestParam(value="size") Integer size, 
			@RequestParam(value="sort") String sort, 
			@RequestParam(value="cateCode") String cateCode, 
			@RequestParam(value="rad") String rad) {
		
		ResponseVO response = searchKeywordService.callKaKaoLocalApi(xLng, yLat, query, page, size, sort, cateCode, rad);
        log.info(response.getStatus().toString());
        log.info(response.getDocuments().toString());
        
		return response;
		
	}
}
