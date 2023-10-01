package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


public class Arauak extends JFrame{
		
	//private Arauak frame;
	private JPanel panelPrincipal;
	private JPanel pnlArauak;
	private JLabel lblHelburua;
	private JLabel lblArauak;
	private JLabel lblArau1;
	private JLabel lblArau2;
	private JLabel lblArau3;
	private JLabel lblArau4;
	private JLabel lblKonb;
	private JLabel lblKonb1;
	private JLabel lblKonb2;
	private JLabel lblKonb3;
	private JLabel lblKonb4;


	
	public Arauak() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(750,450));
	    pack();
	    setLocationRelativeTo(null);
	    
	    panelPrincipal = new JPanel();
	    this.setTitle("Arauak");
	    panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(panelPrincipal);
	    
	    panelPrincipal.add(getPnlArauak());
	    
	    setVisible(true);
	}
	
	private void initialize() {
		
	}
	
	private JPanel getPnlArauak() {
		if(pnlArauak == null) {
			pnlArauak = new JPanel();
			pnlArauak.setLayout(new BoxLayout(pnlArauak, BoxLayout.PAGE_AXIS));
			pnlArauak.add(getLblHelburua());
			pnlArauak.add(new JLabel(" "));
			pnlArauak.add(getLblArauak());
			pnlArauak.add(getLblArau1(), BorderLayout.WEST);
			pnlArauak.add(getLblArau2(), BorderLayout.WEST);
			pnlArauak.add(getLblArau3(), BorderLayout.WEST);
			pnlArauak.add(getLblArau4(), BorderLayout.WEST);
			pnlArauak.add(new JLabel(" "));
			pnlArauak.add(getLblKonbinazioak());
			pnlArauak.add(getLblKonb1());
			pnlArauak.add(getLblKonb2());
			pnlArauak.add(getLblKonb3());
			pnlArauak.add(getLblKonb4());

		}
		return pnlArauak;
	}
	
	private JLabel getLblHelburua() {
		if(lblHelburua == null) {
			lblHelburua = new JLabel();
			lblHelburua.setText("HELBURUA: 3 txita lortzea aurkariak baino lehen.");
		}
		return lblHelburua;
	}
	
	private JLabel getLblArauak() {
		if(lblArauak == null) {
			lblArauak = new JLabel();
			lblArauak.setText("--- ARAUAK ---");
		}
		return lblArauak;
	}
	
	private JLabel getLblArau1() {
		if(lblArau1 == null) {
			lblArau1 = new JLabel();
			lblArau1.setText("1. Jokalari bakoitzak 4 karta hartuko ditu eta urte gehiago dituen jokalaria hasiko da.");
		}
		return lblArau1;
	}
	
	private JLabel getLblArau2() {
		if(lblArau2 == null) {
			lblArau2 = new JLabel();
			lblArau2.setText("2. Zure txanda denean jokatzeko konbinaziorik izanez gero nahitaezkoa da jokaldia egitea.");
		}
		return lblArau2;
	}
	
	private JLabel getLblArau3() {
		if(lblArau3 == null) {
			lblArau3 = new JLabel();
			lblArau3.setText("3. jokaldia egin eta gero erabilitako kartak baztertu eta berri batzuk hartuko dira 4 izan arte.");
		}
		return lblArau3;
	}
	
	private JLabel getLblArau4() {
		if(lblArau4 == null) {
			lblArau4 = new JLabel();
			lblArau4.setText("4. Konbinazio posiblerik ez baduzu zure aukerako karta bat baztertu eta berri bat hartuko duzu.");
		}
		return lblArau4;
	}
	
	private JLabel getLblKonbinazioak() {
		if(lblKonb == null) {
			lblKonb = new JLabel();
			lblKonb.setText("--- KONBINAZIOAK ---");
		}
		return lblKonb;
	}
	
	private JLabel getLblKonb1() {
		if(lblKonb1 == null) {
			lblKonb1 = new JLabel();
			lblKonb1.setText("1. Oilo/Oilar/Habia = Arrautza bat hartu");
		}
		return lblKonb1;
	}
	
	private JLabel getLblKonb2() {
		if(lblKonb2 == null) {
			lblKonb2 = new JLabel();
			lblKonb2.setText("2. Oilo/Oilo = Arrautzarik izanez gero txita bihurtu");
		}
		return lblKonb2;
	}
	
	private JLabel getLblKonb3() {
		if(lblKonb3 == null) {
			lblKonb3 = new JLabel();
			lblKonb3.setText("3. Azeria = Aurkariak arrautzaren bat izanez gero hau lapurtzen saiatu");
		}
		return lblKonb3;
	}
	
	private JLabel getLblKonb4() {
		if(lblKonb4 == null) {
			lblKonb4 = new JLabel();
			lblKonb4.setText("4. Oilar/Oilar = Aurkariak azeriarekin erasoz gero hauek erabiliz arrautza defendatu dezakezu");
		}
		return lblKonb4;
	}
}
