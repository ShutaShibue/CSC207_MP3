/**
 * Test cases for blocks
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TextBlockTests {
    
    @Test
    public void Truncate() throws Exception{
        TextBlock hello = new TextLine("hello");
        TextBlock trunc = new Truncated(hello, 3);
        TextBlock iTooBig = new Truncated(hello, 10);
        assertEquals("hel", TBUtils.stringfy(trunc));
        assertEquals("hello     ", TBUtils.stringfy(iTooBig));
    }

    @Test
    public void Center() throws Exception{
        TextBlock hellocenter = new Centered(new BoxedBlock(new TextLine("Hello")), 21);
        TextBlock ruler = new TextLine("012345678901234567890123456789");
        TextBlock hellocenter2 = new BoxedBlock(new Centered(new TextLine("Hello"), 21));
        TextBlock Vcomp1 = new VComposition(hellocenter, ruler);
        TextBlock Vcomp2 = new VComposition(hellocenter2, ruler);
        assertEquals("       +-----+                \n" +
                     "       |Hello|                \n" +
                     "       +-----+                \n" +
                     "012345678901234567890123456789", TBUtils.stringfy(Vcomp1));

        assertEquals("+---------------------+       \n" +
                     "|        Hello        |       \n" +
                     "+---------------------+       \n" +
                     "012345678901234567890123456789", TBUtils.stringfy(Vcomp2));
    }

    @Test
    public void RightJustify() throws Exception{
        TextBlock helloright = new RightJustified(new BoxedBlock(new TextLine("Hello")), 21);
        TextBlock ruler = new TextLine("012345678901234567890123456789");
        TextBlock helloright2 = new BoxedBlock(new RightJustified(new TextLine("Hello"), 21));
        TextBlock Vcomp1 = new VComposition(helloright, ruler);
        TextBlock Vcomp2 = new VComposition(helloright2, ruler);
        assertEquals("              +-----+         \n" +
                     "              |Hello|         \n" +
                     "              +-----+         \n" +
                     "012345678901234567890123456789", TBUtils.stringfy(Vcomp1));

        assertEquals("+---------------------+       \n" +
                     "|                Hello|       \n" +
                     "+---------------------+       \n" +
                     "012345678901234567890123456789", TBUtils.stringfy(Vcomp2));
    }
    
    @Test
    public void HorizontallyFlip() throws Exception{
        TextBlock hol = new HorizontallyFlipped(new BoxedBlock(new TextLine("Hello")));
        assertEquals("+-----+\n|olleH|\n+-----+", TBUtils.stringfy(hol));
    }

    @Test
    public void VerticallyFlip() throws Exception{
        TextBlock ver = new VerticallyFlipped(new VComposition(new TextLine("Hello"), new TextLine("Goodbye")));
        assertEquals("Goodbye\nHello  ", TBUtils.stringfy(ver));
    }
    
}
