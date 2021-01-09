struct Solution;
impl Solution {
    pub fn is_valid(s: String) -> bool {
        Solution::stack(s)
    }

    /// 0 ms	1.9 MB
    fn stack(s: String) -> bool {
        let mut stack = Vec::new();
        for char in s.chars() {
            match char {
                '(' | '{' | '[' => stack.push(char),
                ')' => {
                    if stack.pop().unwrap_or('_') != '(' {
                        return false;
                    }
                }
                '}' => {
                    if stack.pop().unwrap_or('_') != '{' {
                        return false;
                    }
                }
                ']' => {
                    if stack.pop().unwrap_or('_') != '[' {
                        return false;
                    }
                }
                _ => {
                    return false;
                }
            }
        }

        stack.is_empty()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
        s,
        expected,
        case("()", true),
        case("()[]{}", true),
        case("(]", false),
        case("([)]", false),
        case("{[]}", true),
        case("{", false),
        case("}", false),
        ::trace
    )]
    fn stack(s: &str, expected: bool) {
        assert_eq!(Solution::stack(s.to_string()), expected)
    }
}
