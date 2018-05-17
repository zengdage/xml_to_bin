package data_struct;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import utils.CommonUtils;
import view.Basewin;

public class DataFileXmlItem {
	private List<DataFileViewTableItem> itemList = new ArrayList<DataFileViewTableItem>();
	public static final int PathLen = 32;
	private Basewin basewin;
	private byte []xmlPath = new byte[PathLen];
	private int view_table_pos = 0;
	private int view_num = 0;
	
	
	public static final int XmlItemSize = PathLen + 4 + 4;
	
	public byte[] getXmlPath() {
		return xmlPath;
	}
	public void setXmlPath(byte[] id) {
		for(int i=0; i<PathLen; i++) {
			this.xmlPath[i]=0;
		}
		for(int i=0; i<id.length; i++) {
			this.xmlPath[i]=id[i];
		}
	}

	public Basewin getBasewin() {
		return basewin;
	}

	public void setBasewin(Basewin basewin) {
		this.basewin = basewin;
	}

	public List<DataFileViewTableItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DataFileViewTableItem> itemList) {
		this.itemList = itemList;
	}
	
	public void addViewTableItem(DataFileViewTableItem item) {
		this.itemList.add(item);
		this.view_num++;
	}
	
	public void addPropertyPosOffset(int offset) {
		for(int i=0; i<itemList.size();i++){
			DataFileViewTableItem item = itemList.get(i);
			item.addPropertyPosOffset(offset);
		}
	}
	
	public int getView_table_pos() {
		return view_table_pos;
	}

	public void setView_table_pos(int view_table_pos) {
		this.view_table_pos = view_table_pos;
	}

	public void addPropertyPosDataOffset(int offset) {
		for(int i=0; i<itemList.size();i++){
			DataFileViewTableItem item = itemList.get(i);
			List<PropertyItem> propertyItemsList = item.getPropertyItemsList();
			for(int j=0; j<propertyItemsList.size(); j++){
				propertyItemsList.get(j).addPropertyDataPosOffset(offset);
			}
		}
	}
	
	public int getPropertyItemNum() {
		int num = 0;
		for(int i=0; i<itemList.size(); i++) {
			DataFileViewTableItem item =  itemList.get(i);
			num += item.getPropertyNum();
		}
		return num;
	}
	
	public void addViewTableItemPosOffset(int offset) {
		this.view_table_pos += offset;
	}
	
	public void outSelfToBin(OutputStream outputStream) {
		try {
			outputStream.write(xmlPath);
			outputStream.write(CommonUtils.int2bytes(this.view_num));
			outputStream.write(CommonUtils.int2bytes(this.view_table_pos));
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
