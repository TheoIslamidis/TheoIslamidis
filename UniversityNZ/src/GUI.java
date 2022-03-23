import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	//Step 1 creating Panel
	private JPanel panel;
	
	//Step 2
	private JTextField nameField,idField;
	private JButton createStudentButton;
	private JTextField courseField;
	private JButton printCourseDetailsButton;
	
	ArrayList<Course> courses =new ArrayList<Course>();

	public GUI() {
		
		courses.add(new Course("Java"));
		courses.add(new Course("Python"));
		courses.add(new Course("C++"));
		courses.add(new Course("Javascript"));

		
		panel = new JPanel();
		
		nameField = new JTextField("Enter the name");
		idField= new JTextField("Enter the id");
		createStudentButton = new JButton("Create Student");
		courseField = new JTextField("Enter a course");
		printCourseDetailsButton=new JButton("Print course details");
		
		
		//Step 3
		panel.add(nameField);
		panel.add(idField);
		panel.add(createStudentButton);
		panel.add(courseField);
		panel.add(printCourseDetailsButton);
		
		//Step 4
		this.setContentPane(panel);
		
		//Step 3 create listener object
		ButtonListener listener = new ButtonListener();
		//Step 4 connect listener with events
		createStudentButton.addActionListener(listener);
		printCourseDetailsButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Student form");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//Step 1 for Event Listener
	class ButtonListener implements ActionListener{
		//Step 2 executable code
		public void actionPerformed(ActionEvent e) {
			String name=nameField.getText();
			String id=idField.getText();
			
			Student s = new Student(name,id);
			
			System.out.println("A Student has been successfully created!");
			String courseName =courseField.getText();
			
			for(Course course:courses) {
				if(courseName.equals(course.getTitle())) {
					course.addStudent(s);
				}
			}
		}
	}
	

}
