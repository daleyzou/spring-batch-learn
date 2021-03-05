package com.daleyzou.springbatchhelloworld.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ConvertProcesser
 * @description TODO
 * @author daleyzou
 * @date 2021年03月05日 5:34 下午
 */
@Slf4j
public class ConvertProcesser implements ItemProcessor<String, String> {
    @Autowired
    ConsoleService consoleService;
    @Override
    public String process(String data) throws Exception {
        String result = consoleService.convertToUpperCase(data);
        log.debug("ConvertProcesser data:{}, process end is : {}", data, result);
        return result;
    }
}
