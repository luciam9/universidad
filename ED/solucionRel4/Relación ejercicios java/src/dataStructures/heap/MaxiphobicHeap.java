/**
 * @author <<write here your name>> 
 * 
 * Maxiphobic Heaps
 * Data Structures, Grado en Informática. UMA.
 *
 */
 
package dataStructures.heap;


/**
 * Heap implemented using maxiphobic heap-ordered binary trees.
 * @param <T> Type of elements in heap.
 */
public class MaxiphobicHeap<T extends Comparable<? super T>> implements	Heap<T> {

	protected static class Tree<E> {
		E elem;
		int size;
		int weight;
		Tree<E> left;
		Tree<E> right;
	}

	public int size() {
		return size(root);
	}

	private static int size(Tree<?> heap) {
		return heap == null ? 0 : heap.size;
	}

	private static int weight(Tree<?> heap) {
		return heap == null ? 0 : heap.weight;
	}

	private static <T extends Comparable<? super T>> Tree<T> merge(Tree<T> h1,	Tree<T> h2) {
		// TODO
		if (h1==null) {
			return h1;
		}

		if (h2==null) {
			return h2;
		}

		if (h2.elem.compareTo(h1.elem)<0) {
			Tree<T> aux = h1;
			h1=h2;
			h2=aux;
		}

		if (h2.size>=h1.left.size && h2.size>=h1.right.size) {
			h1.right = merge(h1.left,h1.right);
			h1.left = h2;
		} else if (h1.left.size>=h1.right.size && h1.left.size>=h2.size) {
			h1.right=merge (h1.right,h2);
		} else {
			Tree<T> aux = h1.right;
			h1.right = merge(h1.left,h2);
			h1.left = aux;
		}

		return h1;
	}

	protected Tree<T> root;

	/**
	 * Constructor: creates an empty Maxiphobic Heap.
	 * <p>Time complexity: ???
	 */
	public MaxiphobicHeap() {
		// TODO
		root = null;
	}

	/**
	 * <p>Time complexity: ???
	 */
	public boolean isEmpty() {
		// TODO
		return this == null;
	}

	/**
	 * <p>Time complexity: ???
	 * @throws <code>EmptyHeapException</code> if heap stores no element.
	 */
	public T minElem() {
		// TODO
		return this.root.elem;
	}

	/**
	 * <p>Time complexity: ???
	 * @throws <code>EmptyHeapException</code> if heap stores no element.
	 */
	public void delMin() {
		// TODO
		root = merge(root.left,root.right);
	}

	/**
	 * <p>Time complexity: ???
	 */
	public void insert(T value) {
		// TODO
		Tree<T> single = new Tree<>();
		single.elem = value;
		single.size=1;
		single.left=null;
		single.right=null;
		root = merge(root,single);
	}

	private static String toStringRec(Tree<?> tree) {
		return tree == null ? "null" : "Node<" + toStringRec(tree.left) + ","
				+ tree.elem + "," + toStringRec(tree.right) + ">";
	}

	/**
	 * Returns representation of heap as a String.
	 */
	public String toString() {
		String className = getClass().getSimpleName();

		return className+"("+toStringRec(this.root)+")";
	}

}