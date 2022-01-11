package day220110.org.guiex;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex02_2 extends Frame implements WindowListener{
	public Ex02_2() {
		setTitle("WindowEventListener 실습");
		setSize(640,480);
		setVisible(true);
		
		this.addWindowListener(this);
	}
	public static void main(String[] args) {
		new Ex02_2();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println(">> 닫기 버튼을 눌러서 프로세스 종료");
		dispose();
		System.exit(0);
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		
		
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
}
