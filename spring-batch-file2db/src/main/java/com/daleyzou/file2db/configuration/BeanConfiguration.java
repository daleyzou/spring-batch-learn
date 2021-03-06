package com.daleyzou.file2db.configuration;

import com.daleyzou.file2db.UserSetFieldSetMapper;
import com.daleyzou.file2db.po.TestUserEntity;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * BeanConfiguration
 * @description TODO
 * @author daleyzou
 * @date 2021年03月06日 4:51 下午
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public ItemReader file2DbItemReader() {

        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return new FlatFileItemReaderBuilder<TestUserEntity>().name(funcName)
                .resource(new ClassPathResource("user" + "-data.csv")).delimited()
                .names("id", "name", "phone", "title", "email", "gender", "date_of_birth", "sys_create_time",
                        "sys_create_user", "sys_update_time", "sys_update_user")
                .fieldSetMapper(new UserSetFieldSetMapper()).build();

    }

    @Bean
    public ItemWriter file2DbWriter(@Qualifier("targetDataSource") DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<TestUserEntity>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>()).sql(
                "INSERT INTO test_user(id,name,phone,title,email,gender,date_of_birth,sys_create_time,sys_create_user,sys_update_time,sys_update_user) " +
                        "VALUES (:id,:name,:phone,:title,:email,:gender,:dateOfBirth,:sysCreateTime,:sysCreateUser,:sysUpdateTime,:sysUpdateUser)"
        ).dataSource(dataSource).build();
    }
}
