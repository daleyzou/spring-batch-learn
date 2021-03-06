package com.daleyzou.file2db;

import com.daleyzou.file2db.configuration.File2DbBatchConfig;
import com.daleyzou.file2db.service.JobLauncherService;
import com.daleyzou.file2db.util.JobUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.Join;
import java.util.Map;

/**
 * File2DbTest
 * @description TODO
 * @author zoudaifa
 * @date 2021年03月06日 6:08 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBatchFile2dbApplication.class, File2DbBatchConfig.class })
@Slf4j
public class File2DbTest {

    @Autowired
    private JobLauncherService jobLauncherService;

    @Autowired
    private Job file2DbJob;

    @Test
    public void testFile2Job()
            throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = JobUtil.getJobParameters();

        Map<String, Object> stringObjectMap = jobLauncherService.startJob(file2DbJob, jobParameters);
    }
}
