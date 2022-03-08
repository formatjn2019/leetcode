package problems

import "strings"

func FindLUSlength(a string, b string) int {
	return findLUSlength(a, b)
}

func findLUSlength(a string, b string) int {
	if len(b) > len(a) {
		a, b = b, a
	}
	if strings.EqualFold(a, b) {
		return -1
	}
	return len(a)
}
