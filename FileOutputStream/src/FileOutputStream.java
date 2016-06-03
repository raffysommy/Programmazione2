
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FileOutputStream {
	public static void main(String argv[]){
		java.io.FileOutputStream fis;
		try {
			fis = new java.io.FileOutputStream("./test.txt");
			BufferedOutputStream bos=new BufferedOutputStream(fis);
			DataOutputStream dis=new DataOutputStream(bos);
			dis.writeDouble(1.323);
			dis.writeInt(44);
			dis.writeUTF("ciao");
			dis.flush();
			dis.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
