package pub2504.exgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

// 실습 : GUI 메모장 프로그램 (V2)
// 메뉴UI 추가 : 파일(새메모, 열기, 저장), 정보
// 기능 추가
// 1) 정보메뉴 클릭시 "Copyright 2025 여러분아이디" 메세지창 보여주기
// 2) 메모제목 추가 : 우측 내용편집영역을 메모제목과 메모내용으로 분리
//                        (좌측 메모리스트에는 메모제목만 보여줌)

public class ExMemoPad2 extends JFrame {

	private static final long serialVersionUID = 328940723948793L;

	private DefaultListModel<String> memoListModel = null;
	private JList<String> memoList = null;
	private JTextArea memoTextArea = null;
	private JTextField memoTextField = null;
	private Map<String, String> memoMap = null;

	private void init() {

		memoMap = new HashMap<String, String>();

		setTitle("메모장 프로그램");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JMenuBar jMenuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		JMenu infoMenu = new JMenu("정보");
		JMenuItem fileMenuItemNew = new JMenuItem("새메모");
		JMenuItem fileMenuItemOpen = new JMenuItem("열기");
		JMenuItem fileMenuItemSave = new JMenuItem("저장");
		fileMenu.add(fileMenuItemNew);
		fileMenu.add(fileMenuItemOpen);
		fileMenu.add(fileMenuItemSave);
		jMenuBar.add(fileMenu);
		jMenuBar.add(infoMenu);

		JFrame jframe = this;

		infoMenu.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				JLabel message = new JLabel("Copyright 2025 Realchoky");
				message.setHorizontalAlignment(SwingConstants.CENTER);
				JOptionPane.showMessageDialog(jframe, message);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuCanceled(MenuEvent e) {
			}
		});

		memoListModel = new DefaultListModel<String>();
		memoList = new JList<String>(memoListModel);
		memoList.setPreferredSize(new Dimension(250, 600));
		memoList.setBackground(Color.GRAY);
		memoList.setFont(new Font("굴림", Font.BOLD, 20));
		memoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane listScrollPane = new JScrollPane(memoList);

		memoTextArea = new JTextArea();
		memoTextArea.setBackground(Color.BLACK);
		memoTextArea.setForeground(Color.WHITE);
		memoTextArea.setFont(new Font("굴림", Font.BOLD, 20));
		JScrollPane textScrollPane = new JScrollPane(memoTextArea);

		JPanel centerPanel = new JPanel(new BorderLayout());
		memoTextField = new JTextField();
		memoTextField.setBackground(Color.BLACK);
		memoTextField.setForeground(Color.WHITE);
		memoTextField.setFont(new Font("굴림", Font.BOLD, 20));
		centerPanel.add(memoTextField, BorderLayout.NORTH);
		centerPanel.add(textScrollPane, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		JButton addButton = new JButton("메모 등록");
		JButton editButton = new JButton("메모 수정");
		JButton deleteButton = new JButton("메모 삭제");

		addButtons(buttonPanel, addButton, editButton, deleteButton);

		addActionListener(addButton, editButton, deleteButton);

		memoList.addListSelectionListener(e -> displaySelectedMemo());

		add(jMenuBar, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		add(listScrollPane, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	// 메모 등록 메소드
	private void addMemo() {
		String memoTitle = memoTextField.getText().trim();
		if (memoTitle.isEmpty()) {
			JOptionPane.showMessageDialog(this, "메모 제목을 입력하세요.");
			return;
		}

		// 동일한 제목 등록 불가
		if (memoMap.containsKey(memoTitle)) {
			JOptionPane.showMessageDialog(this, "메모 제목 중복입니다.!");
			return;
		}

		String memoContent = memoTextArea.getText().trim();
		if (!memoContent.isEmpty()) {
			memoMap.put(memoTitle, memoContent);
			memoListModel.addElement(memoTitle);
			JOptionPane.showMessageDialog(this, "메모가 등록되었습니다.");
		} else {
			JOptionPane.showMessageDialog(this, "메모 내용을 입력하세요.");
		}
	}

	// 메모 수정 메서드
	private void editMemo() {
		int selectedIndex = memoList.getSelectedIndex();
		if (selectedIndex != -1) {
			String memoTitle = memoTextField.getText().trim();
			if (memoTitle.isEmpty()) {
				JOptionPane.showMessageDialog(this, "메모 제목을 입력하세요.");
				return;
			}
			String memoContent = memoTextArea.getText().trim();
			if (!memoContent.isEmpty()) {
				memoMap.put(memoTitle, memoContent);
				JOptionPane.showMessageDialog(this, "메모가 수정되었습니다.");
			} else {
				JOptionPane.showMessageDialog(this, "메모 내용을 입력하세요.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "수정할 메모를 선택하세요.");
		}
	}

	// 메모 삭제 메서드
	private void deleteMemo() {
		int selectedIndex = memoList.getSelectedIndex();
		if (selectedIndex != -1) {
			memoMap.remove(memoListModel.get(selectedIndex));
			memoListModel.remove(selectedIndex);
			memoTextField.setText("");
			memoTextArea.setText("");
			JOptionPane.showMessageDialog(this, "메모가 삭제되었습니다.");
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 메모를 선택하세요.");
		}
	}

	// 선택된 메모를 화면에 표시
	private void displaySelectedMemo() {
		int selectedIndex = memoList.getSelectedIndex();
		if (selectedIndex != -1) {
			String memoTitle = memoListModel.get(selectedIndex);
			memoTextField.setText(memoTitle);
			memoTextArea.setText(memoMap.get(memoTitle));
		}
	}

	// 버튼에 리스너 추가
	private void addActionListener(JButton... jbuttons) {
		for (JButton jbutton : jbuttons) {
			jbutton.addActionListener(e -> {
				switch (((JButton) e.getSource()).getText()) {
				case "메모 등록":
					addMemo();
					break;
				case "메모 수정":
					editMemo();
					break;
				case "메모 삭제":
					deleteMemo();
				}
			});
		}
	}

	// 패널에 버튼 추가
	private void addButtons(JPanel jpanel, JButton... jbuttons) {
		for (JButton jbutton : jbuttons) {
			jpanel.add(jbutton);
		}
	}

	public static void main(String[] args) {
		new ExMemoPad2().init();
	}

}
