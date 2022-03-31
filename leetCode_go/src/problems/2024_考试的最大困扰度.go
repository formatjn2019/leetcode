package problems


func MaxConsecutiveAnswers(answerKey string, k int) int {
	return maxConsecutiveAnswers(answerKey,k)
}

func maxConsecutiveAnswers(answerKey string, k int) int {
	chars:=[]rune(answerKey)
	result:=0
	for _,ch:=range []rune{'T','F'}{
		lp,rp:=0,0
		tCount,temp:=k,0
		for rp<len(answerKey) {
			//右指针右移
			for ;rp<len(answerKey)&&(tCount>0||chars[rp]==ch);rp++ {
				if chars[rp]!= ch{
					tCount--
				}
				temp++
			}
			//更新最大值
			if temp>result {
				result=temp
			}
			//左指针右移
			for ;tCount<1 &&lp<len(chars);lp++ {
				if chars[lp]!= ch{
					tCount++
				}
				temp--
			}
		}
	}
	return result
}