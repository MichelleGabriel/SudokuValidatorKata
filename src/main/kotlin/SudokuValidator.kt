fun validate(board: Array<Array<Int>>) = Board(board).isValid()

data class Board(private val values: Array<Array<Int>>) {
    fun isValid() = allBoxesValid() && allColumnsValid() && allRowsValid()
    private fun allRowsValid() = this.values.all { it.isDistinct() }
    private fun allColumnsValid() = allColumns().all { it.isDistinct() }
    private fun allBoxesValid() = allBoxes().all { it.isDistinct() }
    private fun allColumns() = (0..<this.values[0].size).map { column(it) }
    private fun allBoxes() = (0..<this.values[0].size).map { box(it) }
    private fun column(id: Int) = values.map { it[id] }.toTypedArray()
    private fun box(id: Int) = createBox(id / 3 * 3, id % 3 * 3)
    private fun createBox(startRow: Int, startColumn: Int) = (startRow..<startRow + 3)
        .map { row -> this.values[row].sliceArray(startColumn..<3).toList() }
        .flatten()
        .toTypedArray()
}

fun Array<Int>.isDistinct() = this.count() == this.distinctValidNumbers()

fun Array<Int>.distinctValidNumbers() = this
    .filter { "[1-9]".toRegex().matches(it.toString()) }
    .toSet()
    .count()