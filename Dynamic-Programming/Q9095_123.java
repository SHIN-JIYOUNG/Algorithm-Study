package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * 
 * Bottom-up 방식 사용,
 * input할 수를 1, 2, 3을 더하여 만들 수 있는 경우의 수를 반환해야하므로
 * 각 숫자(=배열의 인덱스)마다 만들 수 있는 경우의 수를 배열의 값으로 넣어주고, input이 인덱스로 차지한 배열 값을 반환할 것임
 * for문을 쓴 이유?: 아래 식을 반복하며 배열에 값을 넣어주기 위하여
 * ex. arr[4]=arr[4-1]+arr[4-2]+arr[4-3]
 * => 4를 만들 수 있는 경우의 수는: 4에서 1을 더하기 전인 3의 경우의 수+ 4에서 3을 더하기 전인 2의 경우의 수+ 4에서 3을 더하기 전인 1의 경우의 수
 * @author JIYOUNG
 *
 */
public class Q9095_123 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase; //테스트케이스를 선언할 변수 
		int input; //읽어들일 숫자 변수
		int[] arr = new int[11]; // 정수가 10까지 들어올거니까 숫자에 맞게 인덱스 설정 
		arr[0] = 1; // 공집합이므로 값 1 설정 
		arr[1] = 1; // 1을 만들 수 있는 건 =1 뿐이므로 값은 1 
		arr[2] = 2; // 2를 만들 수 있는 건 =1+1, 2 총 2가지이므로 값은 2  
		for (int i = 3; i < arr.length; i++) { // 3부터는 케이스가 여러가지로 나뉘기때문에 반복문 실행
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]; // 윗 주석 참고
		}

		StringBuilder sb=new StringBuilder();
		while ((testcase = Integer.parseInt(br.readLine())) > 0) { //testcase의 수 만큼 반복 
			testcase--; //한 번 실행하면 testcase 감소 
			input = Integer.parseInt(br.readLine()); //경우의 수 구할 값 받아오기 
			sb.append(arr[input]).append("\n"); //배열에 넣어놓은 input의 경우의 수 StringBuilder에 붙이기 
			bw.write(sb.toString());//쓰기 
			bw.flush();//분출 
		}
		br.close();//메모리 누수를 방지하기 위해 닫아줌 
		bw.close();
	}

}