import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class NoonSong extends JFrame implements ActionListener{
	ImageIcon back, noonsong;
	JButton click;
	JPanel jp;

	public NoonSong(){
		super("눈송이 잡기 시작");
		setSize(800,800);
		setVisible(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		click = new JButton("Click!");
		click.setFont(new Font("HY헤드라인M", Font.BOLD+Font.ITALIC,30));
		click.addActionListener(this);
		add("South",click);
		
		
	}
	public void paint(Graphics g){
		back = new ImageIcon("noonsong.png");
		
		g.drawImage(back.getImage(),0,30,null);
	}
	public void actionPerformed(ActionEvent e){
		setVisible(false);
		new SnowTest("눈송이 잡기");
	}
	

}