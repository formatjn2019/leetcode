package problems

func LongestWord(words []string) string {
	return longestWord(words)
}

func longestWord(words []string) string {
	hashMap:=map[string]bool{}
	for _,word:=range words{
		hashMap[word]=true
	}
	result:=""
	for _,word:=range words{

		if len(result)<=len(word) {
			for tempWord:=word;len(tempWord)>1; {
				tempWord=tempWord[:len(tempWord)-1]
				if _,ok:=hashMap[tempWord];!ok {
					goto outter
				}
			}
			//字典序比较
			if len(word)==len(result) {
				for i:=0;i<len(word);i++ {
					if word[i]>result[i] {
						goto outter
					}else if word[i]<result[i] {
						break
					}
				}
			}
			result=word
		}
	outter:
	}
	return result
}