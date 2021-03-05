package com.daleyzou.springbatchhelloworld.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * ConsoleJonListener
 * @description TODO
 * @author daleyzou
 * @date 2021年03月05日 5:42 下午
 */
@Slf4j
public class ConsoleJobListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.debug("console job completed!!!!");
        }
    }
}
