package com.msa.ims.pos.pages

import com.msa.ims.pos.PosConstants

/**
  * Created by hbao on 8/16/2016.
  */
object Url {
  var url: String = ""

  def getUrl(server: String, user: String): String = {
    if (url == "") {
      url = PosConstants.ServerUrl(server, user)
    }
    url
  }
}
