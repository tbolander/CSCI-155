/**
 * File: Branch.java
 * Description: The branch name should be printed on the account summary.
 * Date: 11/20/26
 * @author Tyler Bolander
 */

public class Branch {
    private String name;

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
