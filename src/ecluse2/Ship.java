package ecluse2;

public class Ship implements Runnable {
	
	private HasShip has_ship;
	private ClosedPool closed_pool;
	private String myName;
	
	/* true if a to b, false if b to a */
	private boolean a2b = true;
	
	public Ship(String name, HasShip has_ship, ClosedPool pool, boolean a2b) {
		closed_pool = pool;
		this.has_ship = has_ship;
		myName = name;
		this.a2b = a2b;
	}
	
	/*change ask_in to ask_in_a and add ask_in_b for exercise 2 */
	private void ask_in_a() {
		closed_pool.open_a();
		System.out.println(myName + " ask in, open a");
	}
	
	/* add ask_in_b function */
	private void ask_in_b() {
		closed_pool.open_b();
		System.out.println(myName + " ask in, open a");
	}
	
	private void enter() {
		has_ship.fill();
		System.out.println(myName + " enter in a");
	}
	
	/* change ask_out to ask_out_a for exercise 2 */
	private void ask_out_a() {
		closed_pool.close_a();
		System.out.println(myName + " ask out, open b");
		closed_pool.a2b();
		System.out.println(myName + " ask out, open b");
		closed_pool.open_b();
		System.out.println(myName + " ask out, open b");
	}
	
	/* create ask_out_b for exercise 2 */
	private void ask_out_b() {
		closed_pool.close_b();
		System.out.println(myName + " ask out, open b");
		closed_pool.b2a();
		System.out.println(myName + " ask out, open b");
		closed_pool.open_a();
		System.out.println(myName + " ask out, open b");
	}
	
	private void exit() {
		has_ship.empty();
		System.out.println(myName + " exit");
	}
	
	
	/* change leave to leave_b */
	private void leave_b() {
		closed_pool.close_b();
		closed_pool.b2a();
		System.out.println(myName + " leave and close");
	}
	
	/* create leave_a */
	private void leave_a() {
		closed_pool.close_a();
		closed_pool.a2b();
		System.out.println(myName + " leave and close");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if (a2b) {
				ask_in_a();
				enter();
				ask_out_a();
				exit();
				leave_b();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				ask_in_b();
				enter();
				ask_out_b();
				exit();
				leave_a();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
