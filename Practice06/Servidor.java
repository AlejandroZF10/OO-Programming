import java.net.*;
import java.io.*;
import java.awt.*;

public class Servidor {

	public static void main(String args[]) {
		int numero;
		Socket client;
		DataOutputStream outputSream;
		DataInputStream inputStream;
		ServerSocket serverSocket;

		String Questions[] = {"Como te llamas","Cual es tu color favorito","Cual es tu edad","Que materia es esta","Numero de puerto","Equipo favorito","Numero favorito","Comida favorita","Pelicula favorita","Auto Favorito"},

		Answers[] = {"Alejandro Zepeda","Azul","20 years old","Programacion Orientada","5000","Cruz Azul","10","Lasagna","Avengers Infinity War","Audi A5","NO ANSWERS"};

		try{
			serverSocket = new ServerSocket(5000);
			System.out.println("Conectandose...");

			while(true){
				client = serverSocket.accept();
				System.out.println("The connection is ok");
				outputSream = new DataOutputStream(client.getOutputStream());
				inputStream = new DataInputStream(client.getInputStream());
				String request = inputStream.readUTF();
				numero = Integer.parseInt(request)-1;
				for (int i=0; i<Questions.length; i++) {
					if (numero == i) 
						outputSream.writeUTF(Answers[i]);
				}

				System.out.println("Closing connection");
				client.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}