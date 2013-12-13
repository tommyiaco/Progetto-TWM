class Tappa {
	private int numeroTappa;
	private String testo;
	private int[] tappeRaggiungibili;

	public Tappa(int numeroTappa, String testo, int[] tappeRaggiungibili) {
		this.testo = testo;
		this.numeroTappa = numeroTappa;
		this.tappeRaggiungibili = tappeRaggiungibili;
	}

	public void setNumeroTappa(int numeroTappa) {
		this.numeroTappa = numeroTappa;
	}

	public int getNumeroTappa() {
		return this.numeroTappa;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getTesto() {
		return this.testo;
	}

	public void setTappeRaggiungibili(int[] tappeRaggiungibili) {
		this.tappeRaggiungibili = tappeRaggiungibili;
	}

	public int[] getTappeRaggiungibili() {
		return this.tappeRaggiungibili;
	}

	public String toString() {
		return (numeroTappa + "\n" + testo + tappeRaggiungibili.length);
	}
}