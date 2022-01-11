package day220111.org.guiex.ex03;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import day220111.org.guiex.myframe.MyJFrame;

public class Ex03JOptionPane extends MyJFrame{
	JButton openBtn, btn2, btn3, btn4;
	public Ex03JOptionPane() {
		super("show dialog example",600,400);
	}
	
	protected void init() {
		openBtn = new JButton("message 열기");
		btn2 = new JButton("input Dialog 열기");
		btn3 = new JButton("confirm Dialog 열기");
		btn4 = new JButton("Option 창 열기");
	}
	
	@Override
	protected void displayLayer() {
		init();
		contentPan = getContentPane();
		contentPan.setLayout(new GridBagLayout());
		contentPan.add(openBtn);
		contentPan.add(btn2);
		contentPan.add(btn3);
		contentPan.add(btn4);
	}
	
	@Override
	protected void actionEvt() {
		openBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 클릭하면 다이얼로그 창 보이게 하기
				JOptionPane.showMessageDialog(Ex03JOptionPane.this, "환영합니다!");
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("내용을 입력해 주세요!");
			}
			
		});
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(Ex03JOptionPane.this, "종료하시겠습니까?");
			}
			
		});
		
		btn4.addActionListener(new ActionListener() {
			String[] options = {"abc", "def", "ghi", "jkl"};
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showOptionDialog(Ex03JOptionPane.this, "선택해주세요", "optionPane", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			}
			
		});
		
		
		
	}
	public static void main(String[] args) {
		new Ex03JOptionPane().setVisible(true);;
	}
	public static void test01(String[] args) {
		JOptionPane.showInternalMessageDialog(null, "Hello world");
	}

}
