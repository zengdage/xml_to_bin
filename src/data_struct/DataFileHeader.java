package data_struct;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import utils.CommonUtils;


public class DataFileHeader {
	public static final int magicLen = 8;
	
	byte [] magic = new byte[magicLen];
	private int viewNum = 0;
	private int xmlNum = 0;
	
	public static final int viewTablePos = magicLen + 4 + 4 + 4;
	
	public DataFileHeader(String magicStr) {
		for(int i=0; i < magicLen; i++){
			magic[i] = 0;
		}
		for(int i=0,j=0; i < magicLen && j < magicStr.length(); i++,j++){
			magic[i] = (byte) magicStr.charAt(j);
		}
	}
	
	public int getXmlNum() {
		return xmlNum;
	}

	public void setXmlNum(int xmlNum) {
		this.xmlNum = xmlNum;
	}
	
	public int getViewNum(){
		return this.viewNum;
	}
	
	public void setViewNum(int ViewNum){
		this.viewNum = ViewNum;
	}
	
	
	
	public void outSelfToBin(OutputStream outputStream){
		try {
			outputStream.write(magic);
			outputStream.write(CommonUtils.int2bytes(xmlNum));
			outputStream.write(CommonUtils.int2bytes(viewNum));
			outputStream.write(CommonUtils.int2bytes(viewTablePos));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
