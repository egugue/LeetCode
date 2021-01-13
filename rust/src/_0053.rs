struct Solution;

/// https://leetcode.com/problems/maximum-subarray/
impl Solution {
    pub fn max_sub_array(nums: Vec<i32>) -> i32 {
        Solution::dp(&nums)
    }

    /// 0 ms	2.1 MB
    fn dp(nums: &Vec<i32>) -> i32 {
        if nums.is_empty() {
            return 0;
        }
        let mut max = *nums.first().unwrap();
        let mut sum = 0;
        for &num in nums.iter() {
            sum += num;
            max = max.max(sum);
            if sum < 0 {
                sum = 0;
            }
        }
        max
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(nums, expected,
    case(&[-2, 1, -3, 4, -1, 2, 1, -5, 4], 6),
    case(&[-2, -3, -1, -5], -1),
    case(&[1, 2], 3),
    case(&[-2, 1], 1),
    case(&[1], 1),
    case(&[0], 0),
    case(&[-1], -1),
    case(&[-100000], -100000),
    ::trace
    )]
    fn dp(nums: &[i32], expected: i32) {
        assert_eq!(Solution::dp(&nums.to_vec()), expected)
    }
}
