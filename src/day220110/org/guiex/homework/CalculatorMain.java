package day220110.org.guiex.homework;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;

import day220110.org.guiex.myframe.Myframe;

class Calculator extends Myframe{
	MenuBar mb = new MenuBar();
	Menu view = new Menu("View");
	Menu edit = new Menu("Edit");
	Menu help = new Menu("Help");
	public Button btnMC = new Button("MC");
	public Button btnMR = new Button("MR");
	public Button btnMS = new Button("MS");
	public Button btnMp = new Button("M+");
	public Button btnMm = new Button("M-");
	public Button btnBS = new Button("<-");
	public Button btnCE = new Button("CE");
	public Button btnC = new Button("C");
	public Button btnPM = new Button("±");
	public Button btnRT = new Button("√");
	public Button btn1 = new Button("1");
	public Button btn2 = new Button("2");
	public Button btn3 = new Button("3");
	public Button btn4 = new Button("4");
	public Button btn5 = new Button("5");
	public Button btn6 = new Button("6");
	public Button btn7 = new Button("7");
	public Button btn8 = new Button("8");
	public Button btn9 = new Button("9");
	public Button btn0 = new Button("0");
	public Button btnDot = new Button(".");
	public Button btnCom = new Button(",");
	public Button btnAdd = new Button("+");
	public Button btnSub = new Button("-");
	public Button btnMul = new Button("*");
	public Button btnDiv = new Button("/");
	public Button btnRes = new Button("=");
	public Button btnPer = new Button("%");
	public Button btnX = new Button("1/x");
	
	TextField tx = new TextField("0", 50);
	Panel whole = new Panel(new GridLayout(7,1));
	Panel p1 = new Panel(new GridLayout(1,1));
	Panel p2 = new Panel(new GridLayout(1,5));
	Panel p3 = new Panel(new GridLayout(1,5));
	Panel p4 = new Panel(new GridLayout(1,5));
	Panel p5 = new Panel(new GridLayout(1,5));
	Panel p6 = new Panel(new GridLayout(1,5));
	Panel p7 = new Panel(new GridLayout(1,5));
	
	Panel in1 = new Panel(new GridLayout(2,1));
	Panel in1_1 = new Panel(new GridLayout(1,2));
	
	Panel in2 = new Panel(new GridLayout(2,1));
	Panel in3 = new Panel(new GridLayout(2,1));
	
	Label display = new Label();
	public Calculator() {
		settingLayout();
	}
	
	public void settingLayout() {
		this.setSize(300,480);
		mb.add(view);
		mb.add(edit);
		mb.add(help);
		this.setMenuBar(mb);
		tx.setPreferredSize(new Dimension(300,200));
		p1.add(tx);
		whole.add(p1);
		p2.add(btnMC);
		p2.add(btnMR);
		p2.add(btnMS);
		p2.add(btnMp);
		p2.add(btnMm);
		whole.add(p2);
		
		p3.add(btnBS);
		p3.add(btnCE);
		p3.add(btnC);
		p3.add(btnPM);
		p3.add(btnRT);
		whole.add(p3);
		
		p4.add(btn7);
		p4.add(btn8);
		p4.add(btn9);
		p4.add(btnDiv);
		p4.add(btnPer);
		whole.add(p4);
		
		p5.add(btn4);
		p5.add(btn5);
		p5.add(btn6);
		p5.add(btnMul);
		p5.add(btnX);
		whole.add(p5);
		
		p6.add(btn1);
		p6.add(btn2);
		p6.add(btn3);
		p6.add(btnSub);
		p6.add(btnRes);
		
		p7.add(btn0);
		p7.add(btnDot);
		p7.add(btnAdd);
		
		p7.setSize(new Dimension(60,480));
//		in1_1.add(btn1);
//		in1_1.add(btn2);
//		in1.add(in1_1);
//		in1.add(btn0);
//		p6.add(in1);
//		
//		in2.add(btn3);
//		in2.add(btnDot);
//		p6.add(in2);
//		
//		in3.add(btnSub);
//		in3.add(btnAdd);
//		p6.add(in3);
//		
//		p6.add(btnRes);
		
		whole.add(p6);
		whole.add(p7);
		
		this.add(whole);

	}
}
public class CalculatorMain {
	public static void main(String[] args) {
		new Calculator().setVisible(true);
		
	}
}
