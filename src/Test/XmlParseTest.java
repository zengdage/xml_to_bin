package Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import data_struct.DataFile;
import resource.ParseLangHeadFile;
import resource.ParseThemeHeadFile;

public class XmlParseTest {

	public static void main(String[] args) {
		
		ParseThemeHeadFile.parseThemeHeadFile("theme.h");
		ParseLangHeadFile.parseLangHeadFile("lang.h");
		
		DataFile dataFile = new DataFile();
		dataFile.parse_xml("home.xml");
		dataFile.parse_xml("home2.xml");
		//dataFile.parse_xml("layout.xml");
		
		File file = new File("view_data") ; // 建立文件
		try {
			OutputStream outputStream = new FileOutputStream(file);
			dataFile.outToBin(outputStream);
			
			outputStream.close();
			System.out.println("write done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
