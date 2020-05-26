package com.htoyama.leetcode._146;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Main {
  public static void main(String[] args) {
    LRUCache cache;
    {
      cache = new LRUCache(2);
      cache.put(1, 1);
      cache.put(2, 2);
      a(cache.get(1), 1);

      cache.put(3, 3);
      a(cache.get(2), -1);

      cache.put(4, 4);
      a(cache.get(1), -1);
      a(cache.get(3), 3);
      a(cache.get(4), 4);
    }

    {
      cache = new LRUCache(3);

      cache.put(1, 1);
      cache.put(2, 2);
      a(cache.get(1), 1);

      cache.put(3, 3);
      a(cache.get(2), 2);

      cache.put(4, 4);
      a(cache.get(1), -1);
      a(cache.get(2), 2);
      a(cache.get(3), 3);
      a(cache.get(4), 4);
    }

    {
      cache = new LRUCache(2);
      cache.put(2, 1);
      cache.put(2, 2);
      a(cache.get(2), 2);
      cache.put(1, 1);
      cache.put(4, 1);
      a(cache.get(2), -1);

      cache = new LRUCache(2);
      cache.put(2, 1);
      cache.put(3, 2);
      a(cache.get(3), 2);
      a(cache.get(2), 1);
      cache.put(4, 3);
      a(cache.get(2), 1);
      a(cache.get(3), -1);
      a(cache.get(4), 3);
    }
  }

  private static void a(int actual, int expected) {
    assertThat(actual).isEqualTo(expected);
  }
}

/**
 * 12 ms	47.3 MB
 */
class LRUCache {
  private final Map<Integer, Node> map;
  private final int capacity;
  private Node mostUsed;
  private Node leastUsed;

  public LRUCache(int capacity) {
    map = new HashMap<>(capacity);
    this.capacity = capacity;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) return -1;

    updateMostUsedNode(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (map.size() == 0) {
      mostUsed = new Node(key, value);
      leastUsed = mostUsed;
      map.put(mostUsed.key, mostUsed);
      return;
    }

    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;
      updateMostUsedNode(node);
      return;
    }

    if (map.size() == capacity) {
      map.remove(leastUsed.key);
      updateLeastUsedNode(leastUsed.prev);
    }

    Node node = new Node(key, value);
    updateMostUsedNode(node);
    map.put(node.key, node);
  }

  private void updateMostUsedNode(Node node) {
    if (node == null) return;
    if (node == mostUsed) return;

    if (node == leastUsed) updateLeastUsedNode(node.prev);

    // skip this node
    if (node.prev != null) node.prev.next = node.next;
    if (node.next != null) node.next.prev = node.prev;

    Node secondMost = mostUsed;
    mostUsed = node;
    mostUsed.prev = null;
    mostUsed.next = secondMost;
    secondMost.prev = mostUsed;
  }

  private void updateLeastUsedNode(Node node) {
    if (node == null) return;
    if (node == leastUsed) return;
    leastUsed = node;
    leastUsed.next = null;
  }

  private static class Node {
    final int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node{" +
        "key=" + key +
        ", value=" + value +
        ", prev=" + (prev == null ? "null" : String.valueOf(prev.key)) +
        ", next=" + (next == null ? "null" : String.valueOf(next.key)) +
        '}';
    }
  }
}

