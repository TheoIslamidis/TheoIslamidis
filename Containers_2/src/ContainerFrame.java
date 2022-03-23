import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContainerFrame extends JFrame{
	
	private JPanel panel= new JPanel();
	private JPanel fieldPanel = new JPanel();
	private JTextField codeField,destinationField,weightField,powerField;
	private JButton createBulkButton,createRefrButton;
	private JList shipList;
	private ArrayList<Ship> ships;
	
	public ContainerFrame(ArrayList<Ship> someShips) {
		
		ships=someShips;
		
		panel.setLayout(new BorderLayout());
		
		fieldPanel.setLayout(new GridLayout(0,2));
		
		codeField = new JTextField("Code");
		destinationField = new JTextField("Destination");
		weightField = new JTextField("Weight");
		powerField = new JTextField("Power");
		createBulkButton = new JButton("Create Bulk");
		createRefrButton = new JButton("Create Refridgerator");
		shipList = new JList();
		
		DefaultListModel<String> model = new DefaultListModel<>();
		for(Ship ship:ships) {
			model.addElement(ship.getName());
		}
		
		shipList.setModel(model);
		
		fieldPanel.add(codeField);
		fieldPanel.add(destinationField);
		fieldPanel.add(weightField);
		fieldPanel.add(powerField);
		fieldPanel.add(createBulkButton);
		fieldPanel.add(createRefrButton);
		
		panel.add(fieldPanel,BorderLayout.CENTER);
		panel.add(shipList,BorderLayout.SOUTH);
		
		this.setContentPane(panel);
		
		ButtonListenerBulk listener1 = new ButtonListenerBulk();
		createBulkButton.addActionListener(listener1);
		
		ButtonListenerRefr listener2 = new ButtonListenerRefr();
		createRefrButton.addActionListener(listener2);

		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Create Containers");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListenerBulk implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String code = codeField.getText();
			String destination = destinationField.getText();
			
			String weightText = weightField.getText();
			double weight = Double.parseDouble(weightText);
			
			Container bulk = new Bulk(code,destination,weight);
			
			String selectedShipName = (String)shipList.getSelectedValue();
			Ship selectedShip = null;
			for(Ship ship:ships) {
				if(ship.getName().equals(selectedShipName)) {
					selectedShip=ship;
				}
			}
			selectedShip.loadContainer(bulk);
			System.out.println("Container loaded on ship "+selectedShipName);
			System.out.println("Total charge for "+selectedShipName + " is:"+selectedShip.calcTotalCharge());
		}
		
		
	}
	class ButtonListenerRefr implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String code = codeField.getText();
			String destination = destinationField.getText();
			
			String powerText = powerField.getText();
			double power = Double.parseDouble(powerText);
			
			Container refridgerator = new Refridgerator(code,destination,power);
			
			String selectedShipName = (String)shipList.getSelectedValue();
			Ship selectedShip = null;
			for(Ship ship:ships) {
				if(ship.getName().equals(selectedShipName)) {
					selectedShip=ship;
				}
			}
			selectedShip.loadContainer(refridgerator);
			System.out.println("Container loaded on ship "+selectedShipName);
			System.out.println("Total charge for "+selectedShipName + " is:"+selectedShip.calcTotalCharge());
		}
		
	}

}
