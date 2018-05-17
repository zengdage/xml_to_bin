package view;


import java.util.HashMap;

import constant.Constant;
import data_struct.PropertyItem;
import utils.CommonUtils;
import xmlpulldemo.AttributeSet;
import xmlpulldemo.ParamValue;
import xmlpulldemo.YDResource;

public class LyrWin extends Basewin{

	public int layer_work_mode_t;
	public int disp_ck_modet;
	public int pipe;
	public int alpha_en;
	public int alpha_val;
	public int scn_win_x;
	public int scn_win_y;
	public int scn_win_width;
	public int scn_win_height;
	public int src_win_x;
	public int src_win_y;
	public int src_win_width;
	public int src_win_heigth;
	
	public int channel;
	public int fb_size_width;
	public int fb_size_height;
	public int fb_add0;
	public int fb_add1;
	public int fb_add2;
	public int fb_type;
	
	public int lyrwin_sta;
	public int lyrwin_type;
	
	public int prio;
	
	public LyrWin(AttributeSet attrs) {
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
			case disp_ck_modet:
				this.disp_ck_modet = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.disp_ck_modet), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case pipe:
				this.pipe = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.pipe), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case alpha_en:
				this.alpha_en = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.alpha_en), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case alpha_val:
				this.alpha_val = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.alpha_val), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case scn_win_x:
				this.scn_win_x = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.scn_win_x), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case scn_win_y:
				this.scn_win_y = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.scn_win_y), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case scn_win_width:
				this.scn_win_width = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.scn_win_width), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case scn_win_height:
				this.scn_win_height = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.scn_win_height), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case src_win_x:
				this.src_win_x = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.src_win_x), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case src_win_y:
				this.src_win_y = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.src_win_y), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case src_win_width:
				this.src_win_width = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.src_win_width), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case src_win_heigth:
				this.src_win_heigth = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.src_win_heigth), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case channel:
				this.channel = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.channel), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case fb_size_width:
				this.fb_size_width = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.fb_size_width), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case fb_size_height:
				this.fb_size_height = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.fb_size_height), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case fb_add0:
				this.fb_add0 = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.fb_add0), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case fb_add1:
				this.fb_add1 = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.fb_add1), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case fb_add2:
				this.fb_add2 = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.fb_add2), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case fb_type:
				this.fb_type = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.fb_type), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
				
			case lyrwin_sta:
				this.lyrwin_sta = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyrwin_sta), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case lyrwin_type:
				this.lyrwin_type = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.lyrwin_type), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;	
			case layer_work_mode_t:
				this.layer_work_mode_t = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.layer_work_mode_t), Constant.propertyDataPos);
				Constant.propertyDataPos += 4;
				propertyCount++;
				break;
			case prio:
				this.prio = attrs.getAttributeIntValue(i, 0);
				item = new PropertyItem(attrs.getAttributeName(i), 
						Constant.DataTypeINT, 
						String.valueOf(this.prio), Constant.propertyDataPos);
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
		viewTableItem.setType(Constant.TypeLyrWin);
		viewTableItem.setDirectSubChildItem(getDirectSubchildItem());
		viewTableItem.setId(this.win_id.getBytes());
		viewTableItem.setPropertySize(viewTableItem.getPropertyNum() * PropertyItem.PropertyItemSize);
	}

}

