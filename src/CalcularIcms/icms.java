package CalcularIcms;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Locale;

public class icms {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        double prc = 0.0, baseIcms, valIcms = 0.0, baseIcmsSt, valIcmsDeb = 0.0, valIcmsCred = 0.0, valSt;
        float aliqEst;
        int qt = 0, opcao = 0;
        boolean teste = true;
        do{
        String opcaoMenu = JOptionPane.showInputDialog("Qual opção você escolhe:\n 1-icms \n 2-icmsST");
        opcao = Integer.parseInt(opcaoMenu);

            switch(opcao){
                case 1:        
                    String preco = JOptionPane.showInputDialog("Digite o preco do produto:");
                    String quantidade = JOptionPane.showInputDialog("Digite a quantidade");
                    String aliquota = JOptionPane.showInputDialog("Digite a aliquota:");
        
                    prc = Double.parseDouble(preco);
                    qt = Integer.parseInt(quantidade);
                    aliqEst = Float.parseFloat(aliquota);
         
                    aliqEst = (float)(aliqEst/100);
                    baseIcms = qt * prc;
                    valIcms = baseIcms * aliqEst;
                    String valorFormatado = NumberFormat.getCurrencyInstance().format(valIcms);
         
                    JOptionPane.showMessageDialog(null,"Resultado" + valorFormatado);
                    JOptionPane.showMessageDialog(null,"Programa finalizado");
                    System.exit(0);
                    break;
                
                case 2:
                    String preco2 = JOptionPane.showInputDialog("Digite o valor do produto:");
                    String valorIpi = JOptionPane.showInputDialog("Digite o valor de IPI:");
                    String percMva = JOptionPane.showInputDialog("Digite o MVA:");
                    String aliquotaDest = JOptionPane.showInputDialog("Digite a alíquota de destino:");
                    String aliquotaOrigem = JOptionPane.showInputDialog("Digite a alíquota de origem");
                
                    double prc2 = Double.parseDouble(preco2);
                    double ipi = Double.parseDouble(valorIpi);
                    float mva = Float.parseFloat(percMva);
                    float aliqDest = Float.parseFloat(aliquotaDest);
                    float aliqOrig = Float.parseFloat(aliquotaOrigem);
                
                    baseIcmsSt = ((prc2+ipi)*(mva/100))+prc2;
                    valIcmsDeb = baseIcmsSt * (aliqDest/100);
                    int pergunta = JOptionPane.showConfirmDialog(null,"vai tributar icms normal?", "validação usuário", JOptionPane.YES_NO_OPTION);
                    if(pergunta == JOptionPane.YES_OPTION){
                        valIcmsCred = prc2 * (aliqOrig/100);
                    }else if(pergunta == JOptionPane.NO_OPTION){
                        valIcmsCred = 0;
                    }
                    //valIcmsCred = prc2 * (aliqOrig/100);
                    /*if (valIcmsCred > 0){
                    valSt = valIcmsDeb - valIcmsCred;
                    }else{
                    valSt = valIcmsDeb;
                    }*/
                    valSt = valIcmsDeb - valIcmsCred;
                    String valorFormatado2 = NumberFormat.getCurrencyInstance().format(valIcmsDeb);
                    String valorFormatado3 = NumberFormat.getCurrencyInstance().format(valIcmsCred);
                    String valorFormatado4 = NumberFormat.getCurrencyInstance().format(valSt);
                
                    JOptionPane.showMessageDialog(null,"Valor icms Debito é: \n" + valorFormatado2 + "\n Valor de icms Credito é:\n" + valorFormatado3);
                    JOptionPane.showMessageDialog(null,"O valor de ST é:\n" + valorFormatado4 + "\n OBS:Se for tributar icms normal também o valor de icms de crédito é deduzido do valor da ST" );
                    System.exit(0);
                    break;
                default:
                    int resposta = JOptionPane.showConfirmDialog(null,"Desejar finalizar?","Confirmação", JOptionPane.YES_NO_OPTION);
                    if(resposta == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"programa finalizado");
                    System.exit(0);
                    }else if(resposta == JOptionPane.NO_OPTION){
                    
                    }

       
            }
        }while(teste);
        
    }
    
}
