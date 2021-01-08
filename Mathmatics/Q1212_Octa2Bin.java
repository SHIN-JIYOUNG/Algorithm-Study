package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 8진수를 2진수로 변환하기
 * 8진수는 한 자리당 숫자 0~7까지 쓰이기 때문에 각 숫자에 따라 2진수를 표현해주면 됨
 * 가독성을 위하여 (+ 8가지 경우밖에 없기 때문에) switch/case문을 사용
 * 만약 2진수로 변환한 후 앞자리에 0이 온다면 0을 삭제함
 * @author JIYOUNG
 *
 */
public class Q1212_Octa2Bin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String inputOcta = br.readLine(); //8진수를 받아들일 변수 
		
		if (inputOcta.length() == 1) { //만약 받아들인 숫자가 0이라면 0을 그대로 출력해줘야 하기 때문에 
			sb.append("0");//0 출력 
			//왜?: 만약 if문이 없었더라면 0을 넣었을 시 맨 앞에 0을 지워주는 while문 때문에 값이 사라졌을 것이기 때문 
		}

		for (int i = 0; i < inputOcta.length(); i++) { //입력될 8진수의 길이까지 for문으로 반복 
			switch (inputOcta.charAt(i)) { //i가 8진수의 한 자리마다 index 역할, index를 불러들이는 method 사용 때문에 char형 사용  
			case '0': //해당 인덱스의 숫자가 0이라면 
				sb.append("000");//000을 2진수 출력값에 붙여주기 
				break; //나가기 
				////이후로 ~7까지 반복 ////
			case '1':
				sb.append("001");
				break;
			case '2':
				sb.append("010");
				break;
			case '3':
				sb.append("011");
				break;
			case '4':
				sb.append("100");
				break;
			case '5':
				sb.append("101");
				break;
			case '6':
				sb.append("110");
				break;
			case '7':
				sb.append("111");
				break;
			}

		}
		while (inputOcta.length() > 1 && sb.charAt(0) == '0') { //8진수 입력값의 길이가 1보다 길고, 맨 첫자가 0이 아닐때까지 while문 반
 			sb.deleteCharAt(0);//0번 인덱스, 즉 맨 첫자리를 지워낸다 
		}

		bw.write(String.valueOf(sb));//출력 
		bw.flush();//분출 
		br.close();//메모리 누수 방지를 위해 닫기 
		bw.close();
	}
}