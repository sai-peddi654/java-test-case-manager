import java.util.ArrayList;
import java.util.List;

public class Main {
    enum Status { NOT_RUN, PASS, FAIL, BLOCKED }
    static class TestCase {
        final String id;
        final String title;
        Status status = Status.NOT_RUN;
        TestCase(String id, String title) { this.id = id; this.title = title; }
    }

    public static void main(String[] args) {
        List<TestCase> suite = new ArrayList<>();
        suite.add(new TestCase("TC-001", "Valid user can sign in"));
        suite.add(new TestCase("TC-002", "Invalid password shows an error"));
        suite.add(new TestCase("TC-003", "Locked user cannot sign in"));
        suite.add(new TestCase("TC-004", "Forgot-password link opens"));

        suite.get(0).status = Status.PASS;
        suite.get(1).status = Status.PASS;
        suite.get(2).status = Status.FAIL;
        suite.get(3).status = Status.BLOCKED;

        System.out.println("=== Test Case Management CLI ===");
        suite.forEach(tc -> System.out.printf("%-7s %-40s %s%n", tc.id, tc.title, tc.status));

        long passed = suite.stream().filter(tc -> tc.status == Status.PASS).count();
        long failed = suite.stream().filter(tc -> tc.status == Status.FAIL).count();
        long blocked = suite.stream().filter(tc -> tc.status == Status.BLOCKED).count();
        System.out.printf("Summary: %d passed, %d failed, %d blocked%n", passed, failed, blocked);
    }
}
