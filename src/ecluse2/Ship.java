package ecluse2;

public class Ship implements Runnable {
	
	private HasShip has_ship;
	private ClosedPool closed_pool;
	private String myName;
	
	public Ship(String name, HasShip has_ship, ClosedPool pool) {
		closed_pool = pool;
		this.has_ship = has_ship;
		myName = name;
	}
	
	private void ask_in() {
		closed_pool.open_a();
		System.out.println(myName + " ask in, open a");
	}
	
	private void enter() {
		has_ship.fill();
		System.out.println(myName + " enter in a");
	}
	
	private void ask_out() {
		closed_pool.close_a();
		System.out.println(myName + " ask out, open b");
		closed_pool.a2b();
		System.out.println(myName + " ask out, open b");
		closed_pool.open_b();
		System.out.println(myName + " ask out, open b");
	}
	
	private void exit() {
		has_ship.empty();
		System.out.println(myName + " exit");
	}
	
	private void leave() {
		closed_pool.close_b();
		closed_pool.b2a();
		System.out.println(myName + " leave and close");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			ask_in();
			enter();
			ask_out();
			exit();
			leave();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
