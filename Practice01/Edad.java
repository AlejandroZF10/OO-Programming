import java.awt.*;
import java.awt.event.*;

import java.applet.*;


public class Edad extends Applet implements ActionListener {
	Button calcular;
    TextField texto;
	Label etiqueta;

    public void init(){
        texto = new TextField(10); add(texto);
        calcular = new Button("Calcular"); add(calcular);
        calcular.addActionListener(this);
		etiqueta = new Label("************"); add(etiqueta);
    }
        
	public void actionPerformed(ActionEvent e){
		int fecha = Integer.parseInt(texto.getText());
		int actual = Integer.parseInt("2018");
		int nuevo = Integer.parseInt("2018");
		nuevo = actual - fecha;
        etiqueta.setText("Edad: "+nuevo);
	}

	public static void main(String s[]){
		Edad age = new Edad();
		age.init(); age.start();
	}
}