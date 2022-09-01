package com.wei.kt.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.kt.model.vod.Course;
import com.wei.kt.vo.vod.CoursePublishVo;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper extends BaseMapper<Course> {
    //根据id获取课程发布信息
    CoursePublishVo selectCoursePublishVoById(Long id);
}
