struct Solution;

/// https://leetcode.com/problems/valid-anagram/
impl Solution {
    /// 0 ms	2.2 MB
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len() != t.len() {
            return false;
        }
        if s.is_empty() {
            return true;
        }

        let mut char_count = [0; 26];

        for char in s.chars() {
            let key: usize = (u32::from(char) - 97) as usize;
            char_count[key] += 1;
        }
        for char in t.chars() {
            let key: usize = (u32::from(char) - 97) as usize;
            if char_count[key] == 0 {
                return false
            }
            char_count[key] -= 1;
        }

        true
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        fn assert(s: &str, t: &str, expected: bool) {
            assert_eq!(Solution::is_anagram(s.to_string(), t.to_string()), expected);
        }

        assert("", "", true);
        assert("a", "a", true);
        assert("a", "b", false);
        assert("anagram", "nagaram", true);
        assert("rat", "car", false);
    }
}
