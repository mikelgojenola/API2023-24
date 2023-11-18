package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class Consola extends JFrame{
	private JPanel panelPrincipal;
	private JPanel panelArauak;
	private static JTextArea txtrArauak;
	private static JTextArea txtrArauak2;
	
	public Consola() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(550,200));
	    pack();
	    setLocationRelativeTo(null);
	    
	    panelPrincipal = new JPanel();
	    this.setTitle("Consola");
	    panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(panelPrincipal);
	    panelPrincipal.setLayout(new BorderLayout(0, 0));
	    panelPrincipal.add(getPanelArauak(), BorderLayout.CENTER);
	    
	    setVisible(true);
	}
	
	public static void cambiarTexto(String mensaje) {
		txtrArauak.setText(mensaje);		
	}
	
	public static void cambiarTexto2(String mensaje) {
		txtrArauak2.setText(mensaje);		
	}

	
	private JPanel getPanelArauak() {
		if (panelArauak == null) {
			panelArauak = new JPanel();
			panelArauak.add(getTxtrArauak());
			panelArauak.add(getTxtrArauak2());
		}
		return panelArauak;
	}
	
	private JTextArea getTxtrArauak() {
		if (txtrArauak == null) {
			txtrArauak = new JTextArea();
			txtrArauak.setEditable(false);
			txtrArauak.setBackground(new Color(240, 240, 240));
			txtrArauak.setText("Aquí saldrán las jugadas de la máquina");		
		
		}
		return txtrArauak;
	}
	private JTextArea getTxtrArauak2() {
		if (txtrArauak2 == null) {
			txtrArauak2 = new JTextArea();
			txtrArauak2.setEditable(false);
			txtrArauak2.setBackground(new Color(240, 240, 240));		
		}
		return txtrArauak2;
	}
	
}
	