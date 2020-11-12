/*	Implementacion de un hilo */

public class Ticket implements Runnable{

	private int sleepTime, howMany, i;

	private String s, s2 = "";

	Thread t;


	

	public Ticket(int n, int sleep, String string){
	
		sleepTime = sleep;
	
		howMany = n;
	
		s = string; 

		
		t = new Thread(this); // This es el objeto de una clase que implementa la interfaz Runneable
					t.start();

	}


	public void run(){

		char imprimir;
	
		int tam;


		tam = s.length();

		System.out.println(s);

		while(true){

			for(i = 0; i < s.length() ; i++)
				s2 +=  s.charAt((i+1) % s.length());

			System.out.println(s2);
	
			s = s2;
	
			s2 = "";


			
			try{

				Thread.sleep(300); //tiempo de ejecucion

			}

			catch(Exception e){

				return;

			}

			
			howMany--;

		}

	}


	
	public static void main(String s[]){

		new Ticket(5, 500, "This put does a smile on my face");
	}

	

	interface Runneable{

		void run();
	}

}