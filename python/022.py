from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # 24 ms	14 MB
        if n <= 0:
            return []

        parenthesis = []
        self.__helper("", n, n, parenthesis)
        return parenthesis

    def __helper(self, builder: str, available_open: int, available_close: int, parenthesis: List[str]):
        if available_open < 0 or available_open > available_close:
            return
        if available_open == 0 and available_close == 0:
            parenthesis.append(builder)
            return

        self.__helper(builder + "(", available_open - 1, available_close, parenthesis)
        self.__helper(builder + ")", available_open, available_close - 1, parenthesis)


if __name__ == '__main__':
    s = Solution()
    print(s.generateParenthesis(1))
    print(s.generateParenthesis(3))
