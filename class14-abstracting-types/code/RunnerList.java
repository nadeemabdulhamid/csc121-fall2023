

// literally copy/paste and find/replace Book -> Runner; ILoB -> ILoR

// determines whether given runner should be selected
interface IRunnerSelector {
  public boolean select(Runner r);
}

// represents a list of Runners
interface ILoR {
  //produces a list of Runners from this list satisfying the given 
  // selector criteria
  public ILoR filter(IRunnerSelector picker);
}

class MTLoR implements ILoR {
  MTLoR() {}

  //produces a list of Runners from this list satisfying the given 
  // selector criteria
  public ILoR filter(IRunnerSelector picker) { return this; }
}

class ConsLoR implements ILoR {
  Runner first;
  ILoR rest;
  
  ConsLoR(Runner first, ILoR rest) {
    this.first = first;
    this.rest = rest;
  }
  
  // produces a list of Runners from this list satisfying the given 
  // selector criteria
  public ILoR filter(IRunnerSelector picker) {
    if (picker.select(this.first)) {
      return new ConsLoR(this.first, this.rest.filter(picker));
    } else {
      return this.rest.filter(picker);
    }
  }
}



// selects runners over age 40
class Over40Selector implements IRunnerSelector {
  // is this runner over 40 years old?
  public boolean select(Runner r) {
    return r.isOver40();
  }
}
