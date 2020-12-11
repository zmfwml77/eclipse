package test.pratice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setTitle("나의 프레임");
		//크기
		f.setSize(300, 300);
		//위치
		f.setLocation(100, 100);
		//창닫기(x)를 누르면 자동으로 프로세스가 종료되도록 설정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//프레임을 보이게 한다.
		f.setVisible(true);
		//배치메니저를 사용하지 않겠다(절대 좌표에 절대 크리고 배치하겠다)
		f.setLayout(null);
		
		JButton btn=new JButton("눌러보셈");
		btn.setBounds(10, 10, 100, 40);
		f.add(btn);
		
		ActionListener listener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("눌렀네?");
				JOptionPane.showMessageDialog(f, "눌렀구만");
			}
		};
		btn.addActionListener(listener);
		
		JButton btn2=new JButton("눌러보삼2");
		btn2.setBounds(160, 10, 100, 40);
		f.add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "눌렀넴");
			}
		});
	}
}
