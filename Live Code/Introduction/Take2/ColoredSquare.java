public class ColoredSquare extends Square {
  //ColoredSquare is the subclass of the parent class Square
  //inheritance - subclass takes all instance variables and method defined in superclass
  //can modify these methods^ using super
  private String color;
  private final String DEFAULT_COLOR = "Gold";

  public ColoredSquare(){
    //Call to super() is implicit, sets side length
    //side length is a private field of square class, cannot define it here (See contructor below)
    this.color = DEFAULT_COLOR;
  }

  public ColoredSquare(Integer sideLength){
    super(sideLength);
    //What will happen if we call
    //this(sideLength) instead?
    //"this" invokes contructor of current class, super invokes contructor of super class
    //this would result in stack overflow exception, keep calling same method over and over

  }

  //Overloading
  public ColoredSquare(Integer sideLength, String color){
    //ILLEGAL because sideLength is private in Square
    //this.sideLength = sideLength;

    super(sideLength);//Calling the constructor of Square
    this.color = color;
  }

  public String toString(){
    return super.toString() + ". It has a " + color + " color.";
    //What will happen if we omit super?
    //It will result in a recursive call, and stack overflow error
  }

  public boolean equals(Object other){
    boolean result = false;
    if(other instanceof ColoredSquare){
      ColoredSquare cs = (ColoredSquare) other;
      result = super.equals(other) && this.color.equals(cs.color);
      //What happens if we use this.color == cs.color?
    }
    return result;
  }
}
