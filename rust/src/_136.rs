struct Solution;

/// https://leetcode.com/problems/single-number/
impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        Solution::bit(nums)
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

    /// 0 ms	2.2 MB
    fn bit(nums: Vec<i32>) -> i32 {
        let mut bits = 0;
        for num in nums {
            bits ^= num;
        }
        bits
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn hash() {
        assert_eq!(Solution::hash(vec![2, 2, 1]), 1);
        assert_eq!(Solution::hash(vec![4, 1, 2, 1, 2]), 4);
        assert_eq!(Solution::hash(vec![1]), 1);
    }

    #[test]
    fn bit() {
        assert_eq!(Solution::bit(vec![2, 2, 1]), 1);
        assert_eq!(Solution::bit(vec![4, 1, 2, 1, 2]), 4);
        assert_eq!(Solution::bit(vec![1]), 1);
    }
}
