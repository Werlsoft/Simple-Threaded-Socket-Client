import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;


public class Client {

	final BufferedReader br;
	final PrintWriter pw;
	final UUID id = UUID.randomUUID();
	
	public Client(Socket sock) throws IOException{
		br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		pw = new PrintWriter(sock.getOutputStream(),true);
	}
	
	public void write(String str){
		pw.println(id + str);
	}
	
	public String read(){
		try {
			if(br.ready())
				return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean ready(){
		try {
			return br.ready();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
