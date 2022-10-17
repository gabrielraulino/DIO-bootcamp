// Abaixo segue um exemplo de código que você pode ou não utilizar

import java.util.*;

public class DIO {
  public static void main(String[] args) {
    int num = Integer.parseInt(new Scanner(System.in).nextLine());
    var count = 0;

    for (var i = 1; i <= num; i++) {
    
      var valor = String.valueOf(i);
      if(valor.length() == 1){
        if(Integer.parseInt(valor) % 2 == 0){
          count++;
        }
      }
      if(valor.length() > 1){
        char[] vetor = valor.toCharArray();
        int soma = 0;
        for (int j = 0; j < vetor.length; j++) {
            soma += (int)Character.getNumericValue(vetor[j]);
          }
        if(soma % 2 == 0)
          count++;
      }
    }
    System.out.println(count);
  }
}
    

