package day220114.org.ex.ex01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyContentPanTest01 extends JPanel {
	JLabel label;

	public MyContentPanTest01() {
		label = new JLabel("우리는 하나다!");
		Font font = new Font("궁서체", Font.ITALIC, 48);
		label.setFont(font);
		this.add(label);
	}
}

class AirPlan01 extends JPanel {
	Image img;
	String imagePath = "airplan01.png";
	BufferedImage bfimage;
	JLabel imgLbl;
	public int x = 0, y = 0;

	public AirPlan01() {
//		img = Toolkit.getDefaultToolkit().getImage(imagePath);
		// 이미지나 그래픽 관련 메소드는 자동 실행 된다.
		// paint(), repaint(), paintComponent()

		// 이미지 아이콘은 이미지가 아니다.
		ImageIcon imgIcon = new ImageIcon("airplan01.png");
//		ImageIcon imgIc = new ImageIcon(getClass().getResource("src\\day220114\\org\\ex\\ex01\\ariplan01.png"));  
		img = imgIcon.getImage();
		// 이미지 사이즈 조정
		// 이미지 아이콘을 이미지로 만들고
		// 이미지에서 getScaledInstance()메소드를 사용해서 새로운 image를 만듦
		// 새로운 이미지를 다시 ImageIcon으로 만들어 준다.
		// 생성자를 사용해서 만들던가
		Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(newImg);
//		try {
//			bfimage = ImageIO.read(this.getClass().getResource("airplan01.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		imgLbl = new JLabel(imgIcon);
		this.add(imgLbl);
//		imgLbl.setBounds(x, y, 50, 100);
		// 이미지 크기도 조정

	}

}

class AirPlan02 extends JPanel implements Runnable {
	MyCenterPan centerpan;
	String imagePath = "airplan02.png";
	Image img = null;
	ImageIcon imgIcon = null;
	Random rand = new Random();
	int x = 100 + (int) rand.nextInt(500);
	int y = -100, w = 100, h = 100;

	public AirPlan02(MyCenterPan centerpan) {
		this.centerpan = centerpan;
		imgIcon = new ImageIcon(imagePath);
		img = imgIcon.getImage();
		img = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);

		JLabel label = new JLabel(imgIcon);
		this.add(label);

		movePlain();
	}

	public void movePlain() {
		this.setBounds(x, y, w, h);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(50);
				y += 10;

				if (y >= 600) {
					y = -100;
					x = 100 + (int) rand.nextInt(500);
					this.setVisible(true);
				}
				
				movePlain();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class AiplanStarterThread extends Thread{
	AirPlan02[] airplan02;
	public AiplanStarterThread(AirPlan02[] airplan02) {
		this.airplan02 = airplan02;
	}

	@Override
	public void run() {
		for(int i =0; i<airplan02.length; i++) {
			Thread th = new Thread(airplan02[i]);
			th.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Bulet extends JPanel implements Runnable{
	String imagePath = "bulet.png";
	Image img = null;
	ImageIcon imgIcon = null;
	MyCenterPan centerpan;
	int x = 350;
	int y = 400, w = 50, h = 70;
	public Bulet(MyCenterPan centerpan) {
		this.centerpan = centerpan;
		x = centerpan.x1+20;
		imgIcon = new ImageIcon(imagePath);
		img = imgIcon.getImage();
		img = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);

		JLabel label = new JLabel(imgIcon);
		this.add(label);
	}

	public void movePlain() {
		this.setBounds(x, y, w, h);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(30);
				y -= 10;
				if (y <= -100) {
					y = 400;
					x = centerpan.x1+20;
					this.setVisible(true);
				}

				movePlain();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class BuletStarterThread extends Thread{
	Bulet[] bulet = null;
	public BuletStarterThread(Bulet[] bulet) {
		 this.bulet = bulet;
	}
	
	@Override
	public void run() {
		for(int i =0; i<bulet.length; i++) {
			Thread th = new Thread(bulet[i]);
			th.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

// 충돌검사 쓰레드
class BuletbaamThread extends Thread{
	MyCenterPan contentpan;
	public BuletbaamThread(MyCenterPan contentpan) {
		this.contentpan = contentpan;
	}
	@Override
	public void run() {
		AirPlan02[] a2Arr = contentpan.airplan02;
		Bulet[] bArr = contentpan.bulet;
		
		while(true) {
			for(int i =0; i<a2Arr.length; i++) {
				int x = a2Arr[i].x;
				int xw = a2Arr[i].x+a2Arr[i].w;
				int y = a2Arr[i].y;
				int yh = a2Arr[i].y+a2Arr[i].h;
				
				for(int j = 0; j<bArr.length; j++) {
					int bx = bArr[j].x;
					int bxw = bArr[j].x+bArr[j].w/2;
					int byh = bArr[j].y+bArr[j].h/2;
					int by = bArr[j].y;
					
					if((bxw>=x)&&(bxw<=xw)&&(byh<=yh)&&(byh>=y)) {
						a2Arr[i].setVisible(false);
						a2Arr[i].y = -100;
						bArr[j].setVisible(false);
					}
				}
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

// 단지 가운데 붙는애
// 움직이거나 하는 애들은 따로 객체로 만들어서 여기 붙이기만.
class MyCenterPan extends JPanel {
	int x1 = 350, y1 = 400, w = 100, h = 100;
	AirPlan01 airplan01 = new AirPlan01();
	AirPlan02 airplan02[] = new AirPlan02[10];
	Bulet bulet[] = new Bulet[5];
	
	public MyCenterPan() {
		setLayout(null);
		this.add(airplan01);
		
		airplan01.setBounds(x1, y1, w, h);

		for (int i = 0; i < airplan02.length; i++) {
			airplan02[i] = new AirPlan02(this);
			this.add(airplan02[i]);
			airplan02[i].movePlain();
			Thread airplan02th = new Thread(airplan02[i]);
		}
		
		for(int i =0; i<bulet.length; i++) {
			bulet[i] = new Bulet(this);
			this.add(bulet[i]);
			
		}
		AiplanStarterThread starter = new AiplanStarterThread(airplan02);
		starter.start();
		
		BuletStarterThread buletStarter = new BuletStarterThread(bulet);
		buletStarter.start();
		
		BuletbaamThread baam = new BuletbaamThread(this);
		baam.start();
	}

}

class MyContentPan extends JPanel {
	MyCenterPan centerPan = new MyCenterPan();
	JButton leftBtn = new JButton("LEFT");
	JButton rightBtn = new JButton("RIGHT");

	public MyContentPan() {
		layoutComponent();
		actionEvent();
	}

	private void actionEvent() {
		leftBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 누르면 비행기가 화면의 좌측으로 이동.5
				centerPan.x1 -= 10;
				centerPan.airplan01.setBounds(centerPan.x1, centerPan.y1, centerPan.w, centerPan.h);
				repaint(); // 해당 컴포넌트의 화면을 다시 그린다.
			}
		});

		rightBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 누르면 비행기가 화면의 우측으로 이동.
				centerPan.x1 += 10;
				centerPan.airplan01.setBounds(centerPan.x1, centerPan.y1, centerPan.w, centerPan.h);
//				centerPan.revalidate();
				repaint();
			}
		});

		this.addKeyListener(new KeyAdapter() {
			// ket type

			// key press
			// key포커스를 설정해야 반응한다.
			// KeyListener 전후로 하면됨.
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();

				// 방향키에대한 상수 존재 VK_LEFT...
				if (keyCode == KeyEvent.VK_LEFT) {
					centerPan.x1 -= 10;
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					centerPan.x1 += 10;
				} else if (keyCode == KeyEvent.VK_UP) {
					centerPan.y1 -= 10;
				} else if (keyCode == KeyEvent.VK_DOWN) {
					centerPan.y1 += 10;
				}
				centerPan.airplan01.setBounds(centerPan.x1, centerPan.y1, centerPan.w, centerPan.h);
				repaint();
			}
		});
		// Focus를 읽을 수 있도록 함.
		this.setFocusable(true);
		this.requestFocus();
	}

	private void layoutComponent() {
		setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, new JLabel("이미지 사용하기"));
		setBackground(Color.PINK);
		this.add(BorderLayout.CENTER, centerPan);
		JPanel bottomPan = new JPanel();
		bottomPan.add(leftBtn);
		bottomPan.add(rightBtn);
		this.add(BorderLayout.SOUTH, bottomPan);
	}

}

public class ImgIO extends JFrame {

	Container contetnPan;

	public ImgIO() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("이미지 불러오기 실습");
		setSize(800, 600);
		MyContentPan myContentPan = new MyContentPan();
		setContentPane(myContentPan);
	}

	public static void main(String[] args) {
		new ImgIO().setVisible(true);
	}

}
