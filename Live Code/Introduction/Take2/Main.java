public class Main {
  public static void main(String[] args){
    ColoredSquare aColoredSquare = new ColoredSquare(20, "Blue");
    aColoredSquare = new ColoredSquare(30, "Gold"); //What happens to the previous object?

    //OK because ColoredSquare is a Square
    Square aSquare = new ColoredSquare(15, "Green");
    
    //ILLEGAL because Square is not ColoredSquare
    //ColoredSquare aColoredSquare = new Square(10);

    System.out.println(aColoredSquare); //Which toString is called?

    System.out.println(aSquare); //Which toString is called?

    //Let's create an array of Squares
  }
}
