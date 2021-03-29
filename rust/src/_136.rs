struct Solution;

/// https://leetcode.com/problems/single-number/
impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        Solution::hash(nums)
    }

    /// 4 ms	2.3 MB
    fn hash(nums: Vec<i32>) -> i32 {
        use std::collections::HashSet;
        let mut hash_set = HashSet::with_capacity(nums.len() / 2);

        for num in nums {
            if hash_set.insert(num) == false {
                hash_set.remove(&num);
            }
        }

        *hash_set.iter().next().unwrap()
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test() {
        assert_eq!(Solution::single_number(vec![2, 2, 1]), 1);
        assert_eq!(Solution::single_number(vec![4, 1, 2, 1, 2]), 4);
        assert_eq!(Solution::single_number(vec![1]), 1);
    }
}
