package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener{
	// 선언만 하면 알아서 null 이 들어가므로 굳이 null을 만들어주지 않아도 됨.
	JTextField text_name, text_addr; 
	DefaultTableModel model;
	JTable table;
	//생성자
	public MemberFrame(String title) {
		super(title);
		//프레임의 레이아웃 법칙 지정하기
		setLayout(new BorderLayout());
		//상단 페널
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		//페널을 상단에 배치하기
		add(topPanel, BorderLayout.NORTH);
		//페널에 추가할 UI객체를 생성해서
		JLabel label_name=new JLabel("이름");
		JLabel label_addr=new JLabel("주소");
		//아래 메소드에서 필요한 값을 필드에 저장하기
		text_name=new JTextField(10);
		text_addr=new JTextField(10);
		JButton btn_add=new JButton("추가");
		//페널에 순서대로 추가하기
		topPanel.add(label_name);
		topPanel.add(text_name);
		topPanel.add(label_addr);
		topPanel.add(text_addr);
		topPanel.add(btn_add);
		//버튼에 Action command 지정
		btn_add.setActionCommand("add");
		btn_add.addActionListener(this);
		
		//회원 목록을 출력할 테이블
		table=new JTable();
		//칼럼명을 String[] 에 순서대로 준비하기
		String[] colName= {"번호","이름","주소"};
		//테이블에 연결할 기본 모델 객체
		model=new DefaultTableModel(colName, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+"|"+column);
				//번호만 수정 불가하게 하려면 여기를 어떻게 코딩하면 될까요?
				if(column == 0 ) { // 0번째 칼럼("번호" 칼럼)
					return false; // 수정 불가하게
				} else { // 나머지 칼럼은 
					return true; // 수정 가능하게
				}
			}
		};
		//모델은 테이블에 연결하기
		table.setModel(model);
		//테이블의 내용이 scroll 될 수 있도록 스크롤 페널로 감싼다
		JScrollPane scPane=new JScrollPane(table);
		//스크롤 페널을 프레임의 중앙에 배치하기
		add(scPane, BorderLayout.CENTER);
		//회원 목록을 테이블에 출력하기
		printMember();
		
		//삭제버튼
		JButton btn_delete=new JButton("삭제");
		btn_delete.addActionListener(this);
		btn_delete.setActionCommand("delete");

		//삭제 버튼을 상단 페널에 추가
		topPanel.add(btn_delete);
		//회원 목록을 주기적으로 업데이트 해주는 스레드 시작 시키기
//		new UpdateThread().start();
		
		//테이블에서 수정된 데이터가 실제로 DB에도 바뀌게 하도록하는 메소드, 
		//여기서 this는 PropertyChangeListener
		table.addPropertyChangeListener(this);
	}
	
	//회원 목록을 테이블에 출력하는 메소드
	public void printMember() {
		
		
		//회원 목록을 불러오기
		MemberDao dao=new MemberDao();
		List<MemberDto> list=dao.selectAll();
		//기존에 출력된 내용 초기화
				model.setRowCount(0); // 0개의 row로 강제로 초기화
		for(MemberDto tmp:list) {
			// {1, "김구라", "노량진"}
			Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(row);
		}
	}
	
	//메인 메소드
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame("회원 정보 관리");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command를 읽어온다
		String commandString=e.getActionCommand();
		if(commandString.equals("add")) { //추가 버튼을 눌렀을 때
			addMember(); // 밑의 메소드 호출
		} else if(commandString.equals("delete")) { //삭제 버튼을 눌렀을 때
			deleteMember();
		}
	}
	//회원 정보를 삭제하는 메소드
	public void deleteMember() {
		// 선택된 row 의 인덱스를 읽어온다.
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex == -1) {
			JOptionPane.showMessageDialog(this, "삭제할 row를 선택해주세요");
			return; // 메소드를 여기서 끝내라
		} 
		//선택한 row의 0 번 칼럼의 값(번호)을 읽어와서 int로 casting 하기
		int num=(int)table.getValueAt(selectedIndex, 0);
		//삭제하기 전에 한 번 확인하기
		int result=JOptionPane.showConfirmDialog(this, num+" 번 회원을 삭제할겨?");
		//만일 "yes" 를 눌렀을 때
		if(result == JOptionPane.YES_OPTION) {
			//MemberDao 객체를 이용해서 삭제하기
			new MemberDao().delete(num);
			//UI 업데이트 (목록 다시 출력하기)
			printMember();
		}
	}
	
	//회원 정보를 추가하는 메소드
	public void addMember() {
		//1. 입력한 이름과 주소를 읽어와서
		String name=text_name.getText();
		String addr=text_addr.getText();
		//2. MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//3. MemberDao 객체를 이용해서 DB에 저장
		MemberDao dao=new MemberDao();
		//작업의 성공여부를 isSuccess 에 담기
		boolean isSuccess=dao.insert(dto);
		//실제 저장되었는지 확인해보세요.
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, name+" 의 정보 추가 성공");
			//테이블에 다시 목록 불러오기
			printMember();
		} else {
			JOptionPane.showMessageDialog(this, "추가 실패");
		}
	}
	//화면을 주기적으로 update해주는 스레드
	class UpdateThread extends Thread {
		@Override
		public void run() {
			//바깥에 싸고있는 클래스의 멤버 메소드 printMember() 메소드를
			//5초마다 한 번 씩 주기적으로 호출하기
			while(true) {
				try {
					//3초 잠자다가
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//화면 업데이트
				printMember();
			}
		}
	}
	//table 칼럼이 수정중인지 여부
	boolean isEditing=false;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("change!");
		System.out.println(evt.getPropertyName());
		//만일 table 칼럼에서 발생한 이벤트라면
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				//수정된 row를 읽어와서 DB에 반영한다.
				int selectedIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String name=(String)model.getValueAt(selectedIndex, 1);
				String addr=(String)model.getValueAt(selectedIndex, 2);
				MemberDto dto=new MemberDto(num,name,addr);
				new MemberDao().update(dto);
			}
			//isEditing 의 값을 반대로 바꿔준다. true => false, false => true
			isEditing=!isEditing; // 수정중이라고 표기한다.
		}
	}
}
