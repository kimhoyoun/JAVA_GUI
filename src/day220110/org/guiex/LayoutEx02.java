package day220110.org.guiex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import day220110.org.guiex.myframe.Myframe;

public class LayoutEx02 extends Myframe{
	// Panel을 이용한 세부 레이아웃 설정
	Panel centerpan = new Panel(new GridBagLayout());
	Label centerLbl = new Label("Hello Java world!");
	Panel southpan = new Panel(new GridLayout(1,3));
	Panel innerpan = new Panel(new GridLayout(2,1));
	Button btn1 = new Button("BTN1");
	Button btn2 = new Button("BTN2");
	Button btn3 = new Button("BTN3");
	Button btn4 = new Button("BTN4");
	
	public LayoutEx02() {
		layoutEx01();
	}
	
	
	
	private void layoutEx01() {
		// 센터에 붙인다.
		this.add(BorderLayout.CENTER,centerpan);
		centerpan.add(centerLbl);
		// 하단에 붙인다.
		southpan.add(btn1);
		southpan.add(btn2);
		southpan.add(innerpan);
		innerpan.add(btn3);
		innerpan.add(btn4);
		this.add(BorderLayout.SOUTH,southpan);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("첫번째버튼 눌렀다.");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("두번째버튼 눌렀다.");
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("세번째버튼 눌렀다.");
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("네번째버튼 눌렀다.");
			}
		});
	}



	public static void main(String[] args) {
		new LayoutEx02().setVisible(true);
	}

}
