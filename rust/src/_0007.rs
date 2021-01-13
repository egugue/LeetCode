struct Solution;

/// https://leetcode.com/problems/reverse-integer/
impl Solution {
    pub fn reverse(x: i32) -> i32 {
        // Solution::i64(x)
        Solution::i32_with_check_overflow(x)
    }
    /// 0 ms	2 MB
    fn i64(x: i32) -> i32 {
        let sign = if x >= 0 { 1 } else { -1 };
        let mut rest = (x as i64).abs();
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

    /// 0 ms	2 MB
    fn i32_with_check_overflow(x: i32) -> i32 {
        let sign = if x >= 0 { 1 } else { -1 };
        let mut rest = x.checked_abs().unwrap_or(0);
        let mut reversed: i32 = 0;
        while rest != 0 {
            let calculated = reversed
                .checked_mul(10)
                .and_then(|n| n.checked_add(rest % 10));

            match calculated {
                None => return 0,
                Some(n) => reversed = n,
            }
            rest /= 10;
        }

        reversed * sign
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
    case(0, 0),
    case(std::i32::MAX, 0),
    case(std::i32::MIN, 0),
    // ::trace
    )]
    fn i64(x: i32, expected: i32) {
        assert_eq!(Solution::i64(x), expected);
    }

    #[rstest(x, expected,
    case(123, 321),
    case(-123, -321),
    case(120, 21),
    case(0, 0),
    case(std::i32::MAX, 0),
    case(std::i32::MIN, 0),
    // ::trace
    )]
    fn i32(x: i32, expected: i32) {
        assert_eq!(Solution::i32_with_check_overflow(x), expected);
    }
}
