package problems

func isWinner(player1 []int, player2 []int) int {
	sum := func(player []int) int {
		sum, pre := 0, -3
		for i, num := range player {
			if i-pre < 3 {
				sum += num * 2
			} else {
				sum += num
			}
			if num == 10 {
				pre = i
			}
		}
		return sum
	}
	if dif := sum(player1) - sum(player2); dif > 0 {
		return 1
	} else if dif < 0 {
		return 2
	} else {
		return dif
	}
}
