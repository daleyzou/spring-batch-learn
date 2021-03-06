package com.daleyzou.file2db.configuration;

import com.daleyzou.file2db.po.TestUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * File2DbItemProcessor
 * @description TODO
 * @author zoudaifa
 * @date 2021年03月06日 5:30 下午
 */
@Slf4j
@Component
public class File2DbItemProcessor implements ItemProcessor<TestUserEntity, TestUserEntity> {
    public final static String CsvEmptyStr = "\\N";
    @Override
    public TestUserEntity process(TestUserEntity user) throws Exception {
        user.setPhone(checkStr(user.getPhone()));
        user.setTitle(checkStr(user.getTitle()));
        user.setEmail(checkStr(user.getEmail()));
        user.setGender(checkStr(user.getGender()));
        log.info( " File2DbItemProcessor  item process: " +user.getName());
        return user;
    }

    private String checkStr(String str) {
        if (CsvEmptyStr.equals(str)){
            return null;
        }
        return str;
    }
}
