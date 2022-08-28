package com.wei.kt.vod.controller;

import com.wei.kt.model.vod.Subject;
import com.wei.kt.result.Result;
import com.wei.kt.vod.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "课程分类管理")
@RestController
@RequestMapping(value="/admin/vod/subject")
@CrossOrigin
public class SubjectController {


    private SubjectService subjectService;
    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //查询下一层课程分类
    //根据parent_id
    @ApiOperation("查询下一层的课程分类")
    @GetMapping("getChildSubject/{id}")
    public Result getChildSubject(@PathVariable Long id) {
        List<Subject> list = subjectService.selectList(id);
        return Result.ok(list);
    }
}
