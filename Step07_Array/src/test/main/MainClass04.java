package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		
		// new int[5] 가 뭐지요? => {0,0,0,0,0}
		int[] nums=new int[5];
		
		// new String[3] ? => {null, null, null}
		String[] names=new String[3];
		String[] friends =  new String[5];
			friends[0] = "김";
			friends[1] = "이";
			friends[2] = "박";
			friends[3] = "최";
			friends[4] = "한";
		for(int i=0; i<friends.length; i++) {
			friends[i]=null;
			String tmp=friends[i];
			System.out.println(tmp);
		}
		int size=friends.length;
		
		//미리 만들어진 배열에 item 저장하기
		nums[0]=10;
		nums[1]=20;
		nums[2]=30;
		
		names[0]="김구라";
		names[1]="해골";
		names[2]="원숭이";
		
	}
}
