package com.wake.mapper;

import com.wake.pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {

    /**
     * 查询显示全部计划表信息
     * @return
     */
    List<Schedule> queryList();

    /**
     * 根据ID删除日程
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 增加一条数据
     * @param schedule
     * @return
     */
    int insert(Schedule schedule);

    /**
     * 更新
     * @param schedule
     * @return
     */
    int update(Schedule schedule);
}
