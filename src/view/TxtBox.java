package view;


import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;

import xmlpulldemo.AttributeSet;
import xmlpulldemo.ParamValue;
import xmlpulldemo.YDResource;

public class TxtBox extends Basewin{

	public TxtBox(AttributeSet attrs) {
		super(attrs);
		// TODO Auto-generated constructor stub
	}

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
		for(int i=0;i<count ;i++){
			ParamValue key=map.get(attrs.getAttributeName(i));
			if(key==null){
				continue;
			}
			switch (key) {
			case focus_bmp:
				this.focus_bmp=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				break;
			case unfocus_bmp:
				this.unfocus_bmp=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				break;
			case bmp_x:
				this.bmp_x=attrs.getAttributeIntValue(i, 0);
				break;
			case bmp_y:
				this.bmp_y=attrs.getAttributeIntValue(i, 0);
				break;
			case txt_x:
				this.txt_x=attrs.getAttributeIntValue(i, 0);
				break;
			case txt_y:
				this.txt_y=attrs.getAttributeIntValue(i, 0);
				break;
			case txt_align:
				this.txt_align=attrs.getAttributeIntValue(i, 0);
				break;
			case text:
				this.text=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				break;
			case focus_txt_color:
				this.focus_txt_color=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				break;
			case unfocus_txt_color:
				this.unfocus_txt_color=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				break;
			case font:
				this.font=attrs.getAttributeIntValue(i, 0);
				break;
			case charset:
				this.charset=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				break;
			case bkcolor:
				this.bkcolor=YDResource.getInstance().getString(attrs.getAttributeValue(i));
				break;
			case alpha:
				this.alpha=attrs.getAttributeBooleanValue(i, true);
				break;
				
			case draw_sts:
				this.draw_sts=attrs.getAttributeIntValue(i, 0);
				break;
			case status:
				this.status=attrs.getAttributeIntValue(i, 0);
				break;
				
			default:
				break;
			}
    	}
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
