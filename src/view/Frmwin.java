package view;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;

import constant.Constant;
import data_struct.PropertyItem;
import utils.CommonUtils;
import xmlpulldemo.AttributeSet;
import xmlpulldemo.ParamValue;
import xmlpulldemo.YDResource;

public class Frmwin extends Basewin{
	
	public Frmwin(AttributeSet attrs) {
		super(attrs);
	}
	
	@Override
	public void setAttributeSet(AttributeSet attrs){	
		super.setAttributeSet(attrs);
		
		HashMap<String,ParamValue> map=YDResource.getInstance().getBasewinMap();	
		int count =attrs.getAttributeCount();
		int propertyCount = 0;
		for(int i=0;i<count ;i++){
			ParamValue key=map.get(attrs.getAttributeName(i));
			if(key==null){
				continue;
			}
			PropertyItem item = null;
			switch (key) {
			case win_spCaption:
				this.win_spCaption=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.win_spCaption, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.win_spCaption);
				propertyCount++;
			default:
				break;
			}
			if (item != null) {
				viewTableItem.addPropertyItemList(item);
			}
    	}
		Constant.propertyTableItemPos += propertyCount * PropertyItem.PropertyItemSize;
		viewTableItem.setType(Constant.TypeFrmwin);
		viewTableItem.setDirectSubChildItem(getDirectSubchildItem());
		viewTableItem.setId(this.win_id.getBytes());
		viewTableItem.setPropertySize(viewTableItem.getPropertyNum() * PropertyItem.PropertyItemSize);
    }
	

	@Override
	public void printChild(int depth) {
		super.printChild(depth);
	}
	
	@Override
	public void showSelf(String space) {
		super.showSelf(space);
	}
	
	@Override
	public void outCode(Basewin win, Basewin parent, File file,PrintStream ps) {
		super.outCode(win, parent,file,ps);
		outFrmWinCode(win, parent,ps);
	}
	
	public void outFrmWinCode(Basewin win, Basewin parent,PrintStream ps) {
	
	}
}
