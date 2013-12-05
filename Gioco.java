import java.io.*;

class Gioco {
	public static void main(String[] args) throws Exception{
		Tappa[] tappe;

		try {
        	FileReader fileReader = new FileReader("Avventura.txt");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);

            boolean endOfFile = false;
            int numeroTappe;
            String riga;

            numeroTappe = Integer.parseInt(bufferedReader.readLine());
            tappe = new Tappa[numeroTappe];

            for(int i = 0; i < tappe.length; i++) {
            	
            }
            while (!endOfFile) {
                String riga = bufferedReader.readLine();
                if (riga == null)
                    endOfFile = true;
                else {
                	if()
                }
		
                fileReader.close();
            }
        } catch (IOException e) {
            System.out.println("Errore in lettura del file");
        }
	}
}