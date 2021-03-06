package com.daleyzou.file2db;

import com.daleyzou.file2db.configuration.File2DbItemProcessor;
import com.daleyzou.file2db.po.TestUserEntity;
import lombok.SneakyThrows;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * UserSetFieldSetMapper
 * @description TODO
 * @author daleyzou
 * @date 2021年03月06日 4:56 下午
 */
public class UserSetFieldSetMapper
        implements org.springframework.batch.item.file.mapping.FieldSetMapper<com.daleyzou.file2db.po.TestUserEntity> {
    @SneakyThrows
    @Override
    public TestUserEntity mapFieldSet(FieldSet fieldSet) throws BindException {
        String patternYmd = "yyyy-MM-dd";
        String patternYmdHms = "yyyy-MM-dd HH:mm:ss";
        TestUserEntity userEntity = new TestUserEntity();
        userEntity.setId(fieldSet.readLong("id"));
        userEntity.setName(fieldSet.readString("name"));
        userEntity.setPhone(fieldSet.readString("phone"));
        userEntity.setTitle(fieldSet.readString("title"));
        userEntity.setEmail(fieldSet.readString("email"));
        userEntity.setGender(fieldSet.readString("gender"));
        //此字段有可能为null
        String dataOfBirthStr = fieldSet.readString("date_of_birth");
        if(File2DbItemProcessor.CsvEmptyStr.equals(dataOfBirthStr)){
        }else{
            SimpleDateFormat formatter = new SimpleDateFormat(patternYmd);

            Date date = formatter.parse(dataOfBirthStr);
            userEntity.setDateOfBirth(date);
        }
        userEntity.setSysCreateTime(fieldSet.readDate("sys_create_time",patternYmdHms));
        userEntity.setSysCreateUser(fieldSet.readString("sys_create_user"));
        userEntity.setSysUpdateTime(fieldSet.readDate("sys_update_time",patternYmdHms));
        userEntity.setSysUpdateUser(fieldSet.readString("sys_update_user"));
        return userEntity;
    }
}
