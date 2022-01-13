package day220112.org.guiex.ex05;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx01 extends JFrame {
	Container contentPane;
	JTable table;
	DefaultTableModel tableModel;
	// 화면을 초과할 데이터가 들어오면 스크롤을 따라서 내려갈 수 있도록 
	// JScrollPane을 생성
	JScrollPane scrollPane;
	
	//테이블에 넣을 데이터값
	Object[][] rowData;
	// 테이블 최상단 행에 넣을 제목 값
	Object[] colNames;
	
	public JTableEx01() {
		init();
		start();
	}
	
	private void init() {
		contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		setSize(640,480);
		// 데이터와 테이블 생성
		mkTbl();
	}
	
	// 데이터와 테이블 생성하는 메소드
	private void mkTbl() {
		colNames = new Object[] {"idx","name","phone"};
		rowData = new Object[][] {
			{1, "kim" ,"010-1111-1111" },
			{2, "lee" ,"010-2222-2222" },
			{3, "park" ,"010-3333-3333" },
			{4, "kang" ,"010-4444-4444" },
			{5, "hong" ,"010-5555-5555" }
		};
		// 수정이 용이하도록 tableModel 사용
		tableModel = new DefaultTableModel(rowData, colNames);
		// 테이블을 생성할때 rowData와 colNames를 바로 넣을 수 있지만
		// 데이터를 수정할 경우 table을 새로 만들지 않기 위해 tableModel을 활용하여 생성
		table = new JTable(tableModel);
		
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		
		
		/// ----------------------------- 내용 변경
		// 일단 데이터 지우기
		tableModel.setDataVector(null, colNames);
		// 새로운 데이터 입력
		tableModel.addRow(new Object[] {3,"ccc","7777"});
		tableModel.addRow(new Object[] {2,"bbb","8888"});
		tableModel.addRow(new Object[] {1,"aaa","9999"});
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}






	public static void main(String[] args) {
		new JTableEx01().setVisible(true);
	}

}
