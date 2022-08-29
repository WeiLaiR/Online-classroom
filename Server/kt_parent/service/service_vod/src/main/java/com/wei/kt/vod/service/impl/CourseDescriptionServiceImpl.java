package com.wei.kt.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.kt.model.vod.CourseDescription;
import com.wei.kt.vod.mapper.CourseDescriptionMapper;
import com.wei.kt.vod.service.CourseDescriptionService;
import org.springframework.stereotype.Service;

@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {
}
