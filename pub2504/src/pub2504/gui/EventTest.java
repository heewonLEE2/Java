package pub2504.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class EventTest {

	public static void main(String[] args) {

		// Component 라는 타이틀을 가진 JFrame 생성
		JFrame frame = new JFrame("Event");

		// X 버튼 누르면 닫히도록 하는 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JFrame 사이즈 (가로 600px, 세로 400px)
		frame.setSize(600, 600);

		// 탭패널 생성
		JTabbedPane tabbedPane = new JTabbedPane();

		// ActionListener : 액션이벤트 (마우스클릭 등등...) 처리
		JPanel actionListenerPanel = new JPanel();
		JButton actionButton = new JButton("클릭");
		JLabel actionLabel = new JLabel("상태 : 클릭대기중");

		// 이벤트리스너 추가법 1) ActionListener 구현
		actionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getSource()); // 이벤트 타겟 객체
				System.out.println(e.getActionCommand()); // 클릭된 버튼의 텍스트
				System.out.println(e.getID()); // 이벤트 아이디
				System.out.println(e.getClass()); // 이벤트 클래스
				actionLabel.setText("상태 : 버튼 클릭됨!");
			}
		});

		// 이벤트리스너 추가법 2) Lambda 사용
		// actionButton.addActionListener(e -> actionLabel.setText("상태 : 버튼 클릭됨!"));

		actionListenerPanel.add(actionButton);
		actionListenerPanel.add(actionLabel);
		tabbedPane.addTab("ActionListener", actionListenerPanel);

		// MouseListener : 마우스 이벤트 처리
		JPanel mouseListenerPanel = new JPanel();
		JLabel mouseLabel = new JLabel("마우스 상태 : 대기 중");

		mouseListenerPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseLabel.setText("마우스 상태 : 영역 안");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mouseLabel.setText("마우스 상태 : 영역 밖");
			}
		});

		mouseListenerPanel.add(mouseLabel);
		tabbedPane.addTab("MouseListener", mouseListenerPanel);

		// KeyListener : 키보드 이벤트 처리
		JPanel keyListenerPanel = new JPanel();
		JTextField keyField = new JTextField(20);
		JLabel keyLabel = new JLabel("키 입력 : 없음");

		keyField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyLabel.setText("키 입력 : " + e.getKeyChar());
			}

		});
		keyListenerPanel.add(keyField);
		keyListenerPanel.add(keyLabel);
		tabbedPane.addTab("KeyListener", keyListenerPanel);

		// FocusListener : 컴포넌트 포커스 처리
		JPanel focusListenerPanel = new JPanel();
		JTextField focusField1 = new JTextField("텍스트필드1", 10);
		JTextField focusField2 = new JTextField("텍스트필드2", 10);
		JLabel focusLabel = new JLabel("포커스 상태 : 없음");

		FocusListener focusListener = new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLabel.setText("포커스 상태 : 없음");
			}

			@Override
			public void focusGained(FocusEvent e) {
				focusLabel.setText("포커스 상태 : " + // getText() 를 가지고 있는 JTextField 로 형변환
						((JTextField) e.getSource()).getText() + "에 포커스");
			}
		};
		focusField1.addFocusListener(focusListener);
		focusField2.addFocusListener(focusListener);
		focusListenerPanel.add(focusField1);
		focusListenerPanel.add(focusField2);
		focusListenerPanel.add(focusLabel);
		tabbedPane.addTab("FocusListener", focusListenerPanel);

		// WindowListener : 윈도우 이벤트 처리
		JPanel windowListenerPanel = new JPanel();
		JLabel windowLabel = new JLabel("윈도우 상태: 대기 중");
		JFrame windowFrame = new JFrame("WindowListener 테스트");
		windowFrame.setSize(300, 200);

		windowFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				windowLabel.setText("윈도우 상태: 열림");
			}

			@Override
			public void windowClosing(WindowEvent e) {
				windowLabel.setText("윈도우 상태: 닫히는 중");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				windowLabel.setText("윈도우 상태: 닫힘");
			}
		});
		JButton openWindowButton = new JButton("새 창 열기");
		openWindowButton.addActionListener(e -> windowFrame.setVisible(true));
		windowListenerPanel.add(openWindowButton);
		windowListenerPanel.add(windowLabel);
		tabbedPane.addTab("WindowListener", windowListenerPanel);

		frame.add(tabbedPane);
		frame.setVisible(true);

	} // main
} // class
