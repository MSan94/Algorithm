package �ڷᱸ��.LinkedList;

class SingleLinkedList<T> {
	public Node<T> head = null;
	
	// ��� ����
	public class Node<T> {
		T data;
		Node<T> next = null;

		public Node(T data) {
			this.data = data;
		}
	}

	public void addNode(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> node = this.head;
			// �� ������ ������ ����
			while(node.next != null) {
				node = node.next;
			}
			// ��� ����
			node.next = new Node<T>(data);
		}
	}
	
	// ������ �߰� ����
	public void addNodeInside(T data, T isData) {
		Node<T> searchedNode = this.search(isData);
		
		if(searchedNode == null) {
			// null�̸� �ش� ���� ���� �����Ͱ� ����
			this.addNode(data); // ������ �ֱ�
		}else {
			// �����Ͱ� �ִٸ�
			Node<T> nextNode = searchedNode.next;
			searchedNode.next = new Node<T>(data); //���� �ִ� ��尡 �� ����� �ּҸ� ����Ŵ
			searchedNode.next.next = nextNode; // ������ �����Ͱ� ������ �ִ� ���� ����� �ּ� ����
		}
	}
	
	// Ư�� ������ ����
	public boolean delNode(T isData) {
		if(this.head == null) {
			return false;
		}else {
			Node<T> node = this.head;
			if(node.data == isData) {
				this.head = this.head.next; //head�� ����Ű�� �ִ� ��ü�� this.head�� ����Ű�� �ִ� ��ü�� �ִµ� this.head.next�� �ٲ���⿡ ������ ����Ű����� gb�� ���� ����
				return true;
			}else {
				while(node.next != null) {
					if(node.next.data == isData) {
						node.next = node.next.next;
						return true;
					}
					node = node.next;
				}
			}
			return false;
		}
	}
	
	// ������ ã��
	public Node<T> search(T data){
		if(this.head == null) {
			return null;
		}else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.data == data) {
					return node;
				}else {
					node = node.next;
				}
			}
			// �˻� �� �ش� ��尡 ���ٸ�
			return null;
		}
	}
	
	public void printAll() {
		if(head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}
}

public class BasicCode {

	public static void main(String[] args) {
		SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();
		MyLinkedList.addNode(1);
		MyLinkedList.addNode(2);
		MyLinkedList.addNode(3);
		MyLinkedList.addNode(4);
		MyLinkedList.addNode(5);

		MyLinkedList.delNode(3);
		MyLinkedList.delNode(1);
		MyLinkedList.delNode(5);
		MyLinkedList.delNode(23);
		
//		MyLinkedList.addNodeInside(5, 2);;

//		System.out.println(MyLinkedList.head.data);
//		System.out.println(MyLinkedList.head.next.data);
		MyLinkedList.printAll();
		
	}

}
