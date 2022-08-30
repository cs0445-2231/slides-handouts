public class Square {

  private final Integer DEFAULT_LENGTH = 10;
  private Integer sideLength; //in inches
  private Integer area;
  private Integer perimeter;

  //default constructor
  public Square(){
    this.sideLength = DEFAULT_LENGTH;
  }

  //parameterized constructor
  public Square(Integer sideLength){
    this.sideLength = sideLength;
  }
  /**
    * compute the area of the square
  **/
  public void computeArea(){
    area = sideLength * sideLength;
  }

  /**
    * compute the perimeter of the square
  **/
  public void computePerimeter(){
    perimeter = sideLength * 4;
  }

  /**
    * set the side length of the square 
    * and update area and perimeter
  **/
  public void setSideLength(Integer sideLength){
    this.sideLength = sideLength;
    computeArea();
    computePerimeter();
  }

/**
  * @return the side length of the square
**/
  public Integer getSideLength(){
    return sideLength;
  }

  /**
    * @return the area of the square
  **/
  public Integer getArea(){
    return area;
  }

  /**
    * @return the perimeter of the square
  **/
  public Integer getPerimeter(){
    return perimeter;
  }

  //Overriding toString of Object
  public String toString(){
    return "I'm a square of side length " + 
           sideLength + " inches, area " + 
           getArea() + " sq. inches and perimeter " + 
           getPerimeter() + " inches.";
  }
}
