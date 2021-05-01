use crate::shared::list_node::ListNode;

struct Solution;

/// https://leetcode.com/problems/palindrome-linked-list/
impl Solution {
    pub fn is_palindrome(head: Option<Box<ListNode>>) -> bool {
        Solution::vec(head)
    }

    /// 60 ms	9.2 MB
    fn vec(head: Option<Box<ListNode>>) -> bool {
        let mut vec = Vec::new();
        let mut cur = head.as_ref();
        while cur.is_some() {
            let node = cur.unwrap();
            vec.push(node.val);
            cur = node.next.as_ref();
        }

        for i in 0..vec.len() / 2 {
            if vec[i] != vec[vec.len() - 1 - i] {
                return false;
            }
        }

        true
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn vec() {
        assert_eq!(
            Solution::is_palindrome(ListNode::in_option_box_from_array(&[])),
            true
        );
        assert_eq!(
            Solution::is_palindrome(ListNode::in_option_box_from_array(&[1])),
            true
        );
        assert_eq!(
            Solution::is_palindrome(ListNode::in_option_box_from_array(&[1, 2])),
            false
        );
        assert_eq!(
            Solution::is_palindrome(ListNode::in_option_box_from_array(&[1, 2, 2, 1])),
            true
        );
        assert_eq!(
            Solution::is_palindrome(ListNode::in_option_box_from_array(&[1, 2, 100, 2, 1])),
            true
        );
    }
}
