struct Solution;
impl Solution {
    pub fn is_valid(s: String) -> bool {
        // Solution::stack(s)
        Solution::stack_map(s)
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

    /// 0 ms	2 MB
    fn stack_map(s: String) -> bool {
        use std::collections::HashMap;
        let mut stack = Vec::new();
        let close_open_table = [(')', '('), ('}', '{'), (']', '[')]
            .iter()
            .cloned()
            .collect::<HashMap<char, char>>();

        for char in s.chars() {
            match char {
                '(' | '{' | '[' => stack.push(char),
                ')' | '}' | ']' => {
                    let open = close_open_table.get(&char).unwrap();
                    if open != &stack.pop().unwrap_or('_') {
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
        // ::trace
    )]
    fn stack(s: &str, expected: bool) {
        assert_eq!(Solution::stack(s.to_string()), expected)
    }

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
        // ::trace
    )]
    fn stack_map(s: &str, expected: bool) {
        assert_eq!(Solution::stack_map(s.to_string()), expected)
    }
}
