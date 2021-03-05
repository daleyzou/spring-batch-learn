package com.daleyzou.springbatchhelloworld.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * ConsoleWriter
 * @description TODO
 * @author daleyzou
 * @date 2021年03月05日 5:39 下午
 */
@Slf4j
public class ConsoleWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String s : list) {
            log.debug("ConsoleWriter, write data, data is : {}", s);
        }
    }
}
