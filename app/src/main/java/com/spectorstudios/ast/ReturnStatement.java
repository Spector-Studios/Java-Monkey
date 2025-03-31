package com.spectorstudios.ast;

import com.spectorstudios.tokens.Token;

public class ReturnStatement implements IStatement{

  private final Token token;
  private IExpression returnValue;

  public ReturnStatement(Token token/*, IExpression returnValue*/) {
    this.token = token;
    //this.returnValue = returnValue;
  }

  @Override
  public void statementNode() {}

  @Override
  public String tokenLiteral() {return token.getLiteral();}

  @Override
  public String string() {
    StringBuilder sBuilder = new StringBuilder();

    sBuilder.append(token.getLiteral() + " ");

    if (returnValue != null) {
      sBuilder.append(returnValue.string());
    }

    sBuilder.append(";");

    return sBuilder.toString();
  }
}
