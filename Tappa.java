class Tappa {
	private String testo;
	private int numeroTappa;
	private int[] tappeRaggiungibili;

	public Tappa(String testo, int numeroTappa, int[] tappeRaggiungibili) {
		this.testo = testo;
		this.numeroTappa = numeroTappa;
		this.tappeRaggiungibili = tappeRaggiungibili;
	}

	public String toString() {
		return (testo + "\n" + tappeRaggiungibili);
	}
}