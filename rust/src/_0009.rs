struct Solution;

impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        //Solution::reverse_integer(x)
        Solution::string(x)
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

    /// 0 ms	2 MB
    fn string(x: i32) -> bool {
        let string = x.to_string();

        let mut left = string.len() - 1;
        let mut right = 0;
        while left > right {
            let left_char = string.chars().nth(left);
            let right_char = string.chars().nth(right);
            if left_char != right_char {
                return false;
            }

            left -= 1;
            right += 1;
        }

        true
    }
}

#[cfg(test)]
mod test {
    use crate::_0009::Solution;
    use rstest::rstest;

    #[rstest( x, expected,
    case(121, true),
    case(-121, false),
    case(10, false),
    case(-101, false),
    case(0, true),
    case(1221, true),
    case(1, true),
    )]
    fn reverse_integer(x: i32, expected: bool) {
        assert_eq!(Solution::reverse_integer(x), expected);
    }

    #[rstest( x, expected,
    case(121, true),
    case(-121, false),
    case(10, false),
    case(-101, false),
    case(0, true),
    case(1221, true),
    case(1, true),
    )]
    fn string(x: i32, expected: bool) {
        assert_eq!(Solution::string(x), expected);
    }
}
