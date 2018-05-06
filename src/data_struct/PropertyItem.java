package data_struct;

import java.io.IOException;
import java.io.OutputStream;

import constant.Constant;
import constant.PropertyTypeValue;
import utils.CommonUtils;

public class PropertyItem {
	public static final int PropertyNameLen = 16;
	//控件id
	private byte [] name = new byte[PropertyNameLen];
	//属性数据的大小
	private int PropertyDataSize = 0;
	//属性数据开始的位置
	private int PropertyDataPos = 0;
	//属性数据种类
	private int PropertyDataType = Constant.DataTypeSTRING;
	private String PropertyData = "5!!!!!";
	
	public PropertyItem(String nameStr, int PropertyDataType, String PropertyData, int PropertyDataSize, int PropertyDataPos) {
		for(int i=0; i < PropertyNameLen; i++){
			name[i] = 0;
		}
		for(int i=0,j=0; i < PropertyNameLen && j < nameStr.length(); i++,j++){
			name[i] = (byte) nameStr.charAt(j);
		}
		this.PropertyData = PropertyData;
		this.PropertyDataType = PropertyDataType;
		this.PropertyDataPos = PropertyDataPos;
		
		if(PropertyDataType == Constant.DataTypeINT){
			this.PropertyDataSize = 4;
		}else if (PropertyDataType == Constant.DataTypeSTRING) {
			this.PropertyDataSize = PropertyData.length();
		}
	}
	
	public PropertyItem(String nameStr) {
		for(int i=0; i < PropertyNameLen; i++){
			name[i] = 0;
		}
		for(int i=0,j=0; i < PropertyNameLen && j < nameStr.length(); i++,j++){
			name[i] = (byte) nameStr.charAt(j);
		}
		
	}
	
	public byte[] getName() {
		return name;
	}
	public void setName(byte[] name) {
		this.name = name;
	}
	public int getPropertyDataSize() {
		return PropertyDataSize;
	}
	public void setPropertyDataSize(int propertyDataSize) {
		PropertyDataSize = propertyDataSize;
	}
	public int getPropertyDataPos() {
		return PropertyDataPos;
	}
	public void setPropertyDataPos(int propertyDataPos) {
		PropertyDataPos = propertyDataPos;
	}
	
	public int getPropertyDataPType() {
		return PropertyDataType;
	}
	public void setPropertyDataPType(int propertyDataPType) {
		PropertyDataType = propertyDataPType;
	}
	
	public String getPropertyData() {
		return PropertyData;
	}

	public void setPropertyData(String propertyData) {
		PropertyData = propertyData;
	}

	public void outSelfToBin(OutputStream outputStream){
		try {
			outputStream.write(name);
			outputStream.write(CommonUtils.int2bytes(PropertyDataSize));
			outputStream.write(CommonUtils.int2bytes(PropertyDataPos));
			outputStream.write(CommonUtils.int2bytes(PropertyDataType));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void outPropertyDataToBin(OutputStream outputStream){
		try {
			if(PropertyDataType == Constant.DataTypeINT){
				int data = Integer.parseInt(PropertyData);
				outputStream.write(CommonUtils.int2bytes(data));
			}else if (PropertyDataType == Constant.DataTypeSTRING) {
				outputStream.write(PropertyData.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


}
