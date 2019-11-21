import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class at8051disasm {

	public static void main(String[] args) {
		ArrayList<String[]> instrtable= new ArrayList<String[]>();
		String hexcode="";
		StringBuilder asm=new StringBuilder();
		try{
			BufferedReader instrin=new BufferedReader(new FileReader("C:\\Users\\PhanTom\\Desktop\\at8051.txt"));
			String temp=null;
			while ((temp=instrin.readLine())!=null){
				instrtable.add(temp.split("\t"));
			}
			instrin.close();
			BufferedReader hexin=new BufferedReader(new FileReader("C:\\Users\\PhanTom\\Desktop\\abc.hex"));
			StringBuilder hex=new StringBuilder();
			while ((temp=hexin.readLine())!=null){
				hex.append(temp.substring(9, 41));
			}
			hexin.close();
			hexcode=hex.toString();
		}catch (Exception ex){ex.printStackTrace();}
		for (int i=0;i<hexcode.length();i+=2){
			int instr= Integer.parseInt(hexcode.substring(i, i+2),16);
			asm.append(instrtable.get(instr)[2]);
			asm.append(' ');
			for (int j=1;j<((Integer.parseInt(instrtable.get(instr)[1],16)-1)*2);j+=2){
				asm.append(hexcode.substring(i+j,i+j+2));		
				i+=2;
			}		
			asm.append(' ');
			asm.append('/');
			asm.append('/');
			try{
				asm.append(instrtable.get(instr)[3]);
			}catch(Exception ed){}			
			asm.append("\r\n");			
		}
		try{
			FileWriter dest=new FileWriter("C:\\Users\\PhanTom\\Desktop\\output.txt");
			dest.write(asm.toString());
			dest.close();
		}catch(Exception ex){ex.printStackTrace();}		
	}
}
