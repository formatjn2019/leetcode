package test

import (
	"src/problems"
	"testing"
)

func TestDistMoney(t *testing.T) {
	problems.DistMoney(11, 3)
	problems.DistMoney(16, 2)
	problems.DistMoney(13, 3)
	problems.DistMoney(1, 2)
	problems.DistMoney(16, 2)
}
