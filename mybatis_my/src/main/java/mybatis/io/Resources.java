package mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入的文件名,获取一个字节输入流
     * 1.获取当前类的字节码
     * 2.获取字节码的类加载器
     * 3.根据类加载器读取配置文件
     * @param FilePath 文件名
     * @return 字节输入流
     */
    public static InputStream getResourceAsStream(String FilePath){
        return Resources.class.getClassLoader().getResourceAsStream(FilePath);
    }
}
