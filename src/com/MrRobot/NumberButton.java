/*
 * ���ܣ��ò��ֱ�д��NumberButton�࣬��JButton�����࣬��Ҫ��������һЩ���ּ��İ�ť
 * �������ּ�Ϊ��ɫ����
 * I.�����ļ���"0","1","2","3","4","5",6","7","8","9".
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