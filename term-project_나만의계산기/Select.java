import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Select extends JPanel implements ActionListener, ItemListener{
	JTabbedPane		tabpane;
	JButton			addcart,pay;
	JRadioButton	small, medium, large, to, ti;
	JLabel			text;
	JPanel			topPanel,sizePanel, resultPanel;
	JTextArea		ta,ta2;
	JCheckBox[] buttons = new JCheckBox[10];
	String[] flav = {"초코", "딸기", "녹차","바닐라","요거트", "치즈","블루베리","샤베트","체리", "민트"};
	String pricelabel;
	Color BLUE = new Color(200, 200, 255);
	Color GREEN = new Color(200, 255, 200);
	private int price = 0, totalprice = 0;
	private int countChecked = 0;
	private int selectedsize = 0;

	public Select(){
		setLayout(new BorderLayout());
		
		// tab panel 생성
		tabpane = new JTabbedPane () ;
		
		// 첫번쩨 사이즈 탭
		JPanel sizeP = new JPanel();
		sizeP.setLayout(new GridLayout(3,1,30,30));
		topPanel = new JPanel();
		JLabel label = new JLabel("아이스크림의 사이즈를 선택해주세요");
		topPanel.add(label);
		sizeP.add(topPanel);
		sizePanel = new JPanel();
		small = new JRadioButton("Small Size");
		medium = new JRadioButton("Medium Size");
		large = new JRadioButton("Large Size");
		ButtonGroup size = new ButtonGroup();
		size.add(small);
		size.add(medium);
		size.add(large);
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);

		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		sizeP.add(sizePanel);
		resultPanel = new JPanel();
		text = new JLabel("사이즈가 선택되지 않았습니다.");
		text.setForeground(Color.red);
		resultPanel.add(text);
		sizeP.add(resultPanel);
		sizeP.setBackground(BLUE);
				
		// 두번째 맛 탭
		JPanel flavor = new JPanel () ;
		flavor.setLayout(new GridLayout(2,5,10,10));
		for (int i = 0;i < 10 ;i++ )
		{
			buttons[i] = new JCheckBox(flav[i]);
			flavor.add(buttons[i]);
			buttons[i].addItemListener(this);
		}
		
		flavor.setBackground(BLUE);
		
		// 세번째 포장 탭
		JPanel take = new JPanel () ;
		take.setLayout(new GridLayout(1,2,10,10));
		ButtonGroup takebutton = new ButtonGroup();
		to = new JRadioButton("가져갈게요");
		ti = new JRadioButton("먹고갈게요");
		to.addItemListener(this);
		ti.addItemListener(this);
		JPanel buttonP = new JPanel();
		buttonP.setLayout(new GridLayout(2,1,30,30));
		addcart = new JButton("추가하기");
		pay = new JButton("결제하기");
		addcart.addActionListener(this);
		pay.addActionListener(this);
		buttonP.add(addcart);
		buttonP.add(pay);
		
		takebutton.add(to);
		takebutton.add(ti);
		take.add(to);
		take.add(ti);
		take.add(buttonP);
		take.setBackground(BLUE);

		tabpane.addTab("사이즈", sizeP) ;
		tabpane.addTab("맛", flavor) ;
		tabpane.addTab("포장", take) ;
		add(tabpane,BorderLayout.CENTER);

		JPanel payment = new JPanel();
		payment.setLayout(new GridLayout(2,1,10,10));
		ta = new JTextArea("<상품 가격>"+"\n",5,15);
		ta2 = new JTextArea("<전체 가격>"+"\n",5,15);
		ta.setFont (new Font ("HY헤드라인M", Font.PLAIN, 20));
		ta2.setFont (new Font ("HY헤드라인M", Font.PLAIN, 20));
		payment.add(ta);
		payment.add(ta2);
		payment.setBackground(GREEN);
		add(payment,BorderLayout.EAST);
	}

	//이벤트 처리
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == small){
			text.setText("Small사이즈가 선택되었습니다." +"\n"+ "3가지 맛 선택 가능");
			selectedsize = 3;
			pricelabel = "3000";
			price = 3000;
		} else if(e.getSource() == medium){
			text.setText("medium사이즈가 선택되었습니다." +"\n"+ "4가지 맛 선택 가능");
			selectedsize = 4;
			pricelabel = "4000";
			price = 4000;
		} else if(e.getSource() == large){
			text.setText("large사이즈가 선택되었습니다."+"\n"+ "5가지 맛 선택 가능");
			selectedsize = 5;
			pricelabel = "5000";
			price = 5000;
		}
		if(e.getSource() == addcart){
			if(selectedsize == 0){
				JOptionPane.showMessageDialog(null,  "먼저 상품을 선택해주세요.", "상품 선택", JOptionPane.WARNING_MESSAGE);
			} else{
				ta.append(pricelabel+"원"+"\n");
				totalprice += price;
				selectedsize = 0;
			}
		}
		if(e.getSource() == pay){
			if(totalprice == 0){
				JOptionPane.showMessageDialog(null, "먼저 상품을 추가해주세요.", "상품 추가", JOptionPane.WARNING_MESSAGE);
			} else{
				ta2.setText("<전체 가격>"+"\n"+Integer.toString(totalprice)+"원");
			}
		}
	}

	public void itemStateChanged(ItemEvent ie){
		if(ie.getSource().getClass() == JCheckBox.class) {
			for(int i=0; ie.getSource() == flav[i]; i++){
				ta.append(flav[i]+"\n");
			}
			
			if(ie.getStateChange() == ie.SELECTED)
				countChecked++;
			else if(ie.getStateChange() == ie.DESELECTED)
			    countChecked--;
			
			if(selectedsize == 0){
				JOptionPane.showMessageDialog(null, "먼저 사이즈를 선택해주세요.", "사이즈 선택", JOptionPane.WARNING_MESSAGE);
			} else if(countChecked > selectedsize){
				JOptionPane.showMessageDialog(null, "모두 선택하였습니다."+"\n"+"포장방법을 선택해주세요.", "맛 선택 완료", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}


