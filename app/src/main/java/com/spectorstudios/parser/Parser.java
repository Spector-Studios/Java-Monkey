package com.spectorstudios.parser;

import java.util.ArrayList;
import java.util.List;

import com.spectorstudios.ast.IExpression;
import com.spectorstudios.ast.IStatement;
import com.spectorstudios.ast.Identifier;
import com.spectorstudios.ast.LetStatement;
import com.spectorstudios.ast.Program;
import com.spectorstudios.ast.ReturnStatement;
import com.spectorstudios.lexer.Lexer;
import com.spectorstudios.tokens.Token;
import com.spectorstudios.tokens.TokenType;

public class Parser {
  private final Lexer lexer;
  private Token currToken;
  private Token peekToken;
  private final List<String> errors;

  public Parser(final Lexer lexer) {
    this.lexer = lexer;
    this.errors = new ArrayList<String>();
    nextToken();
    nextToken();
  }

  public List<String> getErrors() {
    return errors;
  }

  public Program parseProgram() {
    final Program program = new Program();

    while (!currTokenIs(TokenType.EOF)) {
      final IStatement statement = parseStatement();
      if (statement != null) {
        program.addStatement(statement);
      }

      nextToken();
    }

    return program;
  }

  private void nextToken() {
    currToken = peekToken;
    peekToken = lexer.nextToken();
  }

  private boolean currTokenIs(final TokenType type) {
    return currToken.getType() == type;
  }

  private boolean peekTokenIs(final TokenType type) {
    return peekToken.getType() == type;
  }

  private boolean expectPeekAndNext(final TokenType type) {
    if (peekTokenIs(type)) {
      nextToken();
      return true;
    } else {
      peekError(type);
      return false;
    }
  }

  private IStatement parseStatement() {
    switch (currToken.getType()) {
      case TokenType.LET:
        return parseLetStatement();
      case TokenType.RETURN:
        return parseReturnStatement();

      default:
        return null;
    }
  }

  private LetStatement parseLetStatement() {
    final Token token = currToken;

    if (!expectPeekAndNext(TokenType.IDENT)) {
      return null;
    }

    final Identifier name = new Identifier(currToken, currToken.getLiteral());

    if (!expectPeekAndNext(TokenType.ASSIGN)) {
      return null;
    }

    // TODO parse expression

    while (!currTokenIs(TokenType.SEMICOLON)) {
      nextToken();
    }

    return new LetStatement(token, name);
  }

  private ReturnStatement parseReturnStatement() {
    final Token token = currToken;

    // TODO parse expression
    nextToken();

    while (!currTokenIs(TokenType.SEMICOLON)) {
      nextToken();
    }

    return new ReturnStatement(token);
  }

  private IExpression parsePrefixExpression() {
    return null;
  }

  private IExpression parseInfixExpression(final IExpression expression) {
    return null;
  }

  // ERROR HANDLING

  private void peekError(final TokenType type) {
    errors.add("Expected TokenType:" + type.toString() + " ==> Got:" + peekToken.getType().toString());
  }
}
