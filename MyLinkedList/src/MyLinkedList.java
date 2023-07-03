import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

	private static class Node<E> {
		E data;
		Node<E> prev;
		Node<E> next;

		public Node(E data, Node<E> prev, Node<E> next) {
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	int size;
	Node<E> head;
	Node<E> tail;
	private int position;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node<E> node = head;

			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public E next() {
				E obj = node.data;
				node = node.next;
				return obj;
			}
		};
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		Node<E> node = new Node<E>(e, tail, null);
		if (tail != null) {
			tail.next = node;
//			node.prev = tail; // не требуется потому что приняли tail в new
		} else {
			head = node;
		}
		tail = node;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		Node<E> node = getNodeByIndex(index);
		return node.data;
	}

	private Node<E> getNodeByIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(index + "Index out of bound");
		Node<E> node;
		if (index <= size / 2) {
			node = head;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = tail;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}

	@Override
	public E set(int index, E element) {

		return null;
	}

	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index wrong!");
		if (index == size) {
			add(element);
		} else if (index == 0) {
			Node<E> node = new Node<E>(element, null, head);
			head.prev = node;
//			node.next = head; // переопределен в конструкторе
			head = node;
			size++;
		} else {
			Node<E> temp = getNodeByIndex(index);
			Node<E> node = new Node<E>(element, temp.prev, temp);
			temp.prev = node;
			node.prev.next = node;
			size++;
		}

	}

	@Override
	public E remove(int index) {
		Node<E> node = getNodeByIndex(index);
		return unlink(node);
	}

	private E unlink(Node<E> node) {
		if (size == 1) {
			head = null;
			tail = null;
		} else if (node.next == null) {
			node.prev.next = null;
			tail = tail.prev;
		} else if (node.prev == null) {
			node.next.prev = null;
			head = head.next;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		size--;
		return node.data;
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		if (o == null) {
			for (Node<E> i = head; i != null; i = i.next) {
				if (i.data == null)
					return index;
				index--;
			}
		} else {
			for (Node<E> i = head; i != null; i = i.next) {
				if (o.equals(i.data))
					return index;
				index--;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = size - 1;
		if (o == null) {
			for (Node<E> i = tail; i != null; i = i.prev) {
				if (i.prev == null)
					return index;
				index++;
			}
		} else {
			for (Node<E> i = tail; i != null; i = i.prev) {
				if (o.equals(i.data))
					return index;
				index++;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
