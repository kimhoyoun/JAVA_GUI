package day220110.org.guiex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import day220110.org.guiex.myframe.Myframe;

public class LayoutEx01 extends Myframe{
	private Button btn1 = new Button("BTN1");
	private Button btn2 = new Button("BTN2");
	private Button btn3 = new Button("BTN3");
	private Button btn4 = new Button("BTN4");
	private Button btn5 = new Button("BTN5");
	
	public ArrayList<Button> btns = new ArrayList<>();
	{
		for(int i =0; i<100; i++) {
			btns.add(new Button("BTN"+i));
		}
	}
	public LayoutEx01() {
		super("Layout manager 연습",640,480);

//		borderLayoutEx();
//		flowLayoutEx();
		gridLayoutEx();
//		gridBagLayoutEx();
	}
	
	
	
	private void gridBagLayoutEx() {
		// 무조건 정 가운데 붙이는거
		this.setLayout(new GridBagLayout());
		this.add(btn1);
	}



	private void gridLayoutEx() {
		this.setLayout(new GridLayout(3,3, 5, 5));
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btns.get(10));
	}
	
	private void flowLayoutEx() {
		// FlowLayout - 왼쪽에서 오른쪽으로 순서대로 붙인다.
		this.setLayout(new FlowLayout());
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		
		for(Button btn : btns) {
			this.add(btn);
		}
	}


	public void borderLayoutEx(){
		// Window를 상속받은 Frame은 디폴트 레이아웃이 BorderLayout
		add(BorderLayout.NORTH,btn1);
		add(BorderLayout.SOUTH,btn2);
		add(BorderLayout.EAST,btn3);
		add(BorderLayout.WEST,btn4);
		add(BorderLayout.CENTER,btn5);
	}
	public static void main(String[] args) {
		// 미리 클래스에서 setVisible해주면 오류가 걸려서 안뜰경우가 발생할 수 있어서
		// 사용하기 전에 해주는 것이 안정적이다.
		new LayoutEx01().setVisible(true);
	}

}
