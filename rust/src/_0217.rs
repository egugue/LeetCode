struct Solution;

/// https://leetcode.com/problems/contains-duplicate/
impl Solution {
    /// 0 ms	2.7 MB
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        if nums.len() <= 1 {
            return false;
        }

        let mut nums = nums;
        nums.sort();

        let mut prev = nums[0];
        for &num in &nums[1..] {
            if prev == num {
                return true;
            }
            prev = num;
        }

        false
    }
}
