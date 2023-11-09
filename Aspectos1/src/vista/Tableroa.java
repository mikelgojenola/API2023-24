package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import model.ListaJokalaria;

public class Tableroa extends JFrame implements Observer {
	
	//private static Tableroa frame;
	private JPanel panelPrincipal;
	private JPanel panelPC;
	private JPanel panelJok;
	private JPanel panelKartakJok;
	private JPanel panelKartakPC;
	private JPanel panelAkzioak;
	private JPanel panelJokInfo;
	private JToggleButton btnKarta1;
	private JToggleButton btnKarta2;
	private JToggleButton btnKarta3;
	private JToggleButton btnKarta4;
	private JToggleButton btnKarta5;
	private JToggleButton btnKarta6;
	private JToggleButton btnKarta7;
	private JToggleButton btnKarta8;
	private JLabel lblPCPlatos;
	private JLabel lblPCDinero;
	private JButton btnKartaAldatu;
	private JButton btnJokaldiaEgin;
	private Controller controller;
	private String image = null;
	private JLabel lblFotoKarta1;
	private JLabel lblFotoKarta2;
	private JLabel lblFotoKarta3;
	private JLabel lblFotoKarta4;
	private JLabel lblFotoKarta5;
	private JLabel lblFotoKarta6;
	private JLabel lblFotoKarta7;
	private JLabel lblFotoKarta8;
	

	
	public Tableroa(String n) {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(850,550));
	    pack();
	    setLocationRelativeTo(null);
	    
	    panelPrincipal = new JPanel();
	    this.setTitle(n);
	    panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(panelPrincipal);
	    panelPrincipal.setLayout(new BorderLayout(0, 0));

	    
	    panelPrincipal.add(getPnlPC(), BorderLayout.NORTH);
	    //panelPrincipal.add(getPnlKartak(), BorderLayout.CENTER);
	    panelPrincipal.add(getPnlJok(), BorderLayout.SOUTH);
	    
		setVisible(true);
	}
	
	private JPanel getPnlPC() {
		if(panelPC == null) {
			panelPC = new JPanel();
			panelPC.setLayout(new BorderLayout());
			JPanel panelPCInfo = new JPanel();
			panelPCInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelPCInfo.add(new JLabel("PC:    Platos: "));
			
			
			//--------------------------------------------------------------------------
			ImageIcon imageIcon1 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato1.png"));
		    Image image1 = imageIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			JLabel lblFotoPlato = new JLabel();
			lblFotoPlato.setIcon(new ImageIcon(image1));
			panelPCInfo.add(lblFotoPlato);
			
			ImageIcon imageIcon2 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato2.png"));
		    Image image2 = imageIcon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			JLabel lblFotoPlato2 = new JLabel();
			lblFotoPlato2.setIcon(new ImageIcon(image2));
			panelPCInfo.add(lblFotoPlato2);
			//--------------------------------------------------------------------------

			
			panelPCInfo.add(new JLabel("Dinero: "));
			
			
			//--------------------------------------------------------------------------
			ImageIcon imageIcon3 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/dinero.png"));
		    Image image3 = imageIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			JLabel lblFotoDinero = new JLabel();
			lblFotoDinero.setIcon(new ImageIcon(image3));
			panelPCInfo.add(lblFotoDinero);
			//--------------------------------------------------------------------------
			
			panelPC.add(panelPCInfo, BorderLayout.NORTH);
			
			panelPC.add(getPnlKartakPC(), BorderLayout.SOUTH);	

		}
		return panelPC;
	}
	
	private JPanel getPnlKartakPC() {
		if(panelKartakPC == null) {
			panelKartakPC = new JPanel();
			panelKartakPC.add(getBtnKarta5());
			panelKartakPC.add(getBtnKarta6());
			panelKartakPC.add(getBtnKarta7());
			panelKartakPC.add(getBtnKarta8());
		}
		return panelKartakPC;
	}
	
	private JPanel getPnlJok() {
		if(panelJok == null) {
			panelJok = new JPanel();
			panelJok.setLayout(new BorderLayout());
			panelJok.add(getPnlKartakJok(), BorderLayout.NORTH);
			panelJok.add(getPnlAkzioak(), BorderLayout.CENTER);
			panelJok.add(getPnlJokInfo(), BorderLayout.SOUTH);
		}
		return panelJok;
	}
	
	private JPanel getPnlKartakJok() {
		if(panelKartakJok == null) {
			panelKartakJok = new JPanel();
			panelKartakJok.add(getBtnKarta1());
			panelKartakJok.add(getBtnKarta2());
			panelKartakJok.add(getBtnKarta3());
			panelKartakJok.add(getBtnKarta4());
		}
		return panelKartakJok;
	}

	private JPanel getPnlAkzioak() {
		if(panelAkzioak == null) {
			panelAkzioak = new JPanel();
			panelAkzioak.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			panelAkzioak.add(getBtnKartaAldatu());
			panelAkzioak.add(getBtnJokaldiaEgin());
		}
		return panelAkzioak;
	}
	
	private JPanel getPnlJokInfo() {
		if(panelJokInfo == null) {
			panelJokInfo = new JPanel();
			panelJokInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelJokInfo.add(new JLabel("Platos: "));
			
			
			//--------------------------------------------------------------------------
			ImageIcon imageIcon4 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato3.png"));
		    Image image4 = imageIcon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			JLabel lblFotoPlato = new JLabel();
			lblFotoPlato.setIcon(new ImageIcon(image4));
			panelJokInfo.add(lblFotoPlato);
			
			ImageIcon imageIcon5 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato1.png"));
		    Image image5 = imageIcon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			JLabel lblFotoPlato2 = new JLabel();
			lblFotoPlato2.setIcon(new ImageIcon(image5));
			panelJokInfo.add(lblFotoPlato2);
			//--------------------------------------------------------------------------

			
			panelJokInfo.add(new JLabel("Dinero: "));
			
			
			//--------------------------------------------------------------------------
			ImageIcon imageIcon6 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/dinero.png"));
		    Image image6 = imageIcon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			JLabel lblFotoDinero = new JLabel();
			lblFotoDinero.setIcon(new ImageIcon(image6));
			panelJokInfo.add(lblFotoDinero);
			
			JLabel lblDinero2 = new JLabel();
			lblDinero2.setIcon(new ImageIcon(image6));
			panelJokInfo.add(lblDinero2);
			//--------------------------------------------------------------------------

		}
		return panelJokInfo;
	}
	
	private JToggleButton getBtnKarta1() {
		if(btnKarta1 == null) {
			btnKarta1 = new JToggleButton();
		    btnKarta1.setPreferredSize(new Dimension(120, 200));
		    btnKarta1.setLayout(new BorderLayout());

			btnKarta1.add(new JLabel("Carta 1"), BorderLayout.NORTH);
			
			//--------------------------------------------------------------------------
			//ImageIcon imageIcon = new ImageIcon(Tableroa.class.getResource("/irudiak/Rata.png"));
		    //Image image = imageIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
			lblFotoKarta1 = new JLabel();
			//lblFotoKarta1.setIcon(new ImageIcon(image));
			btnKarta1.add(lblFotoKarta1, BorderLayout.SOUTH);
			//--------------------------------------------------------------------------
		}
		return btnKarta1;
	}
	
	private JToggleButton getBtnKarta2() {
		if(btnKarta2 == null) {
		    btnKarta2 = new JToggleButton();
		    btnKarta2.setPreferredSize(new Dimension(120, 200));
		    btnKarta2.setLayout(new BorderLayout());
		    
			btnKarta2.add(new JLabel("Carta 2"), BorderLayout.NORTH);
			
			//--------------------------------------------------------------------------
			//ImageIcon imageIcon = new ImageIcon(HasieraMenua.class.getResource("/irudiak/Malo.png"));
		    //Image image = imageIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
			lblFotoKarta2 = new JLabel();
			//lblFotoKarta2.setIcon(new ImageIcon(image));
			btnKarta2.add(lblFotoKarta2, BorderLayout.SOUTH);
			//--------------------------------------------------------------------------
		}
		return btnKarta2;
	}
	
	private JToggleButton getBtnKarta3() {
		if(btnKarta3 == null) {
			btnKarta3 = new JToggleButton();
		    btnKarta3.setPreferredSize(new Dimension(120, 200));
		    btnKarta3.setLayout(new BorderLayout());

			btnKarta3.add(new JLabel("Carta 3"), BorderLayout.NORTH);
			
			lblFotoKarta3 = new JLabel();
			btnKarta3.add(lblFotoKarta3, BorderLayout.SOUTH);
			}
		return btnKarta3;
	}
	
	private JToggleButton getBtnKarta4() {
		if(btnKarta4 == null) {
			btnKarta4 = new JToggleButton();
		    btnKarta4.setPreferredSize(new Dimension(120, 200));
		    btnKarta4.setLayout(new BorderLayout());

			btnKarta4.add(new JLabel("Carta 4"), BorderLayout.NORTH);
			
			lblFotoKarta4 = new JLabel();
			btnKarta4.add(lblFotoKarta4, BorderLayout.SOUTH);
		}
		return btnKarta4;
	}
	
	private JToggleButton getBtnKarta5() {
		if(btnKarta5 == null) {
			btnKarta5 = new JToggleButton();
		    btnKarta5.setPreferredSize(new Dimension(100, 170));
		    btnKarta5.setLayout(new BorderLayout());

			btnKarta5.add(new JLabel("Carta 5"), BorderLayout.NORTH);
			
			lblFotoKarta5 = new JLabel();
			btnKarta5.add(lblFotoKarta5, BorderLayout.SOUTH);
		}
		return btnKarta5;
	}
	
	private JToggleButton getBtnKarta6() {
		if(btnKarta6 == null) {
			btnKarta6 = new JToggleButton();
		    btnKarta6.setPreferredSize(new Dimension(100, 170));
		    btnKarta6.setLayout(new BorderLayout());

			btnKarta6.add(new JLabel("Carta 6"), BorderLayout.NORTH);
			
			lblFotoKarta6 = new JLabel();
			btnKarta6.add(lblFotoKarta6, BorderLayout.SOUTH);
		}
		return btnKarta6;
	}
	
	private JToggleButton getBtnKarta7() {
		if(btnKarta7 == null) {
			btnKarta7 = new JToggleButton();
		    btnKarta7.setPreferredSize(new Dimension(100, 170));
		    btnKarta7.setLayout(new BorderLayout());

			btnKarta7.add(new JLabel("Carta 7"), BorderLayout.NORTH);
			
			lblFotoKarta7 = new JLabel();
			btnKarta7.add(lblFotoKarta7, BorderLayout.SOUTH);
		}
		return btnKarta7;
	}
	
	
	private JToggleButton getBtnKarta8() {
		if(btnKarta8 == null) {
			btnKarta8 = new JToggleButton();
		    btnKarta8.setPreferredSize(new Dimension(100, 170));
		    btnKarta8.setLayout(new BorderLayout());

			btnKarta8.add(new JLabel("Carta 8"), BorderLayout.NORTH);
			
			lblFotoKarta8 = new JLabel();
			btnKarta8.add(lblFotoKarta8, BorderLayout.SOUTH);
		}
		return btnKarta8;
	}
	
	
	
	
	private JLabel getLblPCPlatos() {
		if(lblPCPlatos == null) {
			lblPCPlatos = new JLabel("PC:     Platos: ");			
		}
		return lblPCPlatos;
	}
	
	private JLabel getLblPCDinero() {
		if(lblPCDinero == null) {
			lblPCDinero = new JLabel("Dinero: ");		
		}
		return lblPCDinero;
	}
	
	
	private Controller getController() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	private JButton getBtnKartaAldatu() {
		if(btnKartaAldatu == null) {
			btnKartaAldatu = new JButton();
			btnKartaAldatu.setText("Karta aldatu");
			btnKartaAldatu.addActionListener(getController());
		}
		return btnKartaAldatu;
	}
	
	private JButton getBtnJokaldiaEgin() {
		if(btnJokaldiaEgin == null) {
			btnJokaldiaEgin = new JButton();
			btnJokaldiaEgin.setText("Jokaldia egin");
			btnJokaldiaEgin.addActionListener(getController());
		}
		return btnJokaldiaEgin;
	}
	
	private class Controller implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnJokaldiaEgin)) {
				ArrayList<Integer> jokaldiKartak = new ArrayList<Integer>();
				if(getBtnKarta1().isSelected()) {
					jokaldiKartak.add(1);
				}
				if(getBtnKarta1().isSelected()) {
					jokaldiKartak.add(2);
				}
				if(getBtnKarta1().isSelected()) {
					jokaldiKartak.add(3);
				}
				if(getBtnKarta1().isSelected()) {
					jokaldiKartak.add(4);
				}
				ListaJokalaria.rondaJolastu2(jokaldiKartak);
				getBtnKarta1().setSelected(false);
				getBtnKarta2().setSelected(false);
				getBtnKarta3().setSelected(false);
				getBtnKarta4().setSelected(false);
			}
			else if(e.getSource().equals(btnKartaAldatu)) {
				
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("INFORMAZIOAREN UPDATEAN SARTU NAIZ");
		ArrayList<String> rr = (ArrayList<String>)arg;
		System.out.println(arg);
		System.out.println(rr.get(1));
		for (int i=0;i<8;i++) {
			if (rr.get(i).equals("Cocina")) {
				this.image = "/irudiak/" + rr.get(i) + ".jpg";
			} else {
				this.image = "/irudiak/" + rr.get(i) + ".png";
			}
			System.out.println(this.image);
			ImageIcon imageIcon = new ImageIcon(Tableroa.class.getResource(this.image));
			Image image = imageIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
			if (i == 0) {
				lblFotoKarta1.setIcon(new ImageIcon(image));
				//btnKarta1.add(lblFotoKarta1, BorderLayout.SOUTH);
			} else if (i == 1) {
				lblFotoKarta2.setIcon(new ImageIcon(image));
				//btnKarta2.add(lblFotoKarta2, BorderLayout.SOUTH);
			} else if (i == 2) {
				lblFotoKarta3.setIcon(new ImageIcon(image));
				//btnKarta3.add(lblFotoKarta3, BorderLayout.SOUTH);
			} else if (i == 3) {
				lblFotoKarta4.setIcon(new ImageIcon(image));
				//btnKarta4.add(lblFotoKarta4, BorderLayout.SOUTH);
			} else if (i == 4) {
				lblFotoKarta5.setIcon(new ImageIcon(image));
				//btnKarta5.add(lblFotoKarta5, BorderLayout.SOUTH);
			} else if (i == 5) {
				lblFotoKarta6.setIcon(new ImageIcon(image));
				//btnKarta6.add(lblFotoKarta6, BorderLayout.SOUTH);
			} else if (i == 6) {
				lblFotoKarta7.setIcon(new ImageIcon(image));
				//btnKarta7.add(lblFotoKarta7, BorderLayout.SOUTH);
			} else if (i == 7) {
				lblFotoKarta8.setIcon(new ImageIcon(image));
				//btnKarta8.add(lblFotoKarta8, BorderLayout.SOUTH);
			}	
		}
	}

}
