package problems

import "fmt"

func getHint(secret string, guess string) string {
	secretCount := [10]int{}
	guessCount := [10]int{}
	guessArr := []rune(guess)
	var succeed int
	for i, n := range secret {
		if guessArr[i] == n {
			succeed++
		} else {
			secretCount[n-'0']++
			guessCount[guessArr[i]-'0']++
		}
	}
	var difCount int

	for i, c := range secretCount {
		if c > guessCount[i] {
			difCount += guessCount[i]
		} else {
			difCount += c
		}
	}
	return fmt.Sprintf("%dA%dB", succeed, difCount)
}
