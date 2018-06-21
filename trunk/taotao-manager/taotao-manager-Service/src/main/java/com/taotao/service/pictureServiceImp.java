package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import utils.FastDFSClient;

@Service
public class pictureServiceImp implements pictureService
{
    @Value("${IMAGE_SERVER_BASE_URL}")
    private  String IMAGE_SERVER_BASE_URL;
    @Override
    public PictureResult upload(MultipartFile picFile){
        PictureResult result = new PictureResult();
        if (picFile.isEmpty())
        {
            result.setError(1);
            result.setMessage("picture is error");
            return  result;
        }

        FastDFSClient client = null;
        try {
            String originalFilename = picFile.getOriginalFilename();
            String exName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            client = new FastDFSClient("properties/fdfs_client.conf");
            String url = client.uploadFile(picFile.getBytes(),exName);
            result.setUrl(IMAGE_SERVER_BASE_URL+url);
            result.setMessage("upload Success");
            result.setError(0);
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("upload Error");
        }
        return result;
    }
}
