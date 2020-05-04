from typing import List

letters = {
    '2': 'abc',
    '3': 'def',
    '4': 'ghi',
    '5': 'jkl',
    '6': 'mno',
    '7': 'pqrs',
    '8': 'tuv',
    '9': 'wxyz'
}


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # 28 ms	13.9 MB

        if len(digits) == 0:
            return []

        combs = []
        self.__helper("", 0, combs, digits)
        return combs

    def __helper(self, cur: str, index: int, comb: List[str], digits: str):
        if index == len(digits):
            comb.append(cur)
            return

        digit = digits[index]
        for letter in letters[digit]:
            self.__helper(cur + letter, index + 1, comb, digits)


if __name__ == '__main__':
    s = Solution()
    print(s.letterCombinations("23"))
    print(s.letterCombinations(""))
