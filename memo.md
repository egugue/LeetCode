

# Array
## How to mark a specific value
In order to replace a value **in place**, marking a specific value is sometimes effective.

### case - marking value out of the range
If the range of values in an array is limited,
marking a value out of the range could be used.

Examples
- https://leetcode.com/problems/surrounded-regions/
  - `*` is a value out of the range

### case - marking only the value in a specific position first

Examples
- https://leetcode.com/problems/set-matrix-zeroes/
  - At first, the first column and first row are set to 0,  
  then the others are checked to set to 0 or not.