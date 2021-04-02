struct Solution;

/// 167. Two Sum II - Input array is sorted
impl Solution {
    pub fn two_sum(numbers: Vec<i32>, target: i32) -> Vec<i32> {
        Solution::binary_search(numbers, target)
    }

    /// 0 ms	2.3 MB
    fn binary_search(numbers: Vec<i32>, target: i32) -> Vec<i32> {
        fn helper(numbers: &[i32], target: i32, start: usize) -> Option<i32> {
            let mut left: isize = (start - 1) as isize;
            let mut right = numbers.len() as isize;
            while right - left > 1 {
                let mid = (right + left) / 2;
                let mid_val = numbers[mid as usize];
                if mid_val == target {
                    return Some(mid as i32);
                } else if target < mid_val {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            None
        }

        for (i, num) in numbers.iter().enumerate() {
            if let Some(other) = helper(&numbers, target - num, i + 1) {
                return vec![i as i32 + 1, other + 1];
            }
        }
        panic!()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn binary_binary() {
        assert_eq!(Solution::binary_search(vec![2, 7, 11, 15], 9), vec![1, 2]);
        assert_eq!(Solution::binary_search(vec![2, 3, 4], 6), vec![1, 3]);
        assert_eq!(Solution::binary_search(vec![-1, 0], -1), vec![1, 2]);
        assert_eq!(Solution::binary_search(vec![5, 25, 75], 100), vec![2, 3]);
    }
}
