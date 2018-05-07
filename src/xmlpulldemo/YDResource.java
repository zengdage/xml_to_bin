package xmlpulldemo;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;

import view.Basewin;


public class YDResource {
	
	private static final String TAG = "YDResource";
	//layout_xxx级标称�??
	private  SoftReference<HashMap<String,ParamValue>> wkMap;
	//字符串键值对
	private  SoftReference<HashMap<String,String>> wkstrings;
	//属�?�标称�??
	private  SoftReference<HashMap<String,ParamValue>> wkBasewinMap;
	//颜色键�?�对
	private  SoftReference<HashMap<String,String>> wkColorMap;
	//数�?�键值对
	private  SoftReference<HashMap<String,String>> wkDimenMap;
	//ID键�?�对
	private  SoftReference<HashMap<String,Basewin>> wkIdMap;
	//Basewin键�?�对
	private SoftReference<HashMap<Basewin,SoftReference<HashMap<String,Basewin>>>> wkBasewinIDMap;
	
	public SoftReference<HashMap<String,String>> wkDrawableHMap;
	public SoftReference<HashMap<String,String>> wkDrawableMMap;
	public SoftReference<HashMap<String,String>> wkDrawableLMap;
	public SoftReference<HashMap<String,String>> wkDrawableXHMap,wkDrawableXXHMap,wkDrawableMap,wkDrawableXXXHMap;
	private HashMap<String, Integer> idMap;
	public static String rootpath="";
	public String vga="drawable-hdpi";
	public static boolean assetsFlag=true;
	private YDResource(){}
	private static YDResource resource=new YDResource();

	public static YDResource getInstance(){
		return resource;
	}
	/**
	 * 初始化资源根路径 
	 * @param mContext 上下�?
	 * @param path 路径
	 */
	public void initResourcePath(String path){		
		if(path.equals("")||path==null){
			//data/data/packageName/files/res
			rootpath="res";
			assetsFlag=true;
		}else{
			rootpath=path;
			assetsFlag=false;
		}
	}
	
	public int getIDWithString(String key){
		if(idMap==null){
			idMap=new HashMap<String, Integer>();
		}
		Integer id=idMap.get(key);
		if(idMap.get(key)==null){
			return -1;
		}
		return id.intValue();
	}
	
	public boolean setIDWithString(String key,int id){
		if(idMap==null){
			idMap=new HashMap<String, Integer>();
		}
		if(idMap.get(key)==null){
		   idMap.put(key,Integer.valueOf(id));
		   return true;
		}else{
		   return false;
		}
	}
	
	public void setBasewinIDMap(Basewin v,SoftReference<HashMap<String,Basewin>> Map){
		HashMap<Basewin,SoftReference<HashMap<String, Basewin>>> map;
		if(wkBasewinIDMap==null||wkBasewinIDMap.get()==null){
			map=new HashMap<Basewin,SoftReference<HashMap<String, Basewin>>>();
		}else{
			map=wkBasewinIDMap.get();
		}
		map.put(v, Map);
		wkBasewinIDMap=new SoftReference<HashMap<Basewin,SoftReference<HashMap<String,Basewin>>>>(map);
	}
	
	public SoftReference<HashMap<String,Basewin>> getIDMap(Basewin v){
		HashMap<Basewin,SoftReference<HashMap<String, Basewin>>> map;
		if(wkBasewinIDMap==null||wkBasewinIDMap.get()==null){
			return null;
		}else{
			map=wkBasewinIDMap.get();
			return map.get(v);
		}
	}
	
	public void setBasewinId(String s,Basewin v){
		HashMap<String, Basewin> map;
		if(wkIdMap==null||wkIdMap.get()==null){
			map=new HashMap<String, Basewin>();
		}else{
			map=wkIdMap.get();
		}
		map.put(s, v);
		wkIdMap=new SoftReference<HashMap<String,Basewin>>(map);
	}

	public Basewin getBasewinByID(String s,SoftReference<HashMap<String,Basewin>> wkIdMap){
		HashMap<String, Basewin> map;
		if(wkIdMap==null||wkIdMap.get()==null){
			return null;
		}else{
			map=wkIdMap.get();
			return map.get(s);
		}
	}
	/**
	 * 获取布局标称�?
	 * @return 
	 */
	/*
	public  HashMap getLayoutMap(){
		if(wkMap==null||wkMap.get()==null){
			HashMap<String,ParamValue> map=new HashMap<String, ParamValue>();
			map.put("layout_width", ParamValue.layout_width);
			map.put("layout_height", ParamValue.layout_height);
			map.put("orientation", ParamValue.orientation);
			map.put("layout_centerHorizontal", ParamValue.layout_centerHorizontal);
			map.put("layout_centerVertical", ParamValue.layout_centerVertical);
			map.put("layout_marginLeft", ParamValue.layout_marginLeft);
			map.put("layout_marginRight", ParamValue.layout_marginRight);
			map.put("layout_margin", ParamValue.layout_margin);
			map.put("layout_gravity", ParamValue.layout_gravity);
			map.put("layout_alignParentRight", ParamValue.layout_alignParentRight);
			map.put("layout_weight", ParamValue.layout_weight);
			wkMap=new SoftReference<HashMap<String,ParamValue>>(map);
		}
		return wkMap.get();
	}
	*/
	/**
	 * 获取属�?�标称�??
	 * @return
	 */
	public  HashMap<String,ParamValue> getBasewinMap(){
		if(wkBasewinMap==null || wkBasewinMap.get()==null){
			HashMap<String,ParamValue> map=new HashMap<String, ParamValue>();
			map.put("app_name",ParamValue.app_name);
			
			map.put("win_id", ParamValue.win_id);
			map.put("win_name", ParamValue.win_name);
			map.put("win_DataType",ParamValue.win_DataType);
			map.put("win_WinType", ParamValue.win_WinType);
			map.put("win_dwStyle", ParamValue.win_dwStyle);
			map.put("win_dwExStyle",ParamValue.win_dwExStyle);
			
			map.put("lyr_type", ParamValue.lyr_type);
			map.put("lyr_status", ParamValue.lyr_status);
			map.put("lyr_intersts", ParamValue.lyr_intersts);
			map.put("lyr_clip_left", ParamValue.lyr_clip_left);
			map.put("lyr_clip_right", ParamValue.lyr_clip_right);			
			map.put("lyr_clip_top", ParamValue.lyr_clip_top);
			map.put("lyr_clip_boottom",ParamValue.lyr_clip_boottom);
			map.put("lyr_zordeer",ParamValue.lyr_zordeer);
			
			map.put("win_left", ParamValue.win_left);
			map.put("win_top", ParamValue.win_top);
			map.put("win_right",ParamValue.win_right);
			map.put("win_bottom", ParamValue.win_bottom);
			map.put("win_client_left", ParamValue.win_client_left);
			map.put("win_client_top",ParamValue.win_client_top);
			map.put("win_client_right", ParamValue.win_client_right);
			map.put("win_client_bottom", ParamValue.win_client_bottom);
			map.put("win_bkcolor",ParamValue.win_bkcolor);
			map.put("win_font", ParamValue.win_font);
			
			map.put("win_invalid_left", ParamValue.win_invalid_left);
			map.put("win_invalid_right",ParamValue.win_invalid_right);
			map.put("win_invalid_top", ParamValue.win_invalid_top);
			map.put("win_invalid_bottom",ParamValue.win_invalid_bottom);
			map.put("win_clip_left", ParamValue.win_clip_left);
			map.put("win_clip_right",ParamValue.win_clip_right);
			map.put("win_clip_top", ParamValue.win_clip_top);
			map.put("win_clip_boottom",ParamValue.win_clip_boottom);
			map.put("win_zordeer",ParamValue.win_zordeer);
			
			map.put("win_callback", ParamValue.win_callback);
			map.put("notify_proc",ParamValue.notify_proc);
			map.put("win_vscroll_minPos", ParamValue.win_vscroll_minPos);
			map.put("win_vscroll_maxPos",ParamValue.win_vscroll_maxPos);
			map.put("win_vscroll_curPos", ParamValue.win_vscroll_curPos);
			map.put("win_vscroll_pageStep",ParamValue.win_vscroll_pageStep);
			map.put("win_vscroll_barStart", ParamValue.win_vscroll_barStart);
			map.put("win_vscroll_barLen",ParamValue.win_vscroll_barLen);
			map.put("win_vscroll_status",ParamValue.win_vscroll_status);
			
			map.put("win_hscroll_minPos", ParamValue.win_hscroll_minPos);
			map.put("win_hscroll_maxPos",ParamValue.win_hscroll_maxPos);
			map.put("win_hscroll_curPos", ParamValue.win_hscroll_curPos);
			map.put("win_hscroll_pageStep",ParamValue.win_hscroll_pageStep);
			map.put("win_hscroll_barStart", ParamValue.win_hscroll_barStart);
			map.put("win_hscroll_barLen",ParamValue.win_hscroll_barLen);
			map.put("win_hscroll_status",ParamValue.win_hscroll_status);
		
			map.put("focus_bmp", ParamValue.focus_bmp);
			map.put("unfocus_bmp",ParamValue.unfocus_bmp);
			map.put("bmp_x", ParamValue.bmp_x);
			map.put("bmp_y",ParamValue.bmp_y);
			map.put("txt_x", ParamValue.txt_x);
			map.put("txt_y",ParamValue.txt_y);
			map.put("txt_align", ParamValue.txt_align);
			map.put("text",ParamValue.text);
			map.put("focus_txt_color",ParamValue.focus_txt_color);
			
			map.put("unfocus_txt_color", ParamValue.unfocus_txt_color);
			map.put("font",ParamValue.font);
			map.put("charset", ParamValue.charset);
			map.put("bkcolor",ParamValue.bkcolor);
			map.put("alpha", ParamValue.alpha);
			map.put("draw_sts",ParamValue.draw_sts);
			map.put("status",ParamValue.status);
			
			map.put("win_spCaption",ParamValue.win_spCaption);
			map.put("win_spClassName",ParamValue.win_spClassName);
			
			map.put("bmp_num",ParamValue.bmp_num);
			map.put("bmp_array",ParamValue.bmp_array);
			
			map.put("pos_num",ParamValue.pos_num);
			map.put("pos_array",ParamValue.pos_array);
			
			wkBasewinMap=new SoftReference<HashMap<String,ParamValue>>(map);

		}
		return wkBasewinMap.get();
	}
	
	public int getAttributeIntValue() {
		return 0;
	}
	
	/**
	 * 得到结果�?律转化为px
	 * @param str
	 * @return
	 */
	/*
	public int getDimen(String str){
		if(str.startsWith("@dimen/")){
			if(wkDimenMap==null || wkDimenMap.get()==null){
				wkDimenMap=new SoftReference<HashMap<String,String>>(ReadXmlUtils.readDimensXml(mContext));
			}
			str=str.substring(7);
			str=wkDimenMap.get().get(str);
		}
		return calculateRealSize(str);
	}
	*/

	/**
	 * 由字符串获取得颜�?
	 * @param val �?"#ffffff或�?�@color/white"
	 * @return  颜色代表的十六进制数�?
	 */
	public long getIntColor(String val){
		/*
		if(val.startsWith("@color/")){
			if(wkColorMap==null || wkColorMap.get()==null){
				wkColorMap=new SoftReference<HashMap<String,String>>(ReadXmlUtils.readColorsXml(mContext));
			}
			val=val.substring(7);
			val=wkColorMap.get().get(val);
		}
		*/
		if(val == null ||"".equals(val)) {
			
		}else {
			if(val.startsWith("#")){
				int length = val.length();
				if(length==7){
					long j=Long.decode(val.replace("#", "#FF"));
					return (long) j;
				}else if(length==9){
					long j=Long.decode(val);
					return (long) j;
				}else{
					return 0xFFffffffL;
				}
			}
		}
		return 0xFF000000L;
	}
	/*
	public int calculateTextSize(String s){
		return DimenUtil.calculateTextSize(s, mContext);
	}
	
	public  int calculateRealSize(String s){
		return DimenUtil.calculateRealSize(s, mContext);
	}
	
	public  int getInputType(String inputType){
		return AttrsUtil.getInputType(inputType);
	}
	
	public ScaleType getScaleType(String scaleType){
		return AttrsUtil.getScaleType(scaleType);
	}
		
	public  int getGravity(String gravity){
		return AttrsUtil.getGravity(gravity);
	}
	
	public  int getIdentifier(String tid){
		return AttrsUtil.getIdentifier(tid);
	}
	
	public String getID(String s){
		return IDUtils.getID(s);
	}
	
	public int getStringHashCode(String s){
		return s.hashCode();
	}
	*/
	/**
	 * 从values中获取到strings
	 * @param s
	 * @return
	 */

	public  String getString(String s){
		if(!s.startsWith("@string/")){
			return s;
		}
		return null;
		/*
		if(wkstrings==null || wkstrings.get()==null){
			wkstrings=new SoftReference<HashMap<String,String>>(ReadXmlUtils.readStringsXml(mContext));
		}
		s=s.substring(8);
		return wkstrings.get().get(s);
		*/
	}

	
	/**
	 * 初始�?,获得strings.xml,colors.xml,dimens.xml,drawable系列文件夹下面的键�?�对
	 * @param context
	 */
	/*
	public void initValues(Context context){
		if(wkstrings==null || wkstrings.get()==null){
			wkstrings=new SoftReference<HashMap<String,String>>(ReadXmlUtils.readStringsXml(context));
		}
		if(wkColorMap==null || wkColorMap.get()==null){
			wkColorMap=new SoftReference<HashMap<String,String>>(ReadXmlUtils.readColorsXml(context));
		}
		if(wkDimenMap==null || wkDimenMap.get()==null){
			wkDimenMap=new SoftReference<HashMap<String,String>>(ReadXmlUtils.readDimensXml(context));
		}
		DrawableUtils.getDrawableMap(context);
	}
	*/
	
	/**
	 * 获取布局Basewin�?
	 * @param str 要解析的xml文件�?
	 * @return 得到组成Basewin�?
	 * @throws Exception 
	 */
	/*
	public Basewin getLayout(String str) {
		//第一次均为空
		//initValues(mContext);
		YDLayoutInflate inflate=new YDLayoutInflate(mContext);
		StringBuilder sb=new StringBuilder();
		//File.separator即是/符号
		//获得要解析的xml文件绝对路径
		sb.append(rootpath).append(File.separator).append("layout").append(File.separator).append(str);
		if(Logger.debug){
		   Logger.i(sb.toString());
		}
		return inflate.inflate(sb.toString(), null);
	}
	*/
}
