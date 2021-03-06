package com.daleyzou.file2db.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * JobLauncherService
 * @description TODO
 * @author zoudaifa
 * @date 2021年03月06日 6:14 下午
 */
@Slf4j
@Service
public class JobLauncherService {
    @Autowired
    private JobLauncher jobLauncher;

    public Map<String, Object> startJob(Job job, JobParameters jobParameter)
            throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException {
        HashMap<String, Object> resultMap = new HashMap<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(job.getName());

        JobExecution run = jobLauncher.run(job, jobParameter);
        // 返回结果
        StringBuffer stringBuffer = new StringBuffer();
        Collection<StepExecution> stepExecutions = run.getStepExecutions();
        stepExecutions.forEach(item -> {
            stringBuffer.append("\n");
            stringBuffer.append("readCount: ").append(item.getReadCount()).append("    ");
            stringBuffer.append("filterCount: ").append(item.getFilterCount()).append("    ");
            stringBuffer.append("commitCount: ").append(item.getCommitCount()).append("    ");
            stringBuffer.append("writeCount: ").append(item.getWriteCount()).append("    ");

            stringBuffer.append("\n");
        });
        stopWatch.stop();
        ExitStatus exitStatus = run.getExitStatus();

        String resultStr =
                stringBuffer.toString() + System.lineSeparator() + "exitStatus : " + exitStatus + "timeInfo: "
                        + stopWatch.prettyPrint();

        log.info("resultStr： {}", resultStr);

        resultMap.put("stringStr", resultStr);
        resultMap.put("exitStatus", exitStatus);

        return resultMap;
    }
}
