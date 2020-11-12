import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticaJDBC extends JFrame{

    private JLabel jlnombre;
    private JLabel jlraza;
    private JLabel jledad;
    private JLabel jlgenero;
	private JLabel labelResultado;
    private JTextField tfnombre;
    private JTextField tfraza;
    private JTextField tfedad;
    private JTextField tfgenero;
	private JButton conectar;
    private JButton insertar;

	public PracticaJDBC(){

    setLayout(null);

	jlnombre=new JLabel("Nombre: ");
	jlnombre.setBounds(10,10,100,25);
	add(jlnombre);

	jlraza=new JLabel("Raza: ");
	jlraza.setBounds(10,60,100,25);
	add(jlraza);

	jledad=new JLabel("Edad: ");
	jledad.setBounds(10,110,100,25);
	add(jledad);

	jlgenero=new JLabel("Genero: ");
	jlgenero.setBounds(10,160,100,25);
	add(jlgenero);

    tfnombre=new JTextField();
	tfnombre.setBounds(80,10,105,25);
	add(tfnombre);

    tfraza=new JTextField();
	tfraza.setBounds(80,60,105,25);
	add(tfraza);

    tfedad=new JTextField();
	tfedad.setBounds(80,110,105,25);
	add(tfedad);

    tfgenero=new JTextField();
	tfgenero.setBounds(80,160,105,25);
	add(tfgenero);

    conectar=new JButton("Conectar");
    conectar.setBounds(20,210,125,30);
    add(conectar);

			conectar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
				try{

					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bdpracticapoo","root", "");
					         if (conexion != null) {
								System.out.println("Conexion a base de datos, Ok");
								conexion.close();
							 }
				} catch(SQLException ex){System.out.println("Hubo un problema al intentar conectarse con la base de datos");}
				}
			});

    insertar=new JButton("Insertar");
    insertar.setBounds(160,210,125,30);
    add(insertar);

	        insertar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
                labelResultado.setText("");
                try{

                    Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/bdpracticapoo","root" ,"");
                    Statement comando=conexion.createStatement();
                    comando.executeUpdate("INSERT INTO perros(Nombre,Raza,Edad,Genero) values ('"+tfnombre.getText()+"','"+tfraza.getText()+"','"+tfedad.getText()+"','"+tfgenero.getText()+"')");
					conexion.close();
                    labelResultado.setText("Alta Exitosa!");
                    tfnombre.setText("");
                    tfraza.setText("");
                    tfedad.setText("");
                    tfgenero.setText("");

                }catch(SQLException ex){
                    setTitle(ex.toString());
                }
				}

			});

			labelResultado = new JLabel("Inserta Datos!");
			labelResultado.setBounds(210,50,100,100);
			add(labelResultado);

		cargarDriver();

}

    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args) {

        PracticaJDBC perros=new PracticaJDBC();
        perros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        perros.setBounds(350,200,320,300);
        perros.setVisible(true);

		       EventQueue.invokeLater(new Runnable() {
				public void run() {
				try {
					PracticaJDBC frame = new PracticaJDBC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					}
				}
		});

    }

	    private void cargarDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception ex) {
			setTitle(ex.toString());
		}
	}

}
