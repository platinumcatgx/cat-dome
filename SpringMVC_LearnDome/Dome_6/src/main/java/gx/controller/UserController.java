package gx.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import gx.exception.MyException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    private String ret = "ok";

    @RequestMapping(path = "yc")
    public String yc() throws Exception{
        System.out.println("执行了yc......");

        try {
            int i = 0/0;
        } catch (Exception e) {
            e.printStackTrace();
//            抛出异常
            throw new MyException("你错了");
        }

        return ret;
    }

}
