package pratice.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AcornFrame extends JFrame implements ActionListener{
	public AcornFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton sendBtn=new JButton("전송");
		add(sendBtn, BorderLayout.NORTH);
		sendBtn.addActionListener(this);
		sendBtn.setActionCommand("send");
	}

	public static void main(String[] args) {
		AcornFrame f=new AcornFrame("acorn");
		f.setBounds(100, 100, 400, 400);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("send")) {
			JOptionPane.showMessageDialog(this, "전송합니다.");
		}
	}
}
