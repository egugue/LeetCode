struct Solution;

/// https://leetcode.com/problems/excel-sheet-column-title/
impl Solution {
    /// 0 ms	2 MB
    pub fn convert_to_title(column_number: i32) -> String {
        let mut rest = column_number;
        let mut title = String::new();
        while rest != 0 {
            rest -= 1;
            let num = rest % 26;
            title.push(char::from((65 + num) as u8));
            rest /= 26;
        }

        title.chars().rev().collect()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        fn c(v: i32) -> String {
            Solution::convert_to_title(v)
        }

        assert_eq!(c(1), "A".to_string());
        assert_eq!(c(2), "B".to_string());
        assert_eq!(c(26), "Z".to_string());
        assert_eq!(c(27), "AA".to_string());
        assert_eq!(c(28), "AB".to_string());
        assert_eq!(c(52), "AZ".to_string());
        assert_eq!(c(53), "BA".to_string());
        assert_eq!(c(701), "ZY".to_string());
        assert_eq!(c(2147483647), "FXSHRXW".to_string());
    }
}
