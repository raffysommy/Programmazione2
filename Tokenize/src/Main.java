import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) {
		File file=new File("test.txt");
		file.deleteOnExit();
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		Tokenize(file,LeggiInput());
		LeggiFile(file);
	}
	private static void Tokenize(File file,BufferedReader input){
		boolean exit=false;
		StreamTokenizer st=new StreamTokenizer(input);
		try {
			while(!exit){
				exit=st.nextToken()==StreamTokenizer.TT_EOF;
				switch(st.ttype){
				case StreamTokenizer.TT_NUMBER:
					ScriviFile(file,"Numero:"+st.nval+"\n");
					break;
				case StreamTokenizer.TT_WORD:
					ScriviFile(file,"Lettera:"+st.sval+"\n");
					if(st.sval.equals("x")){exit=true;};
					break;
				default:
					ScriviFile(file,"Altro:"+(char)st.ttype+"\n");
					break;
				}
				System.out.println("I'm here");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static BufferedReader LeggiInput(){
		return new BufferedReader(new InputStreamReader(System.in));
	}
	
	private static void ScriviFile(File file,String testo){
		try {
			RandomAccessFile out=new RandomAccessFile(file, "rw");
			out.seek(file.length());
			out.writeUTF(testo);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void LeggiFile(File file){
		try {
			InputStream in=new FileInputStream(file);
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			String line;
			while((line=reader.readLine())!=null){
				System.out.println(line);
			}
			reader.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
}
