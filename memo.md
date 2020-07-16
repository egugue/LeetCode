<!-- TOC -->

- [Array](#array)
  - [How to mark a specific value](#how-to-mark-a-specific-value)
    - [case - marking value out of the range](#case---marking-value-out-of-the-range)
      - [130. Surrounded Regions](#130-surrounded-regions)
      - [448. Find All Numbers Disappeared in an Array](#448-find-all-numbers-disappeared-in-an-array)
    - [case - marking only the value in a specific position first](#case---marking-only-the-value-in-a-specific-position-first)
      - [73. Set Matrix Zeroes](#73-set-matrix-zeroes)
- [String](#string)
  - [Substring search template](#substring-search-template)

<!-- /TOC -->

# Array
## How to mark a specific value
In order to replace a value **in place**, marking a specific value is sometimes effective.

### case - marking value out of the range
If the range of values in an array is limited,
marking a value out of the range could be used.

#### 130. Surrounded Regions
https://leetcode.com/problems/surrounded-regions/
`*` is a value out of the range

#### 448. Find All Numbers Disappeared in an Array
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Numbers in a array are only positive integers.  
Taking this advantage of the limitation, Invert some numbers in the first loop.


### case - marking only the value in a specific position first

Examples
#### 73. Set Matrix Zeroes
https://leetcode.com/problems/set-matrix-zeroes/
At first, the first column and first row are set to 0,  
then the others are checked to set to 0 or not.


# String
## Substring search template
https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.