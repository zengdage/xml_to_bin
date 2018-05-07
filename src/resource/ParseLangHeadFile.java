
package resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ParseLangHeadFile {
	
	public static Map langMap = new HashMap();
	
	public static Map langTypeMap = new HashMap();
	
	public static void initThemeMap() {

		
	}
	
	public static void addHashMap(String key, int value) {
		langMap.put(key, value);
	}
	
	public static int getHashMapValue(String key) {
		return (int)langMap.get(key);
	}
	
	public static void addLangTypeHashMap(String key, int value) {
		langTypeMap.put(key, value);
	}
	
	public static int getLangTypeHashMapValue(String key) {
		return (int)langTypeMap.get(key);
	}
	
	public static void parseLangHeadFile(String path) {
		try
        {
            //�����ʽ
            String encoding = "UTF-8";
            //�ļ�·��
            File file = new File(path);
            if (file.isFile() && file.exists()){ // �ж��ļ��Ƿ����
                //������
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// ���ǵ������
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                //��ȡһ��
                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                	if(lineTxt.indexOf("#define")!=-1 && 
                			lineTxt.indexOf("STRING_")!=-1) {
                		String [] arr = lineTxt.split("\\s+");
                		if(arr.length == 3) {
                			try {
                				String num = arr[2].substring(2);
                				addHashMap(arr[1], Integer.parseInt(num, 16));
                    			//System.out.println(arr[0]+ " "+arr[1]+" "+arr[2]);
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("error:"+arr[1]);
							}
                		}

                	}
                	
                	if(lineTxt.indexOf("#define")!=-1 && 
                			lineTxt.indexOf("LANG_")!=-1 &&
                			lineTxt.indexOf("_TYPE")!=-1) {
                		String [] arr = lineTxt.split("\\s+");
                		if(arr.length == 3) {
                			try {
                				String num = arr[2].substring(2);
                				addLangTypeHashMap(arr[1], Integer.parseInt(num, 16));
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
                System.out.println("�Ҳ���ָ�����ļ�");
            }
        }
        catch (Exception e)
        {
            System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
	}

}
