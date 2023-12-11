/**
 * Blocks of contents flipped horizontally.
 * 
 * @author Samuel Rebelsky - took from his Eboard
 * @author Shuta Shibue
 */
public class HorizontallyFlipped implements TextBlock {
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
    public HorizontallyFlipped(TextBlock _block) {
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
        String content = this.block.row(i);
        String reversed = "";

        for (int j = 0; j < content.length(); j++) {
            reversed = content.charAt(j) + reversed; // add next character to the front.
        }
        return reversed;
    } // row(int)
}
