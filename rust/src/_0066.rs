struct Solution;

/// https://leetcode.com/problems/plus-one/
impl Solution {
    /// 0 ms	2 MB
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        let mut result = Vec::with_capacity(digits.len() + 1);

        let mut carry = 1;
        for x in digits.iter().rev() {
            let sum = x + carry;
            result.push(sum % 10);
            carry = sum / 10;
        }
        if carry != 0 {
            result.push(carry);
        }

        result.reverse();
        result
    }
}

mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(digits, expected,
    case(&[1,2,3], &[1,2,4]),
    case(&[4,3,2,1], &[4,3,2,2]),
    case(&[0], &[1]),
    case(&[9, 9], &[1, 0, 0]),
    // ::trace
    )]
    fn plus_one(digits: &[i32], expected: &[i32]) {
        assert_eq!(Solution::plus_one(digits.to_vec()), expected.to_vec());
    }
}
