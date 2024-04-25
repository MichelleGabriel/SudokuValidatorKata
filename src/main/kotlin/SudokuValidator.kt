fun validate(board: Array<Array<Int>>): Boolean {
    return !board.all { it.all { singleNumber -> singleNumber == 5 } }
}
