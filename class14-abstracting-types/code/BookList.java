

// determines whether given book should be selected
interface IBookSelector {
  public boolean select(Book b);
}

// represents a list of books
interface ILoB {
  //produces a list of books from this list satisfying the given 
  // selector criteria
  public ILoB filter(IBookSelector picker);
}

class MTLoB implements ILoB {
  MTLoB() {}

  //produces a list of books from this list satisfying the given 
  // selector criteria
  public ILoB filter(IBookSelector picker) { return this; }
}


class ConsLoB implements ILoB {
  Book first;
  ILoB rest;
  
  ConsLoB(Book first, ILoB rest) {
    this.first = first;
    this.rest = rest;
  }
  
  // produces a list of books from this list satisfying the given 
  // selector criteria
  public ILoB filter(IBookSelector picker) {
    if (picker.select(this.first)) {
      return new ConsLoB(this.first, this.rest.filter(picker));
    } else {
      return this.rest.filter(picker);
    }
  }
}