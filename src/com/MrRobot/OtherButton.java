/*
 * 功能：OtherButton也可以归为功能键的范畴,有清除的功能键、开二次平方根、求百分率、
 * 求一个数的倒数、或求一个数的相反数等
 * I.包含的键有"Backspace","CE","C","sqr","%","1/x","+/-",".","="
 */
package com.MrRobot;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class OtherButton extends JButton
{
 
	String other;
	public OtherButton(String s)
	{
	 
		super(s);
		other=s;
	 
	}
	public String getOther()
	{
		return other;
	}
 
}