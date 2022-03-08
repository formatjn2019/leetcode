package problems

import (
	"fmt"
)

func PlatesBetweenCandles(s string, queries [][]int) []int {
	return platesBetweenCandles(s, queries)
}

func PlatesBetweenCandlesTest(s string, queries [][]int) bool {
	candles1 := platesBetweenCandles(s, queries)
	candles2 := platesBetweenCandles_enum(s, queries)
	if fmt.Sprintf("%v", candles1) != fmt.Sprintf("%v", candles2) {
		for i := 0; i < len(queries); i++ {
			if candles1[i] != candles2[i] {
				fmt.Println(candles1[i], candles2[i])
				fmt.Println(queries[i])
				fmt.Println(s[queries[i][0] : queries[i][1]+1])
			}
		}
		return false
	}
	return true
}

func platesBetweenCandles(s string, queries [][]int) []int {
	pre, count := -1, 0
	skipl := make([]int, len(s))
	skipr := make([]int, len(s))
	chars := []rune(s)
	for i, c := range chars {
		//蜡烛
		if c == '|' {
			pre = i
			skipl[i] = count
		} else {
			//盘子
			if pre >= 0 {
				count++
			}
			skipl[i] = pre
		}
	}
	//倒序判定
	pre = -1
	for i := len(s) - 1; i >= 0; i-- {
		//蜡烛
		if chars[i] == '|' {
			pre = i
			skipr[i] = skipl[i]
		} else {
			//盘子
			if pre <= 0 {
				skipr[i] = -1
			}
			skipr[i] = pre
		}
	}

	result := make([]int, len(queries))
	countl, countr := 100000, -100000
	for i, arr := range queries {
		l, r := arr[0], arr[1]
		if chars[l] == '|' {
			countl = skipr[l]
		} else {
			if skipr[l] >= 0 {
				countl = skipl[skipr[l]]
			}
		}
		if chars[r] == '|' {
			countr = skipl[r]
		} else {
			if skipl[r] >= 0 {
				countr = skipr[skipl[r]]
			}
		}
		if countr-countl > 0 {
			result[i] = countr - countl
		}
	}
	return result
}

func platesBetweenCandles_enum(s string, queries [][]int) []int {
	result := make([]int, len(queries))
	for index, arr := range queries {
		result[index] = countPlate(s, arr[0], arr[1]+1)
	}
	return result
}

func countPlate(s string, start, end int) (result int) {
	pre := false
	preCount := 0
	for _, c := range []rune(s[start:end]) {
		if pre {
			if c == '*' {
				preCount++
			} else {
				result += preCount
				preCount = 0
			}
		} else if c == '|' {
			pre = true
		}
	}
	return result
}
