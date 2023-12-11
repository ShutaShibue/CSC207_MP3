/**
 * Blocks of Right justified.
 * 
 * @author Samuel Rebelsky - took from his Eboard
 * @author Shuta Shibue
 */
public class RightJustified implements TextBlock {
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
    int width;

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+
    public RightJustified(TextBlock _block, int _width) {
        this.block = _block;
        this.width = _width;
    }


    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    public int width() {
        return this.width;
    } // width()

    public int height() {
        return this.block.height();
    } // height()

    public String row(int i) throws Exception {
        String content = this.block.row(i);
        if (content.length() > width())
            return content.substring(content.length() - width, content.length());

        int pad = width() - content.length();
        return TBUtils.spaces(pad) + content;
    } // row(int)
}
