package problems

func areSentencesSimilar(sentence1 []string, sentence2 []string, similarPairs [][]string) bool {
	if len(sentence1) != len(sentence2) {
		return false
	}
	translateDic := map[string]map[string]bool{}
	for _, arr := range similarPairs {
		if _, ok := translateDic[arr[0]]; !ok {
			translateDic[arr[0]] = map[string]bool{}
		}
		translateDic[arr[0]][arr[1]] = true
	}

	for i := 0; i < len(sentence1); i++ {
		if sentence1[i] == sentence2[i] || translateDic[sentence1[i]][sentence2[i]] || translateDic[sentence2[i]][sentence1[i]] {
			continue
		}
		return false
	}
	return true
}
