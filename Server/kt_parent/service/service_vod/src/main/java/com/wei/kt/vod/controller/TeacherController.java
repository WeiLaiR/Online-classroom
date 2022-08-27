package com.wei.kt.vod.controller;


import com.wei.kt.model.vod.Teacher;
import com.wei.kt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author wei
 * @since 2022-08-27
 */
/**
 * 讲师 前端控制器
 * @author atguigu
 */
@RestController
@RequestMapping(value="/admin/vod/teacher")
public class TeacherController {



    private TeacherService teacherService;
    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //查询所有讲师列表
    @GetMapping("findAll")
    public List<Teacher> findAll(){
        List<Teacher> list = teacherService.list();
        return list;
    }
}

