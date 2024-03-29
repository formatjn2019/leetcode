package problems

import (
	"fmt"
	"strings"
)

func CandyCrush(board [][]int) [][]int {
	return candyCrush(board)
}

func candyCrush(board [][]int) [][]int {
	abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}
	m, n := len(board), len(board[0])
	erase := true
	for erase {
		erase = false
		// 横向消除
		for _, line := range board {
			for j, num := range line {
				num = abs(num)
				if num > 0 && j > 1 {
					if abs(line[j]) == abs(line[j-1]) && abs(line[j-1]) == abs(line[j-2]) {
						line[j], line[j-1], line[j-2] = -num, -num, -num
						erase = true
					}
				}
			}
		}
		// 纵向消除
		for j := 0; j < n; j++ {
			for i := 0; i < m; i++ {
				num := abs(board[i][j])
				if num > 0 && i > 1 {
					if abs(board[i][j]) == abs(board[i-1][j]) && abs(board[i-1][j]) == abs(board[i-2][j]) {
						board[i][j], board[i-1][j], board[i-2][j] = -num, -num, -num
						erase = true
					}
				}

			}
		}

		// 下落
		for r := 0; r < n; r++ {
			up, dp := m-1, m-1
			for ; up >= 0; up-- {
				board[dp][r], board[up][r] = board[up][r], board[dp][r]
				if board[dp][r] > 0 {
					dp--
				}
			}
			for ; dp >= 0; dp-- {
				board[dp][r] = 0
			}
		}

	}
	return board
}

func showArray(array [][]int) {
	fmt.Println(strings.Repeat("*", 100))
	for _, line := range array {
		fmt.Println(line)
	}
}
