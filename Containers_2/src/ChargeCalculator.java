import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChargeCalculator extends JFrame{
	
	private JPanel panel=new JPanel();
	private JButton button=new JButton("Calculate Charge");
	private Ship ship;
	
	public ChargeCalculator(Ship aShip) {
		
		panel.add(button);
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		this.setSize(400,400);
		this.setVisible(true);
		this.setTitle("Charge Calculator");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		
		double total = ship.calcTotalCharge();

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}

}
