package command.two;

public class PlayMusic implements ICommand {

	private MusicPlayer musicPlayer;

	public PlayMusic() {
		musicPlayer = new MusicPlayer();
	}

	public MusicPlayer getMusicPlayer() {
		return musicPlayer;
	}

	public void setmusicPlayer(MusicPlayer musicPlayer) {
		this.musicPlayer = musicPlayer;
	}

	@Override
	public void execute() {
		musicPlayer.play();
	}
}
