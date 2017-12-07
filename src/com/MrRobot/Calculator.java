package com.MrRobot;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
 
class Calculator extends JFrame implements ActionListener
{
	//定义组件
	private NumberButton numberButton[];
	private OperateButton operateButton[];
	private MemoryButton memoryButton[];
	private OtherButton otherButton[];
	private JTextField memoryText;
	private JTextField Display;
	private Toolkit tool;
	static Dimension dim;
	String []operate={"/","*","-","+"};
	String []memory={"MC","MR","MS","M+"};
	String []other={"Backspace","CE","C","sqr","%","1/x","+/-",".","="};
	int numberFlag=1;
	String op="";
	int operateFlag=1;
	int operateStart=1;
	int pointFlag=1;
	double m=0;
	boolean point=false;
	int CEFlag=0;
	double result=0;
	Double memoryStore=new Double(0);
//========================构造函数=========================================
public Calculator() 
{
 
	super("MrRobot's计算器");
	setSize(350, 255);
	tool=Toolkit.getDefaultToolkit();
	dim=tool.getScreenSize();//得到电脑屏幕大小
	int screenWidth=dim.width;
	int screenHeight=dim.height;
	int frameWidth=getWidth();//得到计算器的宽
	int frameHeight=getHeight();//得到计算器的高
	setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
	//使计算器处于电脑屏幕中部
	
//====================异常处理=========================================
try
{
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
 
}
catch(UnsupportedLookAndFeelException exc)
{
 
	System.err.println(exc.getMessage());
 
}
catch(Exception exc)
{
	System.err.println(exc.getMessage());
 
}
Container cp=getContentPane();
cp.setLayout(null);
//=============================================================
Display =new JTextField();
cp.add(Display);
Display.setSize(325,30);
Display.setLocation(10,5);
Display.setEditable(false);
Display.setText("0.");
Display.setHorizontalAlignment(JTextField.RIGHT);
//使显示数字在我们的右边，也就是电脑的左边
Display.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
Display.setBorder(new LineBorder(Color.blue));
//=============================================================
memoryText=new JTextField();
cp.add(memoryText);
memoryText.setSize(35,28);
memoryText.setLocation(12,45);
memoryText.setEditable(false);
memoryText.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
//=============================================================
numberButton=new NumberButton[10];
for(int i=0;i<=9;i++)
{
 
	numberButton[i]=new NumberButton(i);
	numberButton[i].setSize(50,30);
	cp.add(numberButton[i]);
	numberButton[i].addActionListener(this);
 
}
operateButton=new OperateButton[4];
for(int i=0;i<4;i++)
{
 
	operateButton[i]=new OperateButton(operate[i]);
	operateButton[i].setSize(50,30);
	cp.add(operateButton[i]);
	operateButton[i].addActionListener(this);
 
}
memoryButton=new MemoryButton[4];
for(int i=0;i<4;i++)
{
 
	memoryButton[i]=new MemoryButton(memory[i]);
	memoryButton[i].setSize(50,30);
	cp.add(memoryButton[i]);
	memoryButton[i].setLocation(10,80+35*i);
	memoryButton[i].addActionListener(this);
 
}
otherButton=new OtherButton[9];
for(int i=0;i<3;i++)
{
 
	otherButton[i]=new OtherButton(other[i]);
	otherButton[i].setSize(87,30);
	otherButton[i].setLocation(65+92*i,45);
	otherButton[i].setForeground(Color.red);
	cp.add(otherButton[i]);
	otherButton[i].addActionListener(this);
 
}
for(int i=3;i<9;i++)
{
 
	otherButton[i]=new OtherButton(other[i]);
	otherButton[i].setSize(50,30);
	otherButton[i].setForeground(Color.blue);
	cp.add(otherButton[i]);
	otherButton[i].addActionListener(this);
 
}
//====================定义按钮位置=========================================
numberButton[7].setLocation(65,80);
numberButton[8].setLocation(120,80);
numberButton[9].setLocation(175,80);
operateButton[0].setLocation(230,80);
otherButton[3].setLocation(285,80);
//=============================================================
numberButton[4].setLocation(65,115);
numberButton[5].setLocation(120,115);
numberButton[6].setLocation(175,115);
operateButton[1].setLocation(230,115);
otherButton[4].setLocation(285,115);
//=============================================================
numberButton[1].setLocation(65,150);
numberButton[2].setLocation(120,150);
numberButton[3].setLocation(175,150);
operateButton[2].setLocation(230,150);
otherButton[5].setLocation(285,150);
//=============================================================
numberButton[0].setLocation(65,185);
otherButton[6].setLocation(120,185);
otherButton[7].setLocation(175,185);
operateButton[3].setLocation(230,185);
otherButton[8].setForeground(Color.red);
otherButton[8].setLocation(285,185);
addWindowListener(new WindowAdapter() //窗体事件监听
{
 
	public void windowClosing(WindowEvent e) 
	{
 
		dispose();
		System.exit(0);
 
	}
 
});
setVisible(true);
setResizable(false);//限制计算器窗体大小，默认为限制大小不允许改变窗体大小
this.setIconImage((new ImageIcon("images/github.jpg")).getImage());//设置窗体图标
 
}
//===============事件处理块====================================================
public void actionPerformed(ActionEvent e)
{
 
String s=e.getActionCommand().trim();
if(e.getSource() instanceof NumberButton)
{
 
	String temp="";
	if(numberFlag==1)
	{
	 
		temp=s;
		numberFlag=0;
	 
	}else if(numberFlag==0)
	{
	 
		int length=Display.getText().length();
		if(length<=32)
		{
		 
			temp=Display.getText()+s;
		 
		}
	else
	return;
	 
	}
	operateFlag=1;
	pointFlag=0;
	Display.setText(temp);
	 
}
else if(e.getSource() instanceof OperateButton)
{
 
	if(operateStart==1)
	{
	 
		result=Double.parseDouble(Display.getText());
		op=s;
 
	}else if(operateStart==0)
	{
	 
		if(operateFlag==1)
		{
		 
			double x=Double.parseDouble(Display.getText());
			calculate(x);
			op=s;
		 
		}else if(operateFlag==0)
		{
	 
			double x=Double.parseDouble(Display.getText());
			op=s;
	 
		}
	 
	}
	m=Double.parseDouble(Display.getText());
	operateFlag=0;
	numberFlag=1;
	pointFlag=1;
	point=false;
	operateStart=0;
	return;
 
}
else if(e.getSource() instanceof MemoryButton)
{
 
	numberFlag=1;
	pointFlag=1;
	point=false;
	operateStart=1;
	if("MC".equals(s))
	{
	 
		memoryText.setText("");
		memoryStore = new Double(0);
		return;
	 
	}
	else if("MR".equals(s))
	{
	 
		Display.setText(memoryStore.toString());
		return;
	 
	}
	else if("MS".equals(s))
	{
		
		memoryText.setText("M");
		memoryText.setHorizontalAlignment(JTextField.CENTER);
		memoryStore=Double.valueOf(Display.getText());
		return;
	 
	}
	else if("M+".equals(s))
	{
	 
		memoryStore = new Double(memoryStore.doubleValue()
		      + Double.parseDouble(Display.getText()));
		    return;
	 
	}
 
}
else if(e.getSource() instanceof OtherButton)
{
 
 
if("Backspace".equals(s))
{
 
	int length=Display.getText().length();
	if(operateStart==0)
	{
	 
		if(length>1)
		{
		 
			if(Display.getText().equals("0."))
					{
			 
						numberFlag=1;
						return;
			 
					}else{
			 
							Display.setText(Display.getText().substring(0,length-1));
							numberFlag=0;
							return;
			 
						  }
		 
		}
		else{
		  
			Display.setText("0.");
			numberFlag=1;
		 
		}
		 
	}
	else
	return;
 
}
else if("CE".equals(s))
{
 
	CEFlag=0;
	Display.setText("0.");
	numberFlag=1;
	pointFlag=1;
	point=false;
	operateFlag=1;
	operateStart=1;
	return;
 
}
else if("C".equals(s)){
 
	Display.setText("0.");
	numberFlag=1;
	pointFlag=1;
	point=false;
	operateFlag=1;
	operateStart=1;
	result=0.0;
	return;
 
}
else if("sqr".equals(s)){             //开二次根号的实现
 
Display.setText(new Double(Math.sqrt(Double.parseDouble(Display.getText()))).toString());
numberFlag=1;
pointFlag=1;
point=false;
operateFlag=1;
operateStart=1;
return;
 
}
else if("%".equals(s)){               //求百分率的实现
 
Display.setText(new Double(Double.parseDouble(Display.getText()) / 100.0).toString());
numberFlag=1;
pointFlag=1;
point=false;
operateFlag=1;
operateStart=1;
return;
 
}
else if("1/x".equals(s)){                    //求倒数的实现
 
Display.setText(new Double(1.0/Double.parseDouble(Display.getText())).toString());
numberFlag=1;
pointFlag=1;
point=false;
operateFlag=1;
operateStart=1;
return;
 
}
else if("+/-".equals(s)){                  //求相反数的实现
 
if(operateFlag==1){
 
Display.setText(new Double(0.0 - Double.parseDouble(Display.getText())).toString());
if(operateStart==1)
numberFlag=0;
else {
 
numberFlag=1;
 
}
 
}
else
Display.setText("0.");
while(!point)
point=true;
return;
 
}
else if(".".equals(s)){
 
while(!point){
 
if(pointFlag==1){
 
Display.setText("0.");
 
}
else if(pointFlag==0)
Display.setText(Display.getText()+".");
numberFlag=0;
point=true;
 
}
return;
 
}
else if("=".equals(s)){
 
if(operateFlag==0){
 
calculate(m);
Display.setText(""+result);
 
}
else{
 
double x=Double.parseDouble(Display.getText());
if(operateStart==0){
 
calculate(x);
Display.setText(""+result);
 
}
else
result=x;
Display.setText(""+result);
operateFlag=1;
 
}
point=false;
pointFlag=1;
operateStart=1;
numberFlag=1;
 
}
 
}
 
}
public void calculate(double n)             //加减乘除混合运算的实现
{
 
	if(op.equals("/"))
	result/=n;
	else if(op.equals("*"))
	result*=n;
	else if(op.equals("-"))
	result-=n;
	else if(op.equals("+"))
	result+=n;
	Display.setText(""+result);
 
}
public static void main(String args[]) 
{
	new Calculator();
 
}
 
}