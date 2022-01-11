package day220110.org.guiex;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEventEx04 extends Frame{
	public FrameEventEx04() {
		setTitle("익명 내부 클래스를 활용한 이벤트 핸들러 구현");
		setSize(640,480);
		setVisible(true);
		// 인터페이스를 구현 하면서 인스턴스 생성 가능 (익명 내부 클래스)
		// 1회용으로 사용이 끝난다.
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				FrameEventEx04.this.dispose();
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public static void main(String[] args) {
		new FrameEventEx04();
	}
}
