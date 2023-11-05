package problems

import "regexp"

var matchRule, _ = regexp.Compile(`^.{11}([7-9].|6[1-9]).{2}$`)

func countSeniors_regexp(details []string) int {
	var result int
	for _, detail := range details {
		if matchRule.Match([]byte(detail)) {
			result++
		}
	}
	return result
}

func countSeniors(details []string) int {
	var result int
	for _, detail := range details {
		if detail[11:13] > "60" {
			result++
		}
	}
	return result
}
