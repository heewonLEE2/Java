package pub2504.exgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// 과제 : GUI 메모장 프로그램 (V3, V4) ~ 7/6, 능력단위평가 대체

// [구조 변경] 
// 1) Memo.java 클래스 생성
// 2) Map<String, String>을 List<Memo> 구조로 변경
// 3) 파일 > 새메모, 열기, 저장 메뉴 구조를 파일 > 저장, 열기 구조로 변경

// [기능 추가]
// 1) 파일 > 저장 : 현재 메모 내용을 "C:\\pub2504\\files\\memo_년월일시분초.json"형태로 저장
// 2) 파일 > 열기 : 기존 메모파일을 열기  = JFileChooser

// [네트워크 버젼]
// Json Server에 memo.json 추가해서 네트워크 버젼 구현 (ExMemopad4.java)

public class ExMemoPad extends JFrame {

   private static final long serialVersionUID = 328940723948793L;

   private DefaultListModel<String> memoListModel = null;
   private JList<String> memoList = null;
   private JTextArea memoTextArea = null;
   private JTextField memoTextField = null;
   private List<Memo> memoClassList = new ArrayList<Memo>();;

   private void init() {

      setTitle("메모장 프로그램");
      setSize(800, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());

      JMenuBar jMenuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("파일");
      JMenu infoMenu = new JMenu("정보");
      JMenuItem fileMenuItemSave = new JMenuItem("저장");
      JMenuItem fileMenuItemOpen = new JMenuItem("열기");
      fileMenu.add(fileMenuItemSave);
      fileMenu.add(fileMenuItemOpen);
      jMenuBar.add(fileMenu);
      jMenuBar.add(infoMenu);

      JFrame jframe = this;

      // 메뉴바에 정보 클릭 이벤트추가
      infoMenu.addMenuListener(new MenuListener() {
         @Override
         public void menuSelected(MenuEvent e) {
            JLabel message = new JLabel("Copyright 2025 heewonLEE2");
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

      // 메뉴바에 저장 클릭 이벤트추가
      fileMenuItemSave.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            addFile();
         }
      });
      // 메뉴바에 열기 클릭 이벤트추가
      fileMenuItemOpen.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            openFolder();
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
      String memoContent = memoTextArea.getText().trim();

      // Title 이 비어있으면 제목 입력 메세지 출력
      if (memoTitle.isEmpty()) {
         JOptionPane.showMessageDialog(this, "메모 제목을 입력하세요.");
         return;
      }

      if (memoClassList.size() > 0) {
         // 동일한 제목 등록 불가
         if (memoClassList.stream().anyMatch(e -> e.getTitle().equals(memoTitle))) {
            JOptionPane.showMessageDialog(this, "메모 제목 중복입니다!");
            return;
         }
      }

      // 컨텐츠가 비어있지 않으면 클래스를 만들고 List 에 추가
      if (!memoContent.isEmpty()) {
         // 추가 메모 클래스 만든 다음에 List<Memo>에 추가
         memoClassList.add(new Memo(memoTitle, memoContent));

         // 메모리에도 추가
         memoListModel.addElement(memoTitle);

         // 등록후 text들 초기화
         memoTextArea.setText("");
         memoTextField.setText("");
         JOptionPane.showMessageDialog(this, "메모가 등록되었습니다.");
      } else {
         JOptionPane.showMessageDialog(this, "메모 내용을 입력하세요.");
      }
   } // addMemo()

   // 메모 수정 메서드
   private void editMemo() {
      int selectedIndex = memoList.getSelectedIndex();
      // 처음 title 제목으로 리스트에서 원하는 목록 바꾸기 위해 값을 일단 저장
      String firstTitle = memoListModel.get(selectedIndex);

      if (selectedIndex != -1) {
         String memoTitle = memoTextField.getText().trim();
         String memoContent = memoTextArea.getText().trim();

         if (memoTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "메모 제목을 입력하세요.");
            return;
         }
         if (!memoContent.isEmpty()) {

            // 데이터 동일한 인덱스부분의 내용을 변경하기
            memoListModel.set(memoListModel.indexOf(firstTitle), memoTitle);

            // List<Memo> 변경
            memoClassList.stream().filter(e -> e.getTitle().equals(firstTitle)).forEach(e -> {
               e.setTitle(memoTitle);
               e.setText(memoContent);
            });
            // List<Memo> 변경되었나 확인
            memoClassList.stream().forEach(System.out::println);

            JOptionPane.showMessageDialog(this, "메모가 수정되었습니다.");
         } else {
            JOptionPane.showMessageDialog(this, "메모 내용을 입력하세요.");
         }
      } else {
         JOptionPane.showMessageDialog(this, "수정할 메모를 선택하세요.");
      }
   } // editMemo()

   // 메모 삭제 메서드
   private void deleteMemo() {
      int selectedIndex = memoList.getSelectedIndex();
      if (selectedIndex != -1) {
         // Model (데이터)에 저장된 부분도 삭제
         String memoTitle = memoListModel.get(selectedIndex);
         memoListModel.remove(selectedIndex);

         // memoTitle 과 같은 타이틀을 리스트에서 삭제
         memoClassList.removeIf(e -> e.getTitle().equals(memoTitle));

         memoTextField.setText("");
         memoTextArea.setText("");
         JOptionPane.showMessageDialog(this, "메모가 삭제되었습니다.");
      } else {
         JOptionPane.showMessageDialog(this, "삭제할 메모를 선택하세요.");
      }
   } // deleteMemo()

   // 선택된 메모를 화면에 표시
   private void displaySelectedMemo() {
      int selectedIndex = memoList.getSelectedIndex();
      if (selectedIndex != -1) {
         String memoTitle = memoListModel.get(selectedIndex);
         memoTextField.setText(memoTitle);

         // 리스트에서 타이틀에 맞는 text 가져오기
         List<Memo> memoText = memoClassList.stream().filter(e -> e.getTitle().equals(memoTitle))
               .collect(Collectors.toList());
         memoTextArea.setText(memoText.get(0).getText());
      }
   } // displaySelectedMemo()

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
   } // addActionListener()

   // 패널에 버튼 추가
   private void addButtons(JPanel jpanel, JButton... jbuttons) {
      for (JButton jbutton : jbuttons) {
         jpanel.add(jbutton);
      }
   } // addButtons()

   // 파일 추가 관련 메소드
   BufferedWriter bw = null;
   
   // 현재 시간 가져오기
   LocalDateTime now = LocalDateTime.now();
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
   String time = now.format(formatter);

   // 파일 이름, gson
   File file = new File("C:\\heewon\\pub2504\\files\\memo_" + time + ".json");
   Gson gson = new GsonBuilder().setPrettyPrinting().create();

   // 파일 추가 메소드
   private void addFile() {

      try {
         bw = new BufferedWriter(new FileWriter(file));
         String jsonStr = gson.toJson(memoClassList);
         bw.write(jsonStr);
         bw.flush();

         JOptionPane.showMessageDialog(this, time + " 시간으로 파일이 저장되었습니다.");
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } finally {
         try {
            bw.close();
         } catch (IOException ioe) {
            ioe.printStackTrace();
         }
      }
   } // addFile

   // 파일이 저장되어 있는 폴더 열기
   private void openFolder() {
      // chooser 객체 생성
      JFileChooser chooser = new JFileChooser();
      // 디렉토리 설정
      chooser.setCurrentDirectory(new File("C:\\heewon\\pub2504"));
      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      chooser.showOpenDialog(null);

   }// openFolder()

   public static void main(String[] args) {
      new ExMemoPad().init();
   }

}
