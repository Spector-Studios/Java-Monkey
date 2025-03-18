 package com.spectorstudios.parser;

import com.spectorstudios.ast.Program;
import com.spectorstudios.lexer.Lexer;
import com.spectorstudios.tokens.Token;

public class Parser {
   private final Lexer lexer;
   private Token currToken;
   private Token peekToken;

   public Parser(Lexer lexer) {
     this.lexer = lexer;
     nextTokent();
     nextTokent();
   }

   private void nextTokent() {
     currToken = peekToken;
     peekToken = lexer.nextToken();
   }

   public Program parseProgram() {
     return null;
   }
 }
