struct Solution;

use crate::shared::tree_node::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn sorted_array_to_bst(nums: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        // Solution::recursive(nums)
        Solution::iterative(nums)
    }

    /// 0 ms	3.1 MB
    fn recursive(nums: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        fn helper(nums: &[i32]) -> Option<TreeNode> {
            if nums.len() == 0 {
                return None;
            }
            let mid = nums.len() / 2;
            let mut node = TreeNode::new(nums[mid]);
            node.left = helper(&nums[0..mid]).map(|n| Rc::new(RefCell::new(n)));
            node.right = helper(&nums[mid + 1..]).map(|n| Rc::new(RefCell::new(n)));

            Some(node)
        }

        helper(&nums[..]).map(|n| Rc::new(RefCell::new(n)))
    }

    /// 0 ms	2.9 MB
    fn iterative(nums: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        if nums.is_empty() {
            return None;
        }

        let root = TreeNode::new(nums[nums.len() / 2]);
        let root = Rc::new(RefCell::new(root));

        let mut stack = Vec::new();
        stack.push((Rc::clone(&root), &nums[..]));
        while !stack.is_empty() {
            let (node, nums) = stack.pop().unwrap();
            let mid = nums.len() / 2;

            let left_nums = &nums[..mid];
            if !left_nums.is_empty() {
                let nums = left_nums;
                let left = TreeNode::new(nums[nums.len() / 2]);
                let left = Rc::new(RefCell::new(left));
                stack.push((Rc::clone(&left), nums));
                node.borrow_mut().left = Some(left);
            }

            let right_nums = &nums[mid + 1..];
            if !right_nums.is_empty() {
                let nums = right_nums;
                let right = TreeNode::new(nums[nums.len() / 2]);
                let right = Rc::new(RefCell::new(right));
                stack.push((Rc::clone(&right), nums));
                node.borrow_mut().right = Some(right);
            }
        }

        Some(root)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(nums, expected,
    case(&[], "[]"),
    case(&[1], "[1]"),
    case(&[1, 2, 3], "[2, 1, 3]"),
    case(&[-10,-3,0,5,9], "[0,-3,9,-10,null,5]"))
    ]
    fn recursive(nums: &[i32], expected: &str) {
        assert_eq!(
            Solution::recursive(Vec::from(nums)),
            TreeNode::from_str_and_wrap(expected)
        );
    }

    #[rstest(nums, expected,
    case(&[], "[]"),
    case(&[1], "[1]"),
    case(&[1, 2, 3], "[2, 1, 3]"),
    case(&[-10,-3,0,5,9], "[0,-3,9,-10,null,5]"))
    ]
    fn iterative(nums: &[i32], expected: &str) {
        assert_eq!(
            Solution::iterative(Vec::from(nums)),
            TreeNode::from_str_and_wrap(expected)
        );
    }
}
