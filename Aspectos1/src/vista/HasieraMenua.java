package vista;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.JugadorNormal;
import model.JugadorCPU;
import model.Juego;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class HasieraMenua extends JFrame {

	private static HasieraMenua frame;
	private JPanel Panelprincipal;
	private Controller controller;
	private JButton btnArauak;
	private JButton btnJokatu;
	private JButton btnIrten;
	private JPanel panelNombreEdad;
	private JTextField txtfldEdad;
	private JLabel lblEdad;
	private JTextField txtfldNombre;
	private JLabel lblNombre;

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
	    Panelprincipal.add(getPanelNombreEdad(), BorderLayout.NORTH);
	}
	
	private JButton getBtnArauak() {
		if(btnArauak == null) {
			btnArauak = new JButton("Reglamento");
			btnArauak.addActionListener(getController());
		}
		return btnArauak;
	}
	
	private JButton getBtnJokatu() {
		if(btnJokatu == null) {
			btnJokatu = new JButton("Jugar");
			btnJokatu.addActionListener(getController());
		}
		return btnJokatu;
	}
	
	private JButton getBtnIrten() {
		if(btnIrten == null) {
			btnIrten = new JButton("Salir");
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
				String nombre = HasieraMenua.this.txtfldNombre.getText();
				int edad = Integer.parseInt(HasieraMenua.this.txtfldEdad.getText());
				//Tableroa tableroa = new Tableroa(nombre);
				frame.setVisible(false);
				partidaPrestatu(nombre, edad);
				//ListaJokalaria.partidaJolastu(nombre,edad);
			}
		}
	}
	
	public void partidaPrestatu(String n, int e) {
		Tableroa tableroa = new Tableroa(n);
		Consola con = new Consola();
		int j,m;
		//System.out.println("Sartu zure nick-a");
		//String izena = Teklatua.getNireTeklatua().irakurriString();
		System.out.println("Zure nick-a: " + n);
		//System.out.println("Sartu zure adina");
		//Teklatua.getNireTeklatua();
		//int adina = Teklatua.getNireTeklatua().irakurriOsoa();
		Random rd = new Random();
		int adinaCPU = rd.nextInt(100)+1;
		System.out.println(adinaCPU);
		System.out.println(e);
		if (adinaCPU < e) {
			System.out.println("Makina lehenengo jokalaria da");			
			m = 0;
			j = 1;
			
		}
		else {
			System.out.println("Lehenengo jokalaria zara");
			
			j = 0;
			m = 1;
		}
		Juego.getMiJuego().getLista()[j] = new JugadorNormal(n,e,j);
		//ListaJokalaria.getNireListaJokalariak().getZerrenda()[j].addObserver(tableroa);
		Juego.getMiJuego().getLista()[m] = new JugadorCPU(adinaCPU,m);
		//ListaJokalaria.getNireListaJokalariak().getZerrenda()[m].addObserver(tableroa);
		Juego.getMiJuego().addObserver(tableroa);
		Juego.partidaJolastu(j,m);
	}
	

	private JPanel getPanelNombreEdad() {
		if (panelNombreEdad == null) {
			panelNombreEdad = new JPanel();
			panelNombreEdad.add(getLblNombre());
			panelNombreEdad.add(getTxtfldNombre());
			panelNombreEdad.add(getLblEdad());
			panelNombreEdad.add(getTxtfldEdad());
		}
		return panelNombreEdad;
	}
	private JTextField getTxtfldEdad() {
		if (txtfldEdad == null) {
			txtfldEdad = new JTextField();
			txtfldEdad.setText("20");
			txtfldEdad.setColumns(10);
		}
		return txtfldEdad;
	}
	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("edad");
		}
		return lblEdad;
	}
	private JTextField getTxtfldNombre() {
		if (txtfldNombre == null) {
			txtfldNombre = new JTextField();
			txtfldNombre.setText("Player");
			txtfldNombre.setColumns(10);
		}
		return txtfldNombre;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("nombre");
		}
		return lblNombre;
	}
}
