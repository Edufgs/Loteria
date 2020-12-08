package edu.loteria.megasena;

import edu.loteria.util.MediaDezenas;
import edu.loteria.util.Teclado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class Main {    
    public static void main(String[] args) throws IOException{ //tratamento de erro
        try{
           menu();//chama o menu
        }catch(FileNotFoundException e){
            System.out.println("Erro:" + e);
        }
    }    

    public static void menu() throws FileNotFoundException, IOException{
        System.out.println("1 = Lotofacil");
        System.out.println("2 = Mega Sena");
        switch(Teclado.leInt("Digite:")){
            case 1:
                FileInputStream arquivoLoto = new FileInputStream(new File("E:\\\\Eduardo\\\\Loteria\\\\Loteria.xlsx")); //abre o arquivo como arquivo para depois configurar como Excel no metodo "abrindoArquivo"
                List<MegaSena> lotoFacil = listaMega(arquivoLoto, 0);//No arquivo Excel pode haver varias planilhas então esta escolhendo a do Mega Sena
                List<MediaDezenas> mediaLoto = mediaDezenas(lotoFacil);
                Collections.sort(mediaLoto);
                for(int i = 0; i<6; i++){
                    System.out.println(mediaLoto.get(i));
                }
                break;
                
            case 2://Abre o arquivo referente a mega sena
                FileInputStream arquivoMega = new FileInputStream(new File("E:\\\\Eduardo\\\\Loteria\\\\Loteria.xlsx")); //abre o arquivo como arquivo para depois configurar como Excel no metodo "abrindoArquivo"
                List<MegaSena> megaSena = listaMega(arquivoMega, 0);//No arquivo Excel pode haver varias planilhas então esta escolhendo a do Mega Sena
                List<MediaDezenas> mediaMega = mediaDezenas(megaSena);
                Collections.sort(mediaMega);
                for(int i = 0; i<6; i++){
                    System.out.println(mediaMega.get(i));
                }
                break;
                
                default:
                    System.out.println("Erro na leitura!!!");
                    menu();
            }
    }
    private static List<MegaSena> listaMega(FileInputStream arquivo, int planilha) throws FileNotFoundException, IOException { //abre o arquivo e transforma em lista
        List<MegaSena> nMega = new ArrayList<>(); //vai guardar todos os dados do Excel
        
        Iterator rowIterator = abrindoArquivo(arquivo, planilha);
            
        int aux = 0;
            
        while(rowIterator.hasNext()){ // Dentro de cada linha, é recuperado outro iterator, agora para iterar sobre as colunas de cada linha (Pega a primeira linha e em cada loop passa para proxima linha ate chegar no minal do arquivo Excel
            Row row = (org.apache.poi.ss.usermodel.Row) rowIterator.next();//Para ler as linhas do arquivo, é utilizada a classe Row, e para a célula especifica é utilizada a classe Cell.
            Iterator<Cell> cellIterator = row.cellIterator();
                
            if(aux == 0){
                aux = 1;
                continue;
            }
                
            MegaSena sorteio = new MegaSena();
            nMega.add(sorteio);
            while(cellIterator.hasNext()){//Anda pela coluna e pegando as celulas
                Cell cell = cellIterator.next();
                switch(cell.getColumnIndex()){
                case 0://Concurso
                    sorteio.setConcurso((int)(cell.getNumericCellValue()));//pega o numero double e transforma em String (Para parecer como int)
                    break;
                        
                case 1://Data de sorteio
                    sorteio.setDataSorteio(cell.getDateCellValue());
                    break;
                    
                case 2://Dezena 1
                case 3://Dezena 2
                case 4://Dezena 3
                case 5://Dezena 4
                case 6://Dezena 5
                case 7://Dezena 6
                    sorteio.setDezenas((int)cell.getNumericCellValue());
                    break;
                    
                case 8://Arrecadação Total
                    sorteio.setArrecadaTotal((int)cell.getNumericCellValue());
                    break;
                        
                case 9://Numero de Ganhadores
                    sorteio.setganhadoresNGanhadores(0, (int)cell.getNumericCellValue());
                    sorteio.setGanhadoresNAcertos(0, 6);
                    break;
                      
                case 10://Cidade
                    sorteio.setGanhadoresCidade(0, cell.getStringCellValue());
                    break;
                        
                case 11://Estado
                    sorteio.setGanhadoresEstado(0, cell.getStringCellValue());
                    break;
                        
                case 12://Rateio (Divisão em partees iguais do premio) Sena
                    sorteio.setGanhadoresRateio(0, cell.getNumericCellValue());
                    break;
                        
                case 13://Numero de Ganhadores da Quina
                    sorteio.setganhadoresNGanhadores(1, (int)cell.getNumericCellValue());
                    sorteio.setGanhadoresNAcertos(1, 5);
                    break;
                        
                case 14://Rateio (Divisão em partees iguais do premio) Quina
                    sorteio.setGanhadoresRateio(1, cell.getNumericCellValue());
                    break;
                        
                case 15://Numero de Ganhadores da Quadra
                    sorteio.setganhadoresNGanhadores(2, (int)cell.getNumericCellValue());
                    sorteio.setGanhadoresNAcertos(2, 4);
                    break;
                       
                case 16://Rateio (Divisão em partees iguais do premio) quadra
                    sorteio.setGanhadoresRateio(2, cell.getNumericCellValue());
                    break;
                        
                case 17://Acumulou ?
                    if("SIM".equals(cell.getStringCellValue())){
                        sorteio.setAcumulado(true);
                    }else{
                        sorteio.setAcumulado(false);
                    }
                    break;
                       
                case 18://valor acumulado
                    sorteio.setValorAcumulado(cell.getNumericCellValue());
                    break;
                        
                case 19://Estimativa de Ganho
                    sorteio.setEstimativa(cell.getNumericCellValue());
                    break;
                    
                case 20://Acumulo para mega da virada
                    sorteio.setAcumuladoMegaVirada(cell.getNumericCellValue());
                    break;
                        
                default://Erro na leitura
                    System.out.println("Erro na leitura");
                    arquivo.close();
                }
                
                arquivo.close();  
                
            }
        }
        return nMega;
    }

    public static Iterator abrindoArquivo(FileInputStream arquivo, int planilha ) throws IOException{ //abre o arquivo e configura como Excel, devolve ele aberto
        //Se fosse a verção antiga do Excel (até 2007), Seria HSSFWorkbook e HSSFSheet na validação e abertura
        Workbook workbook = new XSSFWorkbook(arquivo); //O arquivo é validado se é ou não Excel
            
        Sheet sheetMegaSena = workbook.getSheetAt(planilha); //abre uma planilha do arquivo Excel. Entre parentes esta a planilha dentro do arquivo Excel(pode ter varios arquivos e tem que escolher) abre a folha 0
        
        Iterator<Row> rowIterator = sheetMegaSena.iterator();//è necessario para ler célula a célula do arquivo
        
        return rowIterator;
    }
    
    public static List<MediaDezenas> mediaDezenas(List<MegaSena> mega){//vai pegar a media das dezenas e verificar qual aparece mais
        List<MediaDezenas> media = mediaDezenas();//recebe a lista que vai guarda a frequencia dos numeros
        for(int i = 0; i< mega.size(); i++){//loop para pegar todas as dezenas(entra nos registro da mega sena
            if(i == 0 || mega.get(i - 1).getConcurso() != mega.get(i).getConcurso()){//O primeiro concurso é sempre pega. Depois ele verifica se ja foi adicionado o concurso (O concurso pode se repetir por causa dos ganhadores)
                for(int j = 0; j<mega.get(i).getDezenas().size(); j++){ //vai andar pela lista e pegando as Dezenas
                    media.get((int)mega.get(i).getDezenas().get(j) - 1).setQuantidadeDezena(1);//adiciona mais um na quantidade de dezena dependendo da dezena que aparecer
                }
            }
        }
        return media;
    }
    
    public static List<MediaDezenas> mediaDezenas(){//cria a lista de media para guardar a quantidade de frequencia deles
        List<MediaDezenas> media = new ArrayList<>();//cria a lista que vai retornar
        for(int i = 0; i < 60; i++){//faz um loop que vai adicionar os numeros dentro
            MediaDezenas aux = new MediaDezenas();//cria um auxiliar que vai ser adicionado a lista
            aux.setDezena(i+1);//adiciona a dezena certa
            media.add(aux);//adicionas na lista
        }
        return media;
    }
    
   
}