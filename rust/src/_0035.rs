use std::ops::Index;

struct Solution;

/// https://leetcode.com/problems/search-insert-position/
impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        Solution::binary_search(nums, target)
    }

    /// 0 ms	2 MB
    fn binary_search(nums: Vec<i32>, target: i32) -> i32 {
        if nums.is_empty() {
            return 0;
        }

        // assign -1 and len() because `target` may be lower/higher than any in the nums.
        let mut left: isize = -1;
        let mut right = nums.len() as isize;
        while right - left > 1 {
            let mid = (left + right) / 2;
            let mid_val = *nums.index(mid as usize);
            if mid_val == target {
                return mid as i32;
            }
            if target < mid_val {
                right = mid;
            } else {
                left = mid;
            }
        }

        // target is not found
        right as i32
    }
}

mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(nums, target, expected,
    case(&[1, 3, 5, 6], 5, 2),
    case(&[1, 3, 5, 6], 2, 1),
    case(&[1, 3, 5, 6], 7, 4),
    case(&[1, 3, 5, 6], 0, 0),
    case(&[1], 0, 0),
    // ::trace
    )]
    fn binary_search(nums: &[i32], target: i32, expected: i32) {
        assert_eq!(Solution::binary_search(nums.to_vec(), target), expected);
    }
}
