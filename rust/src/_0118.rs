struct Solution;

/// https://leetcode.com/problems/pascals-triangle/
impl Solution {
    /// 0 ms	2 MB
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        let num_rows = num_rows as usize;
        if num_rows == 0 {
            return Vec::new();
        }

        let mut rows = Vec::with_capacity(num_rows);
        rows.push(vec![1]);

        for num_row in 1..num_rows {
            let mut row = Vec::with_capacity((num_row + 1));
            let prev: &Vec<_> = rows.get(num_row - 1).unwrap();

            row.push(1);
            for i in 1..prev.len() {
                row.push(prev[i - 1] + prev[i]);
            }
            row.push(1);

            rows.push(row);
        }

        rows
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
    num_rows,
    expected,
    case(0, vec![]),
    case(1, vec![vec![1]]),
    case(2, vec![vec![1], vec![1, 1]]),
    case(3, vec![vec![1], vec![1,1], vec![1, 2, 1]]),
    case(4, vec![vec![1], vec![1,1], vec![1, 2, 1], vec![1, 3, 3, 1]]),
    case(5, vec![vec![1], vec![1,1], vec![1, 2, 1], vec![1, 3, 3, 1], vec![1, 4, 6, 4, 1]]),
    )]
    fn foo(num_rows: i32, expected: Vec<Vec<i32>>) {
        assert_eq!(Solution::generate(num_rows), expected);
    }
}
