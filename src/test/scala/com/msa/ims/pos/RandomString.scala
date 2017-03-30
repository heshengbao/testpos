package com.msa.ims.pos

/**
  * Create random string of specified length
  */
object RandomString {

  //random alpha
  def randomAlpha(length: Int): String = {
    val chars = 'a' to 'z'
    randomStringFromCharList(length, chars)
  }

  // used by #6 and #7
  def randomStringFromCharList(length: Int, chars: Seq[Char]): String = {
    val sb = new StringBuilder
    for (i <- 1 to length) {
      val randomNum = util.Random.nextInt(chars.length)
      sb.append(chars(randomNum))
    }
    sb.toString
  }
}
