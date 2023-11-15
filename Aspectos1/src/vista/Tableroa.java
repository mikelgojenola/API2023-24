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

import model.Juego;

public class Tableroa extends JFrame implements Observer {
	
	//private static Tableroa frame;
	private JPanel panelPrincipal;
	private JPanel panelPC;
	private JPanel panelJok;
	private JPanel panelCartakJok;
	private JPanel panelCartakPC;
	private JPanel panelAkzioak;
	private JPanel panelJokInfo;
	private JToggleButton btnCarta1;
	private JToggleButton btnCarta2;
	private JToggleButton btnCarta3;
	private JToggleButton btnCarta4;
	private JButton btnCarta5;
	private JButton btnCarta6;
	private JButton btnCarta7;
	private JButton btnCarta8;
	private JLabel lblPCPlatos;
	private JLabel lblPCDinero;
	private JButton btnCartaAldatu;
	private JButton btnJokaldiaEgin;
	private Controller controller;
	private String image = null;
	private JLabel lblFotoCarta1;
	private JLabel lblFotoCarta2;
	private JLabel lblFotoCarta3;
	private JLabel lblFotoCarta4;
	private JLabel lblFotoCarta5;
	private JLabel lblFotoCarta6;
	private JLabel lblFotoCarta7;
	private JLabel lblFotoCarta8;
	

	
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
	    //panelPrincipal.add(getPnlCartak(), BorderLayout.CENTER);
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
			
			JLabel lblFotoPlato = new JLabel();
			panelPCInfo.add(lblFotoPlato);
			ImageIcon imageIcon1 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato1.png"));
		    Image image1 = imageIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			lblFotoPlato.setIcon(new ImageIcon(image1));

			
			
			JLabel lblFotoPlato2 = new JLabel();
			panelPCInfo.add(lblFotoPlato2);
			ImageIcon imageIcon2 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato2.png"));
		    Image image2 = imageIcon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			lblFotoPlato2.setIcon(new ImageIcon(image2));

			//--------------------------------------------------------------------------

			
			panelPCInfo.add(new JLabel("Dinero: "));
			
			
			//--------------------------------------------------------------------------

			JLabel lblFotoDinero = new JLabel();
			panelPCInfo.add(lblFotoDinero);
			ImageIcon imageIcon3 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/dinero.png"));
		    Image image3 = imageIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			lblFotoDinero.setIcon(new ImageIcon(image3));
			//--------------------------------------------------------------------------
			
			panelPC.add(panelPCInfo, BorderLayout.NORTH);
			
			panelPC.add(getPnlCartakPC(), BorderLayout.SOUTH);	

		}
		return panelPC;
	}
	
	private JPanel getPnlCartakPC() {
		if(panelCartakPC == null) {
			panelCartakPC = new JPanel();
			panelCartakPC.add(getBtnCarta5());
			panelCartakPC.add(getBtnCarta6());
			panelCartakPC.add(getBtnCarta7());
			panelCartakPC.add(getBtnCarta8());
		}
		return panelCartakPC;
	}
	
	private JPanel getPnlJok() {
		if(panelJok == null) {
			panelJok = new JPanel();
			panelJok.setLayout(new BorderLayout());
			panelJok.add(getPnlCartakJok(), BorderLayout.NORTH);
			panelJok.add(getPnlAkzioak(), BorderLayout.CENTER);
			panelJok.add(getPnlJokInfo(), BorderLayout.SOUTH);
		}
		return panelJok;
	}
	
	private JPanel getPnlCartakJok() {
		if(panelCartakJok == null) {
			panelCartakJok = new JPanel();
			panelCartakJok.add(getBtnCarta1());
			panelCartakJok.add(getBtnCarta2());
			panelCartakJok.add(getBtnCarta3());
			panelCartakJok.add(getBtnCarta4());
		}
		return panelCartakJok;
	}

	private JPanel getPnlAkzioak() {
		if(panelAkzioak == null) {
			panelAkzioak = new JPanel();
			panelAkzioak.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			panelAkzioak.add(getBtnCartaAldatu());
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
	
	private JToggleButton getBtnCarta1() {
		if(btnCarta1 == null) {
			btnCarta1 = new JToggleButton();
		    btnCarta1.setPreferredSize(new Dimension(120, 200));
		    btnCarta1.setLayout(new BorderLayout());

			btnCarta1.add(new JLabel("Carta 1"), BorderLayout.NORTH);
			
			//--------------------------------------------------------------------------
			//ImageIcon imageIcon = new ImageIcon(Tableroa.class.getResource("/irudiak/Rata.png"));
		    //Image image = imageIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
			lblFotoCarta1 = new JLabel();
			//lblFotoCarta1.setIcon(new ImageIcon(image));
			btnCarta1.add(lblFotoCarta1, BorderLayout.SOUTH);
			//--------------------------------------------------------------------------
		}
		return btnCarta1;
	}
	
	private JToggleButton getBtnCarta2() {
		if(btnCarta2 == null) {
		    btnCarta2 = new JToggleButton();
		    btnCarta2.setPreferredSize(new Dimension(120, 200));
		    btnCarta2.setLayout(new BorderLayout());
		    
			btnCarta2.add(new JLabel("Carta 2"), BorderLayout.NORTH);
			
			//--------------------------------------------------------------------------
			//ImageIcon imageIcon = new ImageIcon(HasieraMenua.class.getResource("/irudiak/Malo.png"));
		    //Image image = imageIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
			lblFotoCarta2 = new JLabel();
			//lblFotoCarta2.setIcon(new ImageIcon(image));
			btnCarta2.add(lblFotoCarta2, BorderLayout.SOUTH);
			//--------------------------------------------------------------------------
		}
		return btnCarta2;
	}
	
	private JToggleButton getBtnCarta3() {
		if(btnCarta3 == null) {
			btnCarta3 = new JToggleButton();
		    btnCarta3.setPreferredSize(new Dimension(120, 200));
		    btnCarta3.setLayout(new BorderLayout());

			btnCarta3.add(new JLabel("Carta 3"), BorderLayout.NORTH);
			
			lblFotoCarta3 = new JLabel();
			btnCarta3.add(lblFotoCarta3, BorderLayout.SOUTH);
			}
		return btnCarta3;
	}
	
	private JToggleButton getBtnCarta4() {
		if(btnCarta4 == null) {
			btnCarta4 = new JToggleButton();
		    btnCarta4.setPreferredSize(new Dimension(120, 200));
		    btnCarta4.setLayout(new BorderLayout());

			btnCarta4.add(new JLabel("Carta 4"), BorderLayout.NORTH);
			
			lblFotoCarta4 = new JLabel();
			btnCarta4.add(lblFotoCarta4, BorderLayout.SOUTH);
		}
		return btnCarta4;
	}
	
	private JButton getBtnCarta5() {
		if(btnCarta5 == null) {
			btnCarta5 = new JButton();
		    btnCarta5.setPreferredSize(new Dimension(100, 170));
		    btnCarta5.setLayout(new BorderLayout());

			btnCarta5.add(new JLabel("Carta 5"), BorderLayout.NORTH);
			
			lblFotoCarta5 = new JLabel();
			btnCarta5.add(lblFotoCarta5, BorderLayout.SOUTH);
		}
		return btnCarta5;
	}
	
	private JButton getBtnCarta6() {
		if(btnCarta6 == null) {
			btnCarta6 = new JButton();
		    btnCarta6.setPreferredSize(new Dimension(100, 170));
		    btnCarta6.setLayout(new BorderLayout());

			btnCarta6.add(new JLabel("Carta 6"), BorderLayout.NORTH);
			
			lblFotoCarta6 = new JLabel();
			btnCarta6.add(lblFotoCarta6, BorderLayout.SOUTH);
		}
		return btnCarta6;
	}
	
	private JButton getBtnCarta7() {
		if(btnCarta7 == null) {
			btnCarta7 = new JButton();
		    btnCarta7.setPreferredSize(new Dimension(100, 170));
		    btnCarta7.setLayout(new BorderLayout());

			btnCarta7.add(new JLabel("Carta 7"), BorderLayout.NORTH);
			
			lblFotoCarta7 = new JLabel();
			btnCarta7.add(lblFotoCarta7, BorderLayout.SOUTH);
		}
		return btnCarta7;
	}
	
	
	private JButton getBtnCarta8() {
		if(btnCarta8 == null) {
			btnCarta8 = new JButton();
		    btnCarta8.setPreferredSize(new Dimension(100, 170));
		    btnCarta8.setLayout(new BorderLayout());

			btnCarta8.add(new JLabel("Carta 8"), BorderLayout.NORTH);
			
			lblFotoCarta8 = new JLabel();
			btnCarta8.add(lblFotoCarta8, BorderLayout.SOUTH);
		}
		return btnCarta8;
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
	
	private JButton getBtnCartaAldatu() {
		if(btnCartaAldatu == null) {
			btnCartaAldatu = new JButton();
			btnCartaAldatu.setText("Carta aldatu");
			btnCartaAldatu.addActionListener(getController());
		}
		return btnCartaAldatu;
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
				ArrayList<Integer> jokaldiCartakPos = new ArrayList<Integer>();
				if(getBtnCarta1().isSelected()) {
					jokaldiCartakPos.add(1);
				}
				if(getBtnCarta2().isSelected()) {
					jokaldiCartakPos.add(2);
				}
				if(getBtnCarta3().isSelected()) {
					jokaldiCartakPos.add(3);
				}
				if(getBtnCarta4().isSelected()) {
					jokaldiCartakPos.add(4);
				}
				getBtnCarta1().setSelected(false);
				getBtnCarta2().setSelected(false);
				getBtnCarta3().setSelected(false);
				getBtnCarta4().setSelected(false);
				Juego.rondaJolastu2(jokaldiCartakPos);
				
			}
			else if(e.getSource().equals(btnCartaAldatu)) {
				ArrayList<Integer> jokaldiCartakPos = new ArrayList<Integer>();
				if(getBtnCarta1().isSelected()) {
					jokaldiCartakPos.add(1);
				}
				if(getBtnCarta2().isSelected()) {
					jokaldiCartakPos.add(2);
				}
				if(getBtnCarta3().isSelected()) {
					jokaldiCartakPos.add(3);
				}
				if(getBtnCarta4().isSelected()) {
					jokaldiCartakPos.add(4);
				}
				getBtnCarta1().setSelected(false);
				getBtnCarta2().setSelected(false);
				getBtnCarta3().setSelected(false);
				getBtnCarta4().setSelected(false);
				if(jokaldiCartakPos.size() == 1) {
					jokaldiCartakPos.add(-1);
					jokaldiCartakPos.add(-1);
					jokaldiCartakPos.add(-1);
					jokaldiCartakPos.add(-1);
					Juego.rondaJolastu2(jokaldiCartakPos);
				} else {
					System.out.println("�Tienes que elegir UNA carta para descartar!");
				}
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("INFORMAZIOAREN UPDATEAN SARTU NAIZ");
		ArrayList<String> rr = (ArrayList<String>)arg;
		System.out.println(arg);
		System.out.println(rr.get(1));
		for (int i=0;i<rr.size();i++) {
			if (rr.get(i).equals("Cocina")) {
				this.image = "/irudiak/" + rr.get(i) + ".jpg";
			} else {
				this.image = "/irudiak/" + rr.get(i) + ".png";
			}
			System.out.println(this.image);
			ImageIcon imageIcon = new ImageIcon(Tableroa.class.getResource(this.image));
			Image image = imageIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
			if (i == 0) {
				lblFotoCarta1.setIcon(new ImageIcon(image));
				//btnCarta1.add(lblFotoCarta1, BorderLayout.SOUTH);
			} else if (i == 1) {
				lblFotoCarta2.setIcon(new ImageIcon(image));
				//btnCarta2.add(lblFotoCarta2, BorderLayout.SOUTH);
			} else if (i == 2) {
				lblFotoCarta3.setIcon(new ImageIcon(image));
				//btnCarta3.add(lblFotoCarta3, BorderLayout.SOUTH);
			} else if (i == 3) {
				lblFotoCarta4.setIcon(new ImageIcon(image));
				//btnCarta4.add(lblFotoCarta4, BorderLayout.SOUTH);
			} else if (i == 4) {
				lblFotoCarta5.setIcon(new ImageIcon(image));
				//btnCarta5.add(lblFotoCarta5, BorderLayout.SOUTH);
			} else if (i == 5) {
				lblFotoCarta6.setIcon(new ImageIcon(image));
				//btnCarta6.add(lblFotoCarta6, BorderLayout.SOUTH);
			} else if (i == 6) {
				lblFotoCarta7.setIcon(new ImageIcon(image));
				//btnCarta7.add(lblFotoCarta7, BorderLayout.SOUTH);
			} else if (i == 7) {
				lblFotoCarta8.setIcon(new ImageIcon(image));
				//btnCarta8.add(lblFotoCarta8, BorderLayout.SOUTH);
			}
			
			
		}
	}

}
