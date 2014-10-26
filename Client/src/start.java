import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class start implements Runnable {
	
	final Client c;
	Thread thread = new Thread(this);
	
	public static void main(String[] args){
		try {
			new start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public start() throws UnknownHostException, IOException{
		c = new Client(new Socket("10.1.32.57",3412));
		c.write("Connection test");
		thread.start();
		Scanner sc = new Scanner(System.in);
		while(true){
			c.write(sc.nextLine());
		}
	}

	@Override
	public void run() {
		while(true){
			if(c.ready())
				System.out.println(c.read());
		}
	}
	
}
