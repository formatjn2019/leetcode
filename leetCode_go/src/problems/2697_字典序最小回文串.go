package problems

func makeSmallestPalindrome(s string) string {
	bArr := []byte(s)
	for i := 0; i < len(bArr)/2; i++ {
		l, r := i, len(bArr)-1-i
		if bArr[l] > bArr[r] {
			bArr[l] = bArr[r]
		} else if bArr[l] < bArr[r] {
			bArr[r] = bArr[l]
		}
	}
	return string(bArr)
}
