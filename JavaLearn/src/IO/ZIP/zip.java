package IO.ZIP;

import java.io.*;
import java.util.zip.ZipOutputStream;

public class zip {
    private void zip(String zipFileName , File inputFile){
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(inputFile) );
            zip(zos,inputFile,"");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void zip(ZipOutputStream zos , File f , String base){
        if(f.isDirectory()){
            File[] fl = f.listFiles();
            if(base.length()!=0){

            }
        }
    }
}
