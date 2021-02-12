package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * N개의 풍선이 있다. 각 풍선 안에는 -N부터 N까지의 수가 적혀있는 종이가 들어 있다. 우선, 제일 처음에는 1번 풍선을 터뜨린다.
 * 다음에는 풍선 안에 있는 종이를 꺼내어 그 종이에 적혀있는 값만큼 이동하여 다음 풍선을 터뜨린다. 양수가 적혀 있을 경우에는 오른쪽으로,
 * 음수가 적혀 있을 때는 왼쪽으로 이동한다. 풍선은 원형으로 놓여 있다고 생각한다.
 * 
 * 첫째 줄에 자연수 N(1≤N≤1,000)이 주어진다. 다음 줄에는 차례로 각 풍선 안의 종이에 적혀 있는 수가 주어진다. 편의상 0은
 * 적혀있지 않다고 가정하자. 첫째 줄에 터진 풍선의 번호를 차례로 나열한다.
 * 
 * 틀린!! 풀이방법: LinkedList를 2개 만들 것, 1개는 찾은 값을 빼고 넣는 역할, 1개는 인덱스를 찾는 역할로 구분한다.
 * 반례 int배열 [-5, -5, -5, -5, -5] 는 제대로 작동하지 않음!!
 * 왜?: 복사된 배열 2는 인덱스를 찾는 역할인데, 값이 다 똑같으면 인덱스를 찾을 수 없기 때문이다 
 * 고친 풀이는 _success로 다시 업로드
 * 
 * @author JIYOUNG
 *
 */
public class Q2346_PopTheBalloon_Fail {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		LinkedList<Integer> list = new LinkedList<Integer>(); // 리스트를 이용, 이미 만난 숫자라면 그 숫자를 제거해나가서 list.isEmpty()를 만나면
																// 프로그램을 끝낼 것
		LinkedList<Integer> idxList = new LinkedList<Integer>(); // 원본리스트를 보존해놓는 리스트, 만난 숫자의 인덱스만 뽑아내기 위한 리스트임.

		int tc = Integer.parseInt(br.readLine());
		String[] arr = (br.readLine()).split(" "); // 입력받은 숫자는 string형 이니까
		int[] numArr = new int[tc];// int형으로 변환하기 위한 int[]

		for (int i = 0; i < tc; i++) {
			numArr[i] = Integer.parseInt(arr[i]); // int[]에 String형 값들을 int형 값으로 변환해서 넣어주기
			list.add(numArr[i]);// 값 추가
			idxList.add(numArr[i]);// 똑같이 값 추가
		}

		////////// 프로그램 시작////////////
		int now = 0;// 내가 현재 위치한 인덱스
		int past = 0;// 이전 인터벌을 명시해줄 변수
		int interval = list.get(0); // interval은 곧 list의 맨 처음 인덱스에서 만난 값이 될 것, 3을 만난다면 3칸 움직여야 하니까 interval에 3을 담는다
		if (list.get(0) < 0) { //만난 숫자가 음수라면 
			now = now + (list.size() + interval);
			interval = list.get(now);
		}
		if (list.get(0) >= list.size()) { //만난 숫자가 list의 사이즈보다 크다면 
			now = (now + interval) % list.size();
			interval = list.get(now);
		} else {
			now = now + interval;
			interval = list.get(now);
		}
		list.remove(0); //만난 값을 지우고 
		now = list.indexOf(interval);//그 값의 인덱스를 찾아간다 
		sb.append(1 + " ");// 복사된 배열에서 그 값의 인덱스(== 1)를 프린트

		while (list.size() != 1) { // 리스트가 비워지기 직전에 프로그램을 멈춘다
			past = interval;
			now = now + interval;
			if (now < 0) {
				now = list.size() + now;
			} else if (now >= list.size()) {
				now = now - list.size();
			}
			interval = list.get(now);
			list.remove(list.indexOf(past));
			now = list.indexOf(interval);
			sb.append(idxList.indexOf(past) + 1 + " ");
		}
		//리스트의 값이 1개 남았을 시 
		past=interval;
		sb.append(idxList.indexOf(past) + 1);//그대로 찾아서 프린트 

		System.out.println(sb);
	}
}
