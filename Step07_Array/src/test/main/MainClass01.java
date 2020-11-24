package test.main;
/*
 * 1. 배열을 어떻게 만드는지?
 *    ㄴ 배열은 중괄호 {} 열고 닫고해서 만든다
 * 2. 배열의 데이터 type 은 어떻게 선언하는지?
 *    ㄴ 배열안에 저장된 type + [] 기호를 조합해서 선언한다
 * 3. nums, nums2, truth, names 에 저장된 값은 참조값인지? 아니면 기본 데이터값인지?
 *   (=배열이 참조 데이터 type인지? 기본 데이터 type인지?)
 *   ㄴ 배열은 참조 데이터 type 이다.
 */
public class MainClass01 {
	public static void main(String[] args) {
		// int type 5개를 저장하고 있는 고정 배열
		int[] nums = {10, 20, 30, 40, 50};
		// double type 5개를 저장하고 있는 배열
		double[] nums2= {10.1, 10.2, 10.3, 10.4, 10.5};
		// boolean type 3개를 저장하고 있는 배열
		boolean[] truth = {true, false, false};
		// String type 3개를 저장하고 있는 배열
		String[] names = {"김구라", "해골", "원숭이"};
		
//		nums.length 에서 length는 메소드?필드? = 필드임.
//		nums. 하면 뜨는 연두색 동그라미 모양에따라 메소드, 필드로 나뉨
		// 배열의 방의 갯수 5 가 참조된다
		int size = nums.length;
		// 배열의 방의 갯수 3이 참도된다.
		int size2 = names.length;
		
		// 배열의 각각의 방에 저장된 아이템을 참조하는 방법
		int num1=nums[0]; // 10
		int num2=nums[1]; // 20
		int num3=nums[2]; // 30
		
		String name1=names[0]; // "김구라"
		String name2=names[1]; // "해골"
		String name3=names[2]; // "원숭이"
		/* 위 문제의 대한 나의 정답
		 * 1.data type 선언 후 대괄호입력 후 배열의 이름을 정하고 value값을 넣어준다.
		   2.맨 처음에 타입을 선언
		   3. int를 제외한 나머지 (double, boolean, String)는 참조 데이터 type이다.
		      x 틀림! int[] 를 한 순간부터 참조데이터타입으로 변경. ( 배열을 만든 순간부터 )
		*/
	}
}
