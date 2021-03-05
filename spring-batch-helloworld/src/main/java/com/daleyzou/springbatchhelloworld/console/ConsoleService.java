package com.daleyzou.springbatchhelloworld.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ConsoleService
 * @description TODO
 * @author zoudaifa
 * @date 2021年03月05日 5:32 下午
 */
@Service
@Slf4j
public class ConsoleService {
    public String convertToUpperCase(String data) {
        return data.toUpperCase();
    }
}
