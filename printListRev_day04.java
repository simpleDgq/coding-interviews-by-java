/*
 * 链表节点结构
 * */
class Node {
	Node next = null;//引用类型的变量，表示下个节点，相当于c里面的指针
	int value;
	public Node(int value) {
		this.value = value;
	}
}

public class PrintListRev_04 {

	/**
	 * 反向输出单向链表。
	 * 首先我们需要自己构建一个链表。然后按照下面的思路去编写代码。
	 * 思路1.第一个遍历的元素最后一个输出，最后一个遍历的元素第一个输出。联想到栈这种数据结构。
	 * 思路2.递归本质上是一种栈结构，想到了栈，应该想到递归来实现。
	 * 下面分别实现两种思路。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//构建链表
		Node node1 = new Node(1);
		Node node2 = new Node(22);
		Node node3 = new Node(45);
		Node node4 = new Node(6);
		Node node5 = new Node(69);
		Node node6 = new Node(96);
		
		Node headNode = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
		//System.out.println(headNode.value);
		printListRev1(headNode);
		System.out.println();
		printListRev2(headNode);
	}
	
	//1.使用栈。使用java.util.stack。也可以使用linkedList
	public static void printListRev1(Node list) {
		Node head = list;
		if(head == null) {
			return;
		}
		Stack<Integer> stack = new Stack<Integer>();//创建一个新的栈
		while(head != null) {//遍历链表放入栈中
			stack.push(head.value);
			head = head.next;
		}
		//打印栈
		while (!stack.empty()) {//栈不为空
			System.out.print(stack.pop()+" ");
		}
	}
	//2.使用递归
	public  static void printListRev2(Node list) {
		Node head = list;
		if(head == null) {
			return;
		}
		printListRev2(head.next);
		System.out.print(head.value + " ");
	}
}
