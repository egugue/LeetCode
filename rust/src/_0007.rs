struct Solution;

impl Solution {
    pub fn reverse(x: i32) -> i32 {
        Solution::i64(x)
    }

    /// 0 ms	2 MB
    fn i64(x: i32) -> i32 {
        let sign = if x >= 0 { 1 } else { -1 };

        let mut rest = x.abs() as i64;
        let mut reversed: i64 = 0;
        while rest != 0 {
            reversed = reversed * 10 + rest % 10;
            rest /= 10;
        }

        reversed = reversed * sign;
        return if std::i32::MIN as i64 <= reversed && reversed <= std::i32::MAX as i64 {
            reversed as i32
        } else {
            0
        };
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(x, expected,
    case(123, 321),
    case(-123, -321),
    case(120, 21),
    case(0, 0)
    ::trace
    )]
    fn i64(x: i32, expected: i32) {
        assert_eq!(Solution::i64(x), expected);
    }
}
