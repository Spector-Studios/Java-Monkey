package com.spectorstudios.ast;

import com.spectorstudios.tokens.Token;

public class LetStatement implements IStatement {
  private final Token token;
  private final Identifier name;
  private IExpression value;

  public LetStatement(final Token token, final Identifier name) {
    this.token = token;
    this.name = name;
    // this.value = value;
  }

  public Identifier getName() {
    return name;
  }

  @Override
  public void statementNode() {
  }

  @Override
  public String tokenLiteral() {
    return token.getLiteral();
  }

  @Override
  public String string() {
    StringBuilder sBuilder = new StringBuilder();

    sBuilder.append(token.getLiteral() + " ");
    sBuilder.append(name.string());

    if (value != null) {
      sBuilder.append(" = ");
      sBuilder.append(value.string());
    }

    sBuilder.append(";");

    return sBuilder.toString();
  }

}
