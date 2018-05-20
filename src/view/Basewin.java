package view;


import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import constant.Constant;
import data_struct.DataFileViewTableItem;
import data_struct.PropertyItem;
import resource.ParseIDHeadFile;
import resource.ParseThemeHeadFile;
import utils.CommonUtils;
import xmlpulldemo.AttributeSet;
import xmlpulldemo.ParamValue;
import xmlpulldemo.Params;
import xmlpulldemo.YDResource;

public class Basewin extends Win{
	
	public Params params;
	
	public List<Basewin> child_list = new ArrayList<Basewin>();

	protected DataFileViewTableItem viewTableItem = new DataFileViewTableItem("");

	public Basewin(AttributeSet attrs) {
		setAttributeSet(attrs);
		System.out.println("["+Thread.currentThread().getStackTrace()[2].getFileName()+","+Thread.currentThread().getStackTrace()[2].getLineNumber()+"]");
	}
	
	
	public DataFileViewTableItem getViewTableItem() {
		return viewTableItem;
	}

	public void setViewTableItem(DataFileViewTableItem viewTableItem) {
		this.viewTableItem = viewTableItem;
	}
	
	public void addView(Basewin win, Params params){
		child_list.add(win);
	}
	
	public void removeView(Basewin win) {
		child_list.remove(win);
	}
	
	public void setLayoutParams(Params params){
		this.params = params;
	}
	
	public Params generateLayoutParams(AttributeSet attrs){
		return null;
	}
	
	@Override
	public void setAttributeSet(AttributeSet attrs){	
		HashMap<String,ParamValue> map=YDResource.getInstance().getBasewinMap();	
		int count =attrs.getAttributeCount();
		int propertyCount = viewTableItem.getPropertyNum();

		for(int i=0;i<count ;i++){
			ParamValue key=map.get(attrs.getAttributeName(i));
			//System.out.println(attrs.getAttributeName(i));
			if(key==null){
				System.out.println("error:"+attrs.getAttributeName(i));
				continue;
			}
			PropertyItem item = null;
			switch (key) {
			case app_name:
				App.app_name=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						App.app_name, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(App.app_name);
				propertyCount++;
				break;
			case win_id:
				this.win_id=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.win_id, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.win_id);
				propertyCount++;
				break;
			case win_name:
				this.win_name=YDResource.getInstance().getString(attrs.getAttributeValue(i));
//				item = new PropertyItem(attrs.getAttributeName(i), 
//						Constant.DataTypeSTRING, 
//						this.win_name, Constant.propertyDataPos);
//				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.win_name);
//				propertyCount++;
				
				int win_name_data = ParseIDHeadFile.getHashMapValue(this.win_name);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(win_name_data), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_DataType:
				this.win_DataType=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_DataType), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_WinType:
				this.win_WinType=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_WinType), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_dwStyle:
				this.win_dwStyle=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_dwStyle), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_dwExStyle:
				this.win_dwExStyle=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_dwExStyle), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case lyr_type:
				this.lyr_type=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyr_type), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case lyr_status:
				this.lyr_status=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyr_status), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case lyr_intersts:
				this.lyr_intersts=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyr_intersts), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case lyr_clip_left:
				this.lyr_clip_left=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyr_clip_left), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case lyr_clip_right:
				this.lyr_clip_right=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyr_clip_right), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case lyr_clip_top:
				this.lyr_clip_top=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyr_clip_top), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case lyr_clip_boottom:
				this.lyr_clip_boottom=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyr_clip_boottom), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case lyr_zordeer:
				this.lyr_zordeer=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyr_zordeer), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case win_left:
				this.win_left=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_left), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_top:
				this.win_top=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_top), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_right:
				this.win_right=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_right), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_bottom:
				this.win_bottom=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_bottom), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case win_client_left:
				this.win_client_left=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_client_left), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_client_top:
				this.win_client_top=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_client_top), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_client_right:
				this.win_client_right=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_client_right), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_client_bottom:
				this.win_client_bottom=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_client_bottom), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case win_bkcolor:
				this.win_bkcolor=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.win_bkcolor, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.win_bkcolor);
				propertyCount++;
				break;
			case win_font:
				this.win_font=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_font), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case win_invalid_left:
				this.win_invalid_left=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_invalid_left), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_invalid_right:
				this.win_invalid_right=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_invalid_right), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_invalid_top:
				this.win_invalid_top=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_invalid_top), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_invalid_bottom:
				this.win_invalid_bottom=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_invalid_bottom), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case win_clip_left:
				this.win_clip_left=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_clip_left), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_clip_right:
				this.win_clip_right=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_clip_right), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_clip_top:
				this.win_clip_top=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_clip_top), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_clip_boottom:
				this.win_clip_boottom=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_clip_boottom), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case win_zordeer:
				this.win_zordeer=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_zordeer), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case win_callback:
				this.win_callback=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.win_callback, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.win_callback);
				propertyCount++;
				break;
			case notify_proc:
				this.notify_proc=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeSTRING, 
						this.notify_proc, Constant.propertyDataPos);
				Constant.propertyDataPos += CommonUtils.alignStringTo4byte(this.notify_proc);
				propertyCount++;
				break;
			case win_vscroll_minPos:
				this.win_vscroll_minPos=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_vscroll_minPos), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_vscroll_maxPos:
				this.win_vscroll_maxPos=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_vscroll_maxPos), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_vscroll_curPos:
				this.win_vscroll_curPos=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_vscroll_curPos), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_vscroll_pageStep:
				this.win_vscroll_pageStep=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_vscroll_pageStep), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_vscroll_barStart:
				this.win_vscroll_barStart=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_vscroll_barStart), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_vscroll_barLen:
				this.win_vscroll_barLen=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_vscroll_barLen), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_vscroll_status:
				this.win_vscroll_status=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_vscroll_status), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case win_hscroll_minPos:
				this.win_hscroll_minPos=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_hscroll_minPos), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_hscroll_maxPos:
				this.win_hscroll_maxPos=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_hscroll_maxPos), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_hscroll_curPos:
				this.win_hscroll_curPos=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_hscroll_curPos), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_hscroll_pageStep:
				this.win_hscroll_pageStep=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_hscroll_pageStep), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_hscroll_barStart:
				this.win_hscroll_barStart=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_hscroll_barStart), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_hscroll_barLen:
				this.win_hscroll_barLen=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_hscroll_barLen), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case win_hscroll_status:
				this.win_hscroll_status=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.win_hscroll_status), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			
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
			case bmp_num:
				this.bmp_num=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.bmp_num), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case bmp_array:
				this.bmp_array=YDResource.getInstance().getString(attrs.getAttributeValue(i));
					
				Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");  
				Matcher matcher = pattern.matcher(this.bmp_array);
				List<String> strList = new ArrayList<String>();
				while(matcher.find()){
					strList.add(matcher.group());
					//System.out.println(matcher.group());
				}
				String []bmp_arr = strList.toArray(new String[0]);
				
				if(bmp_arr.length == 0) {
					bmp_arr = this.bmp_array.split(",");
				}
		
				if(bmp_arr.length == this.bmp_num) {
					StringBuffer bmp_out = new StringBuffer();
					for(int j=0; j<bmp_arr.length-1; j++) {
						int num = ParseThemeHeadFile.getHashMapValue(bmp_arr[j]);
						bmp_out.append(num+",");
					}
					bmp_out.append(ParseThemeHeadFile.getHashMapValue(bmp_arr[bmp_arr.length-1]));
					
					item = new PropertyItem(attrs.getAttributeName(i), 
							Constant.DataTypeSTRING, 
							bmp_out.toString(), Constant.propertyDataPos);
					Constant.propertyDataPos += CommonUtils.alignStringTo4byte(bmp_out.toString());
					propertyCount++;
				}	
				break;
				
			case pos_num:
				this.pos_num=attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.pos_num), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case pos_array:
				this.pos_array=YDResource.getInstance().getString(attrs.getAttributeValue(i));
					
				Pattern pattern1 = Pattern.compile("(?<=\\()[^\\)]+");  
				Matcher matcher1 = pattern1.matcher(this.pos_array);
				List<String> strList1 = new ArrayList<String>();
				while(matcher1.find()){
					strList1.add(matcher1.group());
					//System.out.println(matcher1.group());
				}
				String []bmp_arr1 = strList1.toArray(new String[0]);
				
				if(bmp_arr1.length == this.pos_num) {
					StringBuffer bmp_out = new StringBuffer();
					for(int j=0; j<bmp_arr1.length-1; j++) {
						String [] xy_array = bmp_arr1[j].split(",");
						for(int k=0; k<xy_array.length;k++) {
							bmp_out.append(Integer.valueOf(xy_array[k])+",");
						}	
					}
					
					String [] xy_array = bmp_arr1[bmp_arr1.length-1].split(",");
					bmp_out.append(Integer.valueOf(xy_array[0])+",");
					bmp_out.append(Integer.valueOf(xy_array[1]));

					item = new PropertyItem(attrs.getAttributeName(i), 
							Constant.DataTypeSTRING, 
							bmp_out.toString(), Constant.propertyDataPos);
					Constant.propertyDataPos += CommonUtils.alignStringTo4byte(bmp_out.toString());
					propertyCount++;
					System.out.println("pos_array:"+bmp_out.toString());
				}
				break;
			default:
				System.out.println("default:"+attrs.getAttributeName(i));
				break;
			}
			if (item != null) {
				viewTableItem.addPropertyItemList(item);
			}
			
    	}

		viewTableItem.setPropertyPos(Constant.propertyTableItemPos);
		Constant.propertyTableItemPos += propertyCount * PropertyItem.PropertyItemSize;
		viewTableItem.setType(Constant.TypeBasewin);
		viewTableItem.setDirectSubChildItem(getDirectSubchildItem());
		viewTableItem.setPropertySize(propertyCount * PropertyItem.PropertyItemSize);
		viewTableItem.setId(this.win_id.getBytes());
    }
	
	public int getAllSubchildItem() {
		return 0;
	}
	
	public int getDirectSubchildItem() {
		int size = child_list.size();
		return size;
	}
	
	public void calcute() {
		viewTableItem.setDirectSubChildItem(getDirectSubchildItem());
		for(int i=0; i<child_list.size();i++) {
			Basewin wBasewin = child_list.get(i);
			wBasewin.calcute();
		}
	}
	
	@Override
	public String toString() {
		return ""+this.getClass().getSimpleName();
	}
	

	
	public void printChild(int depth) {
		if(depth == 0)
			System.out.println(this);
		String space = "";
		for(int i=0;i<depth+1;i++) {
			space += "\t";
		}
		for(int i=0; i<child_list.size(); i++) {
			System.out.println(space+child_list.get(i));
			child_list.get(i).showSelf(space);
			child_list.get(i).printChild(depth+1);
		}
	}
	
	public void showSelf(String space) {
		space += "\t";
		System.out.println(space+"win_id="+this.win_id);
		System.out.println(space+"win_name="+this.win_name);
		System.out.println(space+"win_DataType="+this.win_DataType);
		System.out.println(space+"win_WinType="+this.win_WinType);
		System.out.println(space+"win_dwStyle="+this.win_dwStyle);
		System.out.println(space+"win_dwExStyle="+this.win_dwExStyle);
		
		System.out.println(space+"lyr_type="+this.lyr_type);
		System.out.println(space+"lyr_status="+this.lyr_status);
		System.out.println(space+"lyr_intersts="+this.lyr_intersts);
		System.out.println(space+"lyr_clip_left="+this.lyr_clip_left);
		System.out.println(space+"lyr_clip_right="+this.lyr_clip_right);
		System.out.println(space+"lyr_clip_top="+this.lyr_clip_top);
		System.out.println(space+"lyr_clip_boottom="+this.lyr_clip_boottom);
		System.out.println(space+"lyr_zordeer="+this.lyr_zordeer);
		
		System.out.println(space+"win_left="+this.win_left);
		System.out.println(space+"win_top="+this.win_top);
		System.out.println(space+"win_right="+this.win_right);
		System.out.println(space+"win_bottom="+this.win_bottom);
		System.out.println(space+"win_client_left="+this.win_client_left);
		System.out.println(space+"win_client_top="+this.win_client_top);
		System.out.println(space+"win_client_right="+this.win_client_right);
		System.out.println(space+"win_client_bottom="+this.win_client_bottom);
		
		System.out.println(space+"win_bkcolor="+this.win_bkcolor);
		System.out.println(space+"win_font="+this.win_font);
		System.out.println(space+"win_invalid_left="+this.win_invalid_left);
		System.out.println(space+"win_invalid_right="+this.win_invalid_right);
		System.out.println(space+"win_invalid_top="+this.win_invalid_top);
		System.out.println(space+"win_invalid_bottom="+this.win_invalid_bottom);
		System.out.println(space+"win_clip_left="+this.win_clip_left);
		System.out.println(space+"win_clip_right="+this.win_clip_right);
		System.out.println(space+"win_clip_top="+this.win_clip_top);
		System.out.println(space+"win_clip_boottom="+this.win_clip_boottom);
		
		System.out.println(space+"win_zordeer="+this.win_zordeer);
		System.out.println(space+"win_callback="+this.win_callback);
		System.out.println(space+"notify_proc="+this.notify_proc);
		
		System.out.println(space+"win_vscroll_minPos="+this.win_vscroll_minPos);
		System.out.println(space+"win_vscroll_maxPos="+this.win_vscroll_maxPos);
		System.out.println(space+"win_vscroll_curPos="+this.win_vscroll_curPos);
		System.out.println(space+"win_vscroll_pageStep="+this.win_vscroll_pageStep);
		System.out.println(space+"win_vscroll_barStart="+this.win_vscroll_barStart);
		System.out.println(space+"win_vscroll_barLen="+this.win_vscroll_barLen);
		System.out.println(space+"win_vscroll_status="+this.win_vscroll_status);
		
		System.out.println(space+"win_hscroll_minPos="+this.win_hscroll_minPos);
		System.out.println(space+"win_hscroll_maxPos="+this.win_hscroll_maxPos);
		System.out.println(space+"win_hscroll_curPos="+this.win_hscroll_curPos);
		System.out.println(space+"win_hscroll_pageStep="+this.win_hscroll_pageStep);
		System.out.println(space+"win_hscroll_barStart="+this.win_hscroll_barStart);
		System.out.println(space+"win_hscroll_barLen="+this.win_hscroll_barLen);
		System.out.println(space+"win_hscroll_status="+this.win_hscroll_status);
		
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
	public void outCode(Basewin win, Basewin parent, File file,PrintStream ps) {
		for(int i=0;i<win.child_list.size();i++) {
			Basewin wBasewin = win.child_list.get(i);
			wBasewin.outCode(wBasewin, win, file,ps);
		}
	}


}
