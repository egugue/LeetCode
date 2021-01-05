use std::iter::FromIterator;
use std::collections::HashMap;
use std::ptr::hash;

struct Solution;

/// https://leetcode.com/problems/two-sum/submissions/
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        Solution::hash(&nums, target)
    }

    /// 0 ms	2.2 MB
    fn hash(nums: &Vec<i32>, target: i32) -> Vec<i32> {
        use std::collections::HashMap;
        let mut map: HashMap<i32, usize> = HashMap::new();

        for (i, &num) in nums.iter().enumerate() {
            match map.get(&(target - num)) {
                None => {
                    map.insert(num, i);
                }
                Some(&other_i) => {
                    return vec![other_i as i32, i as i32];
                }
            }
        }

        unreachable!();
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn hash() {
        let a = Solution::hash(&[2, 7, 11, 15].to_vec(), 9);
        assert_eq!(a, [0, 1].to_vec());

        let a = Solution::hash(&[3, 2, 4].to_vec(), 6);
        assert_eq!(a, [1, 2].to_vec());

        let a = Solution::hash(&[3, 3].to_vec(), 6);
        assert_eq!(a, [0, 1].to_vec());
    }
}