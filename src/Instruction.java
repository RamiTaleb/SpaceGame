import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Instruction extends JFrame implements ActionListener{
	
	public JButton returnButton;
	
	public Instruction(){
		
		super("Instructions");
		setSize(425, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		JLabel textLabel = new JLabel("                    Movement: ARROW KEYS");
		textLabel.setSize(600, 30);
		textLabel.setLocation(0,80);
		add(textLabel);
		JLabel textLabel1 = new JLabel("                    Firing: SPACEBAR");
		textLabel1.setSize(600, 30);
		textLabel1.setLocation(0,110);
		add(textLabel1);
		JLabel textLabel2 = new JLabel("                    Small/Big Yellow Powerup: +1/+2 Power");
		textLabel2.setSize(600, 30);
		textLabel2.setLocation(0,140);
		add(textLabel2);
		JLabel textLabel3 = new JLabel("                    Small/Big Pink Powerup: +1/+2 Lives");
		textLabel3.setSize(600, 30);
		textLabel3.setLocation(0,170);
		add(textLabel3);
		JLabel textLabel4 = new JLabel("                    White Powerup: Slowdown Time");
		textLabel4.setSize(600, 30);
		textLabel4.setLocation(0,200);
		add(textLabel4);
		JLabel textLabel5 = new JLabel("                    Blue Powerup: Freeze Time");
		textLabel5.setSize(600, 30);
		textLabel5.setLocation(0,230);
		add(textLabel5);
		JLabel textLabel6 = new JLabel("                    Pink Powerup: Shield");
		textLabel6.setSize(600, 30);
		textLabel6.setLocation(0,260);
		add(textLabel6);
				
		returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setSize(425, 30);
		returnButton.setLocation(0,370);
		add(returnButton);
		
	}
	
public static void main(String[] args) {
		new Instruction();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == returnButton){
			setVisible(false);
		}
		
	}

}
