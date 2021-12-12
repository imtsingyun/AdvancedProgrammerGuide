package org.mindidea.struc.s11heap;

public class MainTest {
	public static void main(String[] args) {
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		heap.add(68);
		heap.add(72);
		heap.add(43);
		heap.add(50);
		heap.add(38);
		for (int i = 0; i < heap.size(); i++) {
			System.out.println(heap.get(i));
		}
	}
}
