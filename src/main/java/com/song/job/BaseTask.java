package com.song.job;

import cn.hutool.extra.spring.SpringUtil;
import com.song.job.sample.job.SampleJob;
import org.springframework.stereotype.Component;


/**
 * @Description TODO
 * @Author Song
 * @Date 2023/1/6 23:32
 * @Version 1.0
 */
@Component
public class BaseTask {

    public void baseJob(String param) {
        SpringUtil.getBean(SampleJob.class).execute(param);
    }
}
