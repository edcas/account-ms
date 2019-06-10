package com.mybank.domain.model

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class AccountValidationsSpec extends FlatSpec with Matchers with AccountValidations {

  behavior of "accountNo validation"

  it should "reject empty numbers" in {
    val response = checkNo("")
    response.isLeft shouldBe true
  }

  it should "accept non-empty numbers" in {
    val response = checkNo("0000000001")
    response.isRight shouldBe true
  }

  behavior of "balance validation"

  it should "reject negative values" in {
    val response = checkBalance(-1.0)
    response.isLeft shouldBe true
  }

}
