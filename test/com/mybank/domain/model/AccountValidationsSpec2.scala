package com.mybank.domain.model

import org.scalatest.{ FlatSpec, FunSuite, Matchers }

class AccountValidationsSpec2 extends FlatSpec with Matchers with AccountValidations {

  "Account number" should "not be empty" in {
    val res = checkNo( "" )
    assert( res.isLeft )
  }

  it should "allow a non-empty no" in {
    val res = checkNo( "11001100" )
    assert( res.isRight )
  }

  "Balance" should "not be negative" in {
    val res = checkBalance( -1 )
    assert( res.isLeft )
  }

}
