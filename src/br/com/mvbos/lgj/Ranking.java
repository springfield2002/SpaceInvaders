package br.com.mvbos.lgj;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ranking {
    ArrayList <jogador> players = new ArrayList<jogador>();
    Scanner Rank = new Scanner(System.in);

    public void  armazena (File Arquivo, int points)  {
        try{
        if (!Arquivo.exists()) {
            Arquivo.createNewFile();

        }
        String name = JOptionPane.showInputDialog("digite seu nome");
        FileWriter escritor = new FileWriter(Arquivo, true);
        escritor.write(name + ": " + points + "\n");
        escritor.close();
        FileReader leitor = new FileReader(Arquivo);
        BufferedReader entrada = new BufferedReader(leitor);
        while(entrada.ready()) {
            System.out.println(entrada.readLine());
        }
    } catch (Exception e) {
        System.out.println("erro ao manipular o arquivo");
    }


}
}

