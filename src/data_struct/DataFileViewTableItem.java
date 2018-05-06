package data_struct;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import utils.CommonUtils;

public class DataFileViewTableItem {
	public static final int idLen = 16;
	public static final int ViewTableItemSize = idLen + 4 + 4 + 4 + 4 + 4 + 4;
	//控件id
	private byte [] id = new byte[idLen];
	//控件种类
	private int type = 0;
	//直接子item数量
	private int DirectSubChildItem = 0;
	//全部子item数量
	private int AllSubChildItem = 0;
	//属性数量
	private int PropertyNum = 0;
	//所有属性的大小
	private int PropertySize = 0;
	//属性表开始的位置
	private int PropertyPos = 0;
	//属性表
	private List<PropertyItem> propertyItemsList = new ArrayList<PropertyItem>();
	
	public DataFileViewTableItem(String idStr) {
		for(int i=0; i < idLen; i++){
			id[i] = 0;
		}
		for(int i=0,j=0; i < idLen && j < idStr.length(); i++,j++){
			id[i] = (byte) idStr.charAt(j);
		}
	}
	
	public byte[] getId() {
		return id;
	}
	public void setId(byte[] id) {
		for(int i=0; i<idLen; i++) {
			this.id[i]=0;
		}
		for(int i=0; i<id.length; i++) {
			this.id[i]=id[i];
		}
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getDirectSubChildItem() {
		return DirectSubChildItem;
	}
	public void setDirectSubChildItem(int directSubChildItem) {
		DirectSubChildItem = directSubChildItem;
	}
	public int getAllSubChildItem() {
		return AllSubChildItem;
	}
	public void setAllSubChildItem(int allSubChildItem) {
		AllSubChildItem = allSubChildItem;
	}
	public int getPropertyNum() {
		return PropertyNum;
	}
	public void setPropertyNum(int propertyNum) {
		PropertyNum = propertyNum;
	}
	public int getPropertySize() {
		return PropertySize;
	}
	public void setPropertySize(int propertySize) {
		PropertySize = propertySize;
	}
	public int getPropertyPos() {
		return PropertyPos;
	}
	public void setPropertyPos(int propertyPos) {
		PropertyPos = propertyPos;
	}
	
	public List<PropertyItem> getPropertyItemsList() {
		return propertyItemsList;
	}

	public void setPropertyItemsList(List<PropertyItem> propertyItemsList) {
		this.propertyItemsList = propertyItemsList;
	}
	
	public void addPropertyItemList(PropertyItem item){
		this.propertyItemsList.add(item);
		this.PropertyNum = propertyItemsList.size();
	}
	
	public void addPropertyPosOffset(int offset) {
		PropertyPos += offset;
	}
	

	public void outSelfToBin(OutputStream outputStream){
		try {
			outputStream.write(id);
			outputStream.write(CommonUtils.int2bytes(type));
			outputStream.write(CommonUtils.int2bytes(DirectSubChildItem));
			outputStream.write(CommonUtils.int2bytes(AllSubChildItem));
			outputStream.write(CommonUtils.int2bytes(PropertyNum));
			outputStream.write(CommonUtils.int2bytes(PropertySize));
			outputStream.write(CommonUtils.int2bytes(PropertyPos));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void outPropertyListToBin(OutputStream outputStream){
		for(int i=0; i<propertyItemsList.size();i++){
			PropertyItem item = propertyItemsList.get(i);
			item.outSelfToBin(outputStream);
		}
	}
	
}
