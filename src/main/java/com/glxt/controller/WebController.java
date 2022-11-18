package com.glxt.controller;

import com.glxt.service.ContactServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
//@Validated
public class WebController {
    //上传文件
    @GetMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model) {
        model.addAttribute("uploadStatus", "上传成功");
        for (MultipartFile file : fileUpload) {
            String fileName = file.getOriginalFilename();
            fileName = UUID.randomUUID() + "_" + fileName;
            String dirPath = "D:/qqfile/";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("uploadStatus", "上传失败:" + e.getMessage());
            }
        }
        return "upload";
    }

    //下载文件
    @GetMapping("/todownload")
    public String todownload() {
        return "download";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String filename) throws Exception {
        //指定要下载的文件路径
        String dirPath = "D:/qqfile";
        //创建文件对象
        File file = new File(dirPath + File.separator + filename);
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        //通知浏览器以下载方式打开(下载前对文件进行转码)
        filename = getFilename(request, filename);
        headers.setContentDispositionFormData("attachment", filename);
        //定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    //根据浏览器的不同进行编码设置，返回编码后的文件名
    private String getFilename(HttpServletRequest request, String filename) throws Exception {
        //IE不同版本User-Agent中出现的关键词
        String[] IEBroserKeyWords = {"MSIE", "Trident", "Edge"};
        //获取请求代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBroserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示并对转换的+进行更正
                return URLEncoder.encode(filename, "UTF-8").replace("+", " ");
            }
        }
        //火狐等其他浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }

    //数据分页
    @Autowired
    ContactServiceImpl contactServiceImpl;

    @GetMapping("/all_page")
    public String all_page(Model m) {
        List UserList = contactServiceImpl.contTable();
        m.addAttribute("Result", UserList);
        return "mypage";
    }

    //数据图表
    @GetMapping("/tochart")
    public String tochart() {
        return "contchart";
    }

    @RequestMapping("/gochart")
    @ResponseBody
    public List gochart(Model m) {

        List UserList = contactServiceImpl.contChart();
        m.addAttribute("Result", UserList);
//        System.out.println(UserList);
        return UserList;
    }

    @GetMapping("/topie")
    public String topie(){
        return "pie";
    }
}

