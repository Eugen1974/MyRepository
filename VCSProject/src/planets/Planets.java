package planets;

public enum Planets implements IPlanet {
	EARTH(11.1, 10, "Земля") {
		@Override
		public String getColor() {
			return "голубая";
		}
	},
	MOON(22.2, 20, "Луна") {
		@Override
		public String getColor() {
			return "белая";
		}
	},
	MARS(33.3, 30, "Марс") {
		@Override
		public String getColor() {
			return "красный";
		}
	},
	VENERA(44.4, 40, "Венера") {
		@Override
		public String getColor() {
			return "розовая";
		}
	};

	private final double weight;
	private final long radius;
	private final String ruName;

	private Planets(double weight, long radius, String ruName) {
		this.weight = weight;
		this.radius = radius;
		this.ruName = ruName;
	}

	public abstract String getColor();

	@Override
	public String toString() {
		return "name=" + String.format("%6s", name()) + "  ordinal=" + ordinal() + "  weight=" + weight + "  radius="
				+ radius + "  ruName=" + String.format("%6s", ruName) + "  цвет=" + getColor();
	}

	@Override
	public String getRuName() {
		return ruName;
	}
}
