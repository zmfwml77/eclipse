package test.main;

import java.io.File;

public class MainClass10 {
	public static void main(String[] args) {
		
		for(int i=0; i<100; i++) {
			File tmp=new File("c:/myFolder/gura"+i);
			tmp.mkdir();
			//mkdir() 대신 delete() 하면 삭제기능.
		}
		System.out.println("");
	}
}
