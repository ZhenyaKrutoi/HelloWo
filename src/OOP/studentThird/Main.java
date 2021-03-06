package OOP.studentThird;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Automibile Zheka = new Automibile("Компания Женька", 10);
        int choose, izmenenie, chet,search;
        float count, znachenie;
        String chooseAuto,name, searchString;
        do {
            System.out.println("------------МЕНЮ-1-----------");
            System.out.println("1 - Добавить Автомобиль;");
            System.out.println("2 - Получить информацию об одном автомобиле;");
            System.out.println("3 - Получить информацию обо всех автомобилях;");
            System.out.println("4 - Изменить значение топлива;");
            System.out.println("5 - Изменить Гос.номер автомобиля;");
            System.out.println("6 - Получить сумму топлива всех авто;");
            System.out.println("7 - Выход.");
            chet = 1;

            chooseAuto = sc.next();

            switch (chooseAuto){

                case "1" ->{

                    System.out.print("Введите Гос номер автомобиля: ");
                    name = sc.next();
                    ExThirdAuto Automobil = new ExThirdAuto(name);
                    Zheka.AddAuto(Automobil);
                    do {
                        System.out.println();
                        System.out.println("------------МЕНЮ-2------------");
                        System.out.println("1 - Добавить расход топлива;");
                        System.out.println("2 - Изменить расход топлива;");
                        System.out.println("3 - Изменить Гос. номер автомобиля");
                        System.out.println("4 - Общая информация;");
                        System.out.println("5 - Выход.");
                        System.out.println();
                        choose = sc.nextInt();


                        switch (choose) {

                            case 1 -> {
                                System.out.println();
                                System.out.println("Введите расход топлива для " + chet + " дня");
                                count = sc.nextFloat();
                                Automobil.addRachod(count);
                                System.out.println();
                                chet++;
                            }

                            case 2 -> {
                                System.out.println();
                                System.out.println("Введите день, который хотите поменять от 1 до 7: ");
                                izmenenie = sc.nextInt();
                                System.out.println("Введите новое значение: ");
                                znachenie = sc.nextFloat();
                                Automobil.setRachod(znachenie, izmenenie);
                                System.out.println();
                            }

                            case 3 -> {
                                System.out.println("Введите новый Гос.номер автомобиля");
                                searchString = sc.next();
                                Automobil.setGosNumber(searchString);
                            }

                            case 4 -> System.out.println(Automobil.getData());

                        }

                    }while (choose != 5) ;
                    System.out.println(Zheka.getAutoCount());
                }



            case "2" -> {
                System.out.print("\nВведите индекс автомобиля: ");
                search = sc.nextInt();
                System.out.println("\n" + Zheka.SearchAuto(search));
            }

            case "3" -> System.out.println(Zheka.getDataCompany());

            case "4" -> {
                float[] Massiv;
                System.out.print("\nВведите индекс автомобиля: ");
                search = sc.nextInt();
                Massiv = Zheka.PoiskAuto(search);
                System.out.println();
                System.out.println("Введите день, который хотите поменять от 1 до 7: ");
                izmenenie = sc.nextInt();
                System.out.println("Введите новое значение: ");
                znachenie = sc.nextFloat();
                for (int i = 0; i < 7; i++){
                    if (i == izmenenie){Massiv[i] = znachenie;}
                }
                System.out.println("\nВыполнено");
            }

            case "5" -> {
                System.out.print("\nВведите Гос.номер автомобиля: ");
                String gosnom = sc.next();
                Zheka.SearchAutoString(gosnom);
                System.out.println("Введите новый Гос.номер автомобиля:");
                String Search2 = sc.next();
                Zheka.AddAutoToGos(gosnom, Search2);
            }

            case "6" ->{
                System.out.println("\nВсего потрачено всеми автомобилями:");
                System.out.println(Zheka.SumCompany());
            }

            }
        } while (!chooseAuto.equals("7"));
        System.out.println("Всегоо хорошееего!");
    }
}