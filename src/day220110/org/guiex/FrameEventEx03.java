package day220110.org.guiex;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEventEx03 extends Frame{
	private int width = 640, height = 480;
	public FrameEventEx03() {
		setTitle("Inner class를 이용한 이벤트 처리 연습");
		setSize(width, height);
		setVisible(true);
		
		WindowListener l = new InnerWindowListener();
		addWindowListener(l);
	}
	
	class InnerWindowListener implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) {
			if(width == 100) {
				dispose();
				System.exit(0);
			}
			width=100;
			height = 100;
			setSize(width, height);
		}
		@Override
		public void windowClosed(WindowEvent e) {}
		@Override
		public void windowIconified(WindowEvent e) {}
		@Override
		public void windowDeiconified(WindowEvent e) {}
		@Override
		public void windowActivated(WindowEvent e) {}
		@Override
		public void windowDeactivated(WindowEvent e) {}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameEventEx03();
	}

}
