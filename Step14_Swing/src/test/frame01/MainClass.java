package test.frame01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainClass {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		JFrame f1=new JFrame();
		f.setTitle("나의 프레임"); // 창 이름
		f.setSize(500, 300); // 창의 크기
		f.setLocation(100, 100); // 창의 위치
		//창닫기(X)를 누르면 자동으로 프로세스가 종료되도록 설정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//배치 매니저를 사용하지 않겠다(절대 좌표에 절대 크기로 배치하겠다)
		f.setLayout(null); 
		JButton btn=new JButton("눌러보셈"); // 버튼 객체 생성
		btn.setBounds(10, 10, 100, 40); //버튼의 크기와 위치 선정
		f.add(btn); // 프레임에 버튼 추가하기
		f.setVisible(true); // 창 보이기(true)
		
		//ActionListener 인터페이스 type의 참조값 얻어내기
		ActionListener listener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 눌렀넹?");
				//JOptionPane 클래스의 static 메소드를 이용해서 알림창 띄우기
				//showMessageDialog(프레임의 참조값, 띄울 문자열)
				JOptionPane.showMessageDialog(f,  "버튼을 눌렀넹?");
			}
		};
		//버튼에 액션 리스너 등록하기
		btn.addActionListener(listener);
	}
}
