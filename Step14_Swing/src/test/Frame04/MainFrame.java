package test.frame04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener, KeyListener{
	//필드
	JTextField inputText;
	JLabel label1;

	//생성자
	public MainFrame(String title) {
		super(title);
		//레이아웃 매니저 설정
		this.setLayout(new BorderLayout()); // this 생략 가능

		
		//텍스트필드와 버튼객체를 만들어서 
		this.inputText=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		
		//패널 객체 생성한 다음
		JPanel topPanal=new JPanel();
		//패널에 텍스트필스와 버튼을 추가하고
		topPanal.add(inputText);
		topPanal.add(sendBtn);
		//패널의 배경색지정
		topPanal.setBackground(Color.YELLOW);
		
		//패널째로 프레임의 북쪽에 배치하기
		add(topPanal, BorderLayout.NORTH);
		
		//버튼에 리스너 등록하기
		sendBtn.addActionListener(this);
		
		//레이블을 만들어서
		label1=new JLabel();
		//패널에 추가하기
		topPanal.add(label1);
		
		//JTextField
		inputText.addKeyListener(this);
	}
	
	//run했을 때 실행순서가 시작되는 main 메소드
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//1.JTextField 에 입력한 문자열을 읽어와서
		String msg=this.inputText.getText();
		//2. 레이블에 출력한다
		label1.setText(msg);
		//3. 입력창 초기화
		inputText.setText("");
	}

	//키를 눌렀을 때 호출되는 메소드
	@Override
	public void keyPressed(KeyEvent e) {
		//눌러진 키의 코드값 읽어오기
		int code=e.getKeyCode();
		System.out.println(code);
		//만일 엔터키를 눌렀다면
		if(code==KeyEvent.VK_ENTER) {
			String msg=this.inputText.getText();
			label1.setText(msg);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("released");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("typed");
	}
}
