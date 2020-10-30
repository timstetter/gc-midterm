package library;
/*
* Tim Stetter
* Java 219 Section 70
* Prof. Kennedy
* Homework #1
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
* User interface that can be defined as unique.  A simple game of Tic Tac Toe gone wrong
* where clicking on spaces in the grid will reveal interesting behaviors of an overused
* game.  
*/

public class GUIFromHell extends JFrame implements ActionListener
{
	private JButton but1, but2, but3, but4, but5, but6, but7, but8, but9 = null;
	private JLabel result = null;
	private Container con = null;
	
	/**
	* Construction of the user interface is done in this method.
	* All together there are 9 buttons used for the grid in the tic tac toe
	* game and a label used for printing out messages.
	*/
	
	public GUIFromHell()
	{
		//set some behaviors of the GUI
		setSize(300,150);
		setTitle("Tic Tac Toe");
		setLocation(12, 500);		
		
		con = getContentPane();
		
		//add buttons to a grid in the panel
		JPanel north = new JPanel( new GridLayout(3,3));
		
		but1 = new JButton("X");
		but2 = new JButton("O");
		but3 = new JButton("X");
		but4 = new JButton("O");
		but5 = new JButton("X");
		but6 = new JButton("O");
		but7 = new JButton("X");
		but8 = new JButton("O");
		but9 = new JButton("O");
		
		north.add(but1);
		north.add(but2);
		north.add(but3);
		north.add(but4);
		north.add(but5);
		north.add(but6);
		north.add(but7);
		north.add(but8);
		north.add(but9);
		
		//add the label to a panel with a flowlayout
		JPanel south = new JPanel( new FlowLayout());
		
		result = new JLabel("X's Win!");
		
		south.add(result);
		
		//add the panels to the container
		con.add(north, BorderLayout.NORTH);
		con.add(south, BorderLayout.SOUTH);
		
		//add the listeners
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		but5.addActionListener(this);
		but6.addActionListener(this);
		but7.addActionListener(this);
		but8.addActionListener(this);
		but9.addActionListener(this);
		
		addWindowListener(new MyWindowResponder());
		setVisible(true);	
	}
	
	/**
	* Creates an object of our venerable GUI class.
	*/	
	
	public static void main(String [] args )
	{
		GUIFromHell gfh = new GUIFromHell();	
	}
	
	/**
	* Defines consequences from specific action generated by an object.
	* Here 8 buttons have separate courses of action to take after they 
	* have generated an ActionEvent from a click.  Some "consequences" 
	* are worse than others, I am a fan of button 6.
	*/
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == but1)
		{
			this.setSize(600,600);
			but1.setSize(30,30);
			but2.setSize(30,30);
			but3.setSize(30,30);
			but4.setSize(30,30);
			but5.setSize(30,30);
			but6.setSize(30,30);
			but7.setSize(30,30);
			but8.setSize(30,30);
			but9.setSize(30,30);
			result.setText("Button 1 wins!");
		
		}
		if(ae.getSource() == but2)
		{
			con.setBackground(Color.orange);
			this.setSize(300,150);
			result.setText("Orange wins!");
		}
		if(ae.getSource() == but3)
		{
			but1.setText("O");
			but2.setText("X");
			but3.setText("O");
			but4.setText("X");
			but5.setText("O");
			but6.setText("X");
			but7.setText("O");
			but8.setText("X");
			but9.setText("X");
			result.setText("O's win now!");
			this.setSize(300,150);
			
		
		}
		if(ae.getSource() == but4)
		{
			JOptionPane.showMessageDialog(but4, "Please Wait...", "Oops, You broke it", JOptionPane.WARNING_MESSAGE);
			this.setSize(300,150);
		
		}
		if(ae.getSource() == but5)
		{
			but1.setBackground(Color.green);
			but2.setBackground(Color.red);
			but3.setBackground(Color.green);
			but4.setBackground(Color.red);
			but5.setBackground(Color.green);
			but6.setBackground(Color.red);
			but7.setBackground(Color.green);
			but8.setBackground(Color.red);
			but9.setBackground(Color.green);
			result.setText("Christmas Colors Win!");
			
		}
		if(ae.getSource() == but6)
		{			
			setVisible(false);
			while(true)
			{
				JFrame jf = new JFrame();
				jf.setVisible(true);
			}
		}
		if(ae.getSource() == but7)
		{
			setLocation(1,1);
		}
		if(ae.getSource() == but8)
		{
			
			JOptionPane.showMessageDialog(but4, "You thought Tic Tac Toe was never this fun",
			"FYI", JOptionPane.INFORMATION_MESSAGE);
			this.setSize(300,150);		
		}			
	}	
}

/**
* This class was designed to help end the program when the X is
* clicked in the upper right corner as a substitute for the 
* setDefaultCloseOperation method
*/

class MyWindowResponder extends WindowAdapter
{
	/**
	* This method runs the exit method for a window that is
	* defined by the windowClosing operation.
	*/
	
	public void windowClosing( WindowEvent e )
	{
		exit(e.getWindow());
	}
	
	/**
	* Disposes of a window and ends the program upon execution
	*/
	
	public void exit(Window w)
	{
		w.dispose();
		System.exit(0);
	}	
}	