/*
 * 功能：该部分编写了OperateButton类，也继承了JButton类，主要是OperateButton类的构造函数
 * 和一些基本的成员方法，另外，设置操作键的字体颜色为红色
 * I.包含的键有"/","*","-","+"
 */
package com.MrRobot;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class OperateButton extends JButton
{
 
	String operate;
	public OperateButton(String op)
	{
	 
		super(op);
		operate=op;
		setForeground(Color.red);
	 
	}
	public String getOperate()
	{
	 
		return operate;
	 
	}
 
}