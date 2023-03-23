package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class VentanaPrincipal extends JFrame {
	public static String TITULO_APLICACION = "el titulito wapo amono";
	public static BufferedImage iconoApp;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	
		v.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				String posiblesRespuestas[] = {"Si","No"};
				// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado	
				int opcionElegida = JOptionPane.showOptionDialog(null, "Salir?", TITULO_APLICACION, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas,  posiblesRespuestas[1]);
			    if(opcionElegida == 0) {
			      System.exit(0);          
			    }
			}
		});	
	}
		
	/**
	 * 
	 */
	public VentanaPrincipal () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("Alquileres", new PanelAlquiler());
		this.setMinimumSize(new Dimension(800, 600));
		
		this.setContentPane(tabedPane);
	}
}
