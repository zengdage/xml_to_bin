package data_struct;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import constant.Constant;
import orange.Inflate;
import view.Basewin;

public class DataFile {
	
	private DataFileHeader header = new DataFileHeader(Constant.magicStr);
	private List<DataFileXmlItem> itemList = new ArrayList<DataFileXmlItem>();
	private List<Basewin> winList = new ArrayList<Basewin>();
	
	public DataFileHeader getHeader() {
		return header;
	}
	public void setHeader(DataFileHeader header) {
		this.header = header;
	}
	public List<DataFileXmlItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<DataFileXmlItem> itemList) {
		this.itemList = itemList;
	}
	
	public void addDataFileItem(DataFileXmlItem item) {
		this.itemList.add(item);
	}
	
	public void outToBin(OutputStream outputStream) {
		int viewNum = 0;
		int xmlNum = itemList.size();
		int propertyNum = 0;
		
		for(int i=0; i<xmlNum;i++) {
			DataFileXmlItem item = itemList.get(i);
			item.getBasewin().calcute();
		}
		
		for(int i=0; i<xmlNum;i++) {
			DataFileXmlItem item = itemList.get(i);
			viewNum += item.getItemList().size();
			propertyNum += item.getPropertyItemNum();
			
		}
		
		header.setViewNum(viewNum);
		header.setXmlNum(xmlNum);
		header.outSelfToBin(outputStream);
		
		for(int i=0; i<xmlNum;i++) {
			DataFileXmlItem item = itemList.get(i);
			item.addPropertyPosOffset(DataFileHeader.xmlTablePos + 
					DataFileXmlItem.XmlItemSize * xmlNum +
					DataFileViewTableItem.ViewTableItemSize * viewNum);
			item.addPropertyPosDataOffset(DataFileHeader.xmlTablePos +
					DataFileXmlItem.XmlItemSize * xmlNum +
					DataFileViewTableItem.ViewTableItemSize * viewNum +
					PropertyItem.PropertyItemSize * propertyNum);
			
			item.addViewTableItemPosOffset(DataFileHeader.xmlTablePos + 
					DataFileXmlItem.XmlItemSize * xmlNum);
		}
		
		for(int i=0; i<xmlNum;i++) {
			DataFileXmlItem item = itemList.get(i);
			item.outSelfToBin(outputStream);
		}
		
		for(int i=0; i<xmlNum;i++) {
			DataFileXmlItem item = itemList.get(i);
			item.outViewTableItemToBin(outputStream);
		}
		
		for(int i=0; i<xmlNum;i++) {
			DataFileXmlItem item = itemList.get(i);
			item.outPropertyItemToBin(outputStream);
		}
		
		for(int i=0; i<xmlNum;i++) {
			DataFileXmlItem item = itemList.get(i);
			item.outPropertyItemDataToBin(outputStream);
		}
		
	}
	
	public void parse_xml(String xmlfile) {
		DataFileXmlItem xmlItem = new DataFileXmlItem();
		Basewin basewin = Inflate.getLayout(xmlItem,xmlfile);
		xmlItem.setBasewin(basewin);
		xmlItem.setXmlPath(xmlfile.getBytes());
		xmlItem.setView_table_pos(Constant.viewTableItemPos);
		Constant.viewTableItemPos += xmlItem.getItemList().size() * DataFileViewTableItem.ViewTableItemSize;
		itemList.add(xmlItem);
		winList.add(basewin);
	}
	

}
