package com.dellent.alticci;

import com.dellent.alticci.service.SeqServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AlticciApplicationTests {

    @Autowired
    private SeqServiceImpl service;

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldGenerateSequence() {

        for (int i = 0; i <= 12; i++) {
            var result = service.getValue(i);
        }

        log.info("Getting values from cache...");

        for (int i = 0; i <= 12; i++) {
            var result = service.getValue(i);
            log.info(Integer.toString(result));
        }
    }

}
