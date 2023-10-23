package vista;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HasieraMenua extends JFrame {

	private static HasieraMenua frame;
	private JPanel Panelprincipal;
	private Controller controller;
	private JButton btnArauak;
	private JButton btnJokatu;
	private JButton btnIrten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HasieraMenua();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/*
	public HasieraMenua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Panelprincipal =  new JPanel();
		Panelprincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Panelprincipal);
		Panelprincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFotoMenu = new JLabel("");
		//--lblFotoMenu.setIcon(new ImageIcon(HasieraMenua.class.getResource("/irudiak/menu1.jpg")));
		//ImageIcon imageIcon = new ImageIcon(HasieraMenua.class.getResource("/irudiak/menu1.jpg"));
		//Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Cambia las dimensiones aquí (200x200 en este ejemplo)
		//lblFotoMenu.setIcon(new ImageIcon(image));
		Panelprincipal.add(lblFotoMenu, BorderLayout.CENTER);
		
		JPanel opciones = new JPanel();
		Panelprincipal.add(opciones, BorderLayout.SOUTH);
		opciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnJokatu = new JButton("New button");
		opciones.add(btnJokatu);
		
		JButton btnArauak = new JButton("New button");
		opciones.add(btnArauak);
		
		JButton btnSkip = new JButton("New button");
		opciones.add(btnSkip);
	}
	*/
	public HasieraMenua() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(500,350));
	    pack();
	    setLocationRelativeTo(null);
	    Panelprincipal = new JPanel();
	    Panelprincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(Panelprincipal);
	    Panelprincipal.setLayout(new BorderLayout(0, 0));

	    JLabel lblFotoMenu = new JLabel("");
	    lblFotoMenu.setHorizontalAlignment(SwingConstants.CENTER);
	    ImageIcon imageIcon = new ImageIcon(HasieraMenua.class.getResource("/irudiak/menu1.jpg"));
	    Image image = imageIcon.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH); // Cambia las dimensiones aquí (200x200 en este ejemplo)
	    //Image image = imageIcon.getImage().getScaledInstance(425, 250, Image.SCALE_DEFAULT); // Cambia las dimensiones aquí (200x200 en este ejemplo)
	    //Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Cambia las dimensiones aquí (200x200 en este ejemplo)
	    lblFotoMenu.setIcon(new ImageIcon(image));
	    Panelprincipal.add(lblFotoMenu, BorderLayout.CENTER);

	    JPanel opciones = new JPanel();
	    Panelprincipal.add(opciones, BorderLayout.SOUTH);
	    opciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	    opciones.add(getBtnJokatu());
	    opciones.add(getBtnArauak());
	    opciones.add(getBtnIrten());
	}
	
	private JButton getBtnArauak() {
		if(btnArauak == null) {
			btnArauak = new JButton("Arauak");
			btnArauak.addActionListener(getController());
		}
		return btnArauak;
	}
	
	private JButton getBtnJokatu() {
		if(btnJokatu == null) {
			btnJokatu = new JButton("Jokatu");
			btnJokatu.addActionListener(getController());
		}
		return btnJokatu;
	}
	
	private JButton getBtnIrten() {
		if(btnIrten == null) {
			btnIrten = new JButton("Irten");
			btnIrten.addActionListener(getController());
		}
		return btnIrten;
	}
	
	private Controller getController() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	private class Controller implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnIrten)) {
				frame.dispose();
			}
			if(e.getSource().equals(btnArauak)) {
				Arauak arauak = new Arauak();
			}
			if(e.getSource().equals(btnJokatu)) {
				Tableroa tableroa = new Tableroa();
				frame.setVisible(false);
			}
		}
	}
	

}
