struct Solution;

/// https://leetcode.com/problems/reverse-bits/
impl Solution {
    /// 0 ms	1.9 MB
    pub fn reverse_bits(x: u32) -> u32 {
        let mut x = x;
        let mut rev = 0;
        for _ in 0..32 {
            rev = rev << 1;
            rev += x & 1;
            x >>= 1;
        }
        rev
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test() {
        fn assert(x: u32, e: u32) {
            assert_eq!(Solution::reverse_bits(x), e)
        }

        assert(0, 0);
        assert(
            0b00000010100101000001111010011100,
            0b00111001011110000010100101000000,
        );
        assert(
            0b11111111111111111111111111111101,
            0b10111111111111111111111111111111,
        );
    }
}
