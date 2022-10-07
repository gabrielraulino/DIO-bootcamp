// Abaixo segue um exemplo de código que você pode ou não utilizar

import java.util.*;

public class Program {
  public static void main(String[] args) {
    int num = Integer.parseInt(new Scanner(System.in).nextLine());
    var step = 0;
    while (num > 0) {
      if (num % 2 != 0) {
        num--;
        step++;
      }
      if (num != 0) {
        num /= 2;
        step++;
      }
    }
    System.out.println(step);
  }
}