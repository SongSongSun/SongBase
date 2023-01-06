package com.song.job.base.job;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.fastjson2.JSONObject;
import com.song.base.BaseEntity;
import com.song.job.base.context.BaseContext;
import com.song.job.base.executor.BaseExecutor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public abstract class BaseJob<Context extends BaseContext> extends BaseEntity<String> {
    @Override
    protected void doExecute(String param) {
        Context context = buildContext(param);
        if (ObjectUtil.isNull(context)) {
            log.error("任务入参异常");
            return;
        }
        executeBody(context);
    }

    private void executeBody(Context context) {
        BaseExecutor<Context> executor = obtainExecutor(context);
        executor.execute(context);
    }

    private Context buildContext(String param) {
        Class<Context> contextClass = obtainContextClass();
        if (StrUtil.isBlank(param)) {
            //默认为空的JSON字符串
            param = "{}";
        }
        Context context = JSONObject.parseObject(param, contextClass);
        buildCustomContext(context);
        return context;
    }

    protected void buildCustomContext(Context context) {
        if (ObjectUtil.isNull(context.getRecordDate())) {
            context.setRecordDate(LocalDate.now());
        }
    }

    protected abstract Class<Context> obtainContextClass();

    protected abstract BaseExecutor<Context> obtainExecutor(Context context);

    public BaseExecutor<Context> createExecutor(Class<? extends BaseExecutor<Context>> executorClass) {
        try {
            return SpringUtil.getBean(executorClass);
        } catch (Exception e) {
            return ReflectUtil.newInstance(executorClass);
        }
    }

}
