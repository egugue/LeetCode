package com.htoyama.leetcode._295;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class Main {
  public static void main(String[] args) {
    MedianFinder f = new MedianFinder();

    assertThat(f.findMedian()).isEqualTo(0);

    f.addNum(1);
    assertThat(f.findMedian()).isEqualTo(1);

    f.addNum(3);
    assertThat(f.findMedian()).isEqualTo(2);

    f.addNum(2);
    assertThat(f.findMedian()).isEqualTo(2);
  }
}

/**
 * 46 ms	50.7 MB
 */
class MedianFinder {

  private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
  private boolean even = true;

  public void addNum(int num) {
    if (even) {
      maxHeap.add(num);
      minHeap.add(maxHeap.poll());
    } else {
      minHeap.add(num);
      maxHeap.add(minHeap.poll());
    }
    even = !even;
  }

  public double findMedian() {
    if (even) {
      if (minHeap.isEmpty() || maxHeap.isEmpty()) {
        return 0;
      }
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    } else {
      return minHeap.peek();
    }
  }
}