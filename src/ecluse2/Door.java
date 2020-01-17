package ecluse2;

public class Door {
	
	boolean is_open = false;
	boolean is_closed = true;
	
	public synchronized void open() {
		while (!is_closed) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		is_closed = false;
		is_open = true;
		notifyAll();
	}
	
	public synchronized void close() {
		while (!is_open) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		is_open = false;
		is_closed = true;
		notifyAll();
	}
	
	public synchronized void is_closed() {
		while (!is_closed) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
	}
	
	public synchronized void is_open( ) {
		while (!is_open) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
	}

}
