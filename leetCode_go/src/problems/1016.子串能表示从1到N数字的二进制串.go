package problems

import (
	"strconv"
	"strings"
)

func QueryString(s string, n int) bool {
	result := queryString(s, n)
	println(result)
	return result
}
func queryString(s string, n int) bool {
	for i := 1; i <= n; i++ {
		if !strings.Contains(s, strconv.FormatInt(int64(n), 2)) {
			return false
		}
	}
	return true
}
