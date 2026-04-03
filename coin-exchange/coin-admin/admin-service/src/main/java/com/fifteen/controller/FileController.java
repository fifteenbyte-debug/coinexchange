package com.fifteen.controller;

import com.fifteen.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api("文件上传的控制器")
public class FileController {

    @PostMapping("/image/AliYunImgUpload")
    @ApiOperation("上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "MultipartFile")
    })
    public R<String> fileUpload(@RequestParam("file") MultipartFile file) {
        return R.ok("https://image.baidu.com/search/detail?adpicid=0&b_applid=8790570047558719514&bdtype=0&commodity=&copyright=&cs=145293877%2C1858314713&di=7607122379617075201&fr=click-pic&fromurl=http%253A%252F%252Fmbd.baidu.com%252Fnewspage%252Fdata%252Fdtlandingsuper%253Fnid%253Ddt_4409852071486531115&gsm=1e&hd=&height=0&hot=&ic=&ie=utf-8&imgformat=&imgratio=&imgspn=0&is=0%2C0&isImgSet=&latest=&lid=9d4190eb00011e9d&lm=&objurl=https%253A%252F%252Fmiaobi-lite.bj.bcebos.com%252Fmiaobi%252F5mao%252Fb%2525276aKR5ZON6IyD5Zu0XzE3MzQ2MzU5NDUuMDA1NzAzNw%25253D%25253D%252527%252F0.png&os=2572457877%2C1381012370&pd=image_content&pi=0&pn=0&rn=1&simid=145293877%2C1858314713&tn=baiduimagedetail&width=0&word=%E5%9B%BE%E9%A2%91%E5%95%8A&z=");
    }

    @GetMapping("/image/pre/upload")
    public R<String> preUpload(){
        return R.ok("https://image.baidu.com/search/detail?adpicid=0&b_applid=8790570047558719514&bdtype=0&commod");
    }

}
