package test.pratice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame01 extends JFrame implements ActionListener{
	//생성자
	public MainFrame01(String title) {
		super(title);
		setLayout(new FlowLayout());
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		sendBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		//버튼에 ActionCommand 를 원하는대로 지정 할수 있다. 
		sendBtn.setActionCommand("send");
		updateBtn.setActionCommand("update");
		deleteBtn.setActionCommand("delete");
	}
	
	public static void main(String[] args) {
		MainFrame01 f=new MainFrame01("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		// 문자열(String) 의 내용을 비교 할때는 == 를 사용하지말고
		// .equals() 메소드를 이용해야 한다. 
		if(command.equals("send")) {
			JOptionPane.showMessageDialog(this, "전송합니다.");
		}else if(command.equals("update")) {
			JOptionPane.showMessageDialog(this, "수정합니다.");
		}else if(command.equals("delete")) {
			JOptionPane.showMessageDialog(this, "삭제합니다.");
		}
	}
}
