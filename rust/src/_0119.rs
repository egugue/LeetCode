struct Solution;

/// https://leetcode.com/problems/pascals-triangle-ii/
impl Solution {
    /// 0 ms	2 MB	rust
    pub fn get_row(row_index: i32) -> Vec<i32> {
        let row_index = row_index as usize;
        let mut row = vec![1; row_index + 1];

        for i in 2..row_index + 1 {
            let mut prev = 1;
            for j in 1..i {
                let cur = row[j];
                row[j] = prev + cur;
                prev = cur;
            }
        }

        row
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
    num_rows,
    expected,
    case(0, &[1]),
    case(1, &[1, 1]),
    case(2, &[1, 2, 1]),
    case(3, &[1, 3, 3, 1]),
    case(4, &[1, 4, 6, 4, 1]),
    )]
    fn get_row(num_rows: i32, expected: &[i32]) {
        assert_eq!(Solution::get_row(num_rows), expected.to_vec());
    }
}
