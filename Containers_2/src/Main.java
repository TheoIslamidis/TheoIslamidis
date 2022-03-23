import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Ship s1 = new Ship("Copacabana",3);
		Ship s2 = new Ship("Hercules",100);
		Ship s3 = new Ship("Zeus",80);
		Ship s4 = new Ship("Olympus",120);
		Ship s5 = new Ship("Tinos",140);
		
		ArrayList<Ship> ships = new ArrayList<>();
		ships.add(s1);
		ships.add(s2);
		ships.add(s3);
		ships.add(s4);
		ships.add(s5);
		
		new ContainerFrame(ships);
	}

}
