package day220107.org.guiex;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Label;

public class Ex01Frame {

	public static void main(String[] args) {
		// 프레임 실행
		// 단독으로 생성하기 / 상속을 받아서 생성하기
		Frame frame = new Frame();
		frame.setLayout(new GridBagLayout());
		
		frame.add(new Label("Hello: "));
		frame.add(new Button("WORLD"));
		
		
		frame.setSize(640, 480);
		frame.setVisible(true);
	}

}
