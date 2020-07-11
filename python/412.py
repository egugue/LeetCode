from typing import List


class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        # 40 ms	14.8 MB
        result = []
        n += 1
        for number in range(1, n):
            if number % 15 == 0:
                result.append("FizzBuzz")
            elif number % 3 == 0:
                result.append("Fizz")
            elif number % 5 == 0:
                result.append("Buzz")
            else:
                result.append(str(number))
        return result


if __name__ == '__main__':
    s = Solution()
    print(s.fizzBuzz(15))
