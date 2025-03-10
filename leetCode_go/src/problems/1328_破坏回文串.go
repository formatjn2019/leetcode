package problems

func breakPalindrome(palindrome string) string {
	if len(palindrome) == 1 {
		return ""
	}
	origin := []byte(palindrome)

	// 找到任意一个不是a的，尝试替换为a
	// 若失败则回滚
	// 成功则返回
	for i := 0; i < len(origin)/2; i++ {
		if origin[i] != 'a' {
			origin[i] = 'a'
			return string(origin)
		}
	}
	// 将最后一个字符替换为b
	origin[len(origin)-1] = 'b'
	return string(origin)
}
