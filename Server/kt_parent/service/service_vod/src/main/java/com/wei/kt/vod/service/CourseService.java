package com.wei.kt.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.kt.model.vod.Course;
import com.wei.kt.vo.vod.CourseFormVo;
import com.wei.kt.vo.vod.CourseQueryVo;

import java.util.Map;

public interface CourseService extends IService<Course> {

    Long saveCourseInfo(CourseFormVo courseFormVo);

    //课程列表
    Map<String,Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    //根据id获取课程信息
    CourseFormVo getCourseFormVoById(Long id);

    //根据id修改课程信息
    void updateCourseById(CourseFormVo courseFormVo);
}
