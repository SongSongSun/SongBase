package com.song.job.sample.executor;

import com.alibaba.fastjson2.JSONObject;
import com.song.job.base.executor.BaseExecutor;
import com.song.job.sample.context.SampleContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Song
 * @Date 2023/1/6 23:46
 * @Version 1.0
 */
@Component
@Slf4j
public class SampleExecutor extends BaseExecutor<SampleContext> {
    @Override
    protected void doExecute(SampleContext sampleContext) {
        log.info("哈哈哈哈，测试一下,入参为:{}", JSONObject.toJSONString(sampleContext));
    }
}
