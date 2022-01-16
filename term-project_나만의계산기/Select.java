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
	String[] flav = {"����", "����", "����","�ٴҶ�","���Ʈ", "ġ��","��纣��","����Ʈ","ü��", "��Ʈ"};
	String pricelabel;
	Color BLUE = new Color(200, 200, 255);
	Color GREEN = new Color(200, 255, 200);
	private int price = 0, totalprice = 0;
	private int countChecked = 0;
	private int selectedsize = 0;

	public Select(){
		setLayout(new BorderLayout());
		
		// tab panel ����
		tabpane = new JTabbedPane () ;
		
		// ù���� ������ ��
		JPanel sizeP = new JPanel();
		sizeP.setLayout(new GridLayout(3,1,30,30));
		topPanel = new JPanel();
		JLabel label = new JLabel("���̽�ũ���� ����� �������ּ���");
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
		text = new JLabel("����� ���õ��� �ʾҽ��ϴ�.");
		text.setForeground(Color.red);
		resultPanel.add(text);
		sizeP.add(resultPanel);
		sizeP.setBackground(BLUE);
				
		// �ι�° �� ��
		JPanel flavor = new JPanel () ;
		flavor.setLayout(new GridLayout(2,5,10,10));
		for (int i = 0;i < 10 ;i++ )
		{
			buttons[i] = new JCheckBox(flav[i]);
			flavor.add(buttons[i]);
			buttons[i].addItemListener(this);
		}
		
		flavor.setBackground(BLUE);
		
		// ����° ���� ��
		JPanel take = new JPanel () ;
		take.setLayout(new GridLayout(1,2,10,10));
		ButtonGroup takebutton = new ButtonGroup();
		to = new JRadioButton("�������Կ�");
		ti = new JRadioButton("�԰��Կ�");
		to.addItemListener(this);
		ti.addItemListener(this);
		JPanel buttonP = new JPanel();
		buttonP.setLayout(new GridLayout(2,1,30,30));
		addcart = new JButton("�߰��ϱ�");
		pay = new JButton("�����ϱ�");
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

		tabpane.addTab("������", sizeP) ;
		tabpane.addTab("��", flavor) ;
		tabpane.addTab("����", take) ;
		add(tabpane,BorderLayout.CENTER);

		JPanel payment = new JPanel();
		payment.setLayout(new GridLayout(2,1,10,10));
		ta = new JTextArea("<��ǰ ����>"+"\n",5,15);
		ta2 = new JTextArea("<��ü ����>"+"\n",5,15);
		ta.setFont (new Font ("HY������M", Font.PLAIN, 20));
		ta2.setFont (new Font ("HY������M", Font.PLAIN, 20));
		payment.add(ta);
		payment.add(ta2);
		payment.setBackground(GREEN);
		add(payment,BorderLayout.EAST);
	}

	//�̺�Ʈ ó��
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == small){
			text.setText("Small����� ���õǾ����ϴ�." +"\n"+ "3���� �� ���� ����");
			selectedsize = 3;
			pricelabel = "3000";
			price = 3000;
		} else if(e.getSource() == medium){
			text.setText("medium����� ���õǾ����ϴ�." +"\n"+ "4���� �� ���� ����");
			selectedsize = 4;
			pricelabel = "4000";
			price = 4000;
		} else if(e.getSource() == large){
			text.setText("large����� ���õǾ����ϴ�."+"\n"+ "5���� �� ���� ����");
			selectedsize = 5;
			pricelabel = "5000";
			price = 5000;
		}
		if(e.getSource() == addcart){
			if(selectedsize == 0){
				JOptionPane.showMessageDialog(null,  "���� ��ǰ�� �������ּ���.", "��ǰ ����", JOptionPane.WARNING_MESSAGE);
			} else{
				ta.append(pricelabel+"��"+"\n");
				totalprice += price;
				selectedsize = 0;
			}
		}
		if(e.getSource() == pay){
			if(totalprice == 0){
				JOptionPane.showMessageDialog(null, "���� ��ǰ�� �߰����ּ���.", "��ǰ �߰�", JOptionPane.WARNING_MESSAGE);
			} else{
				ta2.setText("<��ü ����>"+"\n"+Integer.toString(totalprice)+"��");
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
				JOptionPane.showMessageDialog(null, "���� ����� �������ּ���.", "������ ����", JOptionPane.WARNING_MESSAGE);
			} else if(countChecked > selectedsize){
				JOptionPane.showMessageDialog(null, "��� �����Ͽ����ϴ�."+"\n"+"�������� �������ּ���.", "�� ���� �Ϸ�", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}


