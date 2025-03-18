package com.spectorstudios.repl;

import java.util.Scanner;

import com.spectorstudios.lexer.Lexer;
import com.spectorstudios.tokens.Token;
import com.spectorstudios.tokens.TokenType;

public class Repl {

  private final String prompt = "==>";
  private final Scanner sc;

  public Repl(Scanner sc) {
    this.sc = sc;
  }

  public void start() {
    //Scanner scanner = new Scanner(System.in);
    String input;// = scanner.nextLine();

    while (true) {
      System.out.print(prompt);

      try {
        input = sc.nextLine();

        if (input.equalsIgnoreCase("exit")) {
          System.out.println("Exiting.......");
          break;
        }

        if (input != null) {
          Lexer lexer = new Lexer(input);

          for (Token tok = lexer.nextToken(); tok.getType() != TokenType.EOF; tok = lexer.nextToken()) {
            System.out.println("{" + tok.getType().name() + ", " + tok.getLiteral() + "}");
          }
        }
      } catch (Exception e) {

      }
    }

    //scanner.close();
  }
}
