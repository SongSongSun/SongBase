package com.song.job.base.job;

import com.alibaba.fastjson2.JSONObject;
import com.song.base.BaseEntity;
import com.song.job.base.context.BaseContext;
import com.song.job.base.executor.BaseExecutor;

public abstract class BaseJob<Context extends BaseContext> extends BaseEntity<String> {
    @Override
    protected void doExecute(String param) {
        Context context = buildContext(param);
        executeBody(context);
    }

    private void executeBody(Context context) {
        BaseExecutor<Context> executor = obtainExecutor(context);
        executor.execute(context);
    }

    private Context buildContext(String param) {
        Class<Context> contextClass = obtainContextClass();
        Context context = JSONObject.parseObject(param, contextClass);
        buildCustomContext(context);
        return context;
    }

    private void buildCustomContext(Context context) {
    }

    protected abstract Class<Context> obtainContextClass();

    protected abstract BaseExecutor<Context> obtainExecutor(Context context);
}
