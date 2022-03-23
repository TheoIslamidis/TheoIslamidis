import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
	
	public GUI() {
		
		Board board = new Board();
		this.setContentPane(board);
		this.setVisible(true);
		this.setSize(400,400);
	}
	
class Board extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int sqSize1= this.getWidth()/8;
		int sqSize2= this.getHeight()/8;
		
		int sqSize=sqSize1;
		if(sqSize2<sqSize1) {
			sqSize=sqSize2;
		}
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				int x=j*sqSize;
				int y=i*sqSize;
				g.drawRect(x,y,sqSize,sqSize);
				if((i+j)%2 !=0) {
					g.fillRect(x,y,sqSize,sqSize);
				}
			}
		}
	}
	
	
}
	

}
