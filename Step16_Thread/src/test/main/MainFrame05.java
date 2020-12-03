package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.DownloadTask;
import test.mypac.SubThread;

public class MainFrame05 extends JFrame implements ActionListener{
	//생성자
	public MainFrame05(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		
		add(btn, BorderLayout.NORTH)
;	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, "알림 입니다!!");
		//Runnable 인터페이스의type 의 참조값을 얻어내서
		Runnable downTask=new DownloadTask();
		Thread t=new Thread(downTask);
		t.start();
		
		System.out.println("actionPerformed() 메소드가 리턴합니다.");
		// {} => Thread class를 상속받은 익명의 Local inner class의 객체를 생성하고
		new Thread() {
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
		}.start();
	}
	
	public static void main(String[] args) {
		MainFrame05 f=new MainFrame05("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
