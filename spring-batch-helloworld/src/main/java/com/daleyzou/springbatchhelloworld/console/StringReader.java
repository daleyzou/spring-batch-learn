package com.daleyzou.springbatchhelloworld.console;

import com.sun.xml.internal.messaging.saaj.util.LogDomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import javax.batch.api.chunk.listener.ItemReadListener;

/**
 * StringReader
 * @description TODO
 * @author daleyzou
 * @date 2021年03月05日 5:15 下午
 */
@Slf4j
public class StringReader implements ItemReader<String> {
    private String[] messages = new String[] { "messages", "message2", "message3", "message4" };

    private int count = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count < messages.length) {
            String message = messages[count];
            log.debug("StringReader read data : {}", message);
            return message;
        } else {
            count = 0;
            log.debug("StringReader read data end!!!!!!");
        }
        return null;
    }
}
