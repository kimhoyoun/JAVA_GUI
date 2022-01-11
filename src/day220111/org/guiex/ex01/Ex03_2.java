package day220111.org.guiex.ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

import day220111.org.guiex.myframe.Myframe;

public class Ex03_2 extends Myframe {
	
	public Ex03_2() {
		super("ex",400,300);
		run();
	}
	
	public void run() {
		Panel northPan = new Panel();
		Panel centerPan = new Panel();
		
		Panel gridPan = new Panel(new GridLayout(1,4));
		
		Panel colpan1 = new Panel();
		Checkbox cb1 = new Checkbox("radio1");
		colpan1.add(cb1);
		
		Panel colpan2 = new Panel();
		Checkbox cb2 = new Checkbox("radio2");
		colpan2.add(cb2);
		
		Panel colpan3 = new Panel();
		Checkbox cb3 = new Checkbox("radio3");
		colpan3.add(cb3);
		
		Panel colpan4 = new Panel();
		Checkbox cb4 = new Checkbox("radio4");
		colpan4.add(cb4);
		
		TextField tx = new TextField(30);
		Button btn1 = new Button("btn1");
		Button btn2 = new Button("btn2");
		Button btn3 = new Button("btn3");
		Button btn4 = new Button("btn4");
		gridPan.add(colpan1);
		gridPan.add(colpan2);
		gridPan.add(colpan3);
		gridPan.add(colpan4);
		northPan.add(gridPan);
		
		Panel cgridPan = new Panel(new GridLayout(5,1));
		cgridPan.add(tx);
		cgridPan.add(btn1);
		cgridPan.add(btn2);
		cgridPan.add(btn3);
		cgridPan.add(btn4);
		
		centerPan.add(cgridPan);
		
		add(BorderLayout.NORTH,northPan);
		add(BorderLayout.CENTER,centerPan);
	}
	
	
	public static void main(String[] args) {
		
		new Ex03_2().setVisible(true);;
	}

}
