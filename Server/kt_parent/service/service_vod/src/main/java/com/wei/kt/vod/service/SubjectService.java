package com.wei.kt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.kt.model.vod.Subject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SubjectService extends IService<Subject> {

    //查询下一层课程分类
    List<Subject> selectList(Long id);

    /**
     * 导出
     * @param response
     */
    void exportData(HttpServletResponse response);

    void importDictData(MultipartFile file);
}
