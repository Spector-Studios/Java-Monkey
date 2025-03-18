package com.spectorstudios.ast;

import com.spectorstudios.tokens.Token;

public class LetStatement implements IStatement{
  private final Token token;
  private final Identifier name;
  private final IExpression value;

  public LetStatement(Token token, Identifier name, IExpression value) {
    this.token = token;
    this.name = name;
    this.value = value;
  }

  public Identifier getName() {
    return name;
  }

  @Override
  public void statementNode() {}

  @Override
  public String tokenLiteral() {return token.getLiteral();}
  
}
