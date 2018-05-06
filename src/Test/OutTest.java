package Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import data_struct.DataFileHeader;
import data_struct.DataFileViewTableItem;
import data_struct.PropertyItem;

public class OutTest {

	public static void main(String[] args) {
		DataFileHeader  header = new DataFileHeader("view666");
		DataFileViewTableItem item1 = new DataFileViewTableItem("item1");
		DataFileViewTableItem item2 = new DataFileViewTableItem("item2");
		header.addViewTableItem(item1);
		header.addViewTableItem(item2);
		
		PropertyItem propertyItem1 = new PropertyItem("pro1");
		PropertyItem propertyItem2 = new PropertyItem("pro2");
		item1.addPropertyItemList(propertyItem1);
		item2.addPropertyItemList(propertyItem2);
		
		File file = new File("view.data") ; // 建立文件
		try {
			OutputStream outputStream = new FileOutputStream(file);
			header.outSelfToBin(outputStream);
		
			header.outViewTableItemToBin(outputStream);
			header.outPropertyItemToBin(outputStream);
			header.outPropertyItemDataToBin(outputStream);
			
			outputStream.close();
			System.out.println("write done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
