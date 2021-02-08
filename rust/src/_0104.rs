use crate::shared::tree_node::TreeNode;
use std::cell::RefCell;
use std::cmp::max;
use std::rc::Rc;

struct Solution;
/// https://leetcode.com/problems/maximum-depth-of-binary-tree/
impl Solution {
    pub fn max_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        Solution::recursive(root)
    }

    /// 0 ms	2.7 MB
    fn recursive(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        if root.is_none() {
            return 0;
        }

        let root = root.unwrap().replace(TreeNode::new(0));
        return 1 + max(
            Solution::recursive(root.left),
            Solution::recursive(root.right),
        );
    }
}

mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
        root,
        expected,
        case("[]", 0),
        case("[1]", 1),
        case("[1,null,2]", 2),
        case("[3,9,20,null,null,15,7]", 3)
    )]
    fn max_depth(root: &str, expected: i32) {
        assert_eq!(
            Solution::max_depth(TreeNode::from_str_and_wrap(root)),
            expected
        );
    }
}
