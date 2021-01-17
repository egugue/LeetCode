struct Solution;
/// https://leetcode.com/problems/climbing-stairs/
impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        Solution::dp(n)
    }

    /// 0 ms	1.9 MB
    fn dp(n: i32) -> i32 {
        if n <= 1 {
            return n;
        }
        let mut prev = 1;
        let mut cur = 1;
        for _ in 1..n {
            let next = prev + cur;
            prev = cur;
            cur = next;
        }
        cur
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;
    #[rstest(
        n,
        expected,
        case(1, 1),
        case(2, 2),
        case(3, 3),
        case(4, 5),
        case(5, 8)
    )]
    fn dp(n: i32, expected: i32) {
        assert_eq!(Solution::dp(n), expected);
    }
}
