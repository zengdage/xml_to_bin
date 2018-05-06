package xmlpulldemo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FileUtils {
	
	public static void charOutStream() throws Exception{
        // 1：利用File类找到要操作的对象
        File file = new File("D:" + File.separator + "demo" + File.separator + "test.txt");
        if(!file.getParentFile().exists()){
             file.getParentFile().mkdirs();
        }
            
        //2：准备输出流
        Writer out = new FileWriter(file);
        out.write("测试字符流, 哈哈");
        out.close();
            
    }
	
	public static void outFunctions(File file) throws Exception{
	
	}
}
