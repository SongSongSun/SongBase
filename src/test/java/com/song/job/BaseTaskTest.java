package com.song.job;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaseTaskTest {
    @Resource
    private BaseTask baseTask;

    @Test
    void testBaseJob() {
        baseTask.baseJob(null);
    }
}