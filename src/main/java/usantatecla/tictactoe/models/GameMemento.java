package usantatecla.tictactoe.models;

class GameMemento {

  private Turn turn;
  private Board board;

  GameMemento(Turn turn, Board board) {
    this.board = board;
    this.turn = turn;
  }

  Board getBoard() {
    return this.board;
  }

  Turn getTurn() {
    return this.turn;
  }

}
