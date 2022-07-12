package com.dellent.alticci.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SeqServiceImpl implements SeqService {

    @Cacheable("sequenceModel")
    public int getValue(int idx) {
        log.info("Calculating sequence...");
        int value = sequence(idx);
        return value;
    }

    private int sequence(int n) {
        if (n == 0) {
            return 0;
        }
        if (n > 0 && n < 3) {
            return 1;
        }
        int result = sequence(n - 3) + sequence(n - 2);
        return result;
    }
}
