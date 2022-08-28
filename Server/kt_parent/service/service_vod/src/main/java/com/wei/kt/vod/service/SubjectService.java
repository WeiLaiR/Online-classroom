package com.wei.kt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.kt.model.vod.Subject;

import java.util.List;

public interface SubjectService extends IService<Subject> {

    //查询下一层课程分类
    List<Subject> selectList(Long id);
}
