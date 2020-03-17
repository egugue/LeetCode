package com.htoyama.leetcode.utils

/**
 * For review later
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class String_

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SlidingWindow

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BitManipulation

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Backtracking

annotation class Level {
  @Target(AnnotationTarget.CLASS)
  annotation class Easy

  @Target(AnnotationTarget.CLASS)
  annotation class Medium

  @Target(AnnotationTarget.CLASS)
  annotation class Hard
}

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
annotation class UnionFind

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Dijkstra
