package com.daleyzou.file2db.util;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;

/**
 * JobUtil
 * @description TODO
 * @author zoudaifa
 * @date 2021年03月06日 6:45 下午
 */
public class JobUtil {

    public static JobParameters getJobParameters(){
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        return jobParameters;
    }
}
