import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.File;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener{
	
	public JButton startButton, instructionButton, storyButton ,quitButton;
	
	public static void main(String[] args) {
        new Menu();
       
	}

	public Menu(){
		Font g = new Font("Arial", Font.BOLD, 16);
		
		startButton = new JButton("Start Game");
		startButton.setFont(g);
		startButton.addActionListener(this);
		startButton.setBackground(Color.BLACK);
		add(startButton);
		storyButton = new JButton("Story");
		storyButton.setFont(g);
		storyButton.addActionListener(this);
		storyButton.setBackground(Color.BLACK);
		add(storyButton);
		instructionButton = new JButton("Instructions");
		instructionButton.setFont(g);
		instructionButton.addActionListener(this);
		instructionButton.setBackground(Color.BLACK);
		add(instructionButton);
		quitButton = new JButton("Quit Game");
		quitButton.setFont(g);
		quitButton.addActionListener(this);
		quitButton.setBackground(Color.BLACK);
		add(quitButton);	
		
		setTitle("Rami Taleb's Game");
		setSize(425, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,4));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		super.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton){
			setVisible(false);
			new Game();
		}
		if(e.getSource() == instructionButton){
			new Instruction();
		}
		if(e.getSource() == storyButton){
			new Story();
		}
		
		if(e.getSource() == quitButton){
			System.exit(0);
		}
	}
	
}
	
	


