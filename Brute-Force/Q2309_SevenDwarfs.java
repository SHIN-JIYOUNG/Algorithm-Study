package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 난쟁이가 일곱 명이 아닌 아홉 명이었다! 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다. 아홉 난쟁이의 키가
 * 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾자 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수
 * 일곱 난쟁이의 키를 오름차순으로 출력
 * 
 * 풀이: 9명의 키를 모두 더한 후, 무작위 2명의 키를 뺐을 때 100이 되는 순간 해당 2명은 스파이
 * 
 * @author JIYOUNG
 *
 */
public class Q2309_SevenDwarfs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Integer> list = new ArrayList<Integer>();// 난장이의 키들을 넣을 배열

		int sum = 0; // 난장이 9명의 키를 모두 더한 값을 넣을 변수
		int input; //입력받을 난장이들의 키 

		for (int i = 0; i < 9; i++) {
			input = Integer.parseInt(br.readLine());
			list.add(input); //리스트에 난장이들의 키를 하나씩 넣고 
			sum += list.get(i);//난장이들의 키를 모두 더한 값을 받아낸다 
		}

		for (int i = 1; i < list.size(); i++) { //이제 난장의들이 키를 하나씩 더할 것이다. 이중for문 사용 
			for (int j = 2; j < list.size(); j++) { //1번난장이와 2~9번난장이 비교, 2번 난장이와 3~9번 난장이 비교 
				if (sum - list.get(i) - list.get(j) == 100) { //난장이들의 전체 키 합에서 두 명의 난장의 키를 빼서 100이 되면 
					list.remove(i); //그 난장이중 한명을 빼고 (i는 j보다 앞에있다. 이중for문의 바깥 for문에 있으므로)
					list.remove(j - 1);//i가 빠지면 나머지 난장이들의 인덱스가 앞으로 당겨지기 때문에, j에서도 -1을 해줘야 함 
					break;//답을 찾았으니 for문을 나간다 
				}
			}
		}
		
		Collections.sort(list);//오름차순 정렬 

		for (int i = 0; i < 7; i++) {
			bw.write(String.valueOf(list.get(i)));//스파이를 제외한 7명 난장이의 키 순서대로 출력 
			bw.write("\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
	}

}
