/**Тестовое задание выполнено: Чурсин Р.С. **/

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void calc(String input)
    {
        Scanner console = new Scanner(System.in);
        //создаём массив с римскими числами для работы с ними
        String[] roman =
                {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
                };
        String resultAll;//A здесь будем хранить ответ строчного формата
        int  massInt[] = {0,0};
        System.out.println(input);
        String [] massSymbols = input.split(" ");
        int p=massSymbols.length;

        /*Проверяем наш полученный строковый масив выше на правильность введенных данных.
        Если арифметическое выражение длиннее 3 членов строкового массива - закрываем программу*/
        if(p==1 | p>3)
        {
            try
            {
                throw new IOException();
            }
            catch(IOException x)
            {
                System.out.println("Введено некорректное арифметическое действие.");
                System.exit(0);
            }
        }

        /*В этом цикле будем переназначать строки, что мы получили при вводе, в int-значения другого массива*/
        int j=0;
        for (int i=0;i<massInt.length;i++)
        {
            for (;j<massSymbols.length;j++)
            {
              try
              {
                  massInt[i] = Integer.parseInt(massSymbols[j].trim());
                  /*преобразуем элемент строкового массива в элемент int-массива, при этом удаляются лишние пробелы в
                   элементах массива через метод trim()*/
                  if(massInt[i]>10|massInt[i]<0)//проверка операндов
                  {
                      try
                      {
                          throw new IOException();
                      }
                      catch(IOException x)
                      {
                          System.out.println("Введено недопустимое значение операнда.");
                          System.exit(0);
                      }
                  }
                  break;
              }
              catch (NumberFormatException e)
                {
                    /*Если исключение вызывается на 1-м или 3-м месте нашего строкового массива, и элементы не являются римскими числами,
                     то завершаем программу, т.к. выражение введено некорректно*/
                   if(j==0|j==2)
                    {
                        switch(massSymbols[j])
                        {
                            case "I":
                                break;
                            case "II":
                                break;
                            case "III":
                                break;
                            case "IV":
                                break;
                            case "V":
                                break;
                            case "VI":
                                break;
                            case "VII":
                                break;
                            case "VIII":
                                break;
                            case "IX":
                                break;
                            case "X":
                                break;
                            default:
                                System.out.println("Введено недопустимое значение операнда!!! ");
                                System.exit(0);
                        }
                    }
                continue;
                }

            }
            j++;
        }


        /*Проверяем введенные значения на наличие римских чисел*/
        boolean a = false;
        boolean b = false;
        for (int i=0;i<massSymbols.length;i++)
        {
            for(int k=1;k<=10;k++)
            {
            if(massSymbols[i].equals(roman[k]))
                {
                    if(i == 0)
                    {
                    massInt[0] = k;
                    a = true;
                    }

                    if(i == 2)
                    {
                    massInt[1] = k;
                    b = true;
                    }
                break;
                }
            }
        }
        if(a&b==false)
        {
            System.out.println("Введено недопустимое значение операндов. Один - арабское число, второй - римское.");
            System.exit(0);
        }


        for (int i=0;i<massInt.length;i++)//Теперь проверяем переназначенные значения римских чисел в массив
        {
            if(massInt[i]>10|massInt[i]<0)//проверка операндов
            {
            try
                {
                throw new IOException();
                }
            catch(IOException x)
                {
                System.out.println("Введено недопустимое значение операнда.");
                System.exit(0);
                }
            }
        }

        int result=0; //в этой переменной будем хранить результат наших вычислений
        for (int i=0;i<massSymbols.length;i++)
        {
            try
            {
                int c = Integer.parseInt(massSymbols[i].trim());
            }
            catch(NumberFormatException e)
            {
                switch(massSymbols[i])
                {
                case "+":
                    if(massSymbols[i].equals("+"))
                        result=massInt[0] + massInt[1];
                    break;
                case "-":
                    if(massSymbols[i].equals("-"))
                        result=massInt[0] - massInt[1];
                    break;
                case "*":
                    if(massSymbols[i].equals("*"))
                        result=massInt[0] * massInt[1];
                    break;
                case "/":
                    if(massSymbols[i].equals("/"))
                    result=massInt[0] / massInt[1];
                    break;
                case "I":
                    break;
                case "II":
                    break;
                case "III":
                    break;
                case "IV":
                    break;
                case "V":
                    break;
                case "VI":
                    break;
                case "VII":
                    break;
                case "VIII":
                    break;
                case "IX":
                    break;
                case "X":
                    break;
                default:
                    try
                    {
                        throw new IOException();
                    }
                    catch(IOException x)
                    {
                        System.out.println("Введено некорректное арифметическое действие.");
                        System.exit(0);
                    }
                }
            }
        }
        if(a&b==true)//Если у нас 2 римских числа, то ниже выводим ответ в римском значении
        {
            for(int k=0;k<=roman.length;k++)
            {
                if(result<=0)
                {
                    System.out.println("Недопустимый ответ в римском блоке - меньше единицы!");
                    System.exit(0);
                }
                if(result==k)
                {
                    resultAll = roman[k];
                    System.out.println("Итог: "+ resultAll);
                    System.out.println("Программа заверщена.");
                    System.exit(0);
                }
            }
        }
        resultAll = Integer.toString(result);
        System.out.println("Итог: "+ resultAll);
    }

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (Операнды и операции разделяются пробелами): ");
        calc(console.nextLine());
        System.out.println("Программа завершена.");
    }
}