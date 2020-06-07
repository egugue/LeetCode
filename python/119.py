from typing import List


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]

        rowIndex += 1  # means size
        row = [0] * rowIndex
        row[0] = 1
        row[1] = 1

        for i in range(2, rowIndex):
            prev = 1
            for j in range(1, i):
                next = row[j]
                row[j] = prev + next
                prev = next
            row[i] = 1

        return row


if __name__ == '__main__':
    s = Solution()
    print(s.getRow(0))
