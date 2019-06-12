package com.mybank.domain.model

import java.util.Date

sealed trait Account {
  def no: String
  def balance: BigDecimal
  def openDate: Date
}

case class SavingAccount( no: String, balance: BigDecimal, openDate: Date, rate: BigDecimal ) extends Account

case class CheckingAccount( no: String, balance: BigDecimal, openDate: Date ) extends Account

object Account extends AccountValidations {

  val today = new Date()

  def savingAccount( no: String, balance: BigDecimal, openDate: Option[Date], rate: BigDecimal ): Either[String, SavingAccount] = {

    val date: Date = openDate match {
      case Some( dt ) => dt
      case None       => today
    }

    //for-comprehension
    val result: Either[String, SavingAccount] = for {
      checkedNo <- checkNo( no )
      checkedBalance <- checkBalance( balance )
      checkedRate <- checkBalance( rate )
    } yield SavingAccount( checkedNo, checkedBalance, date, checkedRate )

    result

  }

}
