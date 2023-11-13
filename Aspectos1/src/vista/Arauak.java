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


public class Arauak extends JFrame{
		
	//private Arauak frame;
	private JPanel panelPrincipal;
	private JPanel AtzeraPanel;
	private JButton btnAtzera;
	private JPanel panelArauak;
	private JTextArea txtrArauak;
	private Controller controller;


	
	public Arauak() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(750,450));
	    pack();
	    setLocationRelativeTo(null);
	    
	    panelPrincipal = new JPanel();
	    this.setTitle("Arauak");
	    panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(panelPrincipal);
	    panelPrincipal.setLayout(new BorderLayout(0, 0));
	    panelPrincipal.add(getAtzeraPanel(), BorderLayout.SOUTH);
	    panelPrincipal.add(getPanelArauak(), BorderLayout.CENTER);
	    
	    setVisible(true);
	}
	
	private JPanel getAtzeraPanel() {
		if (AtzeraPanel == null) {
			AtzeraPanel = new JPanel();
			AtzeraPanel.add(getBtnAtzera());
		}
		return AtzeraPanel;
	}
	private JButton getBtnAtzera() {
		if (btnAtzera == null) {
			btnAtzera = new JButton("Atzera");
			btnAtzera.addActionListener(getController());
		}
		return btnAtzera;
	}
	private JPanel getPanelArauak() {
		if (panelArauak == null) {
			panelArauak = new JPanel();
			panelArauak.add(getTxtrArauak());
		}
		return panelArauak;
	}
	private JTextArea getTxtrArauak() {
		if (txtrArauak == null) {
			txtrArauak = new JTextArea();
			txtrArauak.setEditable(false);
			txtrArauak.setBackground(new Color(240, 240, 240));
			txtrArauak.setText("\r\nOBJETIVO: conseguir 3 puntos antes que el rival.\r\n\r\n--- NORMAS ---\r\n\r\n1. Cada jugador tomará 4 cartas y comenzará el jugador que tenga más años.\r\n2. Si es tu turno y hay posibles combinaciones, es obligatorio realizar la jugada.\r\n3 Después de hacer la jugada se descartan las cartas utilizadas y se toman unas nuevas hasta que sean 4.\r\n4. Si no tienes una combinación posible desecharás una carta de tu elección y tomarás una nueva.\r\n\r\n--- COMBINACIONES ---\r\n\r\n1. Gallina/Gallo/Nido = Tomar un huevo\r\n2. Chef/Chef = Obtiene normas\r\n3. Malo = Si el adversario tiene un plato intenta robarlo\r\n4. Rata/Rata = Si el adversario ataca con el malo puede defender el plato usando estos");
			
		
		
		
		}
		return txtrArauak;
	}
	
	private Controller getController() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	private class Controller implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnAtzera)) {
				//HasieraMenua hasieramenua = new HasieraMenua();
				//HasieraMenua.setVisible(true);
				dispose();
				// Cierra el JFrame actual
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnAtzera);
	            frame.dispose();
			}
		}
	}
}

