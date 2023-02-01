package problems

import (
	"bytes"
)

func DecodeMessage(key string, message string) string {
	return decodeMessage(key, message)
}
func decodeMessage(key string, message string) string {
	//构造字典
	index := 'a'
	translateDict := map[rune]rune{}
	for _, c := range []rune(key) {
		if _, ok := translateDict[c]; c != ' ' && !ok {
			translateDict[c] = index
			index++
		}
	}
	var cache bytes.Buffer
	for _, c := range []rune(message) {
		if repl, ok := translateDict[c]; ok {
			c = repl
		}
		cache.WriteRune(c)
	}
	return cache.String()
}
