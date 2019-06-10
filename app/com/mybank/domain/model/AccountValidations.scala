package com.mybank.domain.model

trait AccountValidations {

  def checkNo(no: String):Either[String, String] = {
    if (no.isEmpty) Left("El número de cuenta esta vacío")
    else Right(no)
  }

  def checkBalance(balance: Double):Either[String, Double] = {
    if (balance < 0) Left("El balance no debe ser negativo")
    else Right(balance)
  }

}
