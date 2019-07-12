package br.com.systcc.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@RequestScoped
public class GerarAtaBean {

    public void Escrever() {
        try {

            // Conteudo
            String content = "Teste";

            // Cria arquivo
            File file = new File("C:\\teste.txt");

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }

            // Prepara para escrever no arquivo
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Escreve e fecha arquivo
            bw.write(content);
            bw.close();

            // Le o arquivo
            FileReader ler = new FileReader("teste.txt");
            BufferedReader reader = new BufferedReader(ler);
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

            // Imprime confirmacao
            System.out.println("Feito =D");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
