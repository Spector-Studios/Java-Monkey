
/*
 * This source file was generated by the Gradle 'init' task 
 */

package com.spectorstudios;

public class Token {

  //Special
  public static final String ILLEGAL = "ILLEGAL";
  public static final String EOF = "EOF";

  //Identifiers and numberrs
  public static final String IDENT = "IDENT";
  public static final String INT = "INT";

  //Operators
  public static final String ASSIGN = "=";
  public static final String PLUS = "+";
  
  //Delimiters
  public static final String COMMA = ",";
  public static final String SEMICOLON = ":";

  public static final String LPAREN = "(";
  public static final String RPAREN = ")";

  public static final String LBRACE = "{";
  public static final String RBRACE = "}";

  //Keywords
  public static final String FUNCTION = "FUNCTION";
  public static final String Let = "LET";



  public String TokenType;
  public String Literal;

  Token(String TokenType, String Literal){
    this.TokenType = TokenType;
    this.Literal = Literal;
  }















}
