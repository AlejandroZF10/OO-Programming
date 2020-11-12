import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {

	String Questions[] = {"Como te llamas","Cual es tu color favorito","Cual es tu edad","Que materia es esta","Numero de puerto","Equipo favorito","Numero favorito","Comida favorita","Pelicula favorita","Auto favorito"},
			Response;

	Socket socket;
	DataOutputStream outputStream;
	DataInputStream inputStream;

	public Cliente(){
		for (int i=0; i<Questions.length; i++) {
			System.out.print("\n"+ (i+1) + "." + Questions[i] + "?");
		}
		System.out.print("\n\nOpcion: ");
		Scanner scanner = new Scanner(System.in);
		Response = scanner.nextLine();
	}

	public void connectClient(){
		try{
			socket = new Socket("localhost", 5000);
			outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeUTF(Response);
			inputStream = new DataInputStream(socket.getInputStream());
			System.out.println("The server answer is: " + inputStream.readUTF());
			socket.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		while(true){
			new Cliente().connectClient();
		}
	}
}