package day220110.org.guiex;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEventEx05 extends Frame{
	public FrameEventEx05() {
		setTitle("WindowAdapter를 활용한 Event처리");
		setSize(640,480);
		setVisible(true);
		// 인터페이스를 구현 하면서 인스턴스 생성 가능 (익명 내부 클래스)
		// 1회용으로 사용이 끝난다.
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FrameEventEx05.this.dispose();
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new FrameEventEx05();
	}
}
