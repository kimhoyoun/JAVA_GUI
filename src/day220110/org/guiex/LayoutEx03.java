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

public class LayoutEx03 extends Myframe implements ActionListener{
	// Panel을 이용한 세부 레이아웃 설정
	Panel centerpan = new Panel(new GridBagLayout());
	Label centerLbl = new Label("Hello Java world!");
	Panel southpan = new Panel(new GridLayout(1,3));
	Panel innerpan = new Panel(new GridLayout(2,1));
	Button btn1 = new Button("BTN1");
	Button btn2 = new Button("BTN2");
	Button btn3 = new Button("BTN3");
	Button btn4 = new Button("BTN4");
	
	public LayoutEx03() {
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
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}



	public static void main(String[] args) {
		new LayoutEx03().setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// 제어문을 이용해서 버튼을 선별한다.
//		e.getSource(); // 해당 버튼
		if(e.getSource() instanceof Button) {
			// e.getSource를 버튼으로 형변환
			Button btn = (Button)(e.getSource());
			if(btn1.equals(btn)) {
				System.out.println("btn1");
				centerLbl.setText("press btn1");
			} else if(btn2.equals(btn)) {
				System.out.println("btn1");
				centerLbl.setText("press btn2");
			} else if(btn3.equals(btn)) {
				System.out.println("btn1");
				centerLbl.setText("press btn3");
			}else if(btn4.equals(btn)) {
				System.out.println("btn1");
				centerLbl.setText("press btn4");
			}
		}
		
	}

}
