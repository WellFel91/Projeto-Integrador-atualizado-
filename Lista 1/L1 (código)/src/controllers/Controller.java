package controllers;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Scanner;
import models.*;

public class Controller {
    ClientList clientList = new ClientList();
    private Scanner scan;
    private boolean execute;
    DecimalFormat df = new DecimalFormat("0.0");

    public void start() {
        scan = new Scanner(System.in);
        execute = true;
        System.out.println("\nAgenda");

        while (execute) {
            String option = mainMenu();

            if (option.equalsIgnoreCase("1")) {
                register();
            } else if (option.equalsIgnoreCase("2")) {
                String list = listMenu();

                if (list.equalsIgnoreCase("1")) {
                    showList();
                } else if (list.equalsIgnoreCase("2")) {
                    showListM();
                } else if (list.equalsIgnoreCase("3")) {
                    showListF();
                } else if (list.equalsIgnoreCase("4")) {
                    // * voltar para o inicio do programa
                } else {
                    System.out.println("Favor digitar um número válido!!");
                }

            } else if (option.equalsIgnoreCase("3")) {
                editRegis();
            } else if (option.equalsIgnoreCase("4")) {
                remove();
            } else if (option.equalsIgnoreCase("5")) {
                addProd();
            } else if (option.equalsIgnoreCase("6")) {
                String menu = feedbackOptionMenu();

                if (menu.equalsIgnoreCase("1")) {
                    String selec = feedbackMenu();

                    if (selec.equalsIgnoreCase("1")) {
                        yearsG();
                    } else if (selec.equalsIgnoreCase("2")) {
                        yearsM();
                    } else if (selec.equalsIgnoreCase("3")) {
                        yearsF();
                    } else if (selec.equalsIgnoreCase("4")) {
                        // *voltar
                    } else {
                        System.out.println("Favor digitar um número válido!!");
                    }
                } else if (menu.equalsIgnoreCase("2")) {
                    String selec = feedbackMenu();

                    if (selec.equalsIgnoreCase("1")) {
                        servicesG();
                    } else if (selec.equalsIgnoreCase("2")) {
                        servicesM();
                    } else if (selec.equalsIgnoreCase("3")) {
                        servicesF();
                    } else if (selec.equalsIgnoreCase("4")) {
                        // * voltar
                    } else {
                        System.out.println("Favor digitar um número válido!!");
                    }
                } else if (menu.equalsIgnoreCase("3")) {

                } else {
                    System.out.println("Favor digitar um número válido!!");
                }
            } else if (option.equalsIgnoreCase("7")) {
                execute = false;
            } else {
                System.out.println("Favor digitar um número válido!!");
            }
        }
    }

    public String mainMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Listar cadastrados");
        System.out.println("3 - Editar cadastro");
        System.out.println("4 - Remover cadastro");
        System.out.println("5 - Adicionar/remover produtos");
        System.out.println("6 - Relatórios");
        System.out.println("7 - Sair");
        return scan.nextLine();
    }

    public String listMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Todos os cadastrados");
        System.out.println("2 - Cadastrados Masculinos");
        System.out.println("3 - Cadastrados Femininos");
        System.out.println("4 - Voltar");
        return scan.nextLine();
    }

    public String feedbackOptionMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Média de idade");
        System.out.println("2 - Média de serviços");
        System.out.println("3 - Voltar");
        return scan.nextLine();
    }

    public String feedbackMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Média de todos");
        System.out.println("2 - Média masculino");
        System.out.println("3 - Média feminino");
        System.out.println("4 - Voltar");
        return scan.nextLine();
    }

    private void register() {
        boolean registering = true;

        while (registering) {
            System.out.println("\nCadastro de usuário");
            Client c = new Client();
            String name = textInput("\nNome:");
            while (name.length() < 3) {
                name = textInput("\nNome:");
            }
            c.setName(name);
            String phone = textInput("\nTelefone:");
            while (phone.length() >= 8 && phone.length() <= 9) {
                phone = textInput("\nDigite um telefone válido:");
            }
            c.setPhone(phone);
            String gen = textInput("\nGênero: (M/F)");
            while (gen.length() != 1) {
                gen = textInput("\nGênero: (M/F)");
            }
            c.setGen(gen);
            String date = textInput("\nData de nascimento: (somente números ex: 01102000)");
            while (date.length() != 8) {
                date = textInput("\nDigite uma data de nascimento válida: (somente números ex: 01102000)");
            }
            c.setBirth(date);

            String register = textInput("\nAdicionar cadastro (S/N) ?");
            if (register.equalsIgnoreCase("s")) {
                System.out.println("Cadastro adicionado!!");
                clientList.clients.add(c);
            } else if (register.equalsIgnoreCase("n")) {
                System.out.println("Cadastro ignorado !!!");
            } else {
                System.out.println("\nOpção inválida, favor digitar denovo!! \n");
            }

            String newRegister = textInput("\nContinuar cadastrando (S/N) ?");
            if (newRegister.equalsIgnoreCase("N")) {
                registering = false;
            } else if (newRegister.equalsIgnoreCase("s")) {
                //* se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\nOpção inválida, parando o cadastro!! \n");
                registering = false;
            }
        }
    }

    private void showList() {
        sortList();
        if (clientList.clients.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (Client x : clientList.clients) {
                System.out.println(x);
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private void showListM() {
        sortList();
        int count = 0;
        if (clientList.clients.size() == 0) {
            System.out.println("\nNão existem cadastros!!\n");
        } else {
            for (Client x : clientList.clients) {
                if (x.getGen().equalsIgnoreCase("Masculino")) {
                    System.out.println(x);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("\nNão existem cadastros masculinos");
            }
        }
    }

    private void showListF() {
        sortList();
        int count = 0;
        if (clientList.clients.size() == 0) {
            System.out.println("\nNão existem cadastros!!\n");
        } else {
            for (Client x : clientList.clients) {
                if (x.getGen().equalsIgnoreCase("Feminino")) {
                    System.out.println("\n" + x);
                    count++;
                }
                if (count == 0) {
                    System.out.println("\nNão existem cadastros femininos");
                }
            }
        }
    }

    private String textInput(String label) {
        System.out.println(label);
        return scan.nextLine();
    }

    private void sortList() {
        Collections.sort(clientList.clients);
    }

    private void editRegis() {
        sortList();
        int id = 0;
        if (clientList.clients.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (Client x : clientList.clients) {
                id += 1;
                System.out.println("id: " + id);
                System.out.println(x);
            }
            String select = textInput("Digite o id da pessoa para editar, caso não queira editar, digite exit\n");
            if (select.equalsIgnoreCase("Exit")) {
                //* sair
            } else {
                int index = Integer.parseInt(select);
                index -= 1;
                String option = textInput("Selecione 1-nome / 2-tel / 3-gen");
                if (option.equalsIgnoreCase("1")) {
                    clientList.clients.get(index).setName(textInput("\nDigite o nome"));
                } else if (option.equalsIgnoreCase("2")) {
                    clientList.clients.get(index).setPhone(textInput("\nDigite o tel"));
                } else if (option.equalsIgnoreCase("3")) {
                    clientList.clients.get(index).setGen(textInput("\nDigite o gen (M/F)"));
                } else if (option.equalsIgnoreCase("4")) {
                    //*voltar
                } else {
                    System.out.println("Digite um número válido!!");
                }
            }
        }
    }

    private void remove() {
        sortList();
        int id = 0;
        if (clientList.clients.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (Client x : clientList.clients) {
                id += 1;
                System.out.println("id: " + id);
                System.out.println(x);
            }
            String select = textInput("Digite o id da pessoa para excluir, caso não queira excluir, digite exit\n");
            if (select.equalsIgnoreCase("Exit")) {
                //*voltar
            } else {
                int index = Integer.parseInt(select);
                index -= 1;
                clientList.clients.remove(index);
                System.out.println("Cliente" + index + "removido");
            }
        }
    }

    private void addProd() {
        sortList();
        int id = 0;
        if (clientList.clients.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (Client x : clientList.clients) {
                id += 1;
                System.out.println("id: " + id);
                System.out.println(x);
            }
            String select = textInput(
                    "Digite o id da pessoa, caso não queira adicionar/remover serviços, digite exit\n");
            if (select.equalsIgnoreCase("Exit")) {
                //*voltar
            } else {
                int index = Integer.parseInt(select);
                index -= 1;
                String gen = clientList.clients.get(index).getGen();
                int count = 0;
                if (gen.equalsIgnoreCase("Masculino")) {
                    System.out.println(" ");
                    for (int i = 9; i < clientList.services.length; i++) {
                        System.out.println((i - 8) + " " + clientList.services[i]);
                        count++;
                    }
                    int serv = Integer.parseInt(textInput("Digite o serviço a ser adicionado/removido: "));
                    while (serv > count || serv < 1) {
                        serv = Integer.parseInt(textInput("Digite um serviço válido: "));
                    }
                    clientList.clients.get(index).setServices(serv + 8);
                } else if (gen.equalsIgnoreCase("Feminino")) {
                    System.out.println(" ");
                    for (int i = 0; i < 10; i++) {
                        System.out.println((i + 1) + " " + clientList.services[i]);
                        count++;
                    }
                    int serv = Integer.parseInt(textInput("Digite o serviço a ser adicionado/removido: "));
                    while (serv > count || serv < 1) {
                        serv = Integer.parseInt(textInput("Digite um serviço válido: "));
                    }
                    clientList.clients.get(index).setServices(serv - 1);
                }
            }
        }
    }

    private void yearsG() {
        float count = 0;
        if (clientList.clients.size() == 1) {
            System.out.println(clientList.clients.get(0).getYears());
        } else if (clientList.clients.size() > 1) {
            for (int index = 0; index < clientList.clients.size(); index++) {
                if (index == 0) {
                    count += clientList.clients.get(index).getYears();
                } else {
                    count += clientList.clients.get(index).getYears();
                    count /= 2;
                }
            }
            System.out.println("\nA média de idade é: " + df.format(count));
        } else {
            System.out.println("\nNão há clientes cadastrados");
        }
    }

    private void yearsM() {
        float years = 0;
        boolean validate = false;
        int count = 0;
        if (clientList.clients.size() == 1) {
            if (clientList.clients.get(0).getGen().equalsIgnoreCase("Masculino")) {
                System.out.println(clientList.clients.get(0).getYears());
            } else {
                System.out.println("\nNão há clientes masculinos cadastrados");
            }
        } else if (clientList.clients.size() > 1) {
            for (int index = 0; index < clientList.clients.size(); index++) {
                if (clientList.clients.get(index).getGen().equalsIgnoreCase("Masculino")) {
                    if (count == 0) {
                        years += clientList.clients.get(index).getYears();
                        validate = true;
                        count++;
                    } else {
                        years += clientList.clients.get(index).getYears();
                        years /= 2;
                        validate = true;
                    }
                }
            }
            if (validate) {
                System.out.println("\nA média de idade é: " + df.format(years));
            } else {
                System.out.println("\nNão há clientes masculinos cadastrados");
            }
        } else {
            System.out.println("\nNão há clientes cadastrados");
        }
    }

    private void yearsF() {
        float years = 0;
        boolean validate = false;
        int count = 0;
        if (clientList.clients.size() == 1) {
            if (clientList.clients.get(0).getGen().equalsIgnoreCase("Feminino")) {
                System.out.println(clientList.clients.get(0).getYears());
            } else {
                System.out.println("\nNão há clientes femininos cadastrados");
            }
        } else if (clientList.clients.size() > 1) {
            for (int index = 0; index < clientList.clients.size(); index++) {
                if (clientList.clients.get(index).getGen().equalsIgnoreCase("Feminino")) {
                    if (count == 0) {
                        years += clientList.clients.get(index).getYears();
                        validate = true;
                        count++;
                    } else {
                        years += clientList.clients.get(index).getYears();
                        years /= 2;
                        validate = true;
                    }
                }
            }
            if (validate) {
                System.out.println("\nA média de idade é: " + df.format(years));
            } else {
                System.out.println("\nNão há clientes femininos cadastrados");
            }
        } else {
            System.out.println("\nNão há clientes cadastrados");
        }
    }

    private void servicesG() {
        int count = 0;
        int[] countServ = new int[13];
        System.out.println(" ");
        if (clientList.clients.size() == 1) {
            boolean validate = false;
            for (int index = 0; index < 13; index++) {
                if (clientList.clients.get(0).getServices(index) == true) {
                    System.out.println(clientList.services[index]);
                    validate = true;
                }
            }
            if (!validate) {
                System.out.println("\nNão há serviços cadastrados");
            }
        } else if (clientList.clients.size() > 1) {
            boolean validate = false;
            for (int index = 0; index < clientList.clients.size(); index++) {
                for (int i = 0; i < 13; i++) {
                    if (clientList.clients.get(index).getServices(i) == true) {
                        countServ[i] += 1;
                        validate = true;
                    }
                }
            }
            if (validate) {
                for (int index = 0; index < 13; index++) {
                    if (countServ[index] > count) {
                        count = index;
                    }
                }
                System.out.println(clientList.services[count]);
            } else {
                System.out.println("\nNão há serviços cadastrados");
            }
        } else {
            System.out.println("\nNão há clientes cadastrados");
        }
    }

    private void servicesM() {
        int count = 0;
        int[] countServ = new int[13];
        for (int i = 0; i < 13; i++) {
            countServ[i] = 0;
        }
        System.out.println(" ");
        if (clientList.clients.size() == 1) {
            if (clientList.clients.get(0).getGen().equalsIgnoreCase("Masculino")) {
                boolean validate = false;
                for (int index = 0; index < 13; index++) {
                    if (clientList.clients.get(0).getServices(index) == true) {
                        System.out.println(clientList.services[index]);
                        validate = true;
                    }
                }
                if (!validate) {
                    System.out.println("\nNão há serviços cadastrados");
                }
            }
        } else if (clientList.clients.size() > 1) {
            boolean validate = false;
            for (int index = 0; index < clientList.clients.size(); index++) {
                if (clientList.clients.get(index).getGen().equalsIgnoreCase("Masculino")) {
                    for (int i = 0; i < 13; i++) {
                        if (clientList.clients.get(index).getServices(i) == true) {
                            countServ[i] += 1;
                            validate = true;
                        }
                    }
                }
            }
            if (validate) {
                for (int index = 0; index < 13; index++) {
                    if (countServ[index] > count) {
                        count = index;
                    }
                }
                System.out.println(clientList.services[count]);
            } else {
                System.out.println("Não há serviços masculinos cadastrados");
            }
        } else {
            System.out.println("\nNão há clientes/serviços cadastrados");
        }
    }

    private void servicesF() {
        int count = 0;
        int[] countServ = new int[13];
        for (int i = 0; i < 13; i++) {
            countServ[i] = 0;
        }
        System.out.println(" ");
        if (clientList.clients.size() == 1) {
            if (clientList.clients.get(0).getGen().equalsIgnoreCase("Feminino")) {
                boolean validate = false;
                for (int index = 0; index < 13; index++) {
                    if (clientList.clients.get(0).getServices(index) == true) {
                        System.out.println(clientList.services[index]);
                        validate = true;
                    }
                }
                if (!validate) {
                    System.out.println("\nNão há serviços cadastrados");
                }
            }
        } else if (clientList.clients.size() > 1) {
            boolean validate = false;
            for (int index = 0; index < clientList.clients.size(); index++) {
                if (clientList.clients.get(index).getGen().equalsIgnoreCase("Feminino")) {
                    for (int i = 0; i < 13; i++) {
                        if (clientList.clients.get(index).getServices(i) == true) {
                            countServ[i] += 1;
                            validate = true;
                        }
                    }
                }
            }
            if (validate) {
                for (int index = 0; index < 13; index++) {
                    if (countServ[index] > count) {
                        count = index;
                    }
                }
                System.out.println(clientList.services[count]);
            } else {
                System.out.println("Não há serviços femininos cadastrados");
            }
        } else {
            System.out.println("\nNão há clientes/serviços cadastrados");
        }
    }
}