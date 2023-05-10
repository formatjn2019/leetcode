package problems

import "regexp"

func countTime(time string) int {
	result := 1
	hour, minute := time[:2], time[3:]
	if matched, _ := regexp.Match(`[01]\?`, []byte(hour)); matched {
		result *= 10
	}
	if matched, _ := regexp.Match(`2\?`, []byte(hour)); matched {
		result *= 4
	}
	if matched, _ := regexp.Match(`\?\?`, []byte(hour)); matched {
		result *= 24
	}
	if matched, _ := regexp.Match(`\?[0-3]`, []byte(hour)); matched {
		result *= 3
	}
	if matched, _ := regexp.Match(`\?[4-9]`, []byte(hour)); matched {
		result *= 2
	}
	if minute[0] == '?' {
		result *= 6
	}
	if minute[1] == '?' {
		result *= 10
	}
	return result
}
