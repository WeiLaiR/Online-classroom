package com.wei.kt.vod.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.wei.kt.vod.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String upload(MultipartFile file) {

        String secretKey = "xxxxxxxxxxxxxxxxxx";
        String accessKey = "xxxxxxxxxxxxxxxxxx";
        String bucket = "baiblog";

        StringBuilder sb = new StringBuilder("http://xxxxxxxxxxxxxxxxxx/");


        Configuration configuration = new Configuration(Region.region1());
        configuration.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;
        UploadManager uploadManager = new UploadManager(configuration);


        Auth auth = Auth.create(accessKey, secretKey);

        String uploadToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(file.getInputStream(), file.getSize(),(new Date().getTime()) + file.getOriginalFilename(), uploadToken, null, null ,false);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            sb.append(putRet.key);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return sb.toString();
    }
}
