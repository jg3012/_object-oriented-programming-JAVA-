import javax.swing.*;
import java.awt.*;

class Intro extends JPanel{
	
	public Intro(){
		JLabel intro_label = new JLabel ("���̽�ũ�� ����", JLabel.CENTER) ;
		intro_label.setFont (new Font ("HY������M", Font.ITALIC, 50)) ;
		add(intro_label) ;
		setBackground(Color.pink);
	}		
}


