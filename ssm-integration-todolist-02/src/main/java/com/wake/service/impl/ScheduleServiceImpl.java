package com.wake.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wake.mapper.ScheduleMapper;
import com.wake.pojo.Schedule;
import com.wake.service.ScheduleService;
import com.wake.utils.PageBean;
import com.wake.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Doug
 * @Date: 2024-03-11 01:27
 * @Description:
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public R page(int pageSize, int currentPage) {
        //分页
        PageHelper.startPage(currentPage,pageSize);

        List<Schedule> scheduleList = scheduleMapper.queryList();

        //分页数据配置
        PageInfo<Schedule> info = new PageInfo<>(scheduleList);

        PageBean<Schedule> data = new PageBean<>(currentPage,pageSize,info.getTotal(),info.getList());

        return R.ok(data);
    }
}