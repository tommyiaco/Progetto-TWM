import java.awt.*;
import java.awt.event.*;
class Pannello extends Frame { 
	TextArea testoTappa, segnaTappe;
	Button[] bottoniTappeRaggiungibili;
	Panel pannello;

	public Pannello (String titolo) { 
		super(titolo); 

		pannello = new Panel(); 
		add(pannello, BorderLayout.SOUTH); 

		testoTappa = new TextArea(Gioco.tappe[0].getTesto(),5,20); 
		testoTappa.setEditable(false); 
		add(testoTappa, BorderLayout.CENTER); 

		segnaTappe = new TextArea("Fai la tua scelta!",5,20); 
		add(segnaTappe, BorderLayout.EAST);

		mettiPulsanti(Gioco.tappe[0]);

		setSize(640,360);
		setVisible(true);

    	addWindowListener(new AscoltatorePannello());
	}  


	//Metodo per sovrascrivere l'attuale testo della tappa con quello della tappa selezionata con la variabile numeroTappa.
	public void cambiaTestoTappa(String testo){
		testoTappa.setText(testo);
	}

	//Metodo ascoltatore del bottone che richiama il metodo per effettuare il cambio della tappa.
	class AscoltatoreBottone implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			int prossimaTappa = Integer.parseInt(evento.getActionCommand());
			cambiaTappa(Gioco.tappe[prossimaTappa - 1]);
			//"Appende" del testo riguardo la tappa selezionata alla TextArea segnaTappe.
			segnaTappe.append("\nTappa selezionata: " + prossimaTappa);
			rimuoviBottoni();
			mettiPulsanti(Gioco.tappe[prossimaTappa - 1]);
		} 
	} 

	//Cambia il testo della tappa
	public void cambiaTappa(Tappa tappa){
		cambiaTestoTappa(tappa.getTesto());
	}

	//Elinare i pulsanti attuali
	public void rimuoviBottoni(){
		for (int i = 0; i < bottoniTappeRaggiungibili.length; i++) {
			pannello.remove(bottoniTappeRaggiungibili[i]);
		}
	}

	//Aggiornare i pulsanti
	public void mettiPulsanti(Tappa tappa){
		int[] tappeRaggiungibili = tappa.getTappeRaggiungibili();
		bottoniTappeRaggiungibili = new Button[tappeRaggiungibili.length];
		for (int i = 0; i < bottoniTappeRaggiungibili.length; i++) {
			bottoniTappeRaggiungibili[i] = new Button(Integer.toString(tappeRaggiungibili[i]));
			pannello.add(bottoniTappeRaggiungibili[i]);
			bottoniTappeRaggiungibili[i].addActionListener(new AscoltatoreBottone());
		}
		pannello.validate();
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