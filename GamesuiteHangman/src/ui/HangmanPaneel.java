package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.DomainException;
import domain.HangMan;

public class HangmanPaneel extends JPanel {

	private static final long serialVersionUID = 1L;	
	
	private JTextField letter;	
	private JLabel woord;
	
	private TekenVenster tekenVenster;
	private HangMan spel;
	
	public HangmanPaneel(HangMan spel){
		super();
		setSpel(spel);
		init();
	}

	private void init(){
		letter = new JTextField("",5);
		woord = new JLabel("");
		
		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);
		
		letter.addKeyListener(new RaadLuisteraar());
	}
	
	private void reset() {
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
	}
	
	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()== KeyEvent.VK_ENTER)
				try {
						String input = letter.getText();
						char guess = '\u0000';
						if(input.length() > 0){
							guess = input.charAt(0);
						}
						spel.raad(guess);
						
						woord.setText(getSpel().getHint());
						letter.setText("");
						getTekenVenster().teken();
						
						if (spel.isGameOver()) {
							JOptionPane.showMessageDialog(null, "U heeft verloren. \nHet woord was " + spel.getWoord() + ".\nUw score is " + spel.getSpeler().getScore());
							gameEnd();
						}
						if (spel.isGewonnen()) {
							JOptionPane.showMessageDialog(null, "U heeft gewonnen! \nUw score is " + spel.getSpeler().getScore());
							gameEnd();
						}

				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}	
		}

		@Override
		public void keyReleased(KeyEvent arg0) {}
		@Override
		public void keyTyped(KeyEvent arg0) {}
	}
	
	private void gameEnd() {
		Object[] keuzes = {"Opnieuw", "Exit"};
		Object keuze = JOptionPane.showInputDialog(null,"Wat wilt u doen?", "input", JOptionPane.INFORMATION_MESSAGE, null, keuzes, null);
		if (keuze!=null) {
			if (keuze.equals("Opnieuw")) {
				try {
					Launcher.startPlaying(spel.getSpeler());;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Can't relaunch, seek help.");
					e.printStackTrace();
				}
			} 
		} else {
			this.setVisible(false);
			System.exit(0);
		}
	}
	
	private void setSpel(HangMan spel){
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}
	

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	 public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}
}