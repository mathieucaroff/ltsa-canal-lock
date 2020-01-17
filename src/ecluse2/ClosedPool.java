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
	
	
	public ClosedPool(Door a, Door b, Pool pool) {
		this.pool = pool;
		door1 = a;
		door2 = b;
	}
	
	
	public synchronized void open_a() {
		pool.is_a();
		door1.open();
	}
	
	public synchronized void open_b() {
		pool.is_b();
		door2.open();
	}
	
	public synchronized void close_a() {
		door1.close();
	}
	
	public synchronized void close_b() {
		door2.close();
	}
	
	public synchronized void a2b() {
		door1.is_closed();
		pool.a2b();
	}
	
	public synchronized void b2a() {
		door2.is_closed();
		pool.b2a();
	}
	

}
