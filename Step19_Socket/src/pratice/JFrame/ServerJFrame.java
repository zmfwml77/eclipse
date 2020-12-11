package pratice.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerJFrame extends JFrame implements ActionListener{
	JTextField inputText;
	
	public ServerJFrame(String title) {
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
	}
	
	public static void main(String[] args) {
		ServerJFrame f=new ServerJFrame("chatting");
		f.setBounds(100, 100, 500, 300);
		f.setVisible(true);
		f.setLocation(50, 50);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5000);
			System.out.println("클라이언트의 Socket 접속을 기다립니다...");
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 접속을 했습니다.");
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println("접속한 클라이언트의 ip 주소:" + ip);
			// 방금 접속을 한 클라이언트로 부터 입력받을 객체의 참조값
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String msg = br.readLine();
			System.out.println("클라이언트가 전송한 문자열:" + msg);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ServerMain main 메소드가 종료 됩니다.");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=this.inputText.getText();
		JOptionPane.showMessageDialog(this, msg);

	}
	
}
