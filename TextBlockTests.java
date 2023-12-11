/**
 * Test cases for blocks
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TextBlockTests {

    @Test
    public void Truncate() throws Exception {
        TextBlock hello = new TextLine("hello");
        TextBlock trunc = new Truncated(hello, 3);
        TextBlock iTooBig = new Truncated(hello, 10);
        assertEquals("hel", TBUtils.stringfy(trunc));
        assertEquals("hello     ", TBUtils.stringfy(iTooBig));
    }

    @Test
    public void TruncateZero() throws Exception {
        TextBlock hello = new TextLine(""); // empty
        TextBlock trunc = new Truncated(hello, 3);
        TextBlock withzero = new Truncated(hello, 0);
        assertEquals("   ", TBUtils.stringfy(trunc));
        assertEquals("", TBUtils.stringfy(withzero));
    }

    @Test
    public void Center() throws Exception {
        TextBlock hellocenter = new Centered(new BoxedBlock(new TextLine("Hello")), 21);
        TextBlock ruler = new TextLine("012345678901234567890123456789");
        TextBlock hellocenter2 = new BoxedBlock(new Centered(new TextLine("Hello"), 21));
        TextBlock Vcomp1 = new VComposition(hellocenter, ruler);
        TextBlock Vcomp2 = new VComposition(hellocenter2, ruler);
        assertEquals(
                "       +-----+                \n" + "       |Hello|                \n"
                        + "       +-----+                \n" + "012345678901234567890123456789",
                TBUtils.stringfy(Vcomp1));

        assertEquals(
                "+---------------------+       \n" + "|        Hello        |       \n"
                        + "+---------------------+       \n" + "012345678901234567890123456789",
                TBUtils.stringfy(Vcomp2));
    }

    @Test
    public void CenterZero() throws Exception {
        TextBlock hello = new TextLine(null);
        TextBlock center = new Centered(hello, 0);
        assertEquals("", TBUtils.stringfy(center));
    }

    @Test
    public void Centerless() throws Exception {
        TextBlock hello = new TextLine("hello");
        TextBlock center = new Centered(hello, 3);
        assertEquals("ell", TBUtils.stringfy(center));
    }

    @Test
    public void RightJustify() throws Exception {
        TextBlock helloright = new RightJustified(new BoxedBlock(new TextLine("Hello")), 21);
        TextBlock ruler = new TextLine("012345678901234567890123456789");
        TextBlock helloright2 = new BoxedBlock(new RightJustified(new TextLine("Hello"), 21));
        TextBlock Vcomp1 = new VComposition(helloright, ruler);
        TextBlock Vcomp2 = new VComposition(helloright2, ruler);
        assertEquals(
                "              +-----+         \n" + "              |Hello|         \n"
                        + "              +-----+         \n" + "012345678901234567890123456789",
                TBUtils.stringfy(Vcomp1));

        assertEquals(
                "+---------------------+       \n" + "|                Hello|       \n"
                        + "+---------------------+       \n" + "012345678901234567890123456789",
                TBUtils.stringfy(Vcomp2));
    }

    @Test
    public void RightZero() throws Exception {
        TextBlock hello = new TextLine(null);
        TextBlock right = new RightJustified(hello, 0);
        assertEquals("", TBUtils.stringfy(right));
    }

    @Test
    public void Rightless() throws Exception {
        TextBlock hello = new TextLine("hello");
        TextBlock center = new RightJustified(hello, 3);
        assertEquals("llo", TBUtils.stringfy(center));
    }

    @Test
    public void HorizontallyFlip() throws Exception {
        TextBlock hol = new HorizontallyFlipped(new BoxedBlock(new TextLine("Hello")));
        assertEquals("+-----+\n|olleH|\n+-----+", TBUtils.stringfy(hol));
    }

    @Test
    public void HorizontallyFlipWithSpace() throws Exception {
        TextBlock hol = new HorizontallyFlipped(new BoxedBlock(new TextLine("")));
        assertEquals("++\n||\n++", TBUtils.stringfy(hol));
    }

    @Test
    public void VerticallyFlip() throws Exception {
        TextBlock ver = new VerticallyFlipped(
                new VComposition(new TextLine("Hello"), new TextLine("Goodbye")));
        assertEquals("Goodbye\nHello  ", TBUtils.stringfy(ver));
    }

    @Test
    public void VerticallyFlipWithEmpty() throws Exception {
        TextBlock ver =
                new VerticallyFlipped(new VComposition(new TextLine(""), new TextLine("Goodbye")));
        assertEquals("Goodbye\n       ", TBUtils.stringfy(ver));
    }

    @Test
    public void BoxedRight() throws Exception {
        TextBlock hello = new RightJustified(new TextLine("hello"), 8);
        TextBlock boxed = new BoxedBlock(hello);

        assertEquals("+--------+", boxed.row(0));
        assertEquals("|   hello|", boxed.row(1));
        assertEquals("+--------+", boxed.row(2));
    }

    @Test
    public void Equality() throws Exception {
        TextBlock TBhello = new TextLine("hello");
        TextBlock TBhelle = new TextLine("helle");
        TextBlock TRhello = new Truncated(new TextLine("helloworld"), 5);

        assertEquals(true, TBUtils.equal(TBhello, TRhello));
        assertEquals(false, TBUtils.equal(TBhello, TBhelle));

        assertEquals(true, TBUtils.eqv(TBhello, TRhello));

        assertEquals(false, TBUtils.eq(TBhello, TRhello));
        assertEquals(true, TBUtils.eq(TBhello, TBhello));

    }

    @Test
    public void Grid() throws Exception {
        TextBlock Star = new TextLine("*");
        TextBlock gridStar = new Grid(Star, 3);
        assertEquals("***\n***\n***", TBUtils.stringfy(gridStar));

        TextBlock ab = new TextLine("ab");
        TextBlock cd = new TextLine("cd");
        TextBlock abcd = new VComposition(ab, cd);
        TextBlock abcdGrid = new Grid(abcd, 2);
        assertEquals("abab\ncdcd\nabab\ncdcd", TBUtils.stringfy(abcdGrid));
    }
}
