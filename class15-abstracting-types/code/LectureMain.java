

import tester.Tester;

public class LectureMain {
  public static void main(String[] args) {
    tester.Tester.run(new Examples());
  }
}


class Examples {
  Book oms = new Book("Old Man and the Sea", "EH", 10, 'F');
  Book eos = new Book("Elements of Style", "EBW", 20, 'N');
  Book htdp = new Book("HtDP", "MF", 60, 'T');
  Book ll = new Book("LL", "MF", 20, 'N');
  Book hobbit = new Book("The Hobbit", "JRRT", 20, 'F');
  Book twain = new Book("Autobiography", "MT", 35, 'N');
  Book toc = new Book("Theory of Computation", "MS", 120, 'T');

  ILoB mt = new MTLoB();
  ILoB allbooks =
    new ConsLoB(oms, new ConsLoB(eos, new ConsLoB(htdp, new ConsLoB(ll,
        new ConsLoB(hobbit, new ConsLoB(twain, new ConsLoB(toc, mt)))))));
  ILoB ficbooks =
    new ConsLoB(oms, new ConsLoB(hobbit, mt));
  ILoB nonficbooks = 
    new ConsLoB(eos, new ConsLoB(ll, new ConsLoB(twain, mt)));
  ILoB textbooks = 
    new ConsLoB(htdp, new ConsLoB(toc, mt));
  ILoB mfbooks =   // written by matthias felleisen
    new ConsLoB(htdp, new ConsLoB(ll, mt));
  ILoB over20 =    // sale price $20 or more
    new ConsLoB(htdp, new ConsLoB(twain, new ConsLoB(toc, mt)));
  ILoB under20 =   // sale price under $20
    new ConsLoB(oms, new ConsLoB(eos, new ConsLoB(ll, new ConsLoB(hobbit, mt))));

  Runner br = new Runner("Bill Rogers", 51, true, 26, 143);
  Runner fs = new Runner("Frank Shorter", 48, true, 26, 153);
  Runner kk = new Runner("Komo Kenyata", 25, true, 26, 131);
  Runner jb = new Runner("Joan Benoit", 51, false, 26, 165);
  Runner as = new Runner("Anne Smith", 32, false, 26, 198);

  ILoR mtlor = new MTLoR();
  ILoR allrunners = 
    new ConsLoR(br, new ConsLoR(fs, new ConsLoR(kk, new ConsLoR(jb, new ConsLoR(as, mtlor)))));

  Examples() {}

  // tests for methods of the ILoB classes
  void testListOfBooks(Tester t) {
    // selectFiction tests
    t.checkExpect(mt.filter(new FictionSelector()), mt);
    t.checkExpect(allbooks.filter(new FictionSelector()), ficbooks);
    t.checkExpect(textbooks.filter(new FictionSelector()), mt);

    // selectNonFiction tests
    t.checkExpect(mt.filter(new NonFictionSelector()), mt);
    t.checkExpect(allbooks.filter(new NonFictionSelector()), nonficbooks);
    t.checkExpect(textbooks.filter(new NonFictionSelector()), mt);

    // selectExpensive tests
    t.checkExpect(mt.filter(new ExpensiveSelector(20)), mt);
    t.checkExpect(allbooks.filter(new ExpensiveSelector(20)), over20);
    t.checkExpect(under20.filter(new ExpensiveSelector(20)), mt);
    t.checkExpect(allbooks.filter(new ExpensiveSelector(100)), new ConsLoB(toc, mt));
    t.checkExpect(allbooks.filter(new ExpensiveSelector(120)), new ConsLoB(toc, mt));
    t.checkExpect(allbooks.filter(new ExpensiveSelector(121)), mt);
    t.checkExpect(allbooks.filter(new ExpensiveSelector(1)), allbooks);

    // general filter test
    WrittenBySelector s = new WrittenBySelector("MF");  // select books by Matthias Felleisen
    t.checkExpect(mt.filter(s), mt);
    t.checkExpect(allbooks.filter(s), mfbooks);
    t.checkExpect(ficbooks.filter(s), mt);
  }

  void testListOfRunners(Tester t) {
    t.checkExpect(mtlor.filter(new Over40Selector()), mtlor);
    t.checkExpect(allrunners.filter(new Over40Selector()),
        new ConsLoR(br, new ConsLoR(fs, new ConsLoR(jb, mtlor))));
    t.checkExpect(new ConsLoR(kk, new ConsLoR(as, mtlor)).filter(new Over40Selector()),
        mtlor);
  }

}


//selects a book if it is fiction
class FictionSelector implements IBookSelector {
  public boolean select(Book b) { return b.isFiction(); }
}

//selects a book if it is non-fiction
class NonFictionSelector implements IBookSelector {
  public boolean select(Book b) { return b.isNonFiction(); }
}

//selects a book if its sale price is over a given limit
class ExpensiveSelector implements IBookSelector {
  int limit;
  public ExpensiveSelector(int limit) {
    this.limit = limit;
  }

  public boolean select(Book b) {
    return b.salePrice() >= limit; 
  }
}

//selects a book if written by given author
class WrittenBySelector implements IBookSelector {
  String author;
  public WrittenBySelector(String author) {
    this.author = author;
  }

  public boolean select(Book b) {
    return b.writtenBy(this.author);
  }
}
