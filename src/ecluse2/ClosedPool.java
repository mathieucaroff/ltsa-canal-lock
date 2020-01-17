package ecluse2;

/**
 * This class represents the composition CLOSED_POOL in the FSP model
 * @author gregoire
 *
 */
public class ClosedPool {
	
	/**
	 * door1 is A in the model
	 */
	private Door door1;
	
	/**
	 * door2 is B n the model
	 */
	private Door door2;
	private Pool pool;
	
	
	public synchronized void open_a() {
		pool.is_a();
		door1.open();
	}
	
	public synchronized void open_b() {
		pool.is_b();
		door2.open();
	}
	
	public synchronized void a_is_closed() {
		door1.is_closed();
		pool.a2b();
	}
	
	public synchronized void b_is_closed() {
		door2.is_closed();
		pool.b2a();
	}
	

}
