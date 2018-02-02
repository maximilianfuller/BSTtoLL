
public class Node {
		int val;
		private Node first; //left in bst, prev in LinkedList
		private Node second; //right in bst, next in LinkedList
		
		public Node(Node left, Node right, int val) {
			first = left;
			second = right;
			this.val = val;
		}
		
		
		
		Node left() {
			return first;
		}
		
		Node right() {
			return second;
		}
		
		Node prev() {
			return first;
		}
		
		Node next() {
			return second;
		}
		
		void setPrev(Node n) {
			first = n;
		}
		
		void setNext(Node n) {
			second = n;
		}
	}
