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
		System.out.println("static H_WIN "+win.win_name+"_frmwin_create(H_WIN parent, H_LYR layer)");
		System.out.println("{");
		System.out.println("\tH_WIN h_win;");
		System.out.println("\teLIBs_memset(&para, 0, sizeof(__gui_framewincreate_para_t));");
		System.out.println("\tpara.dwStyle = "+win.win_dwStyle+";");
		System.out.println("\tpara.dwExStyle = "+win.win_dwExStyle+";");
		
		System.out.println("\tpara.name = "+win.win_name+";");
		System.out.println("\tpara.hOwner = NULL;");
		System.out.println("\tpara.hHosting = parent;");
		
		System.out.println("\tpara.FrameWinProc ="+win.win_callback+";");
		System.out.println("\tpara.id ="+win.win_id+";");
		System.out.println("\tpara.hLayer = layer;");
		System.out.println("\tpara.rect.x ="+win.win_left+";");
		System.out.println("\tpara.rect.y ="+win.win_top+";");
		System.out.println("\tpara.rect.width ="+(win.win_right-win.win_left)+";");
		System.out.println("\tpara.rect.heigh ="+(win.win_bottom-win.win_top)+";");
		
		long color = YDResource.getInstance().getIntColor(win.win_bkcolor);
		long alpha = (color&0xff000000)>>24;
		long red = (color&0x00ff0000)>>16;
		long green = (color &0x0000ff00)>>8;
		long blue= color&0x000000ff;
		System.out.println("\tpara.BkColor.alpha = "+alpha+";");
		System.out.println("\tpara.BkColor.red = "+red+";");
		System.out.println("\tpara.BkColor.green = "+green+";");
		System.out.println("\tpara.BkColor.blue = "+blue+";");
		System.out.println("\tpara.attr = NULL;");
		
		System.out.println("\th_win = GUI_FrmWinCreate(&para);");
		System.out.println("\tif( !h_win )");
		System.out.println("\t{");
		System.out.println("\t\t__err(\"volume frm win create error ! \\n\");");
		System.out.println("\t}");
		System.out.println("\treturn h_win;");
		System.out.println("}");
		System.out.println("");
		System.out.println("");
		
		
		StringBuffer code= new StringBuffer();
		code.append("static H_WIN "+win.win_name+"_frmwin_create(H_WIN parent, H_LYR layer)"+"\n");
		code.append("{"+"\n");
		code.append("\tH_WIN h_win;"+"\n");
		code.append("\teLIBs_memset(&para, 0, sizeof(__gui_framewincreate_para_t));"+"\n");
		code.append("\tpara.dwStyle = "+win.win_dwStyle+";"+"\n");
		code.append("\tpara.dwExStyle = "+win.win_dwExStyle+";"+"\n");
		
		code.append("\tpara.name = "+win.win_name+";"+"\n");
		code.append("\tpara.hOwner = NULL;"+"\n");
		code.append("\tpara.hHosting = parent;"+"\n");
		
		code.append("\tpara.FrameWinProc ="+win.win_callback+";"+"\n");
		code.append("\tpara.id ="+win.win_id+";"+"\n");
		code.append("\tpara.hLayer = layer;"+"\n");
		code.append("\tpara.rect.x ="+win.win_left+";"+"\n");
		code.append("\tpara.rect.y ="+win.win_top+";"+"\n");
		code.append("\tpara.rect.width ="+(win.win_right-win.win_left)+";"+"\n");
		code.append("\tpara.rect.heigh ="+(win.win_bottom-win.win_top)+";"+"\n");
		

		code.append("\tpara.BkColor.alpha = "+alpha+";"+"\n");
		code.append("\tpara.BkColor.red = "+red+";"+"\n");
		code.append("\tpara.BkColor.green = "+green+";"+"\n");
		code.append("\tpara.BkColor.blue = "+blue+";"+"\n");
		code.append("\tpara.attr = NULL;"+"\n");
		
		code.append("\th_win = GUI_FrmWinCreate(&para);"+"\n");
		code.append("\tif( !h_win )"+"\n");
		code.append("\t{"+"\n");
		code.append("\t\t__err(\"volume frm win create error ! \\n\");"+"\n");
		code.append("\t}"+"\n");
		code.append("\treturn h_win;"+"\n");
		code.append("}"+"\n");
		code.append(""+"\n");
		code.append(""+"\n");
		ps.print(code);
	}
}
