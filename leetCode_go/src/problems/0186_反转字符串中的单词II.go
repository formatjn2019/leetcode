package problems

func reverseWords(s []byte) {
	for i := 0; i < len(s)/2; i++ {
		s[i], s[len(s)-1-i] = s[len(s)-1-i], s[i]
	}
	for start, end := 0, 0; start < len(s); start = end + 1 {
		for end = start; end < len(s) && s[end] != ' '; end++ {
		}
		for lp, rp := start, end-1; lp < rp; lp, rp = lp+1, rp-1 {
			s[lp], s[rp] = s[rp], s[lp]
		}
	}
}
