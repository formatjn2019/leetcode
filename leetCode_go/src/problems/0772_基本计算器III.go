package problems

import (
	"strconv"
)

func Calculate(s string) int {
	return calculate(s)
}

func calculate(s string) int {
	query := make([]string, 0)
	stack := make([]byte, 0)
	for i := 0; i < len(s); i++ {
		c := s[i]
		switch c {
		case '(':
			stack = append(stack, '(')
		case ')':
			for stack[len(stack)-1] != '(' {
				query = append(query, string(stack[len(stack)-1]))
				stack = stack[:len(stack)-1]
			}
			stack = stack[:len(stack)-1]
		case '+', '-':
			for len(stack) > 0 && stack[len(stack)-1] != '(' {
				query = append(query, string(stack[len(stack)-1]))
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, c)
		case '*', '/':
			for len(stack) > 0 && (stack[len(stack)-1] == '*' || stack[len(stack)-1] == '/') {
				query = append(query, string(stack[len(stack)-1]))
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, c)
		default:
			// 解析数字
			j := i + 1
			for j < len(s) && (rune(s[j])-'0' >= 0 && rune(s[j])-'0' <= 9) {
				j++
			}
			query = append(query, s[i:j])
			i = j - 1
		}
	}
	for len(stack) > 0 {
		query = append(query, string(stack[len(stack)-1]))
		stack = stack[:len(stack)-1]
	}
	numStack := make([]int, 0)
	for _, item := range query {
		switch item {
		case "+":
			numStack[len(numStack)-2] += numStack[len(numStack)-1]
			numStack = numStack[:len(numStack)-1]
		case "-":
			numStack[len(numStack)-2] -= numStack[len(numStack)-1]
			numStack = numStack[:len(numStack)-1]
		case "*":
			numStack[len(numStack)-2] *= numStack[len(numStack)-1]
			numStack = numStack[:len(numStack)-1]
		case "/":
			numStack[len(numStack)-2] /= numStack[len(numStack)-1]
			numStack = numStack[:len(numStack)-1]
		default:
			num, _ := strconv.Atoi(item)
			numStack = append(numStack, num)
		}
	}
	return numStack[0]
}
