package com.mybank.domain.model

import org.scalatest.FunSuite

class AccountValidationsSpec extends FunSuite with AccountValidations {

  test( "validacion cuenta vacia" ) {
    val res = checkNo( "" )
    assert( res.isLeft )
  }

  test( "validacion cuenta correcta" ) {
    val res = checkNo( "0800012001" )
    assert( res.isRight )
  }

}
