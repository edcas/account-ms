package com.mybank.domain.model

trait AccountValidations {

  // Either[E,A]
  // Modela un efecto: Presencia de Error
  // Proyecciones: Left[E], Right[A]
  // Bias: Right

  // Try[A]
  // Modela un efecto: Presencia de Excepcion
  // Proyecciones: Failure[Exception], Success[A]
  // Bias: Success

  // Option[A]
  // Modela un efecto: Ausencia de Valor
  // Proyecciones: None, Some[A]
  // Bias: Some

  def checkNo( no: String ): Either[String, String] = {
    if ( no.isEmpty ) Left( "El numero de cuenta esta vacio" )
    else Right( no )
  }

  def checkBalance( balance: BigDecimal ): Either[String, BigDecimal] = {
    if ( balance < 0 ) Left( "El balance no debe ser negativo" )
    else Right( balance )
  }

}