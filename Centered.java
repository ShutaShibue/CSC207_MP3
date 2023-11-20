/**
 * Blocks of text justified to center.
 * 
 * @author Samuel Rebelsky - took from his Eboard
 * @author Shuta Shibue
 */
public class Centered implements TextBlock {
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
    public Centered(TextBlock _block, int _width) {
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
        if(content.length() > width()) return content.substring(width/2, content.length()-width/2);
        
        int leftPad = (width() - content.length())/2;
        int rightPad = width() - content.length() - leftPad;
        return TBUtils.spaces(leftPad) + content + TBUtils.spaces(rightPad);
    } // row(int)
}
