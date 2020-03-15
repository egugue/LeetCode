package com.htoyama.leetcode.utils

/**
 * For review later
 */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SlidingWindow

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BitManipulation

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
annotation class Graph

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DFS

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class UnionFind

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Dijkstra
