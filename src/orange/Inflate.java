package orange;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import data_struct.DataFileViewTableItem;
import data_struct.DataFileXmlItem;
import view.Basewin;
import xmlpulldemo.LayoutInflate;


public class Inflate {


	
	public static Basewin getLayout(DataFileXmlItem xmlItem , String str) {
		LayoutInflate inflate=new LayoutInflate(xmlItem);
		return inflate.inflate(str, null);
	}
	

}
