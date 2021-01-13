struct Solution;
impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        Solution::find_min(&strs)
    }

    /// 0 ms	2 MB
    /// find the minimum string in the strs at first
    fn find_min(strs: &Vec<String>) -> String {
        match strs.len() {
            0 => {
                return "".to_string();
            }
            1 => {
                return strs.first().unwrap().to_string();
            }
            _ => {}
        }

        let min_str = strs.iter().min().unwrap();
        for (i, char) in min_str.chars().enumerate() {
            let is_different = strs.iter().any(|str| char != str.chars().nth(i).unwrap());
            if is_different {
                return min_str[..i].to_string();
            }
        }

        return min_str.to_string();
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(strs, expected,
    case(&["flower","flow","flight"], "fl"),
    case(&["dog","racecar","car"], ""),
    case(&["a"], "a"),
    // ::trace
    )]
    fn iterate(strs: &[&str], expected: &str) {
        let vec = strs
            .iter()
            .map(|str| str.to_string())
            .collect::<Vec<String>>();
        assert_eq!(Solution::find_min(&vec), expected.to_string());
    }
}
