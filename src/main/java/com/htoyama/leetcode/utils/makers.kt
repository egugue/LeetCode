package com.htoyama.leetcode.utils

/**
 * For review later
 */

annotation class Level {
  @Target(AnnotationTarget.CLASS)
  annotation class Easy

  @Target(AnnotationTarget.CLASS)
  annotation class Medium

  @Target(AnnotationTarget.CLASS)
  annotation class Hard
}

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class String_

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BitManipulation

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Backtracking

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DynamicProgramming

@Target(AnnotationTarget.CLASS)
annotation class LinkedList_

//
// array related
//
@Target(AnnotationTarget.CLASS)
annotation class Array_

@Target(AnnotationTarget.FUNCTION)
annotation class SlidingWindow

@Target(AnnotationTarget.FUNCTION)
annotation class BinarySearch

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Sort

//
// graph related
//
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Tree

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Graph

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DFS

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BFS

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class InOrderTraversal

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PreOrderTraversal

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PostOrderTraversal

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class UnionFind

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Dijkstra
