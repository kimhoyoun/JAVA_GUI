package day220111.org.guiex.ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import day220111.org.guiex.myframe.Myframe;

public class Ex03 extends Myframe{
	Panel leftPan = new Panel();
	Button btn1 = new Button("button 01");
	Panel centerPan = new Panel(new GridBagLayout());
	TextField txtFld = new TextField(10);
	TextField txtFld2 = new TextField(10);
	TextField txtFld3 = new TextField(10);
	TextField txtFld4 = new TextField(10);
	
	public Ex03() {
		super("Member management system",640,480);
		
		add(BorderLayout.WEST,leftPan);
		add(BorderLayout.CENTER,centerPan);
		
		centerPan.add(new Label("center message"));
		centerPan.setBackground(Color.BLUE);
		
		Panel rowPan1 = new Panel();
		rowPan1.add(new Label("btn1 : "));
		rowPan1.add(btn1);
		Panel rowPan2 = new Panel();
		rowPan2.add(new Label("text01 : "));
		rowPan2.add(txtFld);
		
		Panel rowPan3 = new Panel();
		rowPan3.add(new Label("text02 : "));
		rowPan3.add(txtFld2);
		
		Panel rowPan4 = new Panel();
		rowPan4.add(new Label("text03 : "));
		rowPan4.add(txtFld3);
		
		Panel rowPan5 = new Panel();
		rowPan5.add(new Label("text04 : "));
		rowPan5.add(txtFld4);
		
		Panel gridPan = new Panel(new GridLayout(5,1));
		gridPan.add(rowPan1);
		gridPan.add(rowPan2);
		gridPan.add(rowPan3);
		gridPan.add(rowPan4);
		gridPan.add(rowPan5);
		leftPan.add(gridPan);
	}
	
	public static void main(String[] args) {
		new Ex03().setVisible(true);;
	}
}
