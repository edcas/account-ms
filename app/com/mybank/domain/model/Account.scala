package com.mybank.domain.model

import java.util.Date

sealed trait Account {
  def no: String
  def balance: Double
  def openDate: Date
}

case class SavingAccount(no: String, balance: Double, openDate: Date) extends Account

case class CheckingAccount(no: String, balance: Double, openDate: Date) extends Account

object Account extends AccountValidations {

  def savingAccount(no: String, balance: Double, openDate: Option[Date]):Either[String, SavingAccount] = {
    val date: Date = openDate match {
      case Some(dt) => dt
      case None => new Date()
    }

    for {
      checkedNo <- checkNo(no)
      checkedBalance <- checkBalance(balance)
    } yield SavingAccount(checkedNo, checkedBalance, date)
  }

  def checkingAccount(no: String, balance: Double, openDate: Option[Date]):Either[String, SavingAccount] = {
    val date: Date = openDate match {
      case Some(dt) => dt
      case None => new Date()
    }

    for {
      checkedNo <- checkNo(no)
      checkedBalance <- checkBalance(balance)
    } yield SavingAccount(checkedNo, checkedBalance, date)
  }

}