package scalamelb.intro

object NativeXML extends Application {

  val xhtml = <html><head><title>My page</title></head><body><h1>Hello World!</h1></body></html>
  println(xhtml \\ "title" text)
  
  val eggs = "egg" :: "egg" :: "egg" :: "egg" :: Nil
  val eggsml = <basket><eggs count={eggs.length.toString}/></basket>
  println(eggsml)

  val shoppingList =
    <list>
      <item>pancakes</item>
      <item>biscuits</item>
      <non-item>nothingness</non-item>
      <item>coffee</item>
    </list>
  
  for (item <- shoppingList \\ "item") println(item text)
  
  def random = (<random>{Math.random}</random>)
  val aNestedRandom = (<ready_for_it>{random}</ready_for_it>)
  println(aNestedRandom)

  class Listing(val id: Int, val businessName: String, val address: String, val phone: String) {
    def toXML = 
      <listing id={id.toString}>
          <businessName>{businessName}</businessName>
          <address>{address}</address>
          <phone>{phone}</phone>
      </listing>
  }

  val listings = List(
    new Listing(1, "SMXL Cafes", "411 Sturt St  Ballarat  VIC  3350", "(03) 5331 2486"),
    new Listing(4, "Queen of Hearts Cafe", "4 Jetty Rd  Glenelg  SA  5045", "(07) 4772 2243"),
    new Listing(12, "Yoyogi Japanese Cafe", "98 Albany Tce  Augusta  WA  6290", "(07) 4659 9240"),
    new Listing(99, "Cafe Nova", "869 Beaufort St  Inglewood  WA  6052", "(02) 6552 9222"),
    new Listing(1544, "Jetty Cafe", "155 Redcliffe Pde  Redcliffe  QLD  4020", "(07) 3284 2986"))

  val listingsXML = <listings>
	    {for (listing <- listings) yield listing toXML}
	  </listings>
  println(listingsXML)
  

}
