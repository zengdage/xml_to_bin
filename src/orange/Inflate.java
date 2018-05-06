package orange;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import data_struct.DataFileViewTableItem;
import data_struct.DataFileXmlItem;
import view.Basewin;
import xmlpulldemo.LayoutInflate;


public class Inflate {

//	public static void main(String[] args) {
//		Basewin basewin = getLayout("layout.xml");
//		basewin.printChild(0);
//		System.out.println("end!");
//		System.out.println("***************Melis Code***************");
//		//outMelisCode(basewin);
//		System.out.println("****************************************");
//	}
	
	public static Basewin getLayout(DataFileXmlItem xmlItem , String str) {
		LayoutInflate inflate=new LayoutInflate(xmlItem);
		return inflate.inflate(str, null);
	}
	
	
	
	public static void outMelisCode(Basewin win,String codePath) {	
		  try {    
			  	File file = new File(codePath);
				if (!file.exists()) {
					file.createNewFile();
				}
				System.out.println(file.getAbsolutePath());
	            PrintStream ps = new PrintStream(new FileOutputStream(file));  
	            win.outCode(win, null,null,ps);
	            ps.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		
	}
	
	
}
