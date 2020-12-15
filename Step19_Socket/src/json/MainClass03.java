package json;

import org.json.JSONObject;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * 이전 예제와 같은
		 * {"num":1, "name":"김구라", "isMan":true} 형식의 문자열을
		 * 라이브러리의 도움을 받지 않고 만드는 코드는 아래왜 같다.
		 */
		//아래 변수의 값을 참조해서 JSON문자열을 만든다면
		int num=1;
		String name="김구라";
		boolean isMan=true;
//		String result1="{\"num\":1, \"name\":\"김구라\", \"isMan\":true"}"....(실패)
		
		//라이브러리를 이용한다면..
		JSONObject obj2=new JSONObject();
		obj2.put("num", num);
		obj2.put("name", name);
		obj2.put("isMan", isMan);
		
		String result2=obj2.toString();
		System.out.println("result2 : "+result2);
		
	}
}
