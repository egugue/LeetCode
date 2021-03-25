struct Solution;

use std::cmp::max;
/// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
impl Solution {
    /// 12 ms	2.9 MB
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        if prices.len() <= 1 {
            return 0;
        }
        let mut max_profit = 0;
        let mut min_price = *prices.get(0).unwrap();
        for &price in &prices[1..] {
            if price < min_price {
                min_price = price;
            } else {
                max_profit = max(max_profit, price - min_price);
            }
        }
        max_profit
    }
}

#[cfg(test)]
mod test {
    use super::*;
    use rstest::rstest;

    #[rstest(prices, expected, case(&[7], 0), case(&[1, 7], 6), case(&[7,1,5,3,6,4], 5), case(&[7,6,4,3,1], 0))]
    fn max_price(prices: &[i32], expected: i32) {
        assert_eq!(Solution::max_profit(prices.to_vec()), expected);
    }
}
