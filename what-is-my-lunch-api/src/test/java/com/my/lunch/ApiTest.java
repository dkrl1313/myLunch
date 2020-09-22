package com.my.lunch;

import com.kakao.local.domain.ResponseVO;
import com.kakao.local.service.SearchKeywordService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@Slf4j
@SpringBootTest
public class ApiTest {

    @Autowired
    private SearchKeywordService searchKeywordService;

    @Test
    public void apiCall(){
        double xLng = 126.87880659999999;
        double yLng = 37.4730911;

        // VO 받는거 변경해서 front에 보내기 
        // 상태 status code랑 message 보내기 
        
        /*
         * double xLng, double yLat, String query,
			Integer page, Integer size, String sort, String cateCode, String rad
         * */
        
        ResponseVO response = searchKeywordService.callKaKaoLocalApi(xLng, yLng, "맛집", 5, 15, "accuracy", "FD6", "500");
        log.info(response.getStatus().toString());
//        log.info(response.getDocuments().get(''));
        
        
        
    }
}
