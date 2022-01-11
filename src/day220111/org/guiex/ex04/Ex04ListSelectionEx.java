package day220111.org.guiex.ex04;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import day220111.org.guiex.myframe.MyJFrame;

public class Ex04ListSelectionEx extends MyJFrame implements ListSelectionListener{
	JList list;
	JTextField tf;
	
	protected void init() {
		// JList에 들어갈 값을 String 배열로 선언하여 사용
		String[] str = {"등산","윈드서핑","독서","수영","골프","영화"};
		list = new JList(str);
		tf = new JTextField();
	}
	
	@Override
	protected void displayLayer() {
		init();
		this.add(new JLabel("취미를 선택하세요."), BorderLayout.NORTH);
		this.add(list,BorderLayout.CENTER);
		this.add(tf,BorderLayout.SOUTH);
	}

	@Override
	protected void actionEvt() {
		list.addListSelectionListener(this);
	}
	
	public static void main(String[] args) {
		new Ex04ListSelectionEx().setVisible(true);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// 리스트의 항목을 선택하면 실행되는 이벤트 핸들러
		Object[] item;
		String total = "";
		
		// 리스트를 받아와서 li에 저장
		JList li = (JList)e.getSource();
		item = li.getSelectedValues();
		// 리스트에서 선택된 값을 item에 저장
		for(int i =0; i<item.length; i++) {
			total = total + item[i] + " ";
		}
		
		tf.setText("선택 된 항목 >> "+total );
	}

}
