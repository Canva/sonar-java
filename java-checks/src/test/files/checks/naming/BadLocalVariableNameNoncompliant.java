import java.util.function.IntUnaryOperator;

class BadLocalVariableName {
  void method(
    int BAD_FORMAL_PARAMETER // Noncompliant {{Rename this local variable to match the regular expression '^[a-z][a-zA-Z0-9]*$'.}}
//      ^^^^^^^^^^^^^^^^^^^^
  ) {
    int BAD; // Noncompliant
    int good;

    for (int I = 0; I < 10; I++) {
      int D; // Noncompliant
    }

    for (good = 0; good < 10; good++) {
    }

    try (Closeable BAD_RESOURCE = open()) { // Noncompliant
    } catch (IOException BAD_EXCEPTION) { // Noncompliant
    } catch (IllegalStateException E) { // compliant
    } catch (Exception EX) { // Noncompliant
    }
  }

  Object FIELD_SHOULD_NOT_BE_CHECKED = new Object(){
    {
      int BAD; // Noncompliant
    }
  };

  void forEachMethod() {
    int MY_CONSTANT_IS_NOT_A_CONSTANT = 21; // Noncompliant
    final int MY_LOCAL_CONSTANT = 42; // Compliant
    final String MY_OTHER_LOCAL_CONSTANT = "42"; // Compliant
    final Integer MY_ALTERNATE_CONSTANT = Integer.valueOf(42); // Compliant
    for (byte C : "".getBytes()) {
      int D; // Noncompliant
    }
  }

  void foo() {
    IntUnaryOperator f1 = (int _) -> 0; // Compliant, unnamed variable
    IntUnaryOperator f2 = _ -> 0; // Compliant, unnamed variable
  }
}
