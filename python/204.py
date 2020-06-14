class Solution:
    def countPrimes(self, n: int) -> int:
        return hashmap(n)
        # return using_sqrt(n)


def hashmap(n: int) -> int:
    # 664 ms	25.3 MB
    if n <= 2:
        return 0

    is_primes = [True] * n
    count = 0
    for i in range(2, n):
        if not is_primes[i]:
            continue
        count += 1
        for j in range(i * 2, n, i):
            is_primes[j] = False

    return count


def using_sqrt(n: int) -> int:
    # Time Limit Exceeded

    # must count prime numbers "less than" a non-negative number, n.
    if n <= 2:
        return 0

    import math
    def is_prime(num: int):
        sqrt = int(math.sqrt(num))
        for i in range(2, sqrt + 1):
            if num % i == 0:
                return False
        return True

    count = 0
    for i in range(2, n):
        if is_prime(i):
            count += 1

    return count


if __name__ == '__main__':
    s = Solution()
    print(s.countPrimes(10))
    print(s.countPrimes(2))
    print(s.countPrimes(3))
