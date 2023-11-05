package problems

func VerifyPreorder(preorder []int) bool {
	return verifyPreorder(preorder)
}

func verifyPreorder(preorder []int) bool {
	if len(preorder) <= 1 {
		return true
	}
	rtv := preorder[0]
	splitIdx := 1
	for splitIdx < len(preorder) && preorder[splitIdx] < rtv {
		splitIdx++
	}
	for ti := splitIdx; ti < len(preorder); ti++ {
		if preorder[ti] < rtv {
			return false
		}
	}
	return verifyPreorder(preorder[1:splitIdx]) && verifyPreorder(preorder[splitIdx:])
}
