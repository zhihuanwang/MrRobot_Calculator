/*
 * ���ܣ������ֱ�д��MemoryButton�࣬��JButton�����࣬��Ҫ��������ʵ�ּ���洢���ܵİ�ť����MemoryButton
 * ȷ��MemoryButton��һЩ��������
 * I.�����ļ���"MC","MR","MS","M+"
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
		setForeground(Color.RED);//����������ɫΪ��ɫ
	}
	public String getMemory()
	{
	 
		return memory;
	 
	}
 
}
