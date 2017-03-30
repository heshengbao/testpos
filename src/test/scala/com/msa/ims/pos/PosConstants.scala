package com.msa.ims.pos

/**
  * Created by hbao on 8/15/2016.
  */
object PosConstants {
  def ServerUrl(server: String, userType: String): String = {

    server match {
      case "QA"   => "http://vl184.msais.com:8190"
      case "prod" =>
        if (userType.equals("rsc")) {
          "https://myretailerdata.msa.com"
        } else {
          "http://bulldozer.corp.ad.msais.com/id/#/login"
        }
    }
  }
}
