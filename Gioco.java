import java.io.*;

class Gioco {
	public static void main(String[] args) throws Exception{
		Tappa[] tappe;

		try {
        	FileReader fileReader = new FileReader("Avventura.txt");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);

            boolean endOfFile = false;
            int numeroTappe, numeroTappa, numeroRighe;
            int[] tappeRaggiungibili;
            String riga = "";

            numeroTappe = Integer.parseInt(bufferedReader.readLine());
            tappe = new Tappa[numeroTappe];

            for(int i = 0; i < tappe.length; i++) {
            	numeroTappa = Integer.parseInt(bufferedReader.readLine());

                numeroRighe = Integer.parseInt(bufferedReader.readLine());
                for(int j = 0; j < numeroRighe; j++) {
                    riga += bufferedReader.readLine();
                }

                numeroRighe = Integer.parseInt(bufferedReader.readLine());
                tappeRaggiungibili = new int[numeroRighe];
                for(int j = 0; j < tappeRaggiungibili.length; j++) {
                    tappeRaggiungibili[j] = Integer.parseInt(bufferedReader.readLine());
                }

                
            }
            
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Errore in lettura del file");
        }
	}
}