package problems

import (
	"bytes"
)

func EntityParser(text string) string {
	return entityParser(text)
}

func entityParser(text string) string {
	translateMap := map[string]rune{
		"&quot;":  '"',
		"&apos;":  '\'',
		"&amp;":   '&',
		"&gt;":    '>',
		"&lt;":    '<',
		"&frasl;": '/',
	}
	var result bytes.Buffer

	for p := 0; p < len(text); p++ {
		appendFlag := false
		if text[p] == '&' {
			for l := 4; !appendFlag && l < 8; l++ {
				if p+l <= len(text) {
					if _, ok := translateMap[text[p:p+l]]; ok {
						result.WriteRune(translateMap[text[p:p+l]])
						appendFlag = true
						p += l - 1
					}
				}
			}
		}
		if !appendFlag {
			result.WriteByte(text[p])
		}
	}
	return result.String()
}
