package Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import data_struct.DataFile;

public class XmlParseTest {

	public static void main(String[] args) {
		DataFile dataFile = new DataFile();
		dataFile.parse_xml("layout2.xml");
		dataFile.parse_xml("layout.xml");
		
		File file = new File("view.data") ; // �����ļ�
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