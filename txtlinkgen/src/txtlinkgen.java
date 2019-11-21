import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class txtlinkgen {
	public static void main(String[] args){		
		try{
			BufferedReader source=new BufferedReader(new FileReader("C:\\Users\\PhanTom\\Desktop\\linkgen.txt"));
			String temp=null;
			Runtime rt=Runtime.getRuntime();
			while((temp=source.readLine())!=null){
				String[] linkpart=temp.substring(28, temp.length()).split("/");
				String[] linkchange=linkpart[linkpart.length-1].split(" ");
				String head="https://sachweb.com/publish/"+linkpart[0]+"/"+linkpart[1]+"/"+linkpart[2]+"/"+linkpart[3]+"/"+linkpart[4]+"/page";
				String bottom=linkchange[0].substring(8, linkchange[0].length())+"\r\n";
				StringBuilder outcontent=new StringBuilder();
				for (int j=1;j<(Integer.parseInt(linkchange[1])+1);j++){
					outcontent.append(head);
					if (j<10){
						outcontent.append("000");
						outcontent.append(j);
					}else if (j<100){
						outcontent.append("00");
						outcontent.append(j);
					}else if (j<1000){
						outcontent.append('0');
						outcontent.append(j);
					}else if (j<10000){
						outcontent.append(j);
					}else
						break;
					outcontent.append(bottom);
				}
				FileWriter dest=new FileWriter("C:\\Users\\PhanTom\\Desktop\\gentxt\\"+linkpart[0]+".txt");
				dest.write(outcontent.toString());
				dest.close();
				rt.gc();
			}
			source.close();
		}catch(Exception ex){ex.printStackTrace();}
	}	
}
