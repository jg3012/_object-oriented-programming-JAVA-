import javax.swing.*;
import java.awt.*;

class Intro extends JPanel{
	
	public Intro(){
		JLabel intro_label = new JLabel ("아이스크림 계산기", JLabel.CENTER) ;
		intro_label.setFont (new Font ("HY헤드라인M", Font.ITALIC, 50)) ;
		add(intro_label) ;
		setBackground(Color.pink);
	}		
}


