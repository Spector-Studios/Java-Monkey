package com.spectorstudios.ast;

import com.spectorstudios.tokens.Token;

public class Identifier implements IExpression{
  private final Token token;
  private String value;

  public Identifier(Token token, String value) {
    this.token = token;
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public void expressionNode() {}

  @Override
  public String tokenLiteral() {return token.getLiteral();}

  @Override
  public String string() {
     return value;
  }


}
