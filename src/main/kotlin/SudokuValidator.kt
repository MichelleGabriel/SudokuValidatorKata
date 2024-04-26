fun validate(board: Array<Array<Int>>): Boolean {
    val allRows = board
    val allColumns = board.columns()
    val allColumnsDistinct = allColumns.isValid()
    val allRowsDistinct = allRows.isValid()

    return allRowsDistinct && allColumnsDistinct
}

private fun Array<Array<Int>>.isValid() =
    this.all { it.toSet() == (1..9).toSet()}

private fun Array<Array<Int>>.column(index: Int) =
    this.map { row -> row[index] }
        .toTypedArray()

private fun Array<Array<Int>>.columns() =
    (0..<this.first().size)
        .map { columIndex -> column(columIndex) }
        .toTypedArray()

