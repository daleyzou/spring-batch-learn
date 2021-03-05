package com.daleyzou.springbatchhelloworld.console;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
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
 * ConsoleJobConfig
 * @description TODO
 * @author daleyzou
 * @date 2021年03月05日 5:45 下午
 */
@Configuration
@EnableBatchProcessing
public class ConsoleJobConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job consoleJob(Step consoleStep, JobExecutionListener consoleJobListener ){
        String funcName
                = Thread.currentThread().getStackTrace()[1].getMethodName();
        return jobBuilderFactory.get(funcName).listener(consoleJobListener).flow(consoleStep).end().build();
    }

    @Bean
    public  Step consoleStep(ItemReader stringReader, ItemProcessor convertProcessor, ItemWriter consoleWriter,
            CommonStepListener commonStepListener){
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return stepBuilderFactory.get(funcName).listener(commonStepListener).chunk(3).reader(stringReader).processor(convertProcessor).writer(consoleWriter).build();
    }

    @Bean
    public ItemReader stringReader(){
        return new StringReader();
    }
    @Bean
    public ItemWriter consoleWriter(){
        return new ConsoleWriter();
    }

    @Bean
    public ItemProcessor convertProcessor(){
        return new ConvertProcesser();
    }

    @Bean
    public JobExecutionListener consoleJobListener(){
        return new ConsoleJobListener();
    }
}
