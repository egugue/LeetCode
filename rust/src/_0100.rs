use crate::shared::tree_node::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;

struct Solution;
/// https://leetcode.com/problems/same-tree/
impl Solution {
    pub fn is_same_tree(
        p: Option<Rc<RefCell<TreeNode>>>,
        q: Option<Rc<RefCell<TreeNode>>>,
    ) -> bool {
        Solution::recursive(p, q)
    }

    /// 0 ms	2.1 MB
    fn recursive(p: Option<Rc<RefCell<TreeNode>>>, q: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match (p, q) {
            (Some(p), Some(q)) => {
                let p = p.replace(TreeNode::new(0));
                let q = q.replace(TreeNode::new(0));
                p.val == q.val
                    && Solution::is_same_tree(p.left, q.left)
                    && Solution::is_same_tree(p.right, q.right)
            }
            (None, None) => true,
            _ => false,
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
        p,
        q,
        expected,
        case("[]", "[]", true),
        case("[1]", "[1]", true),
        case("[1]", "[2]", false),
        case("[1,2,3]", "[1,2,3]", true),
        case("[1,2]", "[1,null,2]", false),
        case("[1,2,1]", "[1,1,2]", false),
        // ::trace
    )]
    fn recursive(p: &str, q: &str, expected: bool) {
        let p = TreeNode::from_str_and_wrap(p);
        let q = TreeNode::from_str_and_wrap(q);
        assert_eq!(Solution::is_same_tree(p, q), expected);
    }
}
