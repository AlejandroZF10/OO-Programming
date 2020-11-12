import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class ChatBotImpl extends UnicastRemoteObject implements ChatBot{

	String[] preguntas = {"Cual es tu nombre?","Cual es tu edad?","Que materia es esta?",
	"Lenguaje de programacion favorito","Que idiomas hablas?","Cual es tu comida favorita?",
	"Cual es la mejor pelicula de la historia?","Cual es tu auto favorito?",
	"Quien es el mejor jugador del mundo?","Quien quieres que sea tu novia?"};

	String[] respuestas={"Alejandro Zepeda","21 years","Programacion Orientada","Java","Ingles y Frances",
		"Lasagna","Avengers Infinity War","Mazda C3","Lionel Messi","Monserrat"};

	public ChatBotImpl() throws RemoteException{
		super();
	}
	public String chatear (String str) throws RemoteException{
		String e = "No tengo esa respuesta en mi repertorio";
		String result = "";
	  	for(int i = 0; i < preguntas.length; ++i)
	  		if(preguntas[i].equalsIgnoreCase(str)) {
	        	result = respuestas[i];
	  		break;
	      	}
	      	else{
	  			result = e;
	  		}
		return result;
	}
	public static void main(String s[]){
		try{
			ChatBotImpl c = new ChatBotImpl();
			Naming.rebind("Calcular",c);
		}catch(RemoteException re){
		 System.out.println("Exception in ChatBotImpl.main: " + re);}
		 catch(MalformedURLException e) {
      	 System.out.println("MalformedURLException en ChatBotImpl.main: " + e);
   		}
   	}
}