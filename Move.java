class Move{
  Square start;
  Square landing;
  int points;

  public Move(Square x, Square y, int z){
    start = x;
    landing = y;
    points = z;
  }

  public Move(){

  }
  public int getPoints(){// this allows us to tell the value of a move being made
    return points;
  }
  public Square getStart(){
    return start;
  }

  public Square getLanding(){
    return landing;
  }
}
