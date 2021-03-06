package resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ParseThemeHeadFile {
	
	public static Map themeMap = new HashMap();
	
	public static void initThemeMap() {

		
	}
	
	public static void addHashMap(String key, int value) {
		themeMap.put(key, value);
	}
	
	public static int getHashMapValue(String key) {
		return (int)themeMap.get(key);
	}
	
	public static void parseThemeHeadFile(String path) {
		try
        {
            //编码格式
            String encoding = "UTF-8";
            //文件路径
            File file = new File(path);
            if (file.isFile() && file.exists()){ // 判断文件是否存在
                //输入流
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                //读取一行
                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                	if(lineTxt.indexOf("#define")!=-1 && 
                			lineTxt.indexOf("ID_")!=-1) {
                		String [] arr = lineTxt.split("\\s+");
                		if(arr.length == 3) {
                			try {
                				addHashMap(arr[1], Integer.valueOf(arr[2]));
                    			//System.out.println(arr[0]+ " "+arr[1]+" "+arr[2]);
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("error:"+arr[1]);
							}
                		}

                	}
                }
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
	}

}
