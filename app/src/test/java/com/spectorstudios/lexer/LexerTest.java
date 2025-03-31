package com.spectorstudios.lexer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.spectorstudios.tokens.TokenType;
import com.spectorstudios.tokens.Token;

public class LexerTest {

  @Test void SingleTokenTest() {
    String input = "let";

    Token token = new Token(TokenType.LET, "let");
    
    Lexer lexer = new Lexer(input);
    Token actual = lexer.nextToken();
    
    //System.out.println(actual.getType().toString());
    //System.out.println(actual.getLiteral());
    assertNotNull(actual);
    assertEquals(token.getType(), actual.getType());
    assertEquals(token.getLiteral(), actual.getLiteral());
    assertEquals(token, actual);
  }

  @Test void NextTokenTest() {
    String input = """

    let five = 5;
    let ten = 10;

    let add = fn(x, y){
      x + y;
    }

    let result = add(five, ten);
    +/-*5;
    let false_x = true;
    if (else) {
    return true_false = false;
    }
    23 <x> -583
    x == y
    43 != 76
    """;

    List<Token> tokens = List.of(
      new Token(TokenType.LET, "let"),
      new Token(TokenType.IDENT, "five"),
      new Token(TokenType.ASSIGN, "="),
      new Token(TokenType.INT, "5"),
      new Token(TokenType.SEMICOLON, ";"),
      new Token(TokenType.LET, "let"),
      new Token(TokenType.IDENT, "ten"),
      new Token(TokenType.ASSIGN, "="),
      new Token(TokenType.INT, "10"),
      new Token(TokenType.SEMICOLON, ";"),
      new Token(TokenType.LET, "let"),
      new Token(TokenType.IDENT, "add"),
      new Token(TokenType.ASSIGN, "="),
      new Token(TokenType.FUNCTION, "fn"),
      new Token(TokenType.LPAREN, "("),
      new Token(TokenType.IDENT, "x"),
      new Token(TokenType.COMMA, ","),
      new Token(TokenType.IDENT, "y"),
      new Token(TokenType.RPAREN, ")"),
      new Token(TokenType.LBRACE, "{"),
      new Token(TokenType.IDENT, "x"),
      new Token(TokenType.PLUS, "+"),
      new Token(TokenType.IDENT, "y"),
      new Token(TokenType.SEMICOLON, ";"),
      new Token(TokenType.RBRACE, "}"),
      new Token(TokenType.LET, "let"),
      new Token(TokenType.IDENT, "result"),
      new Token(TokenType.ASSIGN, "="),
      new Token(TokenType.IDENT, "add"),
      new Token(TokenType.LPAREN, "("),
      new Token(TokenType.IDENT, "five"),
      new Token(TokenType.COMMA, ","),
      new Token(TokenType.IDENT, "ten"),
      new Token(TokenType.RPAREN, ")"),
      new Token(TokenType.SEMICOLON, ";"), //Here
      new Token(TokenType.PLUS, "+"),
      new Token(TokenType.SLASH, "/"),
      new Token(TokenType.MINUS, "-"),
      new Token(TokenType.ASTERISK, "*"),
      new Token(TokenType.INT, "5"),
      new Token(TokenType.SEMICOLON, ";"),
      new Token(TokenType.LET, "let"),
      new Token(TokenType.IDENT, "false_x"),
      new Token(TokenType.ASSIGN, "="),
      new Token(TokenType.TRUE, "true"),
      new Token(TokenType.SEMICOLON, ";"),
      new Token(TokenType.IF, "if"),
      new Token(TokenType.LPAREN, "("),
      new Token(TokenType.ELSE, "else"),
      new Token(TokenType.RPAREN, ")"),
      new Token(TokenType.LBRACE, "{"),
      new Token(TokenType.RETURN, "return"),
      new Token(TokenType.IDENT, "true_false"),
      new Token(TokenType.ASSIGN, "="),
      new Token(TokenType.FALSE, "false"),
      new Token(TokenType.SEMICOLON, ";"),
      new Token(TokenType.RBRACE, "}"),
      new Token(TokenType.INT, "23"),
      new Token(TokenType.LT, "<"),
      new Token(TokenType.IDENT, "x"),
      new Token(TokenType.GT, ">"),
      new Token(TokenType.MINUS, "-"),
      new Token(TokenType.INT, "583"),
      new Token(TokenType.IDENT, "x"),
      new Token(TokenType.EQ, "=="),
      new Token(TokenType.IDENT, "y"),
      new Token(TokenType.INT, "43"),
      new Token(TokenType.NOT_EQ, "!="),
      new Token(TokenType.INT, "76"),
      new Token(TokenType.EOF, "")
    );

    Lexer lexer = new Lexer(input);
    IntStream.range(0, tokens.size()).forEach(i -> assertEquals(tokens.get(i), lexer.nextToken()));
  }
}
