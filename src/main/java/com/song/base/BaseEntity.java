package com.song.base;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
public abstract class BaseEntity<Context> {

    public void execute(Context context) {
        LocalDateTime start = LocalDateTime.now();
        String contextStr = JSONObject.toJSONString(context);
        try {
            log.info("{}执行开始时间{},执行参数:{}", this.getClass().getName(), LocalDateTime.now(), contextStr);
            beforeExecute(context);
            if (!needExecute(context)) {
                return;
            }
            doExecute(context);
            afterExecute(context);
        } catch (Exception e) {
            log.error("{}执行异常,执行参数为:{}", this.getClass().getName(), contextStr, e);
            executeException(context, e);
        } finally {
            executeFinally(context);
            LocalDateTime end = LocalDateTime.now();
            log.info("{}执行结束时间{},执行参数:{},耗时为:{}ms",
                    this.getClass().getName(), end, contextStr, start.until(end, ChronoUnit.MILLIS));
        }
    }

    private void afterExecute(Context context) {

    }

    private void executeFinally(Context context) {

    }

    private void executeException(Context context, Exception e) {

    }

    protected abstract void doExecute(Context context);

    public boolean needExecute(Context context) {
        return true;
    }

    protected void beforeExecute(Context context) {

    }
}
