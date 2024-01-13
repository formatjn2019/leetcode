package problems

import (
	"strings"
)

var RepeatLimitedString = repeatLimitedString

func repeatLimitedString(s string, repeatLimit int) string {
	ccArr := [26]int{}
	for _, c := range s {
		ccArr[c-'a']++
	}
	cc, pre := 0, -1
	lp, rp := 25, 25
	var result strings.Builder
	for {
		// 右指针定位
		for rp >= 0 && ccArr[rp] == 0 {
			rp--
		}
		// 左指针定位
		for lp >= rp || (lp >= 0 && ccArr[lp] == 0) {
			lp--
		}
		p := rp
		if repeatLimit == cc && pre == p {
			p = lp
		}
		if p < 0 {
			break
		} else {
			ccArr[p]--
			result.WriteByte(byte(p + 'a'))
			if pre == p {
				cc++
			} else {
				cc = 1
			}
			pre = p
		}
	}
	return result.String()
}
