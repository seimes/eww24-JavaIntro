package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Artikelnummern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(": ");
        int group = sc.nextInt();
        if (group < 1 || group > 3) {
            System.out.println("Falsche Eingabe");
            return;
        }
        System.out.print(": ");
        int subgroup = sc.nextInt();
        boolean wrong = false;
        switch (group) {
            case 1:
                if (subgroup < 1 || subgroup > 3) {
                    wrong = true;
                }
                break;
            case 2:
                if (subgroup < 1 || (subgroup > 2 && subgroup < 9) || subgroup > 9) {
                    wrong = true;
                }
                break;
            case 3:
                if (subgroup != 1) {
                    wrong = true;
                }
                break;
        }
        if (wrong) {
            System.out.println("Falsche Eingabe");
            return;
        }
        System.out.print(": ");
        int article = sc.nextInt();

        String articleName = "";

        if (group == 1) {
            switch (subgroup) {
                case 1:
                    if (article < 1 || article > 4) {
                        wrong = true;
                    } else {
                        switch (article) {
                            case 1:
                                articleName = "Bier (hell, 0,5)";
                                break;
                            case 2:
                                articleName = "Bier (hell, 0,33)";
                                break;
                            case 3:
                                articleName = "Zwickel (0,5)";
                                break;
                            case 4:
                                articleName = "Zwickel (0,33)";
                                break;
                        }
                    }
                    break;
                case 2, 3:
                    if (article < 1 || article > 2) {
                        wrong = true;
                    } else {
                        if (subgroup == 2) {
                            if (article == 1) {
                                articleName = "Cola";
                            }
                            else {
                                articleName = "Fanta";
                            }
                        }
                        else {
                            if (article == 1) {
                                articleName = "Rotwein";
                            }
                            else {
                                articleName = "Weißer Spritzer";
                            }
                        }
                    }
                    break;
            }
        }
        else if (group == 2) {
            switch (subgroup) {
                case 1:
                    if (article < 1 || article > 2) {
                        wrong = true;
                    } else {
                        if (article == 1) {
                            articleName = "Schnitzel";
                        }
                        else {
                            articleName = "Schweinsbraten";
                        }
                    }
                    break;
                case 2:
                    if (article != 1) {
                        wrong = true;
                    } else {
                        articleName = "Frankfurter";
                    }
                    break;
                case 9:
                    if (article != 1) {
                        wrong = true;
                    }
                    else {
                        articleName = "Ketchup";
                    }
                    break;
            }
        }
        else {
            if (article < 1 || article > 1) {
                wrong = true;
            }
            else {
                articleName = "Zigaretten";
            }
        }
        if (wrong) {
            System.out.println("Falsche Eingabe");
            return;
        }

        System.out.println(articleName);
    }
}
