package com.wake.service;

import com.wake.utils.R;

public interface ScheduleService {

    /**
     * 分页查询信息
     * @param pageSize
     * @param currentPage
     * @return
     */
    R page(int pageSize, int currentPage);
}
