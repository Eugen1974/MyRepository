package proxy.three;

public class VideoFile implements IFile {

	private String path;

	public VideoFile(String path) {
		this.path = path;
		load();
	}

	private void load() {
		System.out.println("Загружаем файл  " + path);
	}

	@Override
	public void play() {
		System.out.println("Воспроизведение " + path);
	}
}
