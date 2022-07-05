package com.codegym.service.impl;

import com.codegym.service.ISumService;
import org.springframework.stereotype.Service;

@Service
public class SumServiceImpl implements ISumService {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

}
