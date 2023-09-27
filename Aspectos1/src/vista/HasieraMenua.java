package vista;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HasieraMenua extends JFrame {

	private JPanel Panelprincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HasieraMenua frame = new HasieraMenua();
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
	    setBounds(100, 100, 450, 300);
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

	    JButton btnJokatu = new JButton("Jokatu");
	    opciones.add(btnJokatu);

	    JButton btnArauak = new JButton("Arauak");
	    opciones.add(btnArauak);

	    JButton btnSkip = new JButton("Skip");
	    btnSkip.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    opciones.add(btnSkip);
	}

}
