package trabalhopersistencia;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * @version 1.0
 * @author Eduardo Woloszyn
 */
public class BinarioAleatorio {
	public static void main( String [] args ) {
		long NUMTUPLAS = 4; //quantidade tuplas que serao geradas
		String nomearquivo="teste.dat"; //nome do arquivo
		File arq = new File(nomearquivo); //objeto para manipulacao fisica do arquivo
		arq.delete(); // apaga arquivo
		try {
			/*
			 * Cria a quantidade de NUMTUPLAS no arquivo
			 */
			
			//Abre arquivo para leitura e gravacao
			RandomAccessFile arquivo = new RandomAccessFile( nomearquivo, "rw" ); 
				for( int i=0;i<	NUMTUPLAS; i++ ) { //grava a quantidade de NUMTUPLAS no arquivo 
					String nome = "juca "+String.valueOf(i); //nome no formato juca (nro)
					Double salario = Math.random()*1000; // salario aleatorio entre 0 e 1000
					System.out.println(i+" \t| "+nome+" \t| "+salario); // imprime tupla
					arquivo.writeInt( i ); // grava codigo
					//grava nome formatado com tamanho de 30 caracteres
					arquivo.writeChars(String.format("%1$30s", nome)); 
					arquivo.writeDouble(salario); //grava salario
				} 
			long tamArq = arquivo.length(); //recupera o tamanho do arquivo
			System.out.println( "antes de fechar o arquivo, ele tem o tamanho de " + tamArq +" bytes." );
			arquivo.close(); //fecha o arquivo

			/*
			 * abre e le a quantidade de NUMTUPLAS do arquivo
			 */

			//Abre arquivo para leitura e gravacao
			arquivo = new RandomAccessFile( nomearquivo, "rw" ); 
			tamArq = arquivo.length();//recupera o tamanho do arquivo
			System.out.println( "depois de reabrir o arquivo, ele tem o tamanho de " + tamArq +" bytes." );
			for(int i=0;i<	tamArq/72; i++ ) {
				int codigo = arquivo.readInt(); //le 4 bytes do arquivo e converte para int
				String nome = ""; // variavel auxiliar para contruir o nome
				for(int j=0;j<30; j++ ) 
					nome+= arquivo.readChar(); //le 2 bytes do arquivo e converte para char
				Double salario = arquivo.readDouble(); //le 8 bytes do arquivo e converte para double
				System.out.println(codigo+" \t| "+nome+" \t| "+salario); // imprime tupla
			}
			/*
			 * GRAVAR NA POSICAO DO MEIO DO ARQUIVO
			 */

			long novaPosicao = 72*((arquivo.length()/72)/2); //Acha posicao intermediaria
			System.out.println("apontando para a posição: "+novaPosicao); 
			arquivo.seek( novaPosicao );// aponta para a posicao intermediaria
			System.out.println("Arquivo na posição: "+arquivo.getFilePointer());
			arquivo.writeInt( 1000 ); //escreve codigo
			arquivo.writeChars("                   Walter pink" );//escreve nome
			arquivo.writeDouble(666.666); //escreve salario

			System.out.println( "Novo registro -  codigo: 1000 " +
								"nome: Walter Pink "+
								"salario: 666.666 "+
								"na posicao " + novaPosicao);
			
			arquivo.seek(0); //aponta para o inicio do arquivo
			for( int i=0;i<	NUMTUPLAS; i++ ) {
				int codigo = arquivo.readInt(); //le 4 bytes do arquivo e converte para int
				String nome = "";
				for(int j=0;j<30; j++ ) 
					nome+= arquivo.readChar(); //le 2 bytes do arquivo e converte para char
				Double salario = arquivo.readDouble(); //le 8 bytes do arquivo e converte para double
				System.out.println(codigo+" \t| "+nome+" \t| "+salario);
	}
		
			/*
			 * GRAVAR NO FINAL DO ARQUIVO
			 */
			System.out.println( "Novo registro -  codigo: 300 " +
					"nome: Nhô Bazoca "+
					"salario: 1.0 ");
			
			long fimArquivo = arquivo.length();//recupera posicao do final do arquivo
			arquivo.seek( fimArquivo );//aponta para o fim do arquivo
			arquivo.writeInt( 300 ); //grava codigo
			arquivo.writeChars("                    Nhô bazoca" ); // grava nome 
			arquivo.writeDouble(1.0); // grava salario
			NUMTUPLAS++; // incrementa nro de tuplas

			
			/*
			 * LE TODO O ARQUIVO
			 */
		
			NUMTUPLAS = arquivo.length()/72;
			arquivo.seek( 0 ); // posiciona na posicao inicial do arquivo
			for( int i=0;i<	NUMTUPLAS; i++ ) {
				int codigo = arquivo.readInt();
				String nome = "";
				for(int j=0;j<30; j++ ) 
					nome+= arquivo.readChar();
				Double salario = arquivo.readDouble();
				System.out.println(codigo+" \t| "+nome.trim()+" \t| "+salario); //trim() remove espacos em branco antes e depois da string
			}
			/*
			 * Listar apenas salarios
			 */
			
			for( int i=0;i<	(arquivo.length()/72); i++ ) {
				// int codigo = arquivo.readInt();  -> 4
				//String nome = "";
				//for(int j=0;j<30; j++ ) 
				//	nome+= arquivo.readChar(); ->60
				arquivo.seek((i*72) + 64);
				Double salario = arquivo.readDouble();
				System.out.println(salario); 
			}

			
			arquivo.close(); //fecha o arquivo
			for(int i=0;i<10;i++)
				System.out.println("");
//*/
		} catch( IOException e){System.exit( 1 );}
 		
	} 

}