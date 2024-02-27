package problems

import "strings"

func splitWordsBySeparator(words []string, separator byte) []string {
	var result []string
	for _, word := range words {
		var sb strings.Builder
		for _, c := range []byte(word) {
			if c != separator {
				sb.WriteByte(c)
			} else {
				if sb.Len() > 0 {
					result = append(result, sb.String())
				}
				sb = strings.Builder{}
			}
		}
		if sb.Len() > 0 {
			result = append(result, sb.String())
		}
	}
	return result
}
