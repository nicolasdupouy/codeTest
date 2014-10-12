package objsets

import objsets.TweetSet

object Test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(136); 

  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus");System.out.println("""google  : List[String] = """ + $show(google ));$skip(69); 
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad");System.out.println("""apple  : List[String] = """ + $show(apple ));$skip(101); 

  def filterTweet(word: String, ts: TweetSet): TweetSet =
    ts.filter(t => t.text.contains(word));System.out.println("""filterTweet: (word: String, ts: objsets.TweetSet)objsets.TweetSet""");$skip(115); 

  def filterTweets(words: List[String], ts: TweetSet) =
    ts.filter(t => words.exists(w => t.text.contains(w)));System.out.println("""filterTweets: (words: List[String], ts: objsets.TweetSet)objsets.TweetSet""");$skip(129); 

  lazy val googleTweets: TweetSet = filterTweets(google, TweetReader.allTweets);System.out.println("""googleTweets: => objsets.TweetSet""");$skip(36);  //filterTweet("android", TweetReader.allTweets)
  System.out.println(googleTweets);$skip(79); ;
  lazy val appleTweets: TweetSet = filterTweets(google, TweetReader.allTweets);System.out.println("""appleTweets: => objsets.TweetSet""");$skip(214); 

  /**
   * A list of all tweets mentioning a keyword from either apple or google,
   * sorted by the number of retweets.
   */
  lazy val trending: TweetList = (googleTweets union appleTweets).descendingByRetweet;System.out.println("""trending: => objsets.TweetList""")}

  //val googleTweets: TweetSet = filterTweets(google, TweetReader.allTweets) //filterTweet("android", TweetReader.allTweets)
  //lazy val appleTweets: TweetSet = filterTweets(google, TweetReader.allTweets)
}
