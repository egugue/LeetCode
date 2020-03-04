package com.htoyama.leetcode.utils

import org.assertj.core.api.Assertions

infix fun Any.shouldEqual(b: Any) {
  Assertions.assertThat(this).isEqualTo(b)
}

