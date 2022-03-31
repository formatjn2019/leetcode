package problems


func WinnerOfGame(colors string) bool {
	return winnerOfGame(colors)
}

func winnerOfGame(colors string) bool {
	charCount:=[2]int{}
	for i:=1;i<len(colors)-1;i++ {
		preChar,proChar,char:=colors[i-1],colors[i+1],colors[i]
		if preChar ==proChar && proChar  == char {
			charCount[char-'A']++
		}
	}
	return charCount[0]>charCount[1]
}