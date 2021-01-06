struct Solution;

impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        Solution::reverse_integer(x)
    }

    /// 0 ms	2 MB
    fn reverse_integer(x: i32) -> bool {
        if x < 0 {
            return false;
        }

        let mut reversed = 0;
        let mut rest = x;
        while rest != 0 {
            reversed = reversed * 10 + rest % 10;
            rest /= 10;
        }

        x == reversed
    }
}

#[cfg(test)]
mod test {
    use crate::_0009::Solution;

    #[test]
    fn reverse_integer() {
        assert_eq!(Solution::reverse_integer(121), true);
        assert_eq!(Solution::reverse_integer(-121), false);
        assert_eq!(Solution::reverse_integer(10), false);
        assert_eq!(Solution::reverse_integer(-101), false);
        assert_eq!(Solution::reverse_integer(0), true);
    }
}