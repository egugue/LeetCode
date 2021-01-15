struct Solution;
/// https://leetcode.com/problems/add-binary/
impl Solution {
    /// 0 ms	2 MB
    pub fn add_binary(a: String, b: String) -> String {
        let mut result = String::with_capacity(a.len().max(b.len()) + 1);
        let mut a = a.chars().into_iter().rev();
        let mut b = b.chars().into_iter().rev();
        let mut carry = 0;

        loop {
            let a_next = a.next();
            let b_next = b.next();
            if a_next.is_none() && b_next.is_none() {
                break;
            }

            let num_a = a_next.map(|c| if c == '0' { 0 } else { 1 }).unwrap_or(0);
            let num_b = b_next.map(|c| if c == '0' { 0 } else { 1 }).unwrap_or(0);
            let sum = num_a + num_b + carry;
            result.push(if sum % 2 == 0 { '0' } else { '1' });
            carry = sum / 2;
        }

        if carry == 1 {
            result.push('1');
        }

        result.chars().into_iter().rev().collect()
    }
}

mod test {
    use super::*;
    use rstest::rstest;

    #[rstest(
        a,
        b,
        expected,
        case("11", "1", "100"),
        case("1010", "1011", "10101"),
        ::tracing
    )]
    fn add_binary(a: &str, b: &str, expected: &str) {
        assert_eq!(
            Solution::add_binary(a.to_string(), b.to_string()),
            expected.to_string()
        )
    }
}
