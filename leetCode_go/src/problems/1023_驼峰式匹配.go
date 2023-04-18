package problems

import (
	"regexp"
	"strings"
)

func CamelMatch(queries []string, pattern string) []bool {
	return camelMatch(queries, pattern)
}
func camelMatch(queries []string, pattern string) []bool {
	rule, _ := regexp.Compile(`^[a-z]*` + strings.Join(strings.Split(pattern, ""), `[a-z]*`) + `[a-z]*$`)
	result := make([]bool, len(queries))
	for idx, query := range queries {
		result[idx] = rule.Match([]byte(query))
	}
	return result
}
