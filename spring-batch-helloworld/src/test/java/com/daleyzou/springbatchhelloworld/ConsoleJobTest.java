package com.daleyzou.springbatchhelloworld;

import com.daleyzou.springbatchhelloworld.console.ConsoleJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ConsoleJobTest
 * @description TODO
 * @author daleyzou
 * @date 2021年03月05日 8:29 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBatchHelloworldApplication.class, ConsoleJobConfig.class})
@Slf4j
public class ConsoleJobTest {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job consoleJob;

    @Test
    public void testConsoleJob()
            throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        JobExecution jobExecution = jobLauncher.run(consoleJob, jobParameters);
        ExitStatus exitStatus = jobExecution.getExitStatus();
        log.debug(exitStatus.toString());
    }
}
