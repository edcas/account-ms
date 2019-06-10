package com.mybank.domain.model

import org.scalatest.FunSuite

class AccountValidationsTest extends FunSuite with AccountValidations {

  test("reject empty numbers") {
    val response = checkNo("")
    assert( response.isLeft )
  }

  test("reject negative values") {
    val response = checkBalance(-1.0)
    assert( response.isLeft)
  }

}
