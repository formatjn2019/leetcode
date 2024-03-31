package problems

import "strings"

func maximumOddBinaryNumber(s string) string {
	c1, c0 := 0, 0
	for _, c := range s {
		if c == '1' {
			c1++
		} else {
			c0++
		}
	}
	return strings.Join([]string{strings.Repeat("1", c1-1), strings.Repeat("0", c0), "1"}, "")
}
