struct Solution;

/// https://leetcode.com/problems/number-of-islands/
impl Solution {
    /// 4 ms	5.4 MB
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        if grid.len() == 0 || grid[0].len() == 0 {
            return 0;
        }

        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        let mut count = 0;
        for (i, row) in grid.iter().enumerate() {
            for (j, &char) in row.iter().enumerate() {
                if visited[i][j] {
                    continue;
                }
                if char == '0' {
                    visited[i][j] = true;
                    continue;
                }

                count += 1;
                Solution::walk(i, j, &grid, &mut visited);
            }
        }

        count
    }

    fn walk(i: usize, j: usize, grid: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>) {
        if grid.len() <= i || grid[0].len() <= j || visited[i][j] {
            return;
        }

        visited[i][j] = true;
        if grid[i][j] == '0' {
            return;
        }

        if i != 0 {
            Solution::walk(i - 1, j, grid, visited);
        }
        Solution::walk(i + 1, j, grid, visited);

        if j != 0 {
            Solution::walk(i, j - 1, grid, visited);
        }
        Solution::walk(i, j + 1, grid, visited);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        fn assert(g: Vec<Vec<char>>, expected: i32) {
            assert_eq!(Solution::num_islands(g), expected);
        }

        assert(
            vec![
                vec!['1', '1', '1', '1', '0'],
                vec!['1', '1', '0', '1', '0'],
                vec!['1', '1', '0', '0', '0'],
                vec!['0', '0', '0', '0', '0'],
            ],
            1,
        );

        assert(
            vec![
                vec!['1', '1', '0', '0', '0'],
                vec!['1', '1', '0', '0', '0'],
                vec!['0', '0', '1', '0', '0'],
                vec!['0', '0', '0', '1', '1'],
            ],
            3,
        );
    }
}
