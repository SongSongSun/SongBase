package com.song.job.sample.job;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.song.job.base.executor.BaseExecutor;
import com.song.job.base.job.BaseJob;
import com.song.job.sample.context.SampleContext;
import com.song.job.sample.executor.SampleExecutor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Description
 * @Author Song
 * @Date 2023/1/6 23:46
 * @Version 1.0
 */
@Component
public class SampleJob extends BaseJob<SampleContext> {
    @Override
    protected Class<SampleContext> obtainContextClass() {
        return SampleContext.class;
    }

    @Override
    protected BaseExecutor<SampleContext> obtainExecutor(SampleContext context) {
        return createExecutor(SampleExecutor.class);
    }

    @Override
    protected void buildCustomContext(SampleContext context) {
        super.buildCustomContext(context);
        if (StrUtil.isBlank(context.getName())) {
            context.setName("Song");
        }
    }
}
