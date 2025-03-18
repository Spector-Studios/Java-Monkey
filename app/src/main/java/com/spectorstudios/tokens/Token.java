
package com.spectorstudios.tokens;

public class Token {
  private final TokenType type;
  private final String literal;

  public Token(TokenType type, String literal) {
    this.type = type;
    this.literal = literal;
  }

  public TokenType getType() {
    return type;
  }

  public String getLiteral() {
    return literal;
  }

  public static TokenType lookUpIdentifier(String identifier) { 
    return switch (identifier) {
      case "fn" -> TokenType.FUNCTION;
      case "let" -> TokenType.LET;
      case "true" -> TokenType.TRUE;
      case "false" -> TokenType.FALSE;
      case "if" -> TokenType.IF;
      case "else" -> TokenType.ELSE;
      case "return" -> TokenType.RETURN;

      default -> TokenType.IDENT;
    };
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Token)) {
      return false;
    }

    Token c = (Token) o;

    return c.getType().equals(this.getType()) && c.getLiteral().equals(this.getLiteral());
  }
}
