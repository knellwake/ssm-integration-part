package com.wake.service;

import com.wake.pojo.Schedule;
import com.wake.utils.R;

public interface ScheduleService {

    /**
     * 分页查询信息
     * @param pageSize
     * @param currentPage
     * @return
     */
    R page(int pageSize, int currentPage);

    /**
     * 根据ID删除日程
     * @param id
     * @return
     */
    R remove(Integer id);

    /**
     * 添加一条信息
     * @param schedule
     * @return
     */
    R add(Schedule schedule);

    /**
     * 更新信息
     * @param schedule
     * @return
     */
    R update(Schedule schedule);
}
