package com.wake.controller;


import com.wake.pojo.Schedule;
import com.wake.service.ScheduleService;
import com.wake.utils.R;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 */
@CrossOrigin //允许其他源访问，浏览器就不会拦截
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

    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id){
        R r = scheduleService.remove(id);
        return r;
    }

    @PostMapping
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数为空Null！不能保存！");
        }
        R r = scheduleService.add(schedule);
        return r;
    }

    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数为空Null！不能修改！");
        }
        R r = scheduleService.update(schedule);
        return r;
    }
}