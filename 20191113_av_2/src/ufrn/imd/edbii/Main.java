package ufrn.imd.edbii;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    TrieNode root = new TrieNode();

        BufferedReader br = new BufferedReader(new FileReader("palavras.txt"));

        while (br.ready()) {
            root.insert(br.readLine());
        }

/*        root.readTrie();*/

/*        root.search("el");*/

        root.autocomplete("am", 4);
    }
}
