package day220111.org.guiex.ex02;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import day220111.org.guiex.myframe.MyJFrame;

public class Ex02MyJFrameTest extends MyJFrame {
	JButton okBtn, resetBtn;
	JTextField txtFld1, txtFld2, txtFld3, txtFld4;
	JPanel centerPan, leftPan, mainPan, bottomPan;
	
	public Ex02MyJFrameTest() {
		super("회원가입",300,250);
	}
	
	public void init() {
		okBtn = new JButton("가입하기");
		resetBtn = new JButton("다시작성");
		
		txtFld1 = new JTextField(20);
		txtFld2 = new JTextField(20);
		txtFld3 = new JTextField(20);
		txtFld4 = new JTextField(20);
		
		mainPan = new JPanel(new BorderLayout());
		leftPan = new JPanel(new GridLayout(4,1));
		centerPan = new JPanel(new GridLayout(4,1));
		bottomPan = new JPanel();
	}

	@Override
	protected void displayLayer() {
		init();
		// MyJFrame에 필드로 선언 되었다. Container 타입으로 선언됨.(Container contentpan)
		contentPan = getContentPane();
		
		contentPan.setLayout(new GridBagLayout());
		mainPan.setSize(120, 200);

		contentPan.add(mainPan);
		mainPan.add(BorderLayout.WEST,leftPan);
		mainPan.add(BorderLayout.CENTER,centerPan);
		mainPan.add(BorderLayout.SOUTH,bottomPan);
		
		leftPan.add(new JLabel("이      름:"));
		leftPan.add(new JLabel("아 이 디:"));
		leftPan.add(new JLabel("패스워드:"));
		leftPan.add(new JLabel("나      이:"));

		centerPan.add(txtFld1);
		centerPan.add(txtFld2);
		centerPan.add(txtFld3);
		centerPan.add(txtFld4);
		
		bottomPan.add(okBtn);
		bottomPan.add(resetBtn);
	}

	@Override
	protected void actionEvt() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Ex02MyJFrameTest().setVisible(true);
	}
}
