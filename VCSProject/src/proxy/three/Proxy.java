package proxy.three;

import java.util.Objects;

public class Proxy implements IFile {

	private IFile file;
	private String path;
	private TypeFile typeFile;

	public Proxy(String path, TypeFile typeFile) {
		this.path = path;
		this.typeFile = typeFile;
	}

	public IFile getFile() {
		return file;
	}

	@Override
	public void play() {
		if (Objects.isNull(file)) {
			if (Objects.equals(typeFile, TypeFile.VIDEO)) {
				file = new VideoFile(path);
			} else if (Objects.equals(typeFile, TypeFile.AUDIO)) {
				// file = new AudioFile(path);
			} else if (Objects.equals(typeFile, TypeFile.TXT)) {
				// file = new TxtFile(path);
			} else {
				throw new IllegalArgumentException("Don't operated case for type file " + typeFile.name() + " !");
			}
		}
		file.play();
	}
}
