package com.taotao.controller;

import com.taotao.common.pojo.PictureResult;
import com.taotao.service.pictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import utils.JSONUtil;

@Controller
public class uploadController
{
    @Autowired
    pictureService pictureService;
    @RequestMapping("/pic/upload")
    @ResponseBody
    public String upload(MultipartFile uploadFile) throws Exception {
        PictureResult result = pictureService.upload(uploadFile);
        String resultString = JSONUtil.toJSONString(result);
        return resultString;
    }
}
