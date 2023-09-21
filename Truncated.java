/**
 * Blocks of text truncated to a specified width.
 * 
 * @author Samuel Rebelsky - took from his Eboard
 * @author Shuta Shibue
 */
public class Truncated implements TextBlock {
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
    public Truncated(TextBlock _block, int _width) {
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
        int len = this.block.row(i).length();
        if(this.width() > len){
            return this.block.row(i) + TBUtils.spaces(width() - len);
        }
        else{
            return this.block.row(i).substring(0, this.width);
        }
    } // row(int)
}
