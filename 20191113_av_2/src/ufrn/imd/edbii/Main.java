package ufrn.imd.edbii;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
	    TrieNode root = new TrieNode();
        BufferedReader br;
        String defaultFileName = "palavras.txt";

        if (args.length > 0) {

            try {
                br = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo nao localizado");
                return;
            }

            while (br.ready()) {
                root.insert(br.readLine());
            }

            if (args.length == 1) {
                App interfaceAutocomplete = new App(args[0]);
                interfaceAutocomplete.pack();
                interfaceAutocomplete.setVisible(true);
                System.exit(0);
            }

            if (args.length == 2) {
                Queue<String> suggestions = root.autocomplete(args[1]);
                root.printSuggestions(suggestions);
                return;
            }

            if (args.length == 3) {
                int qtd = 0;
                try {
                    qtd = Integer.parseInt(args[2]);
                } catch (NumberFormatException e){
                    System.out.println("Entrada invalida");
                    return;
                }
                root.autocomplete(args[1], qtd);
                return;
            }
        }else{
            App interfaceAutocomplete = new App(defaultFileName);
            interfaceAutocomplete.pack();
            interfaceAutocomplete.setVisible(true);
            System.exit(0);
        }
    }
}
