package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * 1. 3명의 회원 정보를 HashMap 객체를 3개 생성해서 각각 담아보세요.
		 *    변호 => "num"  이라는 키값으로 정수 저장
		 *    이름 => "name" 이라는 키값으로 문자열 저장
		 *    주소 => "addr" 이라는 키값으로 문자열 저장
		 *    
		 * 2. 위에서 생성한 Map을 담을 ArrayList 객체를 생성하고 생성된 참조값을
		 *    members 라는 이름의 지역변수에 담아보세요
		 *    
		 * 3. members에 회원 정보가 담긴 Map객체의 참조값을 순서대로 담아보세요.
		 * 
		 * 4. 반복문 돌면서 members 에 담긴 내용을 아래와 같은 형식으로 출력해보세요.
		 *    번호 : 1, 이름 : 김구라, 주소 : 노량진
		 *    번호 : 2, 이름 : 해골, 주소 : 행신동
		 */
		Map<String, Object> map1=new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		Map<String, Object> map2=new HashMap<>();
		map2.put("num", 2);
		map2.put("name", "해골");
		map2.put("addr", "행신동");
		Map<String, Object> map3=new HashMap<>();
		map3.put("num", 3);
		map3.put("name", "원숭이");
		map3.put("addr", "상도동");
		List<Map> members=new ArrayList<>();
		members.add(map1);
		members.add(map2);
		members.add(map3);
		for(Map tmp:members) {
			//번호
			int num=(int)tmp.get("num"); //tmp=>map type, tmp.get("num") => Object type
			//이름						 // (int)tmp.get("num") => int type
			String name=(String)tmp.get("name");
			//주소
			String addr=(String)tmp.get("addr");
			System.out.println("번호 : "+num+", 이름 : "+name+", 주소 :"+addr);
		}
		
//		HashMap<String, Object> mem1=new HashMap<>();
//		mem1.put("num", 1);
//		mem1.put("name", "김구라");
//		mem1.put("addr", "노량진");
//		HashMap<String, Object> mem2=new HashMap<>();
//		mem2.put("num", 2);
//		mem2.put("name", "해골");
//		mem2.put("addr", "행신동");
//		HashMap<String, Object> mem3=new HashMap<>();
//		mem3.put("num", 3);
//		mem3.put("name", "원숭이");
//		mem3.put("addr", "상도동");
//		
//		List<HashMap> members=new ArrayList<>();
//		members.add(mem1);
//		members.add(mem2);
//		members.add(mem3);
//		for(HashMap tmp:members) {
//			System.out.println("번호 : "+tmp.get("num")+
//					", 이름 : "+tmp.get("name")+
//					", 주소 : "+tmp.get("addr"));
//		}
	}
}
