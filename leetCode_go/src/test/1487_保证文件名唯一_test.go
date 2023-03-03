package test

import (
	"src/problems"
	"testing"
)

func TestGetFolderNames(t *testing.T) {
	problems.GetFolderNames([]string{"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"})
	problems.GetFolderNames([]string{"pes", "fifa", "gta", "pes(2019)"})
	problems.GetFolderNames([]string{"gta", "gta(1)", "gta", "avalon"})
	problems.GetFolderNames([]string{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"})
	problems.GetFolderNames([]string{"wano", "wano(1)", "wano(2)", "wano(3)"})
	problems.GetFolderNames([]string{"kaido", "kaido(1)", "kaido", "kaido(1)"})
	problems.GetFolderNames([]string{"wano", "wano(1)", "wano(5)", "wano", "wano", "wano", "wano", "wano", "wano"})
}
