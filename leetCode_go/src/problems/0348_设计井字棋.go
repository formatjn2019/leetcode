package problems

type TicTacToe struct {
	chessbord     [][]int
	lineScore     []int
	rowScore      []int
	diagonalScore [2]int
	successFlag   int
	n             int
}

func Constructor(n int) TicTacToe {
	chessbord := make([][]int, n)
	for i := 0; i < n; i++ {
		chessbord[i] = make([]int, n)
	}
	return TicTacToe{chessbord: chessbord, lineScore: make([]int, n), rowScore: make([]int, n), n: n}
}

func (this *TicTacToe) Move(row int, col int, player int) int {
	if this.successFlag != 0 {
		return this.successFlag
	}
	user := player*2 - 3
	this.chessbord[col][row] += user
	this.lineScore[col] += user
	if this.lineScore[col]*user == this.n {
		this.successFlag = player
	}
	this.rowScore[row] += user
	if this.rowScore[row]*user == this.n {
		this.successFlag = player
	}
	if row == col {
		this.diagonalScore[0] += user
		if this.diagonalScore[0]*user == this.n {
			this.successFlag = player
		}
	}
	if row+col == this.n-1 {
		this.diagonalScore[1] += user
		if this.diagonalScore[1]*user == this.n {
			this.successFlag = player
		}
	}
	return this.successFlag
}
