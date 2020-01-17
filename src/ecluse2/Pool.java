package ecluse2;

public class Pool {
	
	private boolean in_a_level = true;
	private boolean in_b_level = false;
	
	public Pool() {
		
	}
	
	public synchronized void is_a() {
		while (!in_a_level) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
	}
	
	public synchronized void a2b() {
		while (!in_a_level) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		in_a_level = false;
		in_b_level = true;
		notifyAll();
	}
	
	public synchronized void is_b() {
		while (!in_b_level) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
	}
	
	public synchronized void b2a() {
		while (!in_b_level) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		in_a_level = true;
		in_b_level = false;
		notifyAll();
	}

}
