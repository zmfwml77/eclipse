package test.main;
/*
 *  [ 기본 데이터 type 에 대응되는 참조 data type ]
 *  
 *  byte    : Byte
 *  short   : Short
 *  int     : Integer
 *  long    : Long
 *  
 *  float   : Float
 *  double  : Double
 *  
 *  char    : Character
 *  boolean : Boolean
 */
public class MainClass01 {
	public static void main(String[] args) {
		//기본 데이터 type
		int num1=10; // num. 하면 기본 데이터 type이기 때문에 아무것도 안 뜸
		//참조 데이터 type
		String name="kim"; // name. 하면 참조되는 목록들이 나열
		Integer num2=10;   //  num2. 하면 참조되는 목록들이 나열
		int a =num2.SIZE;
		System.out.println(a);
		
		//참조 데이터 type  이지만 기본 데이터 type 과 동일 하게 사용할수 있다.
		int result1=num2+1;
		int result2=num1+num2;
		Integer result3=num1+num2;
		
		/*
		 *  Integer type  의 메소드를 이용해서 
		 *  
		 *  10 => "10" 문자열로 바꾸기 
		 */
		String result4=num2.toString();
		
		/*
		 *  Integer 클래스의 static 메소드를 이용해서
		 *  "999" => 999 정수로 바꾸기 
		 */
		int result5=Integer.parseInt("999");
	}
}







