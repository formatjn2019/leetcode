package problems

import "strings"

func isCircularSentence(sentence string) bool {
	if sentence[0] != sentence[len(sentence)-1] {
		return false
	}
	arr := strings.Split(sentence, " ")
	for i := 0; i < len(arr)-1; i++ {
		if pre, pro := arr[i], arr[i+1]; pre[len(pre)-1] != pro[0] {
			return false
		}
	}
	return true
}
