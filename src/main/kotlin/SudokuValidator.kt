fun validate(board: Array<Array<Int>>): Boolean {
    return board
        .all { row -> row.size == row.distinct().size}
}
