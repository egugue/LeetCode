struct Solution;
impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        Solution::iterate(&strs)
    }

    /// 0 ms	2 MB
    fn iterate(strs: &Vec<String>) -> String {
        let length = match strs.first() {
            None => {
                return "".to_string();
            }
            Some(s) => s.len(),
        };

        let mut common_prefix = "".to_string();
        for i in 0..length {
            let char = strs.first().and_then(|s| s.chars().nth(i)).unwrap();
            for str in strs {
                match str.chars().nth(i) {
                    None => {
                        return common_prefix.to_string();
                    }
                    Some(other) => {
                        if char != other {
                            return common_prefix.to_string();
                        }
                    }
                }
            }
            common_prefix.push(char);
        }

        return common_prefix;
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(strs, expected,
    case(&["flower","flow","flight"], "fl"),
    case(&["dog","racecar","car"], ""),
    ::trace
    )]
    fn iterate(strs: &[&str], expected: &str) {
        let vec = strs.to_vec().iter().map(|str| str.to_string()).collect();
        assert_eq!(Solution::iterate(&vec), expected.to_string());
    }
}
