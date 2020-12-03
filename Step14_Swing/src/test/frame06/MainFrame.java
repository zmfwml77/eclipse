package test.frame06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener{
	//생성자
	public MainFrame(String title) {
		super(title);
		//레이아웃 지정
		setLayout(new FlowLayout());
		//버튼
		JButton getBtn=new JButton("0~9 랜덤 정수 얻어내기");
		// 버튼을 프레임에 추가
		add(getBtn);
		//버튼에 리스너 등록
		getBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//랜덤한 값을 얻어내기 위한 객체 생성
		Random ran=new Random();
		//0~9사이의 랜덤한 정수 ,  10대신 5를 넣으면 0~4
		int ranNum=ran.nextInt(10);
		JOptionPane.showMessageDialog(this,  "발생된 랜덤 정수: "+ranNum);
	}
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
