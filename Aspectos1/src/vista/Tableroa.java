package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class Tableroa extends JFrame{
	
	//private static Tableroa frame;
	private JPanel panelPrincipal;
	private JPanel panelPC;
	private JPanel panelJok;
	private JPanel panelKartak;
	private JPanel panelAkzioak;
	private JPanel panelJokInfo;
	private JToggleButton btnKarta1;
	private JToggleButton btnKarta2;
	private JToggleButton btnKarta3;
	private JToggleButton btnKarta4;
	private JLabel lblPCPlatos;
	private JLabel lblPCDinero;
	private JButton btnKartaAldatu;
	private JButton btnJokaldiaEgin;
	private Controller controller;

	
	public Tableroa() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(850,550));
	    pack();
	    setLocationRelativeTo(null);
	    
	    panelPrincipal = new JPanel();
	    this.setTitle("ZZ");
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
			panelPC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelPC.add(new JLabel("PC:    Platos: "));
			
			
			//--------------------------------------------------------------------------
			ImageIcon imageIcon1 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato1.png"));
		    Image image1 = imageIcon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			JLabel lblFotoPlato = new JLabel();
			lblFotoPlato.setIcon(new ImageIcon(image1));
			panelPC.add(lblFotoPlato);
			
			ImageIcon imageIcon2 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato2.png"));
		    Image image2 = imageIcon2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			JLabel lblFotoPlato2 = new JLabel();
			lblFotoPlato2.setIcon(new ImageIcon(image2));
			panelPC.add(lblFotoPlato2);
			//--------------------------------------------------------------------------

			
			panelPC.add(new JLabel("Dinero: "));
			
			
			//--------------------------------------------------------------------------
			ImageIcon imageIcon3 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/dinero.png"));
		    Image image3 = imageIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			JLabel lblFotoDinero = new JLabel();
			lblFotoDinero.setIcon(new ImageIcon(image3));
			panelPC.add(lblFotoDinero);
			//--------------------------------------------------------------------------

		}
		return panelPC;
	}
	
	private JPanel getPnlJok() {
		if(panelJok == null) {
			panelJok = new JPanel();
			panelJok.setLayout(new BorderLayout());
			panelJok.add(getPnlKartak(), BorderLayout.NORTH);
			panelJok.add(getPnlAkzioak(), BorderLayout.CENTER);
			panelJok.add(getPnlJokInfo(), BorderLayout.SOUTH);
		}
		return panelJok;
	}
	
	private JPanel getPnlKartak() {
		if(panelKartak == null) {
			panelKartak = new JPanel();
			panelKartak.add(getBtnKarta1());
			panelKartak.add(getBtnKarta2());
			panelKartak.add(getBtnKarta3());
			panelKartak.add(getBtnKarta4());

		}
		return panelKartak;
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
		    Image image4 = imageIcon4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			JLabel lblFotoPlato = new JLabel();
			lblFotoPlato.setIcon(new ImageIcon(image4));
			panelJokInfo.add(lblFotoPlato);
			
			ImageIcon imageIcon5 = new ImageIcon(HasieraMenua.class.getResource("/irudiak/plato1.png"));
		    Image image5 = imageIcon5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
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
			ImageIcon imageIcon = new ImageIcon(HasieraMenua.class.getResource("/irudiak/Remy.png"));
		    Image image = imageIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
			JLabel lblFotoKarta1 = new JLabel();
			lblFotoKarta1.setIcon(new ImageIcon(image));
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
			ImageIcon imageIcon = new ImageIcon(HasieraMenua.class.getResource("/irudiak/Skinner.png"));
		    Image image = imageIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
			JLabel lblFotoKarta2 = new JLabel();
			lblFotoKarta2.setIcon(new ImageIcon(image));
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
			}
		return btnKarta3;
	}
	
	private JToggleButton getBtnKarta4() {
		if(btnKarta4 == null) {
			btnKarta4 = new JToggleButton();
		    btnKarta4.setPreferredSize(new Dimension(120, 200));
		    btnKarta4.setLayout(new BorderLayout());

			btnKarta4.add(new JLabel("Carta 4"), BorderLayout.NORTH);
		}
		return btnKarta4;
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
		}
		return btnKartaAldatu;
	}
	
	private JButton getBtnJokaldiaEgin() {
		if(btnJokaldiaEgin == null) {
			btnJokaldiaEgin = new JButton();
			btnJokaldiaEgin.setText("Jokaldia egin");
		}
		return btnJokaldiaEgin;
	}
	
	private class Controller implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnKarta1)) {
				
			}
		}
	}

}
