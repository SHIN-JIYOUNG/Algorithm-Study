package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 * 수빈이는 동생 N명과 숨바꼭질을 하고 있다. 수빈이는 현재 점 S에 있고, 동생은 A1, A2, ..., AN에 있다.
 * 수빈이의 위치가 X일때 걷는다면 1초 후에 X+D나 X-D로 이동할 수 있다. 수빈이의 위치가 동생이 있는 위치와 같으면, 동생을 찾았다고 한다.
 * 모든 동생을 찾기위해 D의 값을 정하려고 한다. 가능한 D의 최댓값을 구해보자.
 * 
 * 풀이:
 * 동생과 수빈과의 거리를 배열의 각 인덱스에 넣고,
 * 그 거리들 간의 최대공약수를 구하면 수빈이 움직일 수 있는 거리, 즉 D가 된다.
 * 
 * @author JIYOUNG
 *
 */
public class Q17087_HideNSeek6 {

	public static int makeGCD(int a, int b) { // 최대공약수 구하는 method
		if (b == 0) {
			return a;
		} else {
			return makeGCD(b, a % b);// 재귀함수 호출
		} // method GCD
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); //입력 받고, 공백 기준으로 나눠주기 

		int dongsangz = Integer.parseInt(st.nextToken()); //동생의 수를 받아들일 변수 
		int subin = Integer.parseInt(st.nextToken()); //수빈이의 위치를 받아들일 변수 
		String[] dis = br.readLine().split(" "); //동생들이 현재 위치한 좌표를 공백과 함께 입력해줄 것이기 때문에, 공백단위로 찢어서 배열에 넣기
		int[] distance = new int[dongsangz];//수빈이와 동생들간의 거리를 각 배열에 넣어줄 것임 
		int index;//동생 순서대로 매겨줄 index 변수
		int shortest;//최단거리를 나타낼 변수 
		////////////////////////////

		for (index = 0; index < dis.length; index++) { //동생들의 숫자 만큼 반복문을 돌려서 
			distance[index] = Integer.parseInt(dis[index]) - subin;//수빈과 동생의 각 거리를 배열에 넣어주기 
		}

		index=0; //동생들 번호 초기화 
		shortest = distance[index]; //우선 임의로, 최단거리는 첫번째 동생부터 시작할 것임. 이 값부터 최대공약수를 구하는 method에 넣어볼 것임 
		for(index=1; index<distance.length; index++) {//동생들 끼리 다 비교하는 반복문, 동생 수가 뒤로 갈수록 최솟값이 나올 것이기 때문에,
			// 최대공약수 method의 인자로 shortest를 하나씩 넣어줘서 비교 후 리턴하면 시간을 줄일 수 있음 
			shortest = makeGCD(shortest,distance[index]); //
		}
		
		bw.write(String.valueOf(Math.abs(shortest)));
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
