package AlgorithmStudy;

import java.util.Scanner;
import java.util.Stack;

/**
 * 입력되는 문장을 단어단위로 거꾸로 읽어들이는 프로그램을 만들기.
 * ex.
 * I love you => I evol uoy
 * 
 * 풀이:
 * stack을 이용하여, 띄어쓰기 단위로 단어를 끊어주어 stack에 넣어준 뒤
 * 거꾸로 꺼내주면 됨
 * @author JIYOUNG
 */
public class Q9033_ReverseWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();// 테스트 케이스 먼저 입력하기
		sc.nextLine();// 공백 제거용 (단어 단위로 띄어쓰기를 하니까.)
		Stack<Character> stack = new Stack<Character>(); // 스택 사용 <캐릭터>
		String sentence; // 문장
		char letter; // 문자 한 글자
		for (int i = 0; i < testCase; i++) { // 읽어들일 줄 수만큼 반복
			sentence = sc.nextLine();// 쭉 읽어들인 문장을 sentence 변수에 담기
			for (int j = 0; j < sentence.length(); j++) { // sentence의 길이만큼 반복
				letter = sentence.charAt(j); // 한 글자를 의미하는 letter 변수에 차곡차곡 담기
				if (letter == ' ') {// 담다가 만약 space를 만난다면? 
					while (!stack.empty()) {// 스택이 비워질 때까지(=스택이 비어있지 않을 때까지) 반복
						System.out.print(stack.pop());// 마지막 letter부터 끝까지 꺼내기
					}
					System.out.print(" ");// 글자가 비워졌으니 공백을 뱉어내기
				} else {// 스택이 비어있다면 
					stack.add(sentence.charAt(j));// letter에 차곡차곡 쌓기
				}
			}
			while (!stack.empty()) {// 마지막 단어는 공백을 만나지 못하기 때문에 while문을 
				//밖으로 꺼내준 것, 마지막으로 스택이 비워질 때까지(=스택이 비어있지 않을 때까지) 반복
				System.out.print(stack.pop());// 마지막 letter부터 끝까지 꺼내기
			}
			System.out.println();// 줄바꿈
		}

	}
}
