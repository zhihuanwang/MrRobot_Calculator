/*
 * ���ܣ��ò��ֱ�д��OperateButton�࣬Ҳ�̳���JButton�࣬��Ҫ��OperateButton��Ĺ��캯��
 * ��һЩ�����ĳ�Ա���������⣬���ò�������������ɫΪ��ɫ
 * I.�����ļ���"/","*","-","+"
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