fun validate(board: Array<Array<Int>>): Boolean {
    val allRows = board
    val allColumns = board.columns()
    val allColumnsDistinct = allColumns.isDistinct()
    val allRowsDistinct = allRows.isDistinct()

    return allRowsDistinct && allColumnsDistinct
}

private fun Array<Array<Int>>.isDistinct() =
    this.all { it.toSet() == (1..9).toSet()}

private fun Array<Array<Int>>.column(index: Int) =
    this.map { row -> row[index] }
        .toTypedArray()

private fun Array<Array<Int>>.columns() =
    (0..<this.first().size)
        .map { columIndex -> column(columIndex) }
        .toTypedArray()

