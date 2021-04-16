struct Solution;

use std::collections::HashMap;

/// https://leetcode.com/problems/contains-duplicate-ii/
impl Solution {
    /// 4 ms	4.2 MB
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
        let k = k as usize;
        let mut map: HashMap<i32, usize> = HashMap::new();

        for (i, &num) in nums.iter().enumerate() {
            if let Some(last_index) = map.get(&num) {
                if i - last_index <= k {
                    return true;
                }
            }
            map.insert(num, i);
        }
        false
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        fn assert(nums: &[i32], k: i32, expected: bool) {
            assert_eq!(
                Solution::contains_nearby_duplicate(nums.to_vec(), k),
                expected
            )
        }

        assert(&[1], 1, false);
        assert(&[1, 1], 1, true);
        assert(&[1, 2], 1, false);
        assert(&[1, 2, 3, 1], 3, true);
        assert(&[1, 0, 1, 1], 1, true);
        assert(&[1, 2, 3, 1, 2, 3], 2, false)
    }
}
