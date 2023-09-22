package problems

func ValidWordSquare(words []string) bool {
	return validWordSquare(words)
}
func validWordSquare(words []string) bool {
	m := len(words)
	matrix := make([][]byte, m)
	for i, word := range words {
		if len(word) > m {
			return false
		}
		matrix[i] = make([]byte, m)
		copy(matrix[i], word)
	}
	for i := 0; i < m; i++ {
		for j := i; j < m; j++ {
			if len(matrix[j]) <= i || matrix[i][j] != matrix[j][i] {
				return false
			}
		}
	}
	return true
}
