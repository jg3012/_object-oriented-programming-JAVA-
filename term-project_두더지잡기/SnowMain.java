import java.awt.*;
import java.awt.event.*;

class SnowMain
{
	public static void main(String[] args) 
	{

		//SnowTest st = new SnowTest();
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					SnowTest st = new SnowTest("������ ���");
					st.setSize(800,600);
					st.setVisible(true);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
	}
}
