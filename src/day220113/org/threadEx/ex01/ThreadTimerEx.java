package day220113.org.threadEx.ex01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread {
	JLabel label = null;
	boolean isPause = false;

	public TimerThread(JLabel label) {
		this.label = label;
	}

	@Override
	synchronized public void run() {
		// Thread 실행 메소드 재정의 - start()에 의해서 실행 됨.
		int ssec = 0;
		int sec = 0;
		while (true) {
			// throws를 할 수 없는 이유
			// 메인과 여기는 다른 프로세스이므로 메인에서 호출했다고
			// 이것에 대한 예외처리를 할 의무가 없다
			try {
				if ((ssec % 10 == 0) && (ssec != 0))
					sec++;
				ssec %= 10;
//				System.out.println("Timer >> "+ sec+ " : " + ssec++);
				label.setText("Timer >> " + sec + "." + ssec++);
				Thread.sleep(100);

				// 반복문이 끝나면 쓰레드도 종료
				if (isPause) {
					synchronized (this) {
						try {
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (InterruptedException e) {
			}
		}
	}


	public void replay() {
		if (isPause) {
			synchronized (this) {
				isPause = false;
				this.notifyAll();
			}
		}
	}

	public void pauseThread() {
		isPause = true;
	}

//	public void pauseThread() {
//		// timer가 wait하고 다음동작을 하도록 해줘야하는데 그상태 그대로 얼어버림
//		// 다음 동작을 할 수 있도록 대기 상태가 돼야 함.
//		// 메인은 이미 끝나버렸고 쓰레드는 대기상태로 멈춤 현상황 : 메인 끝, 쓰레드 정지
//		// 쓰레드가 동작은 하고있어야함.
//		// 반복문이 끝나면 쓰레드도 끝남.
//		synchronized (this) {
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}


public class ThreadTimerEx extends JFrame {
	public ThreadTimerEx() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Thread를 이용한 시계");
		setSize(300, 200);
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		JLabel label = new JLabel("");
//		label.setFont(new Font("Gothic", Font.ITALIC, 20));
		content.add(label);

		JButton stopBtn = new JButton("stop");
		JButton playBtn = new JButton("play");
		content.add(stopBtn);
		content.add(playBtn);

		// Thread 생성하고 실행하기 - 업캐스팅
		// th안에 일시정지, 재실행 하는 메소드를 만들어야 함.
		TimerThread th = new TimerThread(label);
		// run()을 실행하기 위해서 start() 호출

		th.start();

		stopBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 타이머가 일시중지 하도록 Thread 객체에 요청 한다.
//				try {
//					// 메인에서 다른 쓰레드 못죽임.
//					th.wait();
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

//				th.pauseThread();

				th.pauseThread();
			}
		});

		playBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.replay();
			}
		});

	}

	public static void main(String[] args) {
		new ThreadTimerEx().setVisible(true);

	}

}
