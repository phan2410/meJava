// Demonstrate totalMemory(), freeMemory() and gc().
import java.io.*;
class MemoryDemo {
	public static void main(String args[]) {
		try {
		//	File commands = new File("C:/Users/PhanTom/Desktop/temp/Commands.txt");
		//	 File output = new File("C:/Users/PhanTom/Desktop/temp/ProcessLog.txt");
		//	 File errors = new File("C:/Users/PhanTom/Desktop/temp/ErrorLog.txt");
		//	ProcessBuilder proc =new ProcessBuilder("cmd");
	//	proc.directory(new File("C:/Program Files/Internet Download Manager/"));
	//		proc.redirectInput(commands);
	//		proc.redirectError(errors);
		//	proc.redirectOutput(output);
			
	//	proc.start();
			//String[] abc={};
			Runtime r=Runtime.getRuntime();
			String cm="cmd /c && idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0001.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a && idman /d https://bitcoin.org/bitcoin.pdf /p F:\\abcdes /f alod.pdf /a\r\n &&idman /d http://www.ijcce.org/IJCCE_template.doc /p F: /f adsf.doc /a ";
		//	String cm="cmd /c idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0001.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0002.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0003.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0004.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0005.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0006.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0007.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0008.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0009.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0010.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0011.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0012.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0013.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0014.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0015.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a &&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0016.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a";
			r.exec(cm,null,new File("C:/Program Files/Internet Download Manager/"));
		//	r.exec("cmd /c start dir&&start cls",null,null);
		/*	rt.exec("cmd /c idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0001.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a"
				&& idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0002.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0003.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0004.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0005.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0006.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0007.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0008.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0009.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0010.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0011.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0012.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0013.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0014.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0015.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&idman /d https://sachweb.com/publish/kinhlanggiataman_id582/files/assets/flash/pages/page0016.swf?rnd=11349059995b11b6b0a44ec30905bf0c /p F:/thichthanhtu/kinhlanggiataman_id582 /a
					&&,null,new File("C:/Program Files/Internet Download Manager/"));*/
		} catch (Exception e) {
			System.out.println("Error executing notepad.");
		}
	}
}