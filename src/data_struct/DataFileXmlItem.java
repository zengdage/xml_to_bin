package data_struct;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import view.Basewin;

public class DataFileXmlItem {
	private List<DataFileViewTableItem> itemList = new ArrayList<DataFileViewTableItem>();
	private Basewin basewin;
	private String xmlPath;
	
	public String getXmlPath() {
		return xmlPath;
	}

	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
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
	}
	
	public void addPropertyPosOffset(int offset) {
		for(int i=0; i<itemList.size();i++){
			DataFileViewTableItem item = itemList.get(i);
			item.addPropertyPosOffset(offset);
		}
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
