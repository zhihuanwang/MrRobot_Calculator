/*
 * ���ܣ�OtherButtonҲ���Թ�Ϊ���ܼ��ķ���,������Ĺ��ܼ���������ƽ��������ٷ��ʡ�
 * ��һ�����ĵ���������һ�������෴����
 * I.�����ļ���"Backspace","CE","C","sqr","%","1/x","+/-",".","="
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