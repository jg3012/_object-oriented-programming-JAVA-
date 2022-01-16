import java.awt.*;
import javax.swing.*;

public class MyCal extends JFrame{
	
	JPanel intro = new Intro();
	JPanel select = new Select();
		
	public MyCal(String title){
		super(title);
		setLayout(new BorderLayout(5,5));
		add(select,BorderLayout.CENTER);
		add(intro,BorderLayout.NORTH);
		setSize(1200,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
