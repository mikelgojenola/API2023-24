package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class Ganador extends JFrame{
	private String nombre;
	private JPanel panelPrincipal;
	private JPanel AtzeraPanel;
	private JButton btnAtzera;
	private JPanel panelArauak;
	private JTextArea txtrArauak;
	private Controller controller;
	
	public Ganador(String pNombre) {
		nombre = pNombre;
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
			txtrArauak.setText("Ha ganado: " + nombre);
		
		
		
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
				dispose();
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnAtzera);
	            frame.dispose();
			}
		}
	}
	
	
	
	
	
	

}
