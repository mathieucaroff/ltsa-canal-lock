package ecluse2;

/**
 * represents the Fillable process
 * It is a controller to be sure there is only one ship 
 * inside the lock system
 * @author gregoire
 *
 */
public class HasShip {
	
	private boolean is_empty = true;
	private boolean is_full = false;
	
	public synchronized void is_empty() {
		while (!is_empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
	}
	
	public synchronized void is_full() {
		while (!is_full) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
	}
	
	public synchronized void fill() {
		while (!is_empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		is_empty = false;
		is_full = true;
		notifyAll();
	}
	
	public synchronized void empty() {
		while (!is_full) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		is_full = false;
		is_empty = true;
		notifyAll();
	}
	

}
