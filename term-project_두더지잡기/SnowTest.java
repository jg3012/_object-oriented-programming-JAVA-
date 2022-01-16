import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class SnowTest extends JFrame implements ActionListener,Runnable{
	JPanel TotalPanel, BoardPanel, MenuPanel;
	JButton start, pause, resume;
	ImageIcon in = new ImageIcon("in.png");
	ImageIcon out = new ImageIcon("out.png");
	JButton noon[] = new JButton[9];
	JLabel timeL, scoreL, blankL;
	Font font;
	Thread ths, t;

	private int level = 1;
	private int time = 0;
	private int score = -10;
	private int rand = 0;


	public SnowTest (String title){
		super(title);
		this.init();
		this.start();
		
		}
	public void init(){
		font = new Font("HY헤드라인M", Font.BOLD,20);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		BoardPanel = new JPanel();
		BoardPanel.setLayout(new GridLayout(3,3));
		
		for (int i = 0; i < 9; i++) {
			noon[i] = new JButton();
			noon[i].setIcon(in);
			BoardPanel.add(noon[i]);
		}
		noon[4].setIcon(out);

		MenuPanel = new JPanel();
		MenuPanel.setLayout(new GridLayout(6,1));
		timeL = new JLabel("남은 시간 : " + time+" ");
		scoreL = new JLabel("점수 : 0 ");
		blankL = new JLabel(" ");
		start = new JButton("시작하기");
		pause = new JButton("일시정지");
		resume = new JButton("다시시작");
		timeL.setFont(font);
		scoreL.setFont(font);
		start.setFont(font);
		pause.setFont(font);
		resume.setFont(font);
		
		pause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ths.suspend();
			}
		});
		resume.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ths.resume();
			}
		});
		
		MenuPanel.add(timeL);
		MenuPanel.add(scoreL);
		MenuPanel.add(blankL);
		MenuPanel.add(start);
		MenuPanel.add(pause);
		MenuPanel.add(resume);

		c.add("Center", BoardPanel);
		c.add("East",MenuPanel);
	}
	
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.addActionListener(this);
		for(int i=0; i<9; ++i){
			noon[i].setText(i+"");
			noon[i].addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e) {
		ths = new Thread(this);
		t = new Thread();
		if (e.getSource() == start){
			noon[4].setIcon(in);
			time = 30;
			timeL.setText("남은 시간 : " + time+" ");
			ths.start();
			random(0);
		}
		for(int i=0; i<9; ++i){
			if (e.getSource() == noon[i]){
			random(i);
			}
		}
		
	}
		public void random(int i){
			if(i != rand) return;
			noon[rand].setIcon(in);
			rand = (int)(Math.random()*9);
			noon[rand].setIcon(out);
			score+=10;
			scoreL.setText("점수 : " +score+" ");
	}

	public void run() {
		int time = 30;
		while(true){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
			time--;
			if (time == 0) {
				break;
			}
			timeL.setText("남은 시간 : "+time);
		}
	}	

}