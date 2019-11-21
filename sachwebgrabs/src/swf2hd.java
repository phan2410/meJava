import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class swf2hd {
	public static void main(String[] args){		
		try{
			BufferedReader source=new BufferedReader(new FileReader("C:\\Users\\PhanTom\\Desktop\\linkgen.txt"));
			String temp=null;
			Runtime rt=Runtime.getRuntime();
			while((temp=source.readLine())!=null){	
				String temptrim= temp.trim();
				String[] linkpart=temptrim.substring(temptrim.indexOf('/', 27)+1, temptrim.length()).split("/");//temptrim.indexOf('/', 27)+1 = 32 neu k co www va link thuong, 28 voi link k co www va link login, 32 neu co www va link login
				String[] linkchange=linkpart[linkpart.length-1].split(" ");
				temptrim="&& idman /d https://sachweb.com/publish/"+linkpart[0]+"/"+linkpart[1]+"/"+linkpart[2]+"/"+linkpart[3]+"/"+linkpart[4]+"/page";
				temp=linkchange[0].substring(8, linkchange[0].length())+" /p F:/thichthanhtu/"+linkpart[0]+" /a";
				ArrayList<StringBuilder> commandchunk= new ArrayList<StringBuilder>();//chon chunk 27 cho no chac ^_^ ngay sinh cua meo nho
				rt.gc();
				for (int j=0;j<Integer.parseInt(linkchange[1]);j++){
					if ((j%27)==0){//moi khi bat dau 1 chunk moi thi xoa && o dau temptrim va add cmd /c de start process runtime
						commandchunk.add(new StringBuilder());
						commandchunk.get(j/27).append(temptrim);
						commandchunk.get(j/27).delete(0,2);
						commandchunk.get(j/27).insert(0, "cmd /c");
					}else
						commandchunk.get(j/27).append(temptrim);
					if (j<9){
						commandchunk.get(j/27).append("000");
						commandchunk.get(j/27).append(j+1);
					}else if (j<99){
						commandchunk.get(j/27).append("00");
						commandchunk.get(j/27).append(j+1);
					}else if (j<999){
						commandchunk.get(j/27).append("0");
						commandchunk.get(j/27).append(j+1);
					}else if (j<9999){
						commandchunk.get(j/27).append(j+1);
					}else
						break;
					commandchunk.get(j/27).append(temp);
				}
				for (int c=0;c<commandchunk.size();){
					Process synrt = rt.exec(commandchunk.get(c).toString(),null,new File("C:/Program Files/Internet Download Manager/"));
					while(synrt.isAlive()){}
					commandchunk.remove(c);
				}
				rt.gc();
			}
			source.close();
		}catch(Exception ex){ex.printStackTrace();}
	}	
}
