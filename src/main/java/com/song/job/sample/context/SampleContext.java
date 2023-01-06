package com.song.job.sample.context;

import com.song.job.base.context.BaseContext;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @Description
 * @Author Song
 * @Date 2023/1/6 23:45
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SampleContext extends BaseContext {
    private String name;
}
