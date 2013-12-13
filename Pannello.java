import java.awt.*;
import java.awt.event.*;

class Pannello extends Frame { 
	Tappa[] tappe;
	TextArea testoTappa, segnaTappe;
	Button[] bottoniTappeRaggiungibili;
	Panel pannello;

	public Pannello (String titolo, Tappa[] tappe) { 
		super(titolo);

		this.tappe = tappe;

		pannello = new Panel(); 
		add(pannello, BorderLayout.SOUTH); 

		testoTappa = new TextArea(tappe[0].getTesto(), 5, 20, TextArea.SCROLLBARS_VERTICAL_ONLY); 
		testoTappa.setEditable(false);
		add(testoTappa, BorderLayout.CENTER); 

		segnaTappe = new TextArea("Fai la tua scelta!\n - ", 5, 20, TextArea.SCROLLBARS_VERTICAL_ONLY); 
		add(segnaTappe, BorderLayout.EAST);

		mettiPulsanti(tappe[0]);

		setSize(640,360);
		setVisible(true);

    	addWindowListener(new AscoltatorePannello());
	}  


	//Metodo per sovrascrivere l'attuale testo della tappa con quello della tappa selezionata con la variabile numeroTappa.
	private void cambiaTestoTappa(String testo) {
		testoTappa.setText(testo);
	}

	//Cambia il testo della tappa
	private void cambiaTappa(Tappa tappa){
		cambiaTestoTappa(tappa.getTesto());
	}

	//Elinare i pulsanti attuali
	private void rimuoviBottoni(){
		for (int i = 0; i < bottoniTappeRaggiungibili.length; i++) {
			pannello.remove(bottoniTappeRaggiungibili[i]);
		}
	}

	//Aggiornare i pulsanti
	private void mettiPulsanti(Tappa tappa){
		int[] tappeRaggiungibili = tappa.getTappeRaggiungibili();
		bottoniTappeRaggiungibili = new Button[tappeRaggiungibili.length];
		for (int i = 0; i < bottoniTappeRaggiungibili.length; i++) {
			bottoniTappeRaggiungibili[i] = new Button(Integer.toString(tappeRaggiungibili[i]));
			pannello.add(bottoniTappeRaggiungibili[i]);
			bottoniTappeRaggiungibili[i].addActionListener(new AscoltatoreBottone());
		}
		pannello.validate();
	}

	//Metodo ascoltatore del bottone che richiama il metodo per effettuare il cambio della tappa.
	class AscoltatoreBottone implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			int prossimaTappa = Integer.parseInt(evento.getActionCommand());
			cambiaTappa(tappe[prossimaTappa - 1]);
			//"Appende" del testo riguardo la tappa selezionata alla TextArea segnaTappe.
			segnaTappe.append("\nTappa selezionata: " + prossimaTappa + "\n - ");
			rimuoviBottoni();
			mettiPulsanti(tappe[prossimaTappa - 1]);
		} 
	} 

	public class AscoltatorePannello extends WindowAdapter {
    	public void windowClosing(WindowEvent e) { 
    		e.getWindow().dispose();
    	}

    	public void windowClosed (WindowEvent e) {
      		System.exit(0);
    	}
  	}
} 