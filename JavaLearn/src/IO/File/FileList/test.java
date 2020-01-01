package IO.File.FileList;

import java.io.File;
import java.io.FilenameFilter;

public class test {
    public static void main(String[] args) {
        File file = new File("D:\\1-myfile\\file\\U2");//实例化file对象
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File currFile = new File(dir,name);
                if(currFile.isFile() && !name.endsWith(".txt")){//如果是文件 切 文件名以.txt结尾，返回true
                    return true;
                }else{
                    return false;
                }
            }
        };
        if(file.exists()){
            String[] lists = file.list(filenameFilter);//获得文件过滤的文件名数组
            for(String name : lists){
                System.out.println(name);
            }
        }
    }
}
