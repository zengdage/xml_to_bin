package xmlpulldemo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FileUtils {
	
	public static void charOutStream() throws Exception{
        // 1������File���ҵ�Ҫ�����Ķ���
        File file = new File("D:" + File.separator + "demo" + File.separator + "test.txt");
        if(!file.getParentFile().exists()){
             file.getParentFile().mkdirs();
        }
            
        //2��׼�������
        Writer out = new FileWriter(file);
        out.write("�����ַ���, ����");
        out.close();
            
    }
	
	public static void outFunctions(File file) throws Exception{
	
	}
}
