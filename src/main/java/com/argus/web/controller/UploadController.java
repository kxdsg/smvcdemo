package com.argus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * Created by xingding on 18/4/7.
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload.do")
    public String loginPage(){
        return "upload";
    }

    @RequestMapping(value = "/springUpload.do")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
        //获得物理路径webapp所在路径
//        String pathRoot = request.getSession().getServletContext().getRealPath("");
//        System.out.println("pathRoot: " + pathRoot);

        //指定文件路径，不在应用里面
        String pathRoot="/Users/xingding/imgs/";
        String path="";
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    path=pathRoot+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }
        System.out.println(path);
        request.setAttribute("imgpath", path);
        long  endTime=System.currentTimeMillis();
        return "success";
    }

    /**
     * 文件流的方式读取文件并显示
     * @param filePath
     * @param response
     */
    @RequestMapping(value = "/showPic.do")
    public void showPic(@RequestParam String filePath, HttpServletResponse response){
        try {
            FileInputStream is = new FileInputStream(filePath);
            int i = is.available(); // 得到文件大小
            byte data[] = new byte[i];
            is.read(data); // 读数据
            is.close();
            response.setContentType("image/*"); // 设置返回的文件类型
            OutputStream os = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
            os.write(data); // 输出数据
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
