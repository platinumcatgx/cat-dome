package gx.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
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


    /**
     * 传统文件上传
     */
    @RequestMapping(path = "/f1")
    public String f1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");

        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建文件夹
            file.mkdirs();
        }
        //解析requset对象,获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);

        //解析
        List<FileItem> fileItems = fileUpload.parseRequest(request);

        for (FileItem f : fileItems) {
            if (f.isFormField()) {
                //普通表单项
            } else {
                //上传文件项
                //获取到上传文件的名称
                String name = f.getName();

//                更改文件名,设置为唯一
                String replace = UUID.randomUUID().toString().replace("-", "");
                name += "_" + replace;
                //完成文件上传
                f.write(new File(path, name));

                System.out.println(path + name);
                //删除临时文件
                f.delete();
            }
        }


        return "msg/" + ret;
    }

    /**
     * SpringMVC文件上传
     */
    @RequestMapping(path = "/f2")
    public String f2(HttpServletRequest request, MultipartFile file) throws Exception {
        System.out.println("SpringMVC文件上传...");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File files = new File(path);
        if (!files.exists()) {
            //创建文件夹
            files.mkdirs();
        }
        //获取到上传文件的名称
        String name = file.getOriginalFilename();
        //更改文件名,设置为唯一
        String replace = UUID.randomUUID().toString().replace("-", "");

        name = replace + name;
        //完成文件上传
        file.transferTo(new File(path, name));

        System.out.println(path + name);

        return "msg/" + ret;
    }

    /**
     * SpringMVC跨服务器文件上传
     */
    @RequestMapping(path = "/f3")
    public String f3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传...");

        // 定义上传文件服务器路径
        String path = "http://localhost:9090/uploads/";

        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;

        // 创建客户端的对象
        Client client = Client.create();

        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);

        System.out.println(path + filename);

        // 上传文件
        webResource.put(upload.getBytes());

        return "msg/" + ret;
    }

}
