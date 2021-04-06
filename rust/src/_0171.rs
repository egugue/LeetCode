struct Solution;

/// https://leetcode.com/problems/excel-sheet-column-number/
impl Solution {
    /// 0 ms	2 MB	rust
    pub fn title_to_number(column_title: String) -> i32 {
        column_title
            .chars()
            .rev()
            .enumerate()
            .fold(0, |sum, (i, char)| {
                let code = u32::from(char) as i32;
                sum + 26_i32.pow(i as u32) * (code - 64)
            })
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        fn assert(t: &str, expected: i32) {
            assert_eq!(Solution::title_to_number(t.to_string()), expected);
        }

        assert("A", 1);
        assert("B", 2);
        assert("Z", 26);
        assert("AA", 27);
        assert("ZY", 701);
    }
}
