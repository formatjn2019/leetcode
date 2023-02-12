package problems

import (
	"bytes"
	"strings"
)

func AlphabetBoardPath(target string) string {
	result := alphabetBoardPath(target)
	print(target, result, len(result))
	return result
}

func alphabetBoardPath(target string) string {
	var buffer bytes.Buffer
	prei, prej := 0, 0
	for _, c := range target {
		ci, cj := int((c-'a')/5), int((c-'a')%5)
		//优先垂直走
		if dir := prei < ci; dir {
			buffer.Write([]byte(strings.Repeat("D", ci-prei)))
		} else {
			//向上移动，先上再左右
			buffer.Write([]byte(strings.Repeat("U", prei-ci)))
		}
		//向下移动，先左右再下
		if prej < cj {
			buffer.Write([]byte(strings.Repeat("R", cj-prej)))
		} else {
			buffer.Write([]byte(strings.Repeat("L", prej-cj)))
		}
		buffer.WriteRune('!')
		prei, prej = ci, cj
	}

	return buffer.String()
}
