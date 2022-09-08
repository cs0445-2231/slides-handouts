public class Square {

  private final Integer DEFAULT_LENGTH = 10;
    //Final ints = constants
    //final can modify an instance variable (this example)
    //final can modify a method,
    //final can modify a class (class can't be subclassed)
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
    //sidelength = sidelength will not change anything
    //this.sidelength points to object you are working on (current instance variable you are constructing)
  }
  /**
    * compute the area of the square - these three methods are "mutator methods "
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
    * @return the area of the square - getter
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
}
