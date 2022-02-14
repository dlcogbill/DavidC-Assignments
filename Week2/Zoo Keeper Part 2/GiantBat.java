public class GiantBat extends Mammal{

    //Create a Bat class that can fly(), eatHumans(), and attackTown() and has a default energy level of 300
    public GiantBat() {
        this.energyLevel = 300;
    }
    public void fly() {
        System.out.println("Whoosh!");
        System.out.println("The Giant Bat has spread its monstrous wings and taken flight");
        this.energyLevel -= 50;
    }

    public void eatHumans(String name) {
        System.out.println("The Giant Bat has eaten " + name + ".");
        this.energyLevel += 25;
    }

    public void attackTown(String name) {
        System.out.println("Crash!");
        System.out.println("The Giant Bat has attacked " + name + ".");
        this.energyLevel -= 100;
    }
}
