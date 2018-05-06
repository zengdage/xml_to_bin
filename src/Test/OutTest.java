package Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import data_struct.DataFile;
import data_struct.DataFileHeader;
import data_struct.DataFileViewTableItem;
import data_struct.DataFileXmlItem;
import data_struct.PropertyItem;

public class OutTest {

	public static void main(String[] args) {
		DataFile datafile = new DataFile();
		DataFileHeader  header = new DataFileHeader("view666");
		
		datafile.setHeader(header);
		
		DataFileXmlItem xmlItem1 = new DataFileXmlItem();
		DataFileXmlItem xmlItem2 = new DataFileXmlItem();

		DataFileViewTableItem item1 = new DataFileViewTableItem("item1");
		DataFileViewTableItem item2 = new DataFileViewTableItem("item2");

		PropertyItem propertyItem1 = new PropertyItem("pro1");
		PropertyItem propertyItem2 = new PropertyItem("pro2");
		PropertyItem propertyItem3 = new PropertyItem("pro3");
		item1.addPropertyItemList(propertyItem1);
		item2.addPropertyItemList(propertyItem2);
		item1.addPropertyItemList(propertyItem3);
		
		xmlItem1.addViewTableItem(item1);
		xmlItem2.addViewTableItem(item2);
		
		datafile.addDataFileItem(xmlItem1);
		datafile.addDataFileItem(xmlItem2);
		
		File file = new File("view.data") ; // 建立文件
		try {
			OutputStream outputStream = new FileOutputStream(file);
			datafile.outToBin(outputStream);
			
			outputStream.close();
			System.out.println("write done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
