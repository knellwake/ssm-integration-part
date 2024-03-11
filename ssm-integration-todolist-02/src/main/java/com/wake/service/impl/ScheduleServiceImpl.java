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
        PageHelper.startPage(currentPage, pageSize);

        List<Schedule> scheduleList = scheduleMapper.queryList();

        PageInfo<Schedule> info = new PageInfo<>(scheduleList);

        PageBean<Schedule> data = new PageBean<>(currentPage, pageSize, info.getTotal(), info.getList());

        return R.ok(data);
    }

    @Override
    public R remove(Integer id) {
        int row = scheduleMapper.deleteById(id);

        if (row > 0) {
            return R.ok(null);
        } else {
            return R.fail(null);
        }
    }

    @Override
    public R add(Schedule schedule) {

        int row = scheduleMapper.insert(schedule);

        return row > 0 ? R.ok(null) : R.fail(null);
    }

    @Override
    public R update(Schedule schedule) {
        //判断ID为空
        if (schedule.getId() == null){
            return R.fail("ID不能为空！");
        }

        int row = scheduleMapper.update(schedule);

        if (row > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }
}