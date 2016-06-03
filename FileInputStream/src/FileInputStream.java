import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream {

	public static void main(String[] args) {
		try {
			java.io.FileInputStream fis=new java.io.FileInputStream("../FileOutputStream/test.txt");
			BufferedInputStream bis=new BufferedInputStream(fis);
			DataInputStream dis=new DataInputStream(bis);
			System.out.println("Ho letto: "+dis.readDouble()+" "+dis.readInt()+ " "+dis.readUTF());
			dis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
