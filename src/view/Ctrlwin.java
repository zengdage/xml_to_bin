package view;

import java.util.HashMap;

import constant.Constant;
import data_struct.PropertyItem;
import utils.CommonUtils;
import xmlpulldemo.AttributeSet;
import xmlpulldemo.ParamValue;
import xmlpulldemo.YDResource;

public class Ctrlwin extends Basewin{

	
	
	public Ctrlwin(AttributeSet attrs) {
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
				break;
			case win_spClassName:
				this.spClassName=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.spClassName, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.spClassName);
				propertyCount++;
				break;
			default:
				break;
			}
			if (item != null) {
				viewTableItem.addPropertyItemList(item);
			}
    	}
		Constant.propertyTableItemPos += propertyCount * PropertyItem.PropertyItemSize;
		viewTableItem.setType(Constant.TypeCtrwin);
		viewTableItem.setDirectSubChildItem(getDirectSubchildItem());
		viewTableItem.setId(this.win_id.getBytes());
		viewTableItem.setPropertySize(viewTableItem.getPropertyNum() * PropertyItem.PropertyItemSize);
	}

}
