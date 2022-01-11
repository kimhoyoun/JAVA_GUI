package day220111.org.guiex.ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import day220111.org.guiex.myframe.Myframe;

public class Ex01BtnEvt extends Myframe{
	private Button[] btnArr = new Button[2];
	Panel southPan = new Panel();
	Panel centerPan = new Panel(new GridBagLayout());
	public Ex01BtnEvt() {
		super("Button Event Ex",400,100);
		start();
		run();
	}
	
	{
		// 초기화 블럭 - 필드를 초기화 하는 구역
		// 기타 실행문 넣는건 권장하지 않는다.
		btnArr[0] = new Button("button1");
		btnArr[1] = new Button("button2");
		
	}
	private Label lbl = new Label("[Result] No Button pressed");
	
	public void start() {
		// Panel의 Default Layout은 FlowLayout
		southPan.add(btnArr[0]);
		southPan.add(btnArr[1]);
		centerPan.add(lbl);
		this.add(BorderLayout.SOUTH,southPan);
		this.add(BorderLayout.CENTER,centerPan);
	}
	
	public void run() {
		btnArr[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText("[Result] button1 pressed");
				southPan.setBackground(new Color((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));
				centerPan.setBackground(new Color((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));
				
			}
			
		});
		
		btnArr[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText("[Result] button2 pressed");
				southPan.setBackground(new Color((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));
			}
			
		});
	}
	public static void main(String[] args) {
		new Ex01BtnEvt().setVisible(true);;
	}

}
