struct Solution;
/// https://leetcode.com/problems/merge-sorted-array/
impl Solution {
    /// 0 ms	2 MB
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        let mut max_index = (nums1.len() - 1) as i32;
        let mut right_1 = m - 1;
        let mut right_2 = n - 1;

        while right_1 >= 0 && right_2 >= 0 {
            let v_1 = nums1[right_1 as usize];
            let v_2 = nums2[right_2 as usize];
            if v_1 >= v_2 {
                nums1[max_index as usize] = v_1;
                right_1 -= 1;
            } else {
                nums1[max_index as usize] = v_2;
                right_2 -= 1;
            }
            max_index -= 1;
        }

        while right_1 >= 0 {
            nums1[max_index as usize] = nums1[right_1 as usize];
            right_1 -= 1;
            max_index -= 1;
        }

        while right_2 >= 0 {
            nums1[max_index as usize] = nums2[right_2 as usize];
            right_2 -= 1;
            max_index -= 1;
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(nums1, m, nums2, expected,
    case(&[1], 1, &[], &[1]),
    case(&[0], 0, &[1], &[1]),
    case(&[1, 2, 3, 0, 0, 0], 3, &[7, 8, 9], &[1, 2, 3, 7, 8, 9]),
    case(&[7, 8, 9, 0, 0, 0], 3, &[1, 2, 3], &[1, 2, 3, 7, 8, 9]),
    case(&[1, 2, 3, 0, 0, 0], 3, &[2, 5, 6], &[1, 2, 2, 3, 5, 6]),
    )]
    fn merge(nums1: &[i32], m: i32, nums2: &[i32], expected: &[i32]) {
        let n = nums2.len() as i32;
        let mut nums1 = nums1.to_vec();
        Solution::merge(&mut nums1, m, &mut nums2.to_vec(), n);
        assert_eq!(nums1, expected.to_vec())
    }
}
