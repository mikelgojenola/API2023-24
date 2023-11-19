package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import vista.HasieraMenua.Controller;
import javax.swing.SwingUtilities;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Normas extends JFrame{
		
	//private Normas frame;
	private JPanel panelPrincipal;
	private JPanel atrasPanel;
	private JButton btnAtras;
	private JPanel panelNormas;
	private JTextArea txtrNormas;
	private Controller controller;


	
	public Normas() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(750,450));
	    pack();
	    setLocationRelativeTo(null);
	    
	    panelPrincipal = new JPanel();
	    this.setTitle("Normas");
	    panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(panelPrincipal);
	    panelPrincipal.setLayout(new BorderLayout(0, 0));
	    panelPrincipal.add(getAtrasPanel(), BorderLayout.SOUTH);
	    panelPrincipal.add(getPanelNormas(), BorderLayout.CENTER);
	    
	    setVisible(true);
	}
	
	private JPanel getAtrasPanel() {
		if (atrasPanel == null) {
			atrasPanel = new JPanel();
			atrasPanel.add(getBtnAtras());
		}
		return atrasPanel;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.addActionListener(getController());
		}
		return btnAtras;
	}
	private JPanel getPanelNormas() {
		if (panelNormas == null) {
			panelNormas = new JPanel();
			panelNormas.add(getTxtrNormas());
		}
		return panelNormas;
	}
	private JTextArea getTxtrNormas() {
		if (txtrNormas == null) {
			txtrNormas = new JTextArea();
			txtrNormas.setEditable(false);
			txtrNormas.setBackground(new Color(240, 240, 240));
			txtrNormas.setText("\r\nOBJETIVO: conseguir 3 puntos antes que el rival.\r\n\r\n--- NORMAS ---\r\n\r\n1. Cada jugador tomara 4 cartas y comenzara el jugador mas joven.\r\n2. Despues de hacer la jugada se descartan las cartas utilizadas y se toman unas nuevas hasta que sean 4.\r\n3. En tu turno podras hacer una jugada o descartar una carta. \r\n\r\n--- COMBINACIONES ---\r\n\r\n1. Chef/Rata/Cocina = Hacer un plato \r\n2. Chef/Chef = Convertir un plato en un punto \r\n3. Chef malo = Si el adversario tiene un plato intenta robarlo \r\n4. Rata/Rata = Si el adversario usa el chef malo te defiendes automaticamente con esta combinacion si tienes las cartas necesarias");
			
		
		
		
		}
		return txtrNormas;
	}
	
	private Controller getController() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	private class Controller implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnAtras)) {
				//HasieraMenua hasieramenua = new HasieraMenua();
				//HasieraMenua.setVisible(true);
				dispose();
				// Cierra el JFrame actual
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnAtras);
	            frame.dispose();
			}
		}
	}
}

