package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.SubThread;

public class MainFrame03 extends JFrame implements ActionListener{
	//생성자
	public MainFrame03(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		
		add(btn, BorderLayout.NORTH)
;	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, "알림 입니다!!");
		
		// {} => Thread class를 상속받은 익명의 Local inner class의 객체를 생성하고
		Thread t=new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("무언가 3초(오랜시간)이 걸리는 작업을 합니다.");
					Thread.sleep(3000);
					System.out.println("시간이 오래 걸리는 작업이 끝났습니다.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		//스레드를 시작시킨다.
		t.start();
		System.out.println("actionPerformed() 메소드가 리턴합니다.");
	}
	//실행시키면 'actionPerformed() 메소드가 리턴합니다'가 먼저 실행되는걸 확인하자!
	//=> 따라서 Thread 실행이 2개로 나뉜다(비동기)
//	actionPerformed() 메소드가 리턴합니다.
//	무언가 3초(오랜시간)이 걸리는 작업을 합니다.
//	시간이 오래 걸리는 작업이 끝났습니다.
	
	public static void main(String[] args) {
		MainFrame03 f=new MainFrame03("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
