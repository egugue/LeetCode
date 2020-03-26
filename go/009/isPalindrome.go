package _09

// 16 ms	5.2 MB
func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	ux := uint(x)

	var reversed uint
	for x != 0 {
		reversed *= 10
		reversed += uint(x % 10)
		x /= 10
	}

	return reversed == ux
}
