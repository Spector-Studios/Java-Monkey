package com.spectorstudios.ast;

import com.spectorstudios.tokens.Token;

public class ExpressionStatement implements IStatement {
  private final Token token;
  private final IExpression expression;

  public ExpressionStatement(Token token, IExpression expression) {
    this.token = token;
    this.expression = expression;
  }

  @Override
  public String tokenLiteral() {
    return token.getLiteral();
  }

  @Override
  public void statementNode() {
  }

  @Override
  public String string() {
    if (expression != null) {
      return expression.string();
    }
    return "";
  }
}
