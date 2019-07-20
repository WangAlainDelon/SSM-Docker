package com.wx.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class UploadController {
    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }
    /**
     * 单文件上传 :  MultipartFile file
     * 多文件上传 :  @RequestParam("file") MultipartFile[] file
     * 多文件上传必须加上 @RequestParam("file")注解否则会报错
     */
    @RequestMapping(value = "uploadfile", method = RequestMethod.POST)
    public String testFileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile[] file) {
        for (int i = 0; i < file.length; i++) {
            MultipartFile multipartFile = file[i];
            System.out.println(" ContentType: " + multipartFile.getContentType());
            System.out.println(" Name: " + multipartFile.getName());
            System.out.println(" OriginalFilename: " + multipartFile.getOriginalFilename());
            System.out.println(" Size: " + multipartFile.getSize());
            //判断是否提交文件，如果没有那么跳过上传
            if (multipartFile.isEmpty()) {
                //跳出本次循环执行下一次循环
                continue;
            }
            // 获取文件的上传路径
            String uploadpath = request.getServletContext().getRealPath("uploads");
            //String property = System.getProperty("user.dir");
            //获取文件名称
            String filename = multipartFile.getOriginalFilename();
            //截取文件后缀
            String fileext = filename.substring(filename.lastIndexOf("."));
            //生成新的随机文件名称
            //String newfileName = UUID.randomUUID() + fileext;
            //文件保存位置
            File saveDir = new File(uploadpath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            //文件保存路径
            File savepath = new File(uploadpath + "/" + filename);
            System.out.println(savepath);
            //上传文件
            try {
                multipartFile.transferTo(savepath);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    /***
     * 文件的下载
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileDownLoad")
    public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request) throws Exception{

        ServletContext servletContext = request.getServletContext();
        String fileName="Nutch入门.pdf";
        String realPath = servletContext.getRealPath("/uploads/"+fileName);//得到文件所在位置
        InputStream in=new FileInputStream(new File(realPath));//将该文件加入到输入流之中
        byte[] body=null;
        body=new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
        in.read(body);//读入到输入流里面

        fileName=new String(fileName.getBytes("gbk"),"iso8859-1");//防止中文乱码
        HttpHeaders headers=new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename="+fileName);
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }
}
