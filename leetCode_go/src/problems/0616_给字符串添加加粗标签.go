package problems

import (
	"bytes"
	"strings"
)

func AddBoldTag(s string, words []string) string {
	return addBoldTag(s, words)
}

func addBoldTag(s string, words []string) string {
	cMark := make([]bool, len(s))
	for _, word := range words {
		df, ts := 0, s
		for {
			if idx := strings.Index(ts, word); idx != -1 {
				for i := 0; i < len(word); i++ {
					cMark[df+i+idx] = true
				}
				ts = ts[idx+1:]
				df += idx + 1
			} else {
				break
			}
		}

	}
	var bf bytes.Buffer
	flag := false
	for idx, b := range cMark {
		if b != flag {
			if !flag {
				bf.WriteString("<b>")
			} else {
				bf.WriteString("</b>")
			}
		}
		bf.WriteByte(s[idx])
		flag = b
	}
	if flag {
		bf.WriteString("</b>")
	}
	return bf.String()
}
