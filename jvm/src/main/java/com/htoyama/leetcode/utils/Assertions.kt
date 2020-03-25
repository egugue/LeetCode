package com.htoyama.leetcode.utils

import org.assertj.core.api.Assertions

infix fun Any.shouldEqual(b: Any) {
  Assertions.assertThat(this).isEqualTo(b)
  println("$this equals $b")
}

infix fun <T> List<T>.shouldContainsOnly(values: Array<T>) {
  Assertions.assertThat(this).containsOnly(*values)
  println("$this contains only $values")
}
