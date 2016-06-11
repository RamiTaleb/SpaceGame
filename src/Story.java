import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Story extends JFrame implements ActionListener{
	
	public JButton returnButton;
	
	public Story(){
		
		super("Story");
		setSize(425, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		JLabel textLabel = new JLabel("It is the year 2107. You have been selected to go on a mission to save the ");
		textLabel.setSize(425, 30);
		textLabel.setLocation(5,0);
		add(textLabel);
		
		JLabel textLabel1 = new JLabel("astronauts who have been taken hostage by the Zergs on the ");
		textLabel1.setSize(425, 30);
		textLabel1.setLocation(5,15);
		add(textLabel1);
		
		JLabel textLabel2 = new JLabel("International Space Station. It is your job to take out the Zergs that are");
		textLabel2.setSize(425, 30);
		textLabel2.setLocation(5,30);
		add(textLabel2);
		
		JLabel textLabel3 = new JLabel("surrounding the area. They are very dangerous so you should not allow");
		textLabel3.setSize(425, 30);
		textLabel3.setLocation(5,45);
		add(textLabel3);
		
		JLabel textLabel4 = new JLabel("them to hit into you. You have been equipped with an upgradable machine ");
		textLabel4.setSize(425, 30);
		textLabel4.setLocation(5,60);
		add(textLabel4);
		
		JLabel textLabel5 = new JLabel("gun that can eliminate the Zergs. Watch out though; Zergs come in ");
		textLabel5.setSize(425, 30);
		textLabel5.setLocation(5,75);
		add(textLabel5);
		
		JLabel textLabel6 = new JLabel("different sizes and speeds. Their strength is marked by their colour. ");
		textLabel6.setSize(425, 30);
		textLabel6.setLocation(5,90);
		add(textLabel6);
		
		JLabel textLabel7 = new JLabel("Green, Blue, Red, Yellow are the colours of Zergs in increasing strength.");
		textLabel7.setSize(425, 30);
		textLabel7.setLocation(5,105);
		add(textLabel7);
		
		JLabel textLabel8 = new JLabel("After destroying some Zergs they may drop plasma cubes which can");
		textLabel8.setSize(425, 30);
		textLabel8.setLocation(5,120);
		add(textLabel8);
		
		JLabel textLabel9 = new JLabel("help you get the upper hand on the Zergs. ");
		textLabel9.setSize(425, 30);
		textLabel9.setLocation(5,135);
		add(textLabel9);
		
		returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setSize(425, 30);
		returnButton.setLocation(0,370);
		add(returnButton);
	}
	
public static void main(String[] args) {
		new Story();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == returnButton){
			setVisible(false);
		}		
	}
}
