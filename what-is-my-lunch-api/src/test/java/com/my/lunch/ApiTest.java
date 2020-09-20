package com.my.lunch;

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

        ResponseEntity<Map<String, Object>> responseEntity = searchKeywordService.callKaKaoLocalApi(xLng, yLng, "맛집");
        log.info(responseEntity.getStatusCode().toString());
        log.info(responseEntity.getBody().get("documents").toString());
        
        // git test~~~2
    }
}
