import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ECard {
	public static void main(String[] args) {
		String[] db=new String[16];
		for (int i=0;i<16;i++){
			db[i]=",";
		}
		try{
			BufferedReader source=new BufferedReader(new FileReader("C:\\Users\\PhanTom\\Desktop\\test.txt"));
			String line=null;
			while ((line = source.readLine())!=null) {
				String[] t=line.split("\t");
				if (t.length>3){
					String tempt=end(t[1].trim()).concat(",");
					int id=0;
					if ((t[2].trim()=="")||(t[2].trim()==null)){
						if ((t[4].trim()=="")||(t[4].trim()==null)){
							if (!db[id].toLowerCase().contains(tempt.toLowerCase()))
								db[id]=db[id].concat(id+"-"+tempt);
						}
					}else{
						switch (t[0].trim()){
						case "m":	
							switch (t[2].trim()){
							case "e":
								id=1;
								break;
							case "n":
								id=2;
								break;
							case "en":
								id=3;
								break;
							case "er":
								id=4;
								break;
							case "s":
								id=5;
								break;
							default:
								break;
							}
							break;
						case "f":
							switch (t[2].trim()){
							case "e":
								id=6;
								break;
							case "n":
								id=7;
								break;
							case "en":
								id=8;
								break;
							case "er":
								id=9;
								break;
							case "s":
								id=10;
								break;
							default:
								break;
							}
							break;
						case "n":
							switch (t[2].trim()){
							case "e":
								id=11;
								break;
							case "n":
								id=12;
								break;
							case "en":
								id=13;
								break;
							case "er":
								id=14;
								break;
							case "s":
								id=15;
								break;
							default:
								break;
							}
							break;
						default:
							break;
						}
						if (!db[id].toLowerCase().contains(tempt.toLowerCase()))
							db[id]=db[id].concat(id+"-"+tempt);
					}
				}
			}			
			source.close();
			FileWriter dest=new FileWriter("C:\\Users\\PhanTom\\Desktop\\result.txt");
			for (int i=0;i<16;i++){
				dest.write(db[i]+"\r\n");
			}
			dest.close();
		}catch (Exception ex){ex.printStackTrace();}
	}
	
	public static String end(String str){
		int l=str.length()-1;
		for (int i=0;i<str.length();i++){
			if (!vowel(str.charAt(l))){
				l--;
			}else{
				do{
					if (vowel(str.charAt(l))){
						l--;
					}else
						break;
				}while(true);
				break;
			}
		}
		return str.substring(l+1);
	}
	
	public static boolean vowel(char a){
		boolean temp=false;
		if ((a=='u')||(a=='e')||(a=='o')||(a=='a')||(a=='i')||(a=='y')
				||(a=='ä')||(a=='ö')||(a=='ü')){
			temp=true;
		}else 
			temp=false;
		return temp;
	}
}
