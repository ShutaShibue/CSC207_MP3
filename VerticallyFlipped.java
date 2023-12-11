/**
 * vertically *
 * 
 * @author Samuel Rebelsky - took from his Eboard
 * @author Shuta Shibue
 */
public class VerticallyFlipped implements TextBlock {
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The block we are truncating.
     */
    TextBlock block;


    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+
    public VerticallyFlipped(TextBlock _block) {
        this.block = _block;
    }


    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    public int width() {
        return this.block.width();
    } // width()

    public int height() {
        return this.block.height();
    } // height()

    public String row(int i) throws Exception {
        return this.block.row(this.block.height() - i - 1);
    } // row(int)
}
