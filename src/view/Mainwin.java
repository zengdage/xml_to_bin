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

	}
	
	public void outMainWinCallBackCode(Basewin win, Basewin parent,PrintStream ps) {

		
	}
}
