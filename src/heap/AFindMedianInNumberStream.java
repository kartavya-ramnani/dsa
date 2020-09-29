package heap;

import java.util.PriorityQueue;

// Design a class to calculate the median of a number stream.
// The class should have the following two methods:
//
//insertNum(int num): stores the number in the class
//findMedian(): returns the median of all numbers inserted in the class
//If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
public class AFindMedianInNumberStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    AFindMedianInNumberStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    public double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        AFindMedianInNumberStream medianInNumberStream = new AFindMedianInNumberStream();
        medianInNumberStream.insertNum(3);
        medianInNumberStream.insertNum(1);
        System.out.println("Median : " + medianInNumberStream.getMedian());
        medianInNumberStream.insertNum(5);
        System.out.println("Median : " + medianInNumberStream.getMedian());
        medianInNumberStream.insertNum(4);
        System.out.println("Median : " + medianInNumberStream.getMedian());
    }

}
