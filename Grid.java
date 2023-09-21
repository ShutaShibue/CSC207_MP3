/**
 * Blocks of text matrix of given size.
 * 
 * @author Shuta Shibue
 */
public class Grid implements TextBlock {
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The block we are truncating.
     */
    TextBlock block;

    /**
     * The width of the truncated block.
     */
    int size;

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+
    public Grid(TextBlock _block, int _size) {
        this.block = _block;
        this.size = _size;
    }


    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    public int width() {
        return this.block.width() * size;
    } // width()

    public int height() {
        return this.block.height() * size;
    } // height()

    public String row(int i) throws Exception {
        int index = i % this.block.height();

        String content = "";
        for (int j = 0; j < size; j++) {
            content += this.block.row(index);
        }
        return content;
    } // row(int)
}
