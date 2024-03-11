package com.wake.mapper;

import com.wake.pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {

    /**
     * 查询显示全部计划表信息
     * @return
     */
    List<Schedule> queryList();
}
