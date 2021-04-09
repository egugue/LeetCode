#![allow(non_snake_case)]

struct Solution;

/// https://leetcode.com/problems/number-of-1-bits/
impl Solution {
    /// 0 ms	2.1 MB
    pub fn hammingWeight(n: u32) -> i32 {
        let mut n = n;
        let mut count = 0;
        while n != 0 {
            count += n & 1;
            n >>= 1;
        }
        count as i32
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test() {
        fn assert(n: u32, e: i32) {
            assert_eq!(Solution::hammingWeight(n), e);
        }

        assert(0b00000000000000000000000000000000, 0);
        assert(0b00000000000000000000000000001011, 3);
        assert(0b00000000000000000000000010000000, 1);
        assert(0b11111111111111111111111111111101, 31);
    }
}
