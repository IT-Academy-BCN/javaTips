package itacademy;

public enum CardinalPoints {

    // Instances must be defined first, before methods:
    WEST("The unexplored land of wild men"),
    NORTH("The frozen deserts, home of the bears"),
    EAST("The land of the rising sun"),
    SOUTH("Where metals melt");

    private String description;
    // Constructor must be package or private access:
    private CardinalPoints(String description) {
        this.description = description;
    }
    public String getDescription() { return description; }


    public static void main(String[] args) {

        for(CardinalPoints point : CardinalPoints.values())
            System.out.println(point + ": " + point.getDescription());
    }

}