struct Solution;

/// https://leetcode.com/problems/house-robber/submissions/
impl Solution {
    /// 0 ms	2 MB
    pub fn rob(nums: Vec<i32>) -> i32 {
        let mut dp = vec![0; nums.len() + 1];
        dp[1] = nums[0];
        for i in 2..dp.len() {
            let robbed = dp[i - 2] + nums[i - 1];
            let skipped = dp[i - 1];
            dp[i] = if robbed > skipped { robbed } else { skipped }
        }

        dp[nums.len()]
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test() {
        fn assert(nums: &[i32], expected: i32) {
            assert_eq!(Solution::rob(nums.to_vec()), expected);
        }

        assert(&[1], 1);
        assert(&[3, 2], 3);
        assert(&[1, 2, 3, 1], 4);
        assert(&[2, 7, 9, 3, 1], 12);
        assert(&[2, 1, 1, 2], 4);
    }
}
