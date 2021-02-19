package AlgorithmStudy_notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * N명의 모험가를 대상으로 '공포도'를 측정한다, 공포도가 높은 모험가는 대처 능력이 떨어진다. 공포도가 n인 모험은 n만큼의 사람을
 * 대동해야 한다. 모험을 떠날 수 있는 그룹 수의 최댓값을 구하라
 * 
 * 풀이방법: 모험의 공포도를 차례대로 입력받아서 정렬 후, 공포도가 높은 순으로 그 숫자만큼 배열의 값을 지워나간다. 남은 숫자보다 배열에
 * 남은 인덱스가 더 적은 경우 그 수들은 여행을 보내지 않는다
 * 
 * 
 * @author JIYOUNG
 *
 */
public class Q00000_TravelerGuild {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");//공포도를 입력받아 배열에 저장 
		Arrays.sort(input);//오름차순 정렬 
		ArrayList<Integer> list = new ArrayList<Integer>();//공포도를 Integer로 형변환하여 넣을 배열 
		int gr = 0;//모험을 떠날 수 있는 그룹의 수 

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(input[i])); //형변환 하여 삽입 
		}

		while (list.get(list.size() - 1) <= list.size()) { //맨 끝 인덱스의 값보다 list의 사이즈가 커야만 한다
			//그 수만큼 인원이 채워지지 않으면 모험을 떠날 수 없기 때문 
			int lastNum = list.get(list.size() - 1);//맨 끝 인덱스의 값 
			for (int i = lastNum; i > 0; i--) { 
				list.remove(list.size() - 1);//만큼 값을 지워나간다 
			}
			gr++;//다 지워냈으면 그룹++ 
			if (list.isEmpty()) {//비워낸 후로 배열이 비워졌다면 
				break;//반복문 탈출 
			}
		}
		
		if (list.indexOf(1) >= 0) { //만약 배열에 1이 들어있다면 혼자서 모험을 떠날 수 있으니까 
			while (list.indexOf(1) != -1) {//1이 없어질 때까지 
				list.remove(list.indexOf(1));//1을 빼내면서 
				gr++;//그룹++ 
			}
		}
		System.out.println(gr);
	}
}
