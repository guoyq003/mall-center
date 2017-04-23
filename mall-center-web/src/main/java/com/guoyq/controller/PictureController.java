package com.guoyq.controller;

import com.guoyq.service.PictureService;
import com.guoyq.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile){
        Map resultMap=pictureService.uploadPicture(uploadFile);
        //为了保证功能的兼容性，需要把返回的结果转换成json格式
        String resultJson=JsonUtils.objectToJson(resultMap);
        return resultJson;
    }
}
