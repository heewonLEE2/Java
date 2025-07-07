package practice;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ProjectGUI extends JFrame {

	public ProjectGUI() {
	}

	private void init() {

		setTitle("ProjectGUI");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// 탭패널 생성
		JTabbedPane tabbedPane = new JTabbedPane();

		// 이미지 Panel 생성
		try {
			// 이미지 파일 경로 설정
			File imageFile_1 = new File("C:\\Users\\Administrator\\Downloads\\donGGas.jpg");
			File imageFile_2 = new File("C:\\Users\\Administrator\\Downloads\\떡볶이.jpg");
			File imageFile_3 = new File("C:\\Users\\Administrator\\Downloads\\라면.jpg");

			// 이미지 파일 읽기
			Image image_1 = ImageIO.read(imageFile_1);
			Image image_2 = ImageIO.read(imageFile_2);
			Image image_3 = ImageIO.read(imageFile_3);
			// ImageIcon 생성
			ImageIcon imageIcon_1 = new ImageIcon(image_1);
			ImageIcon imageIcon_2 = new ImageIcon(image_2);
			ImageIcon imageIcon_3 = new ImageIcon(image_3);

			// JLabel 생성 및 이미지 설정
			JLabel imageLabel_1 = new JLabel(imageIcon_1);
			JLabel imageLabel_2 = new JLabel(imageIcon_2);
			JLabel imageLabel_3 = new JLabel(imageIcon_3);

			JPanel cardLayoutPanel = new JPanel(new CardLayout());
			CardLayout cardLayout = (CardLayout) cardLayoutPanel.getLayout();

			cardLayoutPanel.add(imageLabel_1, SwingConstants.CENTER);
			cardLayoutPanel.add(imageLabel_2, SwingConstants.CENTER);
			cardLayoutPanel.add(imageLabel_3, SwingConstants.CENTER);

			JPanel cardControlPanel = new JPanel(new FlowLayout());
			JButton nextButton = new JButton("다음 카드");
			// 버튼 누르면 다음 카드 나오도록 이벤트 처리
			nextButton.addActionListener(e -> cardLayout.next(cardLayoutPanel));
			cardControlPanel.add(nextButton);

			JPanel cardPanelContainer = new JPanel(new BorderLayout());
			cardPanelContainer.add(cardLayoutPanel, BorderLayout.CENTER);
			cardPanelContainer.add(cardControlPanel, BorderLayout.SOUTH);

			tabbedPane.add(cardPanelContainer, "사진");
		} catch (IOException e) {
			System.err.println("이미지 파일을 읽는 중 오류 발생: " + e.getMessage());
		}

		// 날씨 Panel 생성
		JPanel weatherPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		weatherPanel.add(new JLabel("메뉴 사진(gridheight = 2)"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		weatherPanel.add(new JLabel("weather 사진 (1,0)"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		weatherPanel.add(new JLabel("weather 정보 (1,1)"), gbc);

		tabbedPane.add(weatherPanel, "날씨");
		// tabPanel JFrame 에 붙히기
		add(tabbedPane);
		setVisible(true);
	} // init()

	public static void main(String[] args) {

		new ProjectGUI().init();

	} // main
} // class
