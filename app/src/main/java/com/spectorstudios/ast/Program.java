package com.spectorstudios.ast;

import java.util.ArrayList;
import java.util.List;

public class Program implements INode {

  private List<IStatement> statements;

  public Program() {
    statements = new ArrayList<IStatement>();
  }

  public List<IStatement> getStatements() {
    return statements;
  }

  public void addStatement(IStatement statement) {
    statements.add(statement);
  }

  public int getStatementsLength() {
    return statements.size();
  }

  @Override
  public String tokenLiteral() {
    if (statements.size() > 0) {
      return statements.get(0).tokenLiteral();
    } else {
      return "";
    }
  }

  @Override
  public String string() {
    StringBuilder sBuilder = new StringBuilder();
    for (IStatement statement : statements) {
      sBuilder.append(statement.string());
    }
    return sBuilder.toString();
  }
}
