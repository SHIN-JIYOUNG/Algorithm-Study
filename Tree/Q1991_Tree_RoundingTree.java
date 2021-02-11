package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1991_Tree_RoundingTree {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		BinaryTree bintree = new BinaryTree();

		for (int i = 0; i < N; i++) {
			char[] data;
			data = br.readLine().replaceAll(" ", "").toCharArray();
			bintree.createNode(data[0], data[1], data[2]);
		}

		// 전위 순회
		bintree.preorder(bintree.rootNode);
		System.out.println();
		// 중위 순회
		bintree.inorder(bintree.rootNode);
		System.out.println();
		// 후위 순회
		bintree.postorder(bintree.rootNode);

		br.close();
	}
	/*
	 * 1. replaceAll(arg1, arg2)의 쓰임은 readLine으로 읽어들인 문자열에서, arg1은 모두 arg2로 대체한다는 의미.
	 * 2. toCharArray()는, data 배열이 char 배열이기 때문에 replaceAll로 띄어쓰기 제거한 뒤,
	 *    문자 하나 하나를 char형으로 집어넣는 과정을 처리해준다.
	 * */
}

//node 클래스 생성
class Node {
	char data;
	Node leftChild; // 왼쪽 자식 노드
	Node rightChild; // 오른쪽 자식 노드
	// 생성자 생성 - 빈 노드 생성

	public Node(char data) {
		this.data = data;
		this.leftChild = null; // 왼쪽 자식 노드 아직 비어있음
		this.rightChild = null; // 오른쪽 자식 노드 아직 비어있음
	}
}

// 이진트리 클래스 생성
class BinaryTree {
	Node rootNode = null;

	// 새로운 노드 생성하는 메소드 생성
	public void createNode(char data, char leftNode, char rightNode) {
		if (rootNode == null) { // 아무것도 없는 상태 - 루트 노드를 생성
			rootNode = new Node(data); // 루트 노드에 루트 노드로 삼을 데이터 넣기
			
			// 좌우 값이 있는 경우에만 노드를 생성하기 위해서는 if조건 2개를 걸어줘야 함 
			// 왼쪽 노드가 비어있지 않다면 서브트리 생성하기
			if (leftNode != '.') {
				rootNode.leftChild = new Node(leftNode);
			}
			// 오른쪽 노드가 비어있지 않다면 서브 트리 생성
			if (rightNode != '.') {
				rootNode.rightChild = new Node(rightNode);
			}
		} else { // 초기 상태가 아니라면 어디에 들어가야할지 찾아야 함 - 특정 노드를 루트노드로 설정한 이후에 발생
			searchNode(rootNode, data, leftNode, rightNode);
		}
	}

	// 노드를 찾는 메소드 생성
	public void searchNode(Node visitNode, char data, char leftNode, char rightNode) {
		if (visitNode == null) { // 만약 도착한 노드가 null이라면 삽입할 노드가 없기 때문에 재귀 종료시킴
			return;
		} else if (visitNode.data == data) { // 들어갈 위치를 찾았다면
			if (leftNode != '.') { // 노드의 값이 .이 아니라 값이 있는 경우에만 왼쪽 노드 생성
				visitNode.leftChild = new Node(leftNode);
			}
			if (rightNode != '.') { // 노드의 값이 .이 아니라 값이 있는 경우에만 오른쪽 노드 생성
				visitNode.rightChild = new Node(rightNode);
			}
		} else { // 아직 노드를 찾지 못했고 탐색할 노드가 남아있다면 재귀를 사용해서 다시 노드 찾기
			searchNode(visitNode.leftChild, data, leftNode, rightNode); // 왼쪽 재귀 탐색
			searchNode(visitNode.rightChild, data, leftNode, rightNode); // 오른쪽 재귀 탐색
		}
	}

	// 전위 순회 : 루트 -> 왼쪽 자식 -> 오른쪽 자식
	public void preorder(Node rootNode) {
		System.out.print(rootNode.data); // 먼저 해당 루트 노드 출력
		if (rootNode.leftChild != null)
			preorder(rootNode.leftChild); // 왼쪽 자식노드가 있다면 전위순회하라
		if (rootNode.rightChild != null)
			preorder(rootNode.rightChild); // 오른쪽 자식노드가 있다면 전위순회하라
	}

	// 중위 순회 : 왼쪽 자식 -> 루트 -> 오른쪽 자식
	public void inorder(Node rootNode) {
		if (rootNode.leftChild != null)
			inorder(rootNode.leftChild); // 왼쪽 자식노드가 있다면 중위순회하라
		System.out.print(rootNode.data); // 가운데 루트 노드 출력
		if (rootNode.rightChild != null)
			inorder(rootNode.rightChild); // 오른쪽 자식노드가 있다면 중위순회하라
	}

	// 후위 순회 : 왼쪽 자식 -> 오른쪽 자식 -> 루트
	public void postorder(Node rootNode) {
		if (rootNode.leftChild != null)
			postorder(rootNode.leftChild); // 왼쪽 자식노드가 있다면 후위순회하라
		if (rootNode.rightChild != null)
			postorder(rootNode.rightChild); // 오른쪽 자식노드가 있다면 후위순회하라
		System.out.print(rootNode.data); // 가운데 루트 노드 출력
	}
}

