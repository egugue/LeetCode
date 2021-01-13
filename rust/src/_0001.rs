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
    use rstest::rstest;

    #[rstest(nums, target, expected,
    case(&[2, 7, 11, 15], 9, &[0, 1]),
    case(&[3, 2, 4], 6, &[1, 2]),
    case(&[3, 3], 6, &[0, 1]),
    // ::trace
    )]
    fn hash(nums: &[i32], target: i32, expected: &[i32]) {
        assert_eq!(Solution::hash(&nums.to_vec(), target), expected)
    }
}
