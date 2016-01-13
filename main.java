import lib.Glyph;

public class Main {

  static void expect(boolean reality, boolean expectation) {
    if (reality != expectation) {
      System.out.format("[FAIL] expect %b while getting %b.\n", expectation, reality);
    }
    else {
      System.out.format("[PASS]\n");
    }
  }

  public static void main (String[] args) {

    expect(new Glyph("test/fixtures/line.ascii").isClosure(), false);
    expect(new Glyph("test/fixtures/rect.ascii").isClosure(), true);
    expect(new Glyph("test/fixtures/triangle.ascii").isClosure(), true);
    expect(new Glyph("test/fixtures/dog.ascii").isClosure(), true);
  }
}
