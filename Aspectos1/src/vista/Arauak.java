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
			txtrArauak.setBackground(new Color(240, 240, 240));
			txtrArauak.setText("\r\nHELBURUA: 3 txita lortzea aurkariak baino lehen.\r\n\r\n--- ARAUAK ---\r\n\r\n1. Jokalari bakoitzak 4 karta hartuko ditu eta urte gehiago dituen jokalaria hasiko da.\r\n2. Zure txanda denean jokatzeko konbinaziorik izanez gero nahitaezkoa da jokaldia egitea.\r\n3. jokaldia egin eta gero erabilitako kartak baztertu eta berri batzuk hartuko dira 4 izan arte.\r\n4. Konbinazio posiblerik ez baduzu zure aukerako karta bat baztertu eta berri bat hartuko duzu.\r\n\r\n--- KONBINAZIOAK ---\r\n\r\n1. Oilo/Oilar/Habia = Arrautza bat hartu\r\n2. Oilo/Oilo = Arrautzarik izanez gero txita bihurtu\r\n3. Azeria = Aurkariak arrautzaren bat izanez gero hau lapurtzen saiatu\r\n4. Oilar/Oilar = Aurkariak azeriarekin erasoz gero hauek erabiliz arrautza defendatu dezakezu");
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
