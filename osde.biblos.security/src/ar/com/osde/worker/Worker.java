package ar.com.osde.worker;

public interface Worker {

	public void work();
	public boolean canWork();
	public void releaseResources();
}
