// TowerModel.java
public class TowerModel {

    private IntegerStack[] towers;
    private int towerHeight;
    private int printCounter = 0;
    private int moveCounter = 0;

    public TowerModel(int height) {
        towerHeight = height;
        towers = new IntegerStack[3];
        towers[0] = new IntegerStack(height);
        towers[1] = new IntegerStack(height);
        towers[2] = new IntegerStack(height);

        // Initialize the first tower with disks in descending order
        for (int i = 0; i < height; i++) {
            towers[0].push(height - i);
        }
    }

    // Get the height (number of disks)
    public int height() {
        return towerHeight;
    }

    // Move one disk from the source stack to the destination stack.
    public void move(int source, int destination) {
        System.out.println("Move #" + ++moveCounter + " from " + source + " to " + destination);

        // Check if the move is valid: a larger disk cannot be placed on a smaller one.
        if (towers[destination].peek() == 0 || towers[source].peek() < towers[destination].peek()) {
            int disk = towers[source].pop();  // Pop the top disk from the source tower
            towers[destination].push(disk);  // Push it onto the destination tower
        } else {
            System.out.println("Invalid move: Cannot place a larger disk on a smaller one.");
        }

        print();  // Print the updated state of the towers
    }

    // Helper method to print the state of the towers
    public void print() {
        System.out.print("Print #" + ++printCounter + " Towers of Hanoi\n");

        // Print the tower state from the top to the bottom
        for (int layer = towerHeight - 1; layer >= 0; layer--) {
            System.out.print("\n");
            for (int tower = 0; tower < towers.length; tower++) {
                int value = towers[tower].get(layer);
                if (value == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(" " + value);
                }
            }
        }
        System.out.println();
        for (int i = 0; i < towers.length; i++) {
            System.out.print(" =");
        }
        System.out.println();
    }

    // Accessor method to get the towers array
    public IntegerStack[] getTowers() {
        return towers;
    }

    // Accessor method to get the tower height
    public int getHeight() {
        return towerHeight;
    }
}
