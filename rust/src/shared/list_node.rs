#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }

    pub fn from_array(array: &[i32]) -> Self {
        ListNode::from(array)
    }

    pub fn in_option_box_from_array(array: &[i32]) -> Option<Box<ListNode>> {
        if array.is_empty() {
            None
        } else {
            ListNode::from_array(array).to_option_box()
        }
    }

    pub fn to_option_box(self) -> Option<Box<ListNode>> {
        Some(Box::new(self))
    }

    pub fn to_vec(&self) -> Vec<i32> {
        let mut vec = Vec::new();
        self._to_vec(&mut vec);
        vec
    }

    fn _to_vec(&self, vec: &mut Vec<i32>) {
        vec.push(self.val);
        match &self.next {
            None => {}
            Some(b) => (*b)._to_vec(vec),
        }
    }
}

impl From<&[i32]> for ListNode {
    fn from(array: &[i32]) -> Self {
        let mut current = None;

        for &num in array.iter().rev() {
            let mut node = ListNode::new(num);
            node.next = current;
            current = Some(Box::new(node));
        }

        *current.unwrap()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[test]
    fn from_array() {
        let expected = ListNode::new(10);
        assert_eq!(ListNode::from_array(&[10]), expected);

        let expected = ListNode {
            val: 10,
            next: Some(Box::new(ListNode {
                val: 20,
                next: Some(Box::new(ListNode {
                    val: 30,
                    next: None,
                })),
            })),
        };
        assert_eq!(ListNode::from_array(&[10, 20, 30]), expected)
    }

    #[test]
    #[ignore]
    #[should_panic]
    fn from_array_panic() {
        ListNode::from(&[] as &[i32]);
    }

    #[test]
    fn to_option_box() {
        assert_eq!(
            ListNode::new(10).to_option_box(),
            Some(Box::new(ListNode::new(10)))
        );
    }

    #[rstest(array,
    case(&[10]),
    case(&[10, 20, 30]),
    ::trace
    )]
    fn to_vec(array: &[i32]) {
        assert_eq!(ListNode::from_array(array).to_vec(), array.to_vec())
    }
}
