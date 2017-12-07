/*
 * 功能：该部分编写了NumberButton类，是JButton的子类，主要初步处理一些数字键的按钮
 * 设置数字键为蓝色字体
 * I.包含的键有"0","1","2","3","4","5",6","7","8","9".
 */
package com.MrRobot;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class NumberButton extends JButton
{
 
	int number;
	public NumberButton(int number)
	{
		super(""+number);
		this.number=number;
		setForeground(Color.blue);
	}
	public int getNumber()
	{
		return number;
	 
	}
 
}