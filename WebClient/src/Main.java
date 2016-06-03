import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;

public class Main {

	public static void main(String[] args) throws IOException {
		GetFile urlw=new GetFile();
		URLConnection conn= urlw.pagina.openConnection();
		conn.connect();
		System.out.println("Connessione Aperta");
		BufferedReader data= new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while((line=data.readLine())!=null){
			System.out.println(line);
		}
		

	}

}
