package proxy.three;

public class Main {

	public static void main(String[] args) {
		Proxy proxy = new Proxy("video.avi", TypeFile.VIDEO);
		proxy.play();
		proxy.play();
		proxy.play();
	}
}
