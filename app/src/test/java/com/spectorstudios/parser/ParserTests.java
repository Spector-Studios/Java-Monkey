package com.spectorstudios.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.spectorstudios.ast.IStatement;
import com.spectorstudios.ast.LetStatement;
import com.spectorstudios.ast.Program;
import com.spectorstudios.lexer.Lexer;

import org.junit.jupiter.api.Test;

class ParserTests {

  @Test void letStatementTest() {
    String input = """

    let x = 5;
    let y =10;
    let foobar = 838383;

    """;

    Lexer lexer = new Lexer(input);
    Parser parser = new Parser(lexer);

    Program program = parser.parseProgram();

    assertNotNull(program, "parseProgram() returned null");
    assertEquals(3, program.getStatementsLength(), ("Did not get 3 statements. Got: " + program.getStatementsLength()));

    List<String> expectedIdentifier = List.of("x", "y", "foobar");

    for (IStatement statement : program.getStatements()) {
      assertTrue(statement instanceof LetStatement);
    }

    List<IStatement> statements = program.getStatements();

    for (int i=0; i<3; i++) {
      String actualIdentifier = ((LetStatement)statements.get(i)).getName().getValue();
      assertEquals(statements.get(i).tokenLiteral(), "let", "Expected let tokenLiteral. Got:" + statements.get(i).tokenLiteral());
      assertEquals(actualIdentifier, expectedIdentifier.get(i), "Expected identifier:" + expectedIdentifier.get(i) + "\nGot:" + actualIdentifier);
    }
  }
}
