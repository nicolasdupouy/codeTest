package objsets

import objsets.TweetSet

object Test {

  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
                                                  //> google  : List[String] = List(android, Android, galaxy, Galaxy, nexus, Nexus
                                                  //| )
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")
                                                  //> apple  : List[String] = List(ios, iOS, iphone, iPhone, ipad, iPad)

  def filterTweet(word: String, ts: TweetSet): TweetSet =
    ts.filter(t => t.text.contains(word))         //> filterTweet: (word: String, ts: objsets.TweetSet)objsets.TweetSet

  def filterTweets(words: List[String], ts: TweetSet) =
    ts.filter(t => words.exists(w => t.text.contains(w)))
                                                  //> filterTweets: (words: List[String], ts: objsets.TweetSet)objsets.TweetSet

  lazy val googleTweets: TweetSet = filterTweets(google, TweetReader.allTweets) //filterTweet("android", TweetReader.allTweets)
                                                  //> googleTweets: => objsets.TweetSet
  System.out.println(googleTweets);               //> objsets.NonEmpty@440149a7
  lazy val appleTweets: TweetSet = filterTweets(google, TweetReader.allTweets)
                                                  //> appleTweets: => objsets.TweetSet

  /**
   * A list of all tweets mentioning a keyword from either apple or google,
   * sorted by the number of retweets.
   */
  lazy val trending: TweetList = (googleTweets union appleTweets).descendingByRetweet
                                                  //> trending: => objsets.TweetList

  //val googleTweets: TweetSet = filterTweets(google, TweetReader.allTweets) //filterTweet("android", TweetReader.allTweets)
  //lazy val appleTweets: TweetSet = filterTweets(google, TweetReader.allTweets)
}