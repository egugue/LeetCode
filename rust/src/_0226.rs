use crate::shared::tree_node::TreeNode;
struct Solution;

use std::cell::RefCell;
use std::rc::Rc;

/// https://leetcode.com/problems/invert-binary-tree/
impl Solution {
    /// 0 ms	2.2 MB
    pub fn invert_tree(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        fn helper(node: Rc<RefCell<TreeNode>>) -> Rc<RefCell<TreeNode>> {
            let mut node = node.replace(TreeNode::new(0));

            let left = if let Some(left) = node.left {
                Some(helper(left))
            } else {
                None
            };
            let right = if let Some(right) = node.right {
                Some(helper(right))
            } else {
                None
            };

            node.left = right;
            node.right = left;
            Rc::new(RefCell::new(node))
        }

        if let Some(root) = root {
            Some(helper(root))
        } else {
            None
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        assert_eq!(
            Solution::invert_tree(TreeNode::from_str_and_wrap("[4,2,7,1,3,6,9]")),
            TreeNode::from_str_and_wrap("[4,7,2,9,6,3,1]")
        );
        assert_eq!(
            Solution::invert_tree(TreeNode::from_str_and_wrap("[2,1,3]")),
            TreeNode::from_str_and_wrap("[2,3,1]")
        );
        assert_eq!(
            Solution::invert_tree(TreeNode::from_str_and_wrap("[]")),
            TreeNode::from_str_and_wrap("[]")
        );
    }
}
