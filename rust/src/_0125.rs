struct Solution;

/// https://leetcode.com/problems/valid-palindrome/
impl Solution {
    /// 0 ms	2.7 MB
    pub fn is_palindrome(s: String) -> bool {
        if s.is_empty() {
            return true;
        }

        let chars = s.chars().collect::<Vec<_>>();
        let mut left_pos = 0;
        let mut right_pos = s.len() - 1;
        while left_pos < right_pos {
            let left = chars[left_pos];
            if !left.is_ascii_alphanumeric() {
                left_pos += 1;
                continue;
            }

            let right = chars[right_pos];
            if !right.is_ascii_alphanumeric() {
                right_pos -= 1;
                continue;
            }

            if !left.eq_ignore_ascii_case(&right) {
                return false;
            }
            left_pos += 1;
            right_pos -= 1;
        }

        true
    }
}

#[cfg(test)]
mod test {
    use super::*;
    use rstest::rstest;

    #[rstest(
    s,
    expected,
    case(" ", true),
    case("1b1", true),
    case("A man, a plan, a canal: Panama", true),
    case("race a car", false),
    )]
    fn test(s: &str, expected: bool) {
        assert_eq!(Solution::is_palindrome(s.to_string()), expected)
    }
}
