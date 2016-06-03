import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayIOApp {

	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream outStream=new ByteArrayOutputStream();
		String s="Questo è un messaggio di prova";
		outStream.write(s.getBytes());
		ByteArrayInputStream inStream=new ByteArrayInputStream(outStream.toByteArray());
		int numbyte=inStream.available();
		byte Buffer[]=new byte[numbyte];
		inStream.read(Buffer);
		System.out.println("Ho letto:"+new String(Buffer)+"di nbyte:"+numbyte);

	}

}
