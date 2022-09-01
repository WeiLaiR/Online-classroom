package com.wei.kt.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.kt.model.vod.Video;
import com.wei.kt.vod.mapper.VideoMapper;
import com.wei.kt.vod.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
}
