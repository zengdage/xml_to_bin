package view;

import java.io.File;
import java.io.PrintStream;

import xmlpulldemo.AttributeSet;

public abstract class Win {

	public String win_id;
	public String win_name;
	public int win_DataType;
	public int win_WinType;
	public int win_dwStyle;
	public int win_dwExStyle;
	
	public int lyr_type;
	public int lyr_status;
	public int lyr_intersts;
	public int lyr_clip_left;
	public int lyr_clip_right;
	public int lyr_clip_top;
	public int lyr_clip_boottom;
	public int lyr_zordeer;
	
	public int win_left;
	public int win_top;
	public int win_right;
	public int win_bottom;
	
	public int win_client_left;
	public int win_client_top;
	public int win_client_right;
	public int win_client_bottom;
	
	public String win_bkcolor;
	public int win_font;
	
	public int win_invalid_left;
	public int win_invalid_right;
	public int win_invalid_top;
	public int win_invalid_bottom;
	
	public int win_clip_left;
	public int win_clip_right;
	public int win_clip_top;
	public int win_clip_boottom;
	
	public int win_zordeer;
	
	public String win_callback;
	public String notify_proc;
	public int win_vscroll_minPos;
	public int win_vscroll_maxPos;
	public int win_vscroll_curPos;
	public int win_vscroll_pageStep;
	public int win_vscroll_barStart;
	public int win_vscroll_barLen;
	public int win_vscroll_status;
	
	public int win_hscroll_minPos;
	public int win_hscroll_maxPos;
	public int win_hscroll_curPos;
	public int win_hscroll_pageStep;
	public int win_hscroll_barStart;
	public int win_hscroll_barLen;
	public int win_hscroll_status;
	
	public String win_spCaption;
	public String spClassName;
	
	//for some wins
	public String focus_bmp;
	public String unfocus_bmp;
	public int bmp_x;
	public int bmp_y;
	public int txt_x;
	public int txt_y;
	public int txt_align;
	public String text;
	public String focus_txt_color;
	public String unfocus_txt_color;
	public int font;
	public String charset;
	public String bkcolor;
	public boolean alpha;
	
	public int draw_sts;
	public int status;
	
	public abstract void setAttributeSet(AttributeSet attrs) ;
	public abstract void outCode(Basewin win, Basewin parent, File file,PrintStream ps) ;
	
}

