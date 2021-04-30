struct Solution;

/// https://leetcode.com/problems/power-of-two/
impl Solution {
    pub fn is_power_of_two(n: i32) -> bool {
        Solution::bit(n)
    }

    /// 0 ms	2 MB
    fn bit(n: i32) -> bool {
        if n <= 0 {
            return false;
        }
        (n & (n - 1)) == 0
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        assert_eq!(Solution::is_power_of_two(1), true);
        assert_eq!(Solution::is_power_of_two(16), true);
        assert_eq!(Solution::is_power_of_two(3), false);
        assert_eq!(Solution::is_power_of_two(5), false);
        assert_eq!(Solution::is_power_of_two(-1), false);
        assert_eq!(Solution::is_power_of_two(-2), false);
    }
}
