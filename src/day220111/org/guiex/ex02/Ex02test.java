package day220111.org.guiex.ex02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import day220111.org.guiex.myframe.MyJFrame;

public class Ex02test extends MyJFrame {
	public Ex02test() {
		// TODO Auto-generated constructor stub
		super("회원가입", 300, 300);
	}

	@Override
	protected void displayLayer() {
		// MyJFrame에 필드로 선언 되었다. Container 타입으로 선언됨.(Container contentpan)
		contentPan = getContentPane();
		JPanel grid = new JPanel(new GridLayout(5, 1));
		JPanel rowpan1 = new JPanel(new GridBagLayout());
		JPanel rowpan2 = new JPanel(new GridBagLayout());
		JPanel rowpan3 = new JPanel(new GridBagLayout());
		JPanel rowpan4 = new JPanel(new GridBagLayout());
		JPanel rowpan5 = new JPanel(new GridBagLayout());
		JTextField name = new JTextField(15);
		JTextField id = new JTextField(15);
		JTextField pwd = new JTextField(15);
		JTextField age = new JTextField(15);
		JButton btn1 = new JButton("가입하기");
		JButton btn2 = new JButton("다시쓰기");

		rowpan1.add(new JLabel("이    름: "));
		rowpan1.add(name);
		rowpan2.add(new JLabel("아 이 디: "));
		rowpan2.add(id);
		rowpan3.add(new JLabel("패스워드: "));
		rowpan3.add(pwd);
		rowpan4.add(new JLabel("나    이: "));
		rowpan4.add(age);

		rowpan5.add(btn1);
		rowpan5.add(btn2);

		grid.add(rowpan1);
		grid.add(rowpan2);
		grid.add(rowpan3);
		grid.add(rowpan4);
		grid.add(rowpan5);

		contentPan.add(grid, BorderLayout.CENTER);

	}

	@Override
	protected void actionEvt() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Ex02test().setVisible(true);
	}
}
