package com.springboot.learning.demo_05_tlias.controller;

import com.springboot.learning.demo_05_tlias.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    //    文件上传接口的实现
    @PostMapping("/upload")
    //MultipartFile image 和表单中name一致
    public Result upload(String username, String age, MultipartFile image) throws IOException{
        log.info("文件上传：{},{},{}",username,age,image);
//        文件保存到本地
        String originalFilename = image.getOriginalFilename(); //获取原始文件名
        System.out.println(originalFilename);//123.txt
        if (originalFilename == null || originalFilename.isEmpty()) {
            log.info("文件名不能为空");
        }
        // 定义目标路径，使用平台无关的路径分隔符
        String uploadDir = "E:" + File.separator + "images";
        File directory = new File(uploadDir);
        // 定义文件保存路径
        if (!directory.exists()) {
            boolean created = directory.mkdirs(); // 创建目录及其父目录
            if (!created) {
                log.info("无法创建目录");
            }
        }
//        File destinationFile = new File(directory, originalFilename);
//        image.transferTo(destinationFile);//文件转存,文件夹必须存在，否则会报错
        String extname = originalFilename.substring(originalFilename.lastIndexOf(".")); //获取文件扩展 名
        System.out.println(extname);
        String newFilename = UUID.randomUUID().toString()+extname; //UUID+扩展名
        File destinationFileUUID =new File(directory, newFilename);
        image.transferTo(destinationFileUUID);

        return Result.success();
    }

}
