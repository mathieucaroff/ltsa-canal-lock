package ecluse2;

public class Ship implements Runnable {
	
	private HasShip has_ship;
	private ClosedPool closed_pool;
	
	public Ship(HasShip has_ship, ClosedPool pool) {
		closed_pool = pool;
		this.has_ship = has_ship;
	}
	
	private void ask_in() {
		closed_pool.open_a();
	}
	
	private void enter() {
		has_ship.fill();
		closed_pool.open_a();
	}
	
	private void ask_out() {
		closed_pool.open_b();
	}
	
	private void exit() {
		has_ship.fill();
		closed_pool.open_a();
	}
	
	private void leave() {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ask_in();
		enter();
		ask_out();
		exit();
		leave();
	}
}
