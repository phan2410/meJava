import java.io.FileInputStream;
import java.io.FileWriter;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

public class Word {

	public static void main(String[] args){
		StringBuilder txtout=new StringBuilder().append(".");		
		HWPFDocument source=null;		
		for (int filenum=1;filenum<5;filenum++){
			try{
				source=new HWPFDocument(new FileInputStream("C:\\Users\\PhanTom\\Desktop\\dicc"+filenum+".doc"));
			}catch(Exception ex){System.out.println("The program failed to open .doc file");ex.printStackTrace();}		
			for (int i=0;i<source.characterLength();i++){
				int j=1;
				StringBuilder temp=new StringBuilder();
				CharacterRun cr=new Range(i,i+1,source).getCharacterRun(0);	
				while((cr.isItalic())&&(Character.isUpperCase(cr.text().charAt(0)))){
					temp.append(cr.text());
					cr=new Range(i+j,i+1+j++,source).getCharacterRun(0);
				}
				if ((temp.length()>1)&&(cr.isItalic())&&(cr.text().charAt(0)=='.')){
					if (txtout.indexOf("."+temp.append('.').toString())<0)
						txtout.append(temp);
				}
				i+=j-1;
			}
		}
		try{
			FileWriter writeout=new FileWriter("C:\\Users\\PhanTom\\Desktop\\areaterm.txt");
			writeout.write(txtout.toString());
			writeout.flush();
			writeout.close();
		}catch (Exception ex){ex.printStackTrace();}
	}
}
