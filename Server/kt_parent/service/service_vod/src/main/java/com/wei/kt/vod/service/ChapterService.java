package com.wei.kt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.kt.model.vod.Chapter;
import com.wei.kt.vo.vod.ChapterVo;

import java.util.List;

public interface ChapterService extends IService<Chapter> {
    //章节小结列表
    List<ChapterVo> getNestedTreeList(Long courseId);
}
