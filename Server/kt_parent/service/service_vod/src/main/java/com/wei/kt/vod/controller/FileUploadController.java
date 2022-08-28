package com.wei.kt.vod.controller;


import com.wei.kt.result.Result;
import com.wei.kt.vod.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "文件接口上传")
@RestController
@RequestMapping("/admin/vod/file")
@CrossOrigin
public class FileUploadController {

    private FileService fileService;
    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * 文件上传
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public Result uploadFile(@ApiParam(name = "file", value = "文件", required = true)
                                 @RequestParam("file") MultipartFile file) {
        String url = fileService.upload(file);
        return Result.ok(url).message("文件上传成功！");
    }
}
