package problems

func ShiftingLetters(s string, shifts []int) string {
	return shiftingLetters(s,shifts)
}

func shiftingLetters(s string, shifts []int) string {
	chars:=[]rune(s)
	for sum,i:=0,len(shifts)-1;i>=0;i-- {
		sum=(sum+shifts[i])%26
		chars[i]='a'+(chars[i]-'a'+rune(sum))%26
	}
	return string(chars)
}