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
	
	private int viewTablePos = magicLen + 4;
	
	private List<DataFileViewTableItem> itemList = new ArrayList<DataFileViewTableItem>();
	
	public DataFileHeader(String magicStr) {
		for(int i=0; i < magicLen; i++){
			magic[i] = 0;
		}
		for(int i=0,j=0; i < magicLen && j < magicStr.length(); i++,j++){
			magic[i] = (byte) magicStr.charAt(j);
		}
	}
	
	public int getViewNum(){
		return this.viewNum;
	}
	
	public void setViewNum(int ViewNum){
		this.viewNum = ViewNum;
	}
	
	public int getViewTablePos(){
		return this.viewTablePos;
	}
	
	public void setViewTablePos(int tablepos){
		this.viewTablePos = tablepos;
	}
	
	public List<DataFileViewTableItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DataFileViewTableItem> itemList) {
		this.itemList = itemList;
	}
	
	public void addViewTableItem(DataFileViewTableItem item) {
		this.itemList.add(item);
		viewNum = this.itemList.size();
	}

	
	public void outSelfToBin(OutputStream outputStream){
		try {
			outputStream.write(magic);
			outputStream.write(CommonUtils.int2bytes(viewNum));
			outputStream.write(CommonUtils.int2bytes(viewTablePos));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void outViewTableItemToBin(OutputStream outputStream){
		for(int i=0; i<itemList.size();i++){
			DataFileViewTableItem item = itemList.get(i);
			item.outSelfToBin(outputStream);
		}
	}
	
	public void outPropertyItemToBin(OutputStream outputStream){
		for(int i=0; i<itemList.size();i++){
			DataFileViewTableItem item = itemList.get(i);
			item.outPropertyListToBin(outputStream);
		}
	}
	
	public void outPropertyItemDataToBin(OutputStream outputStream){
		for(int i=0; i<itemList.size();i++){
			DataFileViewTableItem item = itemList.get(i);
			List<PropertyItem> propertyItemsList = item.getPropertyItemsList();
			for(int j=0; j<propertyItemsList.size(); j++){
				propertyItemsList.get(j).outPropertyDataToBin(outputStream);
			}
		}
	}
	
}
