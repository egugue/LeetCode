struct Solution;

/// https://leetcode.com/problems/basic-calculator-ii/
impl Solution {
    /// 0 ms	3.9 MB
    pub fn calculate(s: String) -> i32 {
        let mut num_stack = Vec::new();
        let mut op_stack = Vec::new();

        let chars = s.chars().collect::<Vec<_>>();
        let mut i = 0;

        while let Some(&char) = chars.get(i) {
            match char {
                '0'..='9' => {
                    let (mut num, next) = Solution::take_number(&chars, i);
                    i = next;
                    if let Some(&op) = op_stack.last() {
                        if op == '*' {
                            op_stack.pop();
                            num = num_stack.pop().unwrap() * num;
                        } else if op == '/' {
                            op_stack.pop();
                            num = num_stack.pop().unwrap() / num;
                        }
                    }
                    num_stack.push(num);
                }
                '+' | '-' | '*' | '/' => {
                    op_stack.push(char);
                }
                _ => {
                }
            }
            i += 1;
        }

        num_stack.reverse();
        let mut result = num_stack.pop().unwrap();
        for op in  op_stack.iter() {
            match op {
                '+' => {
                    result += num_stack.pop().unwrap();
                }
                '-' => {
                    result -= num_stack.pop().unwrap();
                }
                _ => {}
            }
        }

        result
    }

    fn take_number(chars: &Vec<char>, mut i: usize) -> (i32, usize) {
        let mut sum = 0;
        while let Some(&char) = chars.get(i) {
            if let Some(num) = char.to_digit(10) {
                sum = sum * 10 + num;
                i += 1;
            } else {
                break;
            }
        }
        (sum as i32, i - 1)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        fn assert(s: &str, expected: i32) {
            assert_eq!(Solution::calculate(s.to_string()), expected);
        }
        assert("1+1", 2);
        assert("42", 42);
        assert("1 + 2 * 3", 7);
        assert("1+2*3*2+2*2", 17);
        assert("1+2*30*2+2*2", 125);
        assert("1-1+1", 1);
        assert("1+1-1", 1);
    }
}
