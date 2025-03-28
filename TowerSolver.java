// TowerSolver.java
public class TowerSolver {

    private TowerModel model;

    public TowerSolver() {
        // Nothing to do here
    }

    // Solve the Tower of Hanoi puzzle using recursion
    public void solve(TowerModel model) {
        this.model = model;
        solveRecursive(model.height(), 0, 2, 1); // Initial call to solve with source=0, destination=2, and auxiliary=1
    }

    // Recursive method to solve the Tower of Hanoi puzzle
    private void solveRecursive(int n, int source, int destination, int auxiliary) {
        if (n == 1) {
            // Base case: Move a single disk from source to destination
            model.move(source, destination);
        } else {
            // Move n-1 disks from source to auxiliary
            solveRecursive(n - 1, source, auxiliary, destination);
            
            // Move the nth disk from source to destination
            model.move(source, destination);

            // Move n-1 disks from auxiliary to destination
            solveRecursive(n - 1, auxiliary, destination, source);
        }
    }
}
