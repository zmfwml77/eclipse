package test.main;

import java.io.File;

public class MainClass11 {
	public static void main(String[] args) {
		File f=new File("c:/myFolder");
		File[] files=f.listFiles();
		for(File tmp:files) {
			tmp.delete();
		}
		System.out.println("c:/myFolder에 하위에 있는 모든 파일을 삭제했습니다");
		
	}
}
