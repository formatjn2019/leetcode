package problems

import (
	"fmt"
	"strings"
)

func ReorderSpaces(text string) string {
	result := reorderSpaces(text)
	result = strings.ReplaceAll(result, " ", "*")
	fmt.Println(result)
	fmt.Println(len(result))
	return result
}

func reorderSpaces(text string) string {
	words := strings.Fields(text)
	spaces := strings.Count(text, " ")
	if len(words) < 2 {
		return strings.Join(words, "") + strings.Repeat(" ", spaces)
	}
	return strings.Join(words, strings.Repeat(" ", spaces/(len(words)-1))) + strings.Repeat(" ", spaces%(len(words)-1))
}

func reorderSpaces_split(text string) string {
	words := make([]string, 0)
	lenth := len(text)
	strLen := 0
	for _, word := range strings.Split(text, " ") {
		if len(word) > 0 {
			words = append(words, word)
			strLen += len(word)
		}
	}

	if len(words) < 2 {
		return strings.Join(words, "") + strings.Repeat(" ", lenth-strLen)
	}
	return strings.Join(words, strings.Repeat(" ", (lenth-strLen)/(len(words)-1))) + strings.Repeat(" ", (lenth-strLen)%(len(words)-1))
}
