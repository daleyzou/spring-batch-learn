package com.daleyzou.file2db.configuration;

import com.daleyzou.file2db.CommonStepListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * File2DbBatchConfig
 * @description TODO
 * @author zoudaifa
 * @date 2021年03月06日 5:45 下午
 */
@Configuration
@EnableBatchProcessing
public class File2DbBatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job file2DbJob(Step file2DbStep, CommonStepListener commonStepListener) {
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return jobBuilderFactory.get(funcName).listener(commonStepListener).flow(file2DbStep).end().build();
    }

    @Bean
    public Step file2DbStep(ItemReader file2DbItemReader, ItemProcessor file2DbItemProcessor,
            ItemWriter file2DbWriter) {
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return stepBuilderFactory.get(funcName).chunk(10).reader(file2DbItemReader).processor(file2DbItemProcessor)
                .writer(file2DbWriter).build();
    }
}
