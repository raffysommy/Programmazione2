import java.io.IOException;
import java.net.ServerSocket;

public class Main {
	public static void main(String argv[]) throws IOException{
		ServerSocket server = null;
		try {
			server=new ServerSocket(12345);
			while(true){
				new Worker(server.accept()).run();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(server!=null){
				server.close();
			}
		}
	}
}
