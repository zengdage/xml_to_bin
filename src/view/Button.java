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

public class Button extends Basewin{

	String focus_bmp;
	String unfocus_bmp;
	int bmp_x;
	int bmp_y;
	int txt_x;
	int txt_y;
	int txt_align;
	String text;
	String focus_txt_color;
	String unfocus_txt_color;
	int font;
	String charset;
	String bkcolor;
	boolean alpha;
	
	int draw_sts;
	int status;
	
	public Button(AttributeSet attrs) {
		super(attrs);
	}
	
	@Override
	public void showSelf(String space) {
		super.showSelf(space);
		space += "\t";
		System.out.println(space+"focus_bmp="+this.focus_bmp);
		System.out.println(space+"unfocus_bmp="+this.unfocus_bmp);
		System.out.println(space+"bmp_x="+this.bmp_x);
		System.out.println(space+"bmp_y="+this.bmp_y);
		System.out.println(space+"txt_x="+this.txt_x);
		System.out.println(space+"txt_y="+this.txt_y);
		System.out.println(space+"txt_align="+this.txt_align);
		System.out.println(space+"text="+this.text);
		System.out.println(space+"focus_txt_color="+this.focus_txt_color);
		System.out.println(space+"unfocus_txt_color="+this.unfocus_txt_color);
		
		System.out.println(space+"font="+this.font);
		System.out.println(space+"charset="+this.charset);
		System.out.println(space+"bkcolor="+this.bkcolor);
		System.out.println(space+"alpha="+this.alpha);
		System.out.println(space+"draw_sts="+this.draw_sts);
		System.out.println(space+"status="+this.status);
		
	}
	
	@Override
	public void printChild(int depth) {
		super.printChild(depth);
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
			case focus_bmp:
				this.focus_bmp=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.focus_bmp, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.focus_bmp);
				propertyCount++;
				break;
			case unfocus_bmp:
				this.unfocus_bmp=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.unfocus_bmp, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.unfocus_bmp);
				propertyCount++;
				break;
			case bmp_x:
				this.bmp_x=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.bmp_x), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case bmp_y:
				this.bmp_y=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.bmp_y), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case txt_x:
				this.txt_x=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.txt_x), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case txt_y:
				this.txt_y=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.txt_x), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case txt_align:
				this.txt_align=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.txt_align), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case text:
				this.text=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.text, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.text);
				propertyCount++;
				break;
			case focus_txt_color:
				this.focus_txt_color=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.focus_txt_color, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.focus_txt_color);
				propertyCount++;
				break;
			case unfocus_txt_color:
				this.unfocus_txt_color=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.unfocus_txt_color, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.unfocus_txt_color);
				propertyCount++;
				break;
			case font:
				this.font=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.font), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case charset:
				this.charset=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.charset, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.charset);
				propertyCount++;
				break;
			case bkcolor:
				this.bkcolor=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.bkcolor, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.bkcolor);
				propertyCount++;
				break;
			case alpha:
				this.alpha=attrs.getAttributeBooleanValue(i, true);
				if(alpha) {
					item = new PropertyItem(attrs.getAttributeName(i), 
							Constant.DataTypeINT, 
							String.valueOf(1), Constant.propertyDataPos);
				}else {
					item = new PropertyItem(attrs.getAttributeName(0), 
							Constant.DataTypeINT, 
							String.valueOf(1), Constant.propertyDataPos);
				}
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case draw_sts:
				this.draw_sts=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.draw_sts), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case status:
				this.status=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.status), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			default:
				break;
			}
			if (item != null) {
				viewTableItem.addPropertyItemList(item);
			}
    	}
		//System.out.println("============"+Constant.propertyTableItemPos);
		//viewTableItem.setPropertyNum(propertyCount+viewTableItem.getPropertyNum());
		Constant.propertyTableItemPos += propertyCount * PropertyItem.PropertyItemSize;
		viewTableItem.setType(Constant.TypeButton);
		viewTableItem.setDirectSubChildItem(getDirectSubchildItem());
		viewTableItem.setId(this.win_id.getBytes());
		viewTableItem.setPropertySize(viewTableItem.getPropertyNum() * PropertyItem.PropertyItemSize);
    }
	
	@Override
	public void outCode(Basewin win, Basewin parent,File file,PrintStream ps) {
		super.outCode(win, parent,file,ps);
		outCtrCode(win, parent,ps);
	}
	
	public void outCtrCode(Basewin win, Basewin parent,PrintStream ps) {
		StringBuffer code = new StringBuffer();
	
		
		
	}

}
