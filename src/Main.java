
public class Main {

	public static void main(String[] args) {
		
        //           4
	//          / \
	//         2   7
	//        /\   /
	//       1  3 5
	//             \
	//              6
		
		Node one = new Node(null, null, 1);
		Node three = new Node(null, null, 3);
		Node two = new Node(one, three, 2);
		
		Node six = new Node(null, null, 6);
		Node five = new Node(null, six, 5);
		Node seven = new Node(five, null, 7);
		
		Node four = new Node(two, seven, 4);
		
		Node root = four;
		
		System.out.println("bst in order");
		printBSTInorder(root);
		System.out.println();
		
		LinkedList list = binarySearchTreeToLinkedList(root);
		
		System.out.println("linked list left to right");
		printLinkedListLeftToRight(list.head);
		System.out.println();
		
		System.out.println("linked list right to left");
		printLinkedListRightToLeft(list.tail);
		System.out.println();
	}
	
	static LinkedList binarySearchTreeToLinkedList(Node root) {
		if(root == null) { return null; }
		LinkedList left = binarySearchTreeToLinkedList(root.left());
		LinkedList right = binarySearchTreeToLinkedList(root.right());
		if(left != null) {
			left.tail.setNext(root);
			root.setPrev(left.tail);
		}
		if(right != null) {
			right.head.setPrev(root);
			root.setNext(right.head);
		}
		Node head = left == null ? root : left.head;
		Node tail = right == null? root : right.tail;
		return new LinkedList(head, tail);
	}
	
	public static void printBSTInorder(Node root) {
		if(root == null) { return; }
		printBSTInorder(root.left());
		System.out.print(root.val + " ");
		printBSTInorder(root.right());
	}
	
	public static void printLinkedListLeftToRight(Node head) {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next();
		}
	}
	
	public static void printLinkedListRightToLeft(Node tail) {
		Node curr = tail;
		while(curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.prev();
		}
	}
}
