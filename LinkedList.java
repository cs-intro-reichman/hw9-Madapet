/**
 * Represents a list of Nodes.
 */
public class LinkedList {

	public static void main(String[] args) {
		MemoryBlock block1 = new MemoryBlock(1, 1);
		MemoryBlock block2 = new MemoryBlock(1, 2);
		MemoryBlock block3 = new MemoryBlock(1, 3);
		MemoryBlock block4 = new MemoryBlock(1, 4);
		Node node1 = new Node(block1);
		Node node2 = new Node(block2);
		Node node3 = new Node(block3);
		Node node4 = new Node(block4);

		// LinkedList trylist = new LinkedList();
		// System.out.println(trylist.toString());

		// //Try add
		// trylist.add(0, block1);
		// System.out.println(trylist.toString());

		// //Try addFirst

		// trylist.addFirst(block2);
		// System.out.println(trylist.toString());

		// //Try addLast

		// trylist.addLast(block1);
		// System.out.println(trylist.toString());


	}

	private Node first; // pointer to the first element of this list
	private Node last; // pointer to the last element of this list
	private int size; // number of elements in this list

	/**
	 * Constructs a new list.
	 */
	public LinkedList() {
		first = null;
		last = first;
		size = 0;
	}

	/**
	 * Gets the first node of the list
	 *
	 * @return The first node of the list.
	 */
	public Node getFirst() {
		return this.first;
	}

	/**
	 * Gets the last node of the list
	 *
	 * @return The last node of the list.
	 */
	public Node getLast() {
		return this.last;
	}

	/**
	 * Gets the current size of the list
	 *
	 * @return The size of the list.
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Gets the node located at the given index in this list.
	 *
	 * @param index
	 *              the index of the node to retrieve, between 0 and size
	 * @throws IllegalArgumentException
	 *                                  if index is negative or greater than the
	 *                                  list's size
	 * @return the node at the given index
	 */
	public Node getNode(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException(
					"index must be between 0 and size");
		}
		Node indexNode = this.first;
		while (index > 0) {
			indexNode = indexNode.next;
			index--;
		}
		//// Replace the following statement with your code
		return indexNode;
	}

	/**
	 * Creates a new Node object that points to the given memory block,
	 * and inserts the node at the given index in this list.
	 * <p>
	 * If the given index is 0, the new node becomes the first node in this list.
	 * <p>
	 * If the given index equals the list's size, the new node becomes the last
	 * node in this list.
	 * <p>
	 * The method implementation is optimized, as follows: if the given
	 * index is either 0 or the list's size, the addition time is O(1).
	 *
	 * @param block
	 *              the memory block to be inserted into the list
	 * @param index
	 *              the index before which the memory block should be inserted
	 * @throws IllegalArgumentException
	 *                                  if index is negative or greater than the
	 *                                  list's size
	 */
	public void add(int index, MemoryBlock block) {
		Node newNode = new Node(block);
		// System.out.println(index);
		if (index == 0) {
			newNode.next = this.first;
			this.first = newNode;
			if (size ==0){this.last = this.first;}
		} else {
			if (index == size) {
				//System.out.println("last is " + this.last);
				this.last.next = newNode;
				this.last = newNode;
			} else {
				newNode.next = this.getNode(index);
				this.getNode(index - 1).next = newNode;
			}
		}

		this.size++;
		//// Write your code here
	}

	/**
	 * Creates a new node that points to the given memory block, and adds it
	 * to the end of this list (the node will become the list's last element).
	 *
	 * @param block
	 *              the given memory block
	 */
	public void addLast(MemoryBlock block) {
		this.add(this.size, block);
		//// Write your code here
	}

	/**
	 * Creates a new node that points to the given memory block, and adds it
	 * to the beginning of this list (the node will become the list's first
	 * element).
	 *
	 * @param block
	 *              the given memory block
	 */
	public void addFirst(MemoryBlock block) {
		this.add(0, block);
		//// Write your code here
	}

	/**
	 * Gets the memory block located at the given index in this list.
	 *
	 * @param index
	 *              the index of the retrieved memory block
	 * @return the memory block at the given index
	 * @throws IllegalArgumentException
	 *                                  if index is negative or greater than or
	 *                                  equal to size
	 */
	public MemoryBlock getBlock(int index) {
		if (this.getSize() == 0){throw new IllegalArgumentException(
			"index must be between 0 and size"); }
		Node tmoNode = getNode(index);

		return tmoNode.block;
	}

	/**
	 * Gets the index of the node pointing to the given memory block.
	 *
	 * @param block
	 *              the given memory block
	 * @return the index of the block, or -1 if the block is not in this list
	 */
	public int indexOf(MemoryBlock block) {
		for (int i = 0; i < size; i++) {
			if (getBlock(i).equals(block)) {
				return i;
			}
		}
		//// Replace the following statement with your code
		return -1;
	}

	/**
	 * Removes the given node from this list.
	 *
	 * @param node
	 *             the node that will be removed from this list
	 */
	public void remove(Node node) {
		Node tmpNode = node.next;
		getNode(this.indexOf(node.block) - 1).next = tmpNode;
		//// Write your code here
	}

	/**
	 * Removes from this list the node which is located at the given index.
	 *
	 * @param index the location of the node that has to be removed.
	 * @throws IllegalArgumentException
	 *                                  if index is negative or greater than or
	 *                                  equal to size
	 */
	public void remove(int index) {
		remove(getNode(index));
		//// Write your code here
	}

	/**
	 * Removes from this list the node pointing to the given memory block.
	 *
	 * @param block the memory block that should be removed from the list
	 * @throws IllegalArgumentException
	 *                                  if the given memory block is not in this
	 *                                  list
	 */
	public void remove(MemoryBlock block) {
		remove(indexOf(block));
		//// Write your code here
	}

	/**
	 * Returns an iterator over this list, starting with the first element.
	 */
	public ListIterator iterator() {
		return new ListIterator(first);
	}

	/**
	 * A textual representation of this list, for debugging.
	 */
	public String toString() {
		//// Replace the following statement with your code
		String linkedList = "";
		for (int i = 0; i < size; i++) {
			linkedList = linkedList  + getNode(i).toString();
		}
		return linkedList;
	}
}