package com.htoyama.leetcode._341;

import java.util.*;

import static java.util.Arrays.asList;

class NestedInteger {
  private Integer integer = null;
  private List<NestedInteger> nestedIntegerList;
  // @return true if this NestedInteger holds a single integer, rather than a nested list.

  NestedInteger(Integer integer) {
    this.integer = integer;
  }

  NestedInteger(List<NestedInteger> nestedIntegerList) {
    this.nestedIntegerList = nestedIntegerList;
  }

  boolean isInteger() {
    return integer != null;
  }

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  Integer getInteger() {
    return integer;
  }

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  List<NestedInteger> getList() {
    return nestedIntegerList;
  }

  private static NestedInteger i(int i) {
    return new NestedInteger(i);
  }

  private static NestedInteger n(NestedInteger... list) {
    List<NestedInteger> nestedIntegers = asList(list);
    return new NestedInteger(nestedIntegers);
  }

  public static void main(String[] args) {
    List<NestedInteger> nestedIntegers = asList(
      n()
    );
    NestedIterator nestedIterator = new NestedIterator(nestedIntegers);
    while (nestedIterator.hasNext()) {
      System.out.print(nestedIterator.next());
      System.out.print(", ");
    }
  }
}


/**
 * 2 ms	42.2 MB
 */
public class NestedIterator implements Iterator<Integer> {
  private final ArrayDeque<NestedInteger> queue = new ArrayDeque<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    queue.addAll(nestedList);
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      queue.push(nestedList.get(i));
    }
  }

  @Override
  public Integer next() {
    if (hasNext()) {
      return queue.poll().getInteger();
    } else {
      return null;
    }
  }

  @Override
  public boolean hasNext() {
    while (!queue.isEmpty() && !queue.peek().isInteger()) {
      List<NestedInteger> nestedList = queue.poll().getList();
      for (int i = nestedList.size() - 1; i >= 0; i--) {
        queue.push(nestedList.get(i));
      }
    }
    return !queue.isEmpty();
  }
}
