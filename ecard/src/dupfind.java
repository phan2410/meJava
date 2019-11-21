import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class dupfind {
	public static void main(String[] args){
		String res="";
		try{
			BufferedReader source=new BufferedReader(new FileReader("C:\\Users\\PhanTom\\Desktop\\result.txt"));
			String line=null;
			StringBuilder src=new StringBuilder();		
			while ((line = source.readLine())!=null) {
				src.append(line.substring(1));
			}
			source.close();
			String[] temp=src.toString().split(",");
			for (int i=0;i<temp.length;i++){
				String count="";
				if (!res.toLowerCase().contains(temp[i].split("-")[1].toLowerCase())){
					for (int j=0;j<temp.length;j++){
						if ((i!=j)&&(temp[i].split("-")[1].equalsIgnoreCase(temp[j].split("-")[1]))){
							count=count+"-"+temp[j].split("-")[0];
						}
					}
				}
				if (count!="") res=res+","+temp[i]+count;
			}
		FileWriter dest=new FileWriter("C:\\Users\\PhanTom\\Desktop\\resulttt.txt");
		dest.write(res+"\r\n");
		dest.write(temp.length+"/"+(res.split(",").length-1));
		dest.close();
		}catch(Exception ex){ex.printStackTrace();}
	}
}
