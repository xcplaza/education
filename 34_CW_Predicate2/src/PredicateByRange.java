import java.util.function.Predicate;

class PredicateByRange implements Predicate<Integer> {
  private int min;
  private int max;
  
  
  
  public PredicateByRange(int min, int max) {
    super();
    this.min = min;
    this.max = max;
  }



  public int getMin() {
    return min;
  }



  public void setMin(int min) {
    this.min = min;
  }



  public int getMax() {
    return max;
  }



  public void setMax(int max) {
    this.max = max;
  }



  @Override
  public boolean test(Integer t) {
    return t>min&&t<max;
  }

}
