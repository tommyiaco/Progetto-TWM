import java.io.*;

class Gioco {
	public static void main(String[] args) throws Exception {
        //MODIFICATO DA IACO
        Tappa[] tappe;

        //System.out.println("Inserisci il nome del file da leggere:");
		try {
        	FileReader fileReader = new FileReader("Avventura.txt"/*Leggi.unoString()*/);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);

            int totaleTappe, numeroTappa, numeroRighe;
            int[] tappeRaggiungibili;
            String riga = "";

            totaleTappe = Integer.parseInt(bufferedReader.readLine());
            tappe = new Tappa[totaleTappe];

            for(int i = 0; i < tappe.length; i++) {
            	numeroTappa = Integer.parseInt(bufferedReader.readLine());

                numeroRighe = Integer.parseInt(bufferedReader.readLine());
                for(int j = 0; j < numeroRighe; j++) {
                    riga += bufferedReader.readLine() + "\n";
                }

                numeroRighe = Integer.parseInt(bufferedReader.readLine());
                tappeRaggiungibili = new int[numeroRighe];
                for(int j = 0; j < tappeRaggiungibili.length; j++) {
                    tappeRaggiungibili[j] = Integer.parseInt(bufferedReader.readLine());
                }

                tappe[i] = new Tappa(numeroTappa, riga, tappeRaggiungibili);

                riga = "";
            }
            
            fileReader.close();

            Pannello pannello = new Pannello("Avventura", tappe);
            } catch (IOException e) {
            System.out.println("Errore in lettura del file");
        }

	}
}