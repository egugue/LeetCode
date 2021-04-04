struct Solution;

/// https://leetcode.com/problems/majority-element/
impl Solution {
    /// 0 ms	2.3 MB
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        let mut major = nums[0];
        let mut count = 1;
        for &num in &nums[1..] {
            if major == num {
                count += 1;
            } else if major != num {
                count -= 1;
            }
            if count == 0 {
                major = num;
                count = 1;
            }
        }
        major
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn test() {
        fn assert(nums: Vec<i32>, expected: i32) {
            assert_eq!(Solution::majority_element(nums), expected);
        }

        assert(vec![3], 3);
        assert(vec![3, 2, 3], 3);
        assert(vec![10, 9, 9, 9, 10], 9);
        assert(vec![2, 2, 1, 1, 1, 2, 2], 2);
    }
}
