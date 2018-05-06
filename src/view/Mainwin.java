package view;

import java.io.File;
import java.io.PrintStream;

import constant.Constant;
import xmlpulldemo.AttributeSet;

public class Mainwin extends Basewin{

	public Mainwin(AttributeSet attrs) {
		super(attrs);
	}
	
	@Override
	public void setAttributeSet(AttributeSet attrs){	
		super.setAttributeSet(attrs);
		viewTableItem.setType(Constant.TypeMainwin);
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
		System.out.println("H_WIN "+App.app_name+"_mainwin_create(void)");
		System.out.println("{");
		System.out.println("\tH_WIN hManWin;");
		System.out.println("\t__gui_manwincreate_para_t create_info;");
		System.out.println("\teLIBs_memset(&create_info, 0, sizeof(__gui_manwincreate_para_t));");
		System.out.println("\tcreate_info.attr = NULL;");
		System.out.println("\tcreate_info.hParent = NULL;");
		System.out.println("\tcreate_info.hHosting = NULL");
		System.out.println("\tcreate_info.ManWindowProc = "+ win.win_callback+";");
		System.out.println("\tcreate_info.name = "+ "\""+App.app_name+"\""+";");		
		System.out.println("\thManWin = GUI_ManWinCreate(&create_info);");
		System.out.println("\tif(hManWin == NULL)");
		System.out.println("\t{");
		System.out.println("\t\t__wrn(\"TouchMain: create main windows failed!\\n\");");
		System.out.println("\t\treturn NULL;");
		System.out.println("\t}");
		System.out.println("\treturn hManWin;");
		System.out.println("}");
		System.out.println("");
		System.out.println("");
		
		StringBuffer code = new StringBuffer();
		code.append("H_WIN "+App.app_name+"_mainwin_create(void)"+"\n");
		code.append("{"+"\n");
		code.append("\tH_WIN hManWin;"+"\n");
		code.append("\t__gui_manwincreate_para_t create_info;"+"\n");
		code.append("\teLIBs_memset(&create_info, 0, sizeof(__gui_manwincreate_para_t));"+"\n");
		code.append("\tcreate_info.attr = NULL;"+"\n");
		code.append("\tcreate_info.hParent = NULL;"+"\n");
		code.append("\tcreate_info.hHosting = NULL"+"\n");
		code.append("\tcreate_info.ManWindowProc = "+ win.win_callback+";"+"\n");
		code.append("\tcreate_info.name = "+ "\""+App.app_name+"\""+";"+"\n");		
		code.append("\thManWin = GUI_ManWinCreate(&create_info);"+"\n");
		code.append("\tif(hManWin == NULL)"+"\n");
		code.append("\t{"+"\n");
		code.append("\t\t__wrn(\"TouchMain: create main windows failed!\\n\");"+"\n");
		code.append("\t\treturn NULL;"+"\n");
		code.append("\t}"+"\n");
		code.append("\treturn hManWin;"+"\n");
		code.append("}"+"\n");
		code.append(""+"\n");
		code.append(""+"\n");
		ps.print(code);
	}
	
	public void outMainWinCallBackCode(Basewin win, Basewin parent,PrintStream ps) {
		System.out.println("static __s32 "+win.win_callback+"(__gui_msg_t *msg)");
		System.out.println("{");
		System.out.println("\t__s32 ret;");
		System.out.println("\tswitch( msg->id )");
		System.out.println("\t{");
		System.out.println("\t\tcase GUI_MSG_CREATE: /* 创建子窗口*/");
		System.out.println("\t\t\tlayer = htouch_layer_create(); /* 创建图层*/");
		System.out.println("\t\t\tGUI_LyrWinSetTop(layer); /* 图层置顶*/");
		System.out.println("\t\t\thtouch_frmwin_create(msg->h_deswin, layer); /* 创建 framewin*/");
		System.out.println("\t\t\treturn EPDK_OK;");
		
		System.out.println("\t\tcase GUI_MSG_DESTROY:");
		System.out.println("\t\t\tGUI_LyrWinDelete(layer);");
		System.out.println("\t\t\treturn EPDK_OK;");
		
		System.out.println("\t\tcase DSK_MSG_HOME: /* 回到主界面 */");
		System.out.println("\t\tcase DSK_MSG_KILL: /* 强制杀掉该应用程序 */");
		System.out.println("\t\t\tret = GUI_ManWinDelete(msg->h_deswin);");
		System.out.println("\t\t\treturn ret;");
		
		System.out.println("\t\tcase GUI_MSG_CLOSE:");
		System.out.println("\t\t\tGUI_ManWinDelete(msg->h_deswin);");
		System.out.println("\t\t\tdsk_load_app(\"main.app\"); /* 回到主界面 */");
		System.out.println("\t\t\treturn EPDK_OK;");
		
		System.out.println("\t\tcase GUI_MSG_KEY: /* 按键响应 */");
		System.out.println("\t\t\tif( msg->dwAddData1 == GUI_MSG_KEY_ESCAPE )");
		System.out.println("\t\t\t{");
		System.out.println("\t\t\t\tGUI_ManWinDelete(msg->h_deswin);");
		System.out.println("\t\t\t\tdsk_load_app(\"main.app\"); /* 回到主界面 */");
		System.out.println("\t\t\t\treturn EPDK_OK;");
		System.out.println("\t\t\t}");
		System.out.println("\t\t\tbreak;");
		
		System.out.println("\t\tdefault:");
		System.out.println("\t\t\tbreak;");
		
		System.out.println("\t}");
		System.out.println("\treturn GUI_ManWinDefaultProc(msg);");
		System.out.println("}");
		System.out.println("");
		System.out.println("");
		
		
		StringBuffer code = new StringBuffer();
		
		code.append("static __s32 "+win.win_callback+"(__gui_msg_t *msg)"+"\n");
		code.append("{"+"\n");
		code.append("\t__s32 ret;"+"\n");
		code.append("\tswitch( msg->id )"+"\n");
		code.append("\t{"+"\n");
		code.append("\t\tcase GUI_MSG_CREATE: /* 创建子窗口*/"+"\n");
		code.append("\t\t\tlayer = htouch_layer_create(); /* 创建图层*/"+"\n");
		code.append("\t\t\tGUI_LyrWinSetTop(layer); /* 图层置顶*/"+"\n");
		code.append("\t\t\thtouch_frmwin_create(msg->h_deswin, layer); /* 创建 framewin*/"+"\n");
		code.append("\t\t\treturn EPDK_OK;"+"\n");
		
		code.append("\t\tcase GUI_MSG_DESTROY:"+"\n");
		code.append("\t\t\tGUI_LyrWinDelete(layer);"+"\n");
		code.append("\t\t\treturn EPDK_OK;"+"\n");
		
		code.append("\t\tcase DSK_MSG_HOME: /* 回到主界面 */"+"\n");
		code.append("\t\tcase DSK_MSG_KILL: /* 强制杀掉该应用程序 */"+"\n");
		code.append("\t\t\tret = GUI_ManWinDelete(msg->h_deswin);"+"\n");
		code.append("\t\t\treturn ret;"+"\n");
		
		code.append("\t\tcase GUI_MSG_CLOSE:"+"\n");
		code.append("\t\t\tGUI_ManWinDelete(msg->h_deswin);"+"\n");
		code.append("\t\t\tdsk_load_app(\"main.app\"); /* 回到主界面 */"+"\n");
		code.append("\t\t\treturn EPDK_OK;"+"\n");
		
		code.append("\t\tcase GUI_MSG_KEY: /* 按键响应 */"+"\n");
		code.append("\t\t\tif( msg->dwAddData1 == GUI_MSG_KEY_ESCAPE )"+"\n");
		code.append("\t\t\t{"+"\n");
		code.append("\t\t\t\tGUI_ManWinDelete(msg->h_deswin);"+"\n");
		code.append("\t\t\t\tdsk_load_app(\"main.app\"); /* 回到主界面 */"+"\n");
		code.append("\t\t\t\treturn EPDK_OK;"+"\n");
		code.append("\t\t\t}"+"\n");
		code.append("\t\t\tbreak;"+"\n");
		
		code.append("\t\tdefault:"+"\n");
		code.append("\t\t\tbreak;"+"\n");
		
		code.append("\t}"+"\n");
		code.append("\treturn GUI_ManWinDefaultProc(msg);"+"\n");
		code.append("}"+"\n");
		code.append(""+"\n");
		code.append(""+"\n");
		ps.print(code);
		
	}
}
