package com.wake.controller;


import com.wake.service.ScheduleService;
import com.wake.utils.R;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 */
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize,
                  @PathVariable int currentPage) {

        R r = scheduleService.page(pageSize,currentPage);
        log.info("查询信息为：{}",r);
        return r;
    }
}