package proxy.one;

public class Proxy implements IService {

	private IService service;

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	@Override
	public void doSomething() {
		service.doSomething();
	}
}
