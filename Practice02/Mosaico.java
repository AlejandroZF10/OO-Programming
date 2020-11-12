import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class Mosaico extends JFrame implements ActionListener {
	JButton botones[] = new JButton[40];
	BufferedImage imagenes[];
	String s= ""; Container c;
	JLabel mensaje;
	public Mosaico(){
		c = getContentPane();
		imagenes = new BufferedImage[40];
		setLayout(new GridLayout(8,5));
		for(int i = 0; i < 40; i++){
			s= i+".jpg";
			imagenes[i] = leeImagen(s);
			add(botones[i] = new JButton(new ImageIcon(imagenes[i])));
			mensaje = new JLabel("           ");
			c.add("South",mensaje);
			botones[i].addActionListener(this);	
		}
	        setSize(900, 900); setVisible(true);  
	}
	public void actionPerformed ( ActionEvent e ){
		JButton b=(JButton)e.getSource();
		mensaje.setIcon( b.getIcon() );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String s[]){ new Mosaico(); }
	public BufferedImage leeImagen(String nombre){
		BufferedImage imagen;
		try{
			imagen = ImageIO.read(new File(nombre));     
		}catch (IOException e){
	       		System.err.println(e+" "+nombre);
     			return null;
		}
		return imagen;
   	}
}
	