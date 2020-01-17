package ecluse2;

public class Main {
	
	public static void main(String[] args) {
		Pool pool = new Pool();
		Door a = new Door();
		Door b = new Door();
		ClosedPool lock = new ClosedPool(a, b, pool);
		
		HasShip controller = new HasShip();
		Ship ship1 = new Ship("boat1", controller, lock);
		Ship ship2 = new Ship("boat2", controller, lock);	
		
		new Thread(ship1).start();
		new Thread(ship2).start();
	}

}
