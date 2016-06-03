import java.net.MalformedURLException;
import java.net.URL;

public class GetFile {
	URL pagina;
	public GetFile(){
		try {
			pagina=new URL("http://www.r4ffy.info");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
