/*
 * 功能：本部分编写了MemoryButton类，是JButton的子类，主要初步处理实现记忆存储功能的按钮，即MemoryButton
 * 确定MemoryButton的一些基本属性
 * I.包含的键有"MC","MR","MS","M+"
 */
package com.MrRobot;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MemoryButton extends JButton
{
	String memory;
	public MemoryButton(String s)
	{
		super(s);
		memory=s;
		setForeground(Color.RED);//设置字体颜色为红色
	}
	public String getMemory()
	{
	 
		return memory;
	 
	}
 
}
