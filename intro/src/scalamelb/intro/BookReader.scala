package scalamelb.intro

class Book(val title: String, val isbn: String)

class Reader(name: String) {
  var bookTitlesRead = 0
  def readBookTitle(book: Book) = {
    bookTitlesRead += 1
    println(name + " reads the book title. That makes " + bookTitlesRead + " of them")
    book.title
  }
  def readBookISBN(book: Book) = {
    println(name + " reads the book isbn")
    book.isbn
  }
}




object BookReader extends Application {
  
  val hermoine = new Reader("Hermoine")
  val ronald = new Reader("Ron")
  val textbook = new Book("Potions for Novices", "978-0131495050")
  val sportsbook = new Book("Quidditch Through the Ages", "922-0746335241")
  
  def getBookAttribute(f: (Book) => String, book: Book) = "The attribute is " + f(book)
  
  println(getBookAttribute(ronald.readBookTitle, sportsbook))
  println(getBookAttribute(hermoine.readBookTitle, textbook))
  println(getBookAttribute(hermoine.readBookISBN, textbook))
  
  println(getBookAttribute((book: Book) => book.title.reverse, textbook))
}
