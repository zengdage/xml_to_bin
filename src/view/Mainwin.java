package view;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;

import constant.Constant;
import data_struct.PropertyItem;
import resource.ParseThemeHeadFile;
import utils.CommonUtils;
import xmlpulldemo.AttributeSet;
import xmlpulldemo.ParamValue;
import xmlpulldemo.YDResource;

public class Mainwin extends Basewin{

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
	
	public Mainwin(AttributeSet attrs) {
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
			case focus_bmp:
				this.focus_bmp=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				int focus_bmp_data = ParseThemeHeadFile.getHashMapValue(this.focus_bmp);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(focus_bmp_data), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case unfocus_bmp:
				this.unfocus_bmp=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				int unfocus_bmp_data = ParseThemeHeadFile.getHashMapValue(this.unfocus_bmp);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(unfocus_bmp_data), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
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
				
				int text = ParseThemeHeadFile.getHashMapValue(this.text);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(text), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
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
		
		Constant.propertyTableItemPos += propertyCount * PropertyItem.PropertyItemSize;
		viewTableItem.setType(Constant.TypeMainwin);
		viewTableItem.setDirectSubChildItem(getDirectSubchildItem());
		viewTableItem.setId(this.win_id.getBytes());
		viewTableItem.setPropertySize(viewTableItem.getPropertyNum() * PropertyItem.PropertyItemSize);
    }
	
	@Override
	public void showSelf(String space) {
		super.showSelf(space);
	}
	
	@Override
	public void printChild(int depth) {
		super.printChild(depth);
	}
	
	@Override
	public void outCode(Basewin win, Basewin parent, File file,PrintStream ps) {
		super.outCode(win, parent,file,ps);
		outMainWinCode(win, parent,ps);
		outMainWinCallBackCode(win, parent,ps);
	}
	
	public void outMainWinCode(Basewin win, Basewin parent,PrintStream ps) {

	}
	
	public void outMainWinCallBackCode(Basewin win, Basewin parent,PrintStream ps) {

		
	}
}
