package org.mindidea.数据结构.s11heap;

public class MainTest {
	public static void main(String[] args) {
//		BinaryHeap<Integer> heap = new BinaryHeap<>();
//		heap.add(68);
//		heap.add(72);
//		heap.add(43);
//		heap.add(50);
//		heap.add(38);
//		heap.add(10);
//		heap.add(90);
//		heap.add(65);
//		for (int i = 0; i < heap.size(); i++) {
//			System.out.println(heap.get(i));
//		}
//		System.out.println("==========================");
//		heap.remove();
//
//		for (int i = 0; i < heap.size(); i++) {
//			System.out.println(heap.get(i));
//		}
		Integer[] tree = new Integer[]{88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 35, 43, 37};
		BinaryHeap<Integer> heap = new BinaryHeap<>(tree);
		for (int i = 0; i < heap.size(); i++) {
			System.out.println(heap.get(i));
		}
	}
}
