
import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * This is lab code shared by Joshua Delarosa because I was absent at the lab class. Modified by Shuta Shibue.
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use

    TextBlock hellocenter = new RightJustified(new BoxedBlock(new TextLine("Hello")), 21);
    TextBlock ruler = new TextLine("012345678901234567890123456789");
    TextBlock hellocenter2 = new BoxedBlock(new RightJustified(new TextLine("Hello"), 21));
    TextBlock olleh = new VComposition(hellocenter, ruler);
    TextBlock olleh2 = new VComposition(hellocenter2, ruler);

    TBUtils.print(pen, olleh);
    TBUtils.print(pen, olleh2);


    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
