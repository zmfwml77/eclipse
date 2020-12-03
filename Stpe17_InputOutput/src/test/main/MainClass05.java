package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		//콘솔창에 출력할 수 있는 객체의 참조값을 ps 라는 지역변수에 담기
		PrintStream ps=System.out;
		//학습을 위해서 PrintStream 객체를 부모 type OutputStream 변수에 담기
		OutputStream os=ps;
		//2byte 처리
		OutputStreamWriter osw=new OutputStreamWriter(os);
		try {
			osw.write("안녕하세요");
			osw.write("\n");// '\n' or '\r'만 써도 되는데, '\r\n'은 모든 운영체제에서 받아줌.
			osw.write("어쩌구..");
			osw.write("\n");
			osw.write("저쩌구..");
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
