package problems

import "strings"

var IsValidSerialization = isValidSerialization

func isValidSerialization(preorder string) bool {
	arr := strings.Split(preorder, ",")
	// #计数，num计数
	sc, nc := 0, 0
	for p := len(arr) - 1; p >= 0; p-- {
		if arr[p] == "#" {
			sc++
		} else {
			nc++
		}
		if sc > 1 && nc > 0 {
			sc--
			nc--
		}
		// 无足够的# 消除数字 返回
		if sc < 2*nc {
			return false
		}
	}
	return sc == 1
}
