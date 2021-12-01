import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import exceptions.DocumentException;
import exceptions.DriverException;
import exceptions.VehicleException;
import exceptions.VehicleIsNotFreeException;


public class App {
    
    static CadastroFuncionarios funcionarios;
    static CadastroVeiculos veiculos;
    static CadastroFretamentos fretes;
    static boolean running;
    static final Scanner input = new Scanner(System.in);
    static String res;

    public static void main(String args[]) throws DocumentException, DriverException, VehicleException {

        funcionarios = new CadastroFuncionarios();
        veiculos = new CadastroVeiculos();
        fretes = new CadastroFretamentos();

        running = true;

        Cnh cnh1 = new Cnh("28934898453", CategoriaCnh.C, LocalDate.of(2030,9,11));
        Motorista mot1 = new Motorista("Lewis Hamilton", LocalDate.of(1987,5,25), "12345678910", cnh1, false, false);

        Cnh cnh2 = new Cnh("78936925814", CategoriaCnh.B, LocalDate.of(2022,10,17));
        Motorista mot2 = new Motorista("Ayrton Senna", LocalDate.of(1960,11,1), "98765432100", cnh2, true, false);

        Cnh cnh3 = new Cnh("00011155577", CategoriaCnh.E, LocalDate.of(2040,10,17));
        Motorista mot3 = new Motorista("Nelson Piquet", LocalDate.of(1950,1,5), "11122233355", cnh3, true, true);

        Cnh cnh4 = new Cnh("99977766669", CategoriaCnh.D, LocalDate.of(2040,10,17));
        Motorista mot4 = new Motorista("Fernando Alonso", LocalDate.of(1980,8,9), "44422588714", cnh4, false, true);

        Cnh cnh5 = new Cnh("66688877711", CategoriaCnh.B, LocalDate.of(2023,3,17));
        Manobrista man1 = new Manobrista("Max Verstappen",LocalDate.of(1999,11,30), "04166081455", cnh5);

        Administrativo adm1 = new Administrativo("Michael Schumacher", LocalDate.of(1983,4,4), "12398745388");

        funcionarios.cadastra(mot1);
        funcionarios.cadastra(mot2);
        funcionarios.cadastra(mot3);
        funcionarios.cadastra(mot4);
        funcionarios.cadastra(man1);
        funcionarios.cadastra(adm1);

        VeiculoPasseio veiculo1 = new VeiculoPasseio("por7777", "Porshe Panamera Turbo S", 2010, 2048.3);
        VeiculoPasseio veiculo2 = new VeiculoPasseio("bmw7814", "BMW X6", 2015, 2748.3);
        VeiculoPasseio veiculo3 = new VeiculoPasseio("gol1234", "Volkswagen Golf GTI", 2021, 1897.1);

        VeiculoCarga veiculo4 = new VeiculoCarga("ram2500", "Dodge RAM 2500", 2022, 3768.45, 1594.45, 2, false);
        VeiculoCarga veiculo5 = new VeiculoCarga("ram3500", "Dodge RAM 3500", 2019, 6349.23, 3428, 3, false);
        VeiculoCarga veiculo6 = new VeiculoCarga("for0150", "Ford F-150 Raptor", 2021, 3045.1, 1123.3, 2, false);
        VeiculoCarga veiculo7 = new VeiculoCarga("vol0540", "Volvo FH 540", 2017, 13045.1, 46238.9, 7, true);
        VeiculoCarga veiculo8 = new VeiculoCarga("scn0450", "Scania R 450", 2021, 11045.1, 39238.9, 5, true);
        
        VeiculoPassageiros veiculo9 = new VeiculoPassageiros("spi7349", "Chevrolet Spin", 2016, 1584.8, 7);
        VeiculoPassageiros veiculo10 = new VeiculoPassageiros("ren9876", "Renault Master", 2009, 3184.9, 19);
        VeiculoPassageiros veiculo11 = new VeiculoPassageiros("vol8448", "Volkswagen Kombi", 2000, 2500.3, 15);
        VeiculoPassageiros veiculo12 = new VeiculoPassageiros("onn8912", "Onibus Mercedes", 2011, 10500.5, 40);
        VeiculoPassageiros veiculo13 = new VeiculoPassageiros("oni9321", "Onibus Marcopolo", 2011, 11980.5, 53);
        
        veiculos.cadastra(veiculo1);
        veiculos.cadastra(veiculo2);
        veiculos.cadastra(veiculo3);
        veiculos.cadastra(veiculo4);
        veiculos.cadastra(veiculo5);
        veiculos.cadastra(veiculo6);
        veiculos.cadastra(veiculo7);
        veiculos.cadastra(veiculo8);
        veiculos.cadastra(veiculo9);
        veiculos.cadastra(veiculo10);
        veiculos.cadastra(veiculo11);
        veiculos.cadastra(veiculo12);
        veiculos.cadastra(veiculo13);



        FretamentoCargas frete1 = new FretamentoCargas(LocalDate.of(2021,5,25), LocalDate.of(2021,6,25), 4385.45, false);
        frete1.setVeiculo(veiculo4);
        frete1.setCondutor(mot1);

        FretamentoCargas frete2 = new FretamentoCargas(LocalDate.of(2019,10,25), LocalDate.of(2020,1,25), 19172, false);
        frete2.setVeiculo(veiculo4);
        frete2.setCondutor(mot1);

        FretamentoCargas frete3 = new FretamentoCargas(LocalDate.of(2010,2,1), LocalDate.of(2010,3,25), 8741, true);
        frete3.setVeiculo(veiculo6);
        frete3.setCondutor(mot2);

        FretamentoCargas frete4 = new FretamentoCargas(LocalDate.of(2021,2,1), LocalDate.of(2021,8,25), 478741, true);
        frete4.setVeiculo(veiculo7);
        frete4.setCondutor(mot3);

        FretamentoCargas frete5 = new FretamentoCargas(LocalDate.of(2019,9,9), LocalDate.of(2019,9,30), 6741, false);
        frete5.setVeiculo(veiculo5);
        frete5.setCondutor(mot1);

        FretamentoPassageiros frete6 = new FretamentoPassageiros(LocalDate.of(2021,5,25), LocalDate.of(2021,6,2), 11385.99);
        frete6.setVeiculo(veiculo9);
        frete6.setCondutor(mot3);

        FretamentoPassageiros frete7 = new FretamentoPassageiros(LocalDate.of(2021,8,1), LocalDate.of(2021,9,15), 35385.99);
        frete7.setVeiculo(veiculo13);
        frete7.setCondutor(mot4);

        FretamentoPassageiros frete8 = new FretamentoPassageiros(LocalDate.of(2021,1,1), LocalDate.of(2021,1,4), 3385.99);
        frete8.setVeiculo(veiculo11);
        frete8.setCondutor(mot4);

        FretamentoPassageiros frete9 = new FretamentoPassageiros(LocalDate.of(2021,8,1), LocalDate.of(2022,9,15), 35385.99);
        frete9.setVeiculo(veiculo10);
        frete9.setCondutor(mot3);

        fretes.cadastra(frete1);
        fretes.cadastra(frete2);
        fretes.cadastra(frete3);
        fretes.cadastra(frete4);
        fretes.cadastra(frete5);
        fretes.cadastra(frete6);
        fretes.cadastra(frete7);
        fretes.cadastra(frete8);
        fretes.cadastra(frete9);

        while (running) {
            menuPrincipal();
        }

    }

    public static void menuPrincipal() {

        clear();
        System.out.println("========= CONTROLE DE FROTAS DE VEICULOS =========");
        System.out.println("1. Funcionarios");
        System.out.println("2. Veiculos");
        System.out.println("3. Fretamentos");
        System.out.println("4. Sair do sistema");
        System.out.print("\n> Escolha uma opcao: ");

        res = input.next();

        sleep(0.2);
        switch(res) {

            case "1":
                clear();
                menuFuncionarios();
                break;
            case "2":
                clear();
                menuVeiculos();
                break;
            case "3":
                clear();
                menuFretamentos();
                break;
            case "4":
                System.out.println("Saindo do sistema...");
                running = false;
                break;
            default:
                System.out.println("Opcao invalida...");
                sleep(0.25);
                menuPrincipal();
                break;

        }

    }

    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long)(seconds*1000));
        }
        catch (InterruptedException e) {}
    }

    public static void menuFuncionarios() {

        System.out.println("========= CONTROLE DE FUNCIONARIOS =========");
        System.out.println("1. Cadastrar funcionario");
        System.out.println("2. Listar funcionarios em ordem alfabetica");
        System.out.println("3. Buscar funcionario por cpf");
        System.out.println("4. Voltar");
        System.out.print("\n> Escolha uma opcao: ");

        res = input.next();

        sleep(0.2);
        switch(res) {

            case "1":
                clear();
                cadastrarFuncionario();
                break;
            case "2":
                clear();
                listarFuncionarios();
                break;
            case "3":
                clear();
                buscarFuncionarioCpf();
                break;
            case "4":
                clear();
                menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida...");
                sleep(0.25);
                menuFuncionarios();
                break;

        }

    }

    public static void cadastrarFuncionario() {

        System.out.println("========= CADASTRO DE FUNCIONARIO =========");
        System.out.println("1. Administrativo");
        System.out.println("2. Manobrista");
        System.out.println("3. Motorista");
        System.out.println("4. Voltar");
        System.out.print("\n> Escolha uma opcao: ");

        res = input.next();

        sleep(1);
        if (res.equals("4")) {
            menuFuncionarios();
        }
        else if (Arrays.asList("1","2","3").contains(res)) {

            String nome;
            LocalDate nasc;
            String cpf;

            input.nextLine();
            System.out.println("\n> Insira o nome: ");
            nome = input.nextLine();

            System.out.println("> Insira a data de nascimento (yyyy-mm-dd)): ");
            nasc = LocalDate.parse(input.nextLine());
           
            System.out.println("> Insira o cpf: ");
            cpf = input.nextLine();

            if (res.equals("1")) {

                try {
                    Administrativo func = new Administrativo(nome, nasc, cpf);
                    funcionarios.cadastra(func);
                    clear();
                    System.out.println("\nFuncionario administrativo cadastrado com sucesso\n");
                    sleep(2);
                }
                catch (DocumentException e) {
                    clear();
                    System.out.println("\nNão foi possível cadastrar o funcionário");
                    System.out.println(e.getMessage()+"\n");
                    sleep(2);
                }
                
            }
            else {

                String numero;
                String cat;
                LocalDate venc;
                
                System.out.println("> Insira o número da cnh: ");
                numero = input.nextLine();

                System.out.println("> Insira a categoria: ");
                cat = input.nextLine().toUpperCase();

                System.out.println("> Insira a data de vencimento (yyyy-mm-dd)): ");
                venc = LocalDate.parse(input.nextLine());

                if (res.equals("2")) {

                    try {
                        Cnh cnh = new Cnh(numero, CategoriaCnh.valueOf(cat), venc);
                        Manobrista func = new Manobrista(nome, nasc, cpf, cnh);
                        funcionarios.cadastra(func);
                        clear();
                        System.out.println("\nFuncionario manobrista cadastrado com sucesso\n");
                        sleep(2);
                    }
                    catch (DocumentException e) {
                        clear();
                        System.out.println("\nNão foi possível cadastrar o funcionário");
                        System.out.println(e.getMessage()+"\n");
                        sleep(2);
                    }

                }
                else {

                    boolean cargasPerigosas;
                    boolean passageiros;

                    System.out.println("> Habilitado para cargas perigosas?(true or false): ");
                    cargasPerigosas = input.nextBoolean();

                    System.out.println("> Habilitado para cargas passageiros?(true or false): ");
                    passageiros = input.nextBoolean();

                    try {
                        Cnh cnh = new Cnh(numero, CategoriaCnh.valueOf(cat), venc);
                        Motorista func = new Motorista(nome, nasc, cpf, cnh, cargasPerigosas, passageiros);
                        funcionarios.cadastra(func);
                        clear();
                        System.out.println("\nFuncionario motorista cadastrado com sucesso\n");
                        sleep(2);
                    }
                    catch (DocumentException e) {
                        clear();
                        System.out.println("\nNão foi possível cadastrar o funcionário");
                        System.out.println(e.getMessage()+"\n");
                        sleep(2);
                    }

                }

            }
            menuFuncionarios();
        }
        else {
            System.out.println("Opcao invalida...");
            cadastrarFuncionario();
        }
    }

    public static void listarFuncionarios() {

        clear();
        System.out.println("\nLISTA DE FUNCIONARIOS:");
        int i = 1;
        for (Funcionario f : funcionarios.getEmOrdemAlfabetica()) {
            System.out.println(i+". "+f);
            i++;
        }
        System.out.println();
        menuFuncionarios();
    }

    public static void buscarFuncionarioCpf() {

        System.out.println("BUSCAR FUNCIONARIO");
        System.out.print("> Digite o CPF: ");
        String cpf = input.next();
        Funcionario f = funcionarios.getFuncionario(cpf);
        if (f != null) {
            System.out.println(f);
        }
        else {
            System.out.println("Nenhum funcionario para CPF "+cpf);
        }
        System.out.println();
        menuFuncionarios();

    }

    public static void menuVeiculos() {

        sleep(0.25);

        System.out.println("========= CONTROLE DE VEICULOS =========");
        System.out.println("1. Cadastrar veiculo");
        System.out.println("2. Listar veiculos em ordem de ano de fabricacao");
        System.out.println("3. Buscar veiculo por placa");
        System.out.println("4. Voltar");
        System.out.print("\n> Escolha uma opcao: ");

        res = input.next();

        sleep(0.25);
        switch(res) {

            case "1":
                clear();
                cadastrarVeiculo();
                break;
            case "2":
                clear();
                listarVeiculos();
                break;
            case "3":
                clear();
                buscaVeiculoPlaca();
                break;
            case "4":
                menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida...");
                menuVeiculos();
                break;

        }

    }

    public static void cadastrarVeiculo() {

        System.out.println("========= CADASTRO DE VEICULO =========");
        System.out.println("1. Passeio ou utilitario");
        System.out.println("2. Transporte de cargas");
        System.out.println("3. Transporte de passageiros");
        System.out.println("4. Voltar");
        System.out.print("\n> Escolha uma opcao: ");

        res = input.next();

        if (res.equals("4")) {
            menuVeiculos();
        }
        else if (Arrays.asList("1","2","3").contains(res)) {

            String placa;
            String modelo;
            int fabricacao;
            double peso;
            
            input.nextLine();
            System.out.println("\n> Insira a placa:");
            placa = input.nextLine();

            System.out.println("> Insira o modelo:");
            modelo = input.nextLine();

            System.out.println("> Insira o ano de fabricacao: ");
            fabricacao = Integer.parseInt(input.nextLine());

            System.out.println("> Insira o peso: ");
            peso = Double.valueOf(input.nextLine());

            if (res.equals("1")) {

                try {
                    VeiculoPasseio veiculo = new VeiculoPasseio(placa, modelo, fabricacao, peso);
                    veiculos.cadastra(veiculo);
                    clear();
                    System.out.println("\nVeiculo de passeio cadastrado com sucesso\n");
                    sleep(2);
                } catch (Exception e) {
                    clear();
                    System.out.println("\nNão foi possível cadastrar o veiculo");
                    System.out.println(e.getMessage()+"\n");
                    sleep(2);
                }

            }
            else if (res.equals("2")) {

                double capacidadeCarga;
                int numeroEixos;
                boolean unidadeAcoplada;

                System.out.println("> Insira a capacidade de carga: ");
                capacidadeCarga = Double.valueOf(input.nextLine());

                System.out.println("> Insira o numero de eixos: ");
                numeroEixos = Integer.parseInt(input.nextLine());

                System.out.println("> Tem uma unidade acoplada? (true or false) ");
                unidadeAcoplada = input.nextBoolean();

                try {
                    VeiculoCarga veiculo = new VeiculoCarga(placa, modelo, fabricacao, peso, capacidadeCarga, numeroEixos, unidadeAcoplada);
                    veiculos.cadastra(veiculo);
                    clear();
                    System.out.println("\nVeiculo de cargas cadastrado com sucesso\n");
                    sleep(2);
                } catch (Exception e) {
                    clear();
                    System.out.println("\nNão foi possível cadastrar o veiculo");
                    System.out.println(e.getMessage()+"\n");
                    sleep(2);
                }

            }
            else if (res.equals("3")) {

                int maxPassageiros;

                System.out.println("> Insira a capacidade de passageiros: ");
                maxPassageiros = Integer.parseInt(input.nextLine());

                try {
                    VeiculoPassageiros veiculo = new VeiculoPassageiros(placa, modelo, fabricacao, peso, maxPassageiros);
                    veiculos.cadastra(veiculo);
                    clear();
                    System.out.println("\nVeiculo de passageiros cadastrado com sucesso\n");
                    sleep(2);
                } catch (Exception e) {
                    clear();
                    System.out.println("\nNão foi possível cadastrar o veiculo");
                    System.out.println(e.getMessage()+"\n");
                    sleep(2);
                }

            }
            menuVeiculos();
        }
        else {
            System.out.println("Opcao invalida...");
            cadastrarVeiculo();
        }
        

    }

    public static void listarVeiculos() {

        clear();
        System.out.println("\nLISTA DE VEICULOS:");
        int i = 1;
        for (Veiculo v : veiculos.getEmOrdemFabricacao()) {
            System.out.println(i+". "+v);
            i++;
        }
        System.out.println();
        menuVeiculos();

    }

    public static void buscaVeiculoPlaca() {

        System.out.println("BUSCAR VEICULO");
        System.out.print("> Digite a placa: ");
        String placa = input.next();
        Veiculo v = veiculos.getVeiculo(placa);
        if (v != null) {
            System.out.println(v);
        }
        else {
            System.out.println("Nenhum veiculo para PLACA "+placa);
        }
        System.out.println();
        menuVeiculos();

    }

    public static void menuFretamentos() {

        sleep(0.25);

        System.out.println("========= CONTROLE DE FRETAMENTOS =========");
        System.out.println("1. Cadastrar fretamento de veículo");
        System.out.println("2. Listar motoristas livres");
        System.out.println("3. Listar veiculos livres");
        System.out.println("4. Listar historico de fretamentos");
        System.out.println("5. Listar top 5 veiculos mais lucrativos");
        System.out.println("6. Voltar");
        System.out.print("\n> Escolha uma opcao: ");

        res = input.next();

        sleep(0.25);
        switch(res) {

            case "1":
                clear();
                cadastrarFretamento();
                break;
            case "2":
                clear();
                listarMotoristasLivres();
                menuFretamentos();
                break;
            case "3":
                clear();
                listarVeiculosLivres();
                menuFretamentos();
                break;
            case "4":
                clear();
                listarHistoricoFretamentos();
                menuFretamentos();
                break;
            case "5":
                clear();
                listarVeiculosMaisLucrativos();
                menuFretamentos();
                break;  
            case "6":
                menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida...");
                menuFretamentos();
                break;

        }

    }

    public static void cadastrarFretamento() {

        System.out.println("========= CADASTRO DE FRETAMENTO =========");
        System.out.println("1. Fretamento de cargas");
        System.out.println("2. Fretamento de passageiros");
        System.out.println("3. Voltar");
        System.out.print("\n> Escolha uma opcao: ");

        res = input.next();

        if (res.equals("4")) {
            menuFretamentos();
        }
        else if (Arrays.asList("1","2").contains(res)) {

            Motorista condutor;
            LocalDate dataInicio;
            LocalDate dataTermino;
            double distanciaPercorrida;

            listarMotoristasLivres();
            input.nextLine();
            System.out.println("\n> Insira o id do condutor: ");
            int condutorId = Integer.parseInt(input.nextLine());
            condutor = funcionarios.getMotorista(condutorId);

            System.out.println("> Insira a data de inicio (yyyy-mm-dd)): ");
            dataInicio = LocalDate.parse(input.nextLine());

            System.out.println("> Insira a data de termino (yyyy-mm-dd)): ");
            dataTermino = LocalDate.parse(input.nextLine());

            System.out.println("> Insira a distacia percorrida: ");
            distanciaPercorrida = Double.valueOf(input.nextLine());

            if (res.equals("1")) {

                VeiculoCarga veiculo;
                boolean cargaPerigosa;

                listarVeiculosLivres();
                System.out.println("\n> Insira o id do veiculo de carga: ");
                int veiculoId = Integer.parseInt(input.nextLine());
                veiculo = veiculos.getVeiculoCarga(veiculoId);

                System.out.println("> É carga perigosa?(true or false): ");
                cargaPerigosa = input.nextBoolean();

                try {
                    FretamentoCargas frete = new FretamentoCargas(dataInicio, dataTermino, distanciaPercorrida, cargaPerigosa);
                    frete.setVeiculo(veiculo);
                    frete.setCondutor(condutor);
                    fretes.cadastra(frete);
                    clear();
                    System.out.println("\nFretamento de cargas cadastrado com sucesso\n");
                    sleep(2);
                } catch (Exception e) {
                    clear();
                    System.out.println("\nNão foi possível cadastrar o fretamento");
                    System.out.println(e.getMessage()+"\n");
                    sleep(2);
                }
            }
            else if (res.equals("2")) {

                VeiculoPassageiros veiculo;
                
                listarVeiculosLivres();
                System.out.println("> Insira o id do veiculo de passageiros: ");
                int veiculoId = Integer.parseInt(input.nextLine());
                veiculo = veiculos.getVeiculoPassageiros(veiculoId);

                try {
                    FretamentoPassageiros frete = new FretamentoPassageiros(dataInicio, dataTermino, distanciaPercorrida);
                    frete.setVeiculo(veiculo);
                    frete.setCondutor(condutor);
                    fretes.cadastra(frete);
                    clear();
                    System.out.println("\nFretamento de passageiros cadastrado com sucesso\n");
                    sleep(2);
                } catch (Exception e) {
                    clear();
                    System.out.println("\nNão foi possível cadastrar o fretamento");
                    System.out.println(e.getMessage()+"\n");
                    sleep(2);
                }

            }
            menuFretamentos();
        }
    }

    public static void listarMotoristasLivres() {
        System.out.println();
        System.out.println("MOTORISTAS LIVRES: ");
        fretes.atualizarStatusMotorista();
        int i = 1;
        for (Funcionario f : funcionarios.getEmOrdemAlfabetica()) {
            if (f instanceof Motorista) {
                if (f.isLivre()) {
                    System.out.println(i+". "+f);
                    i++;
                }
            }
        }
        System.out.println();
        sleep(1);
    }

    public static void listarVeiculosLivres() {
        System.out.println();
        System.out.println("VEICULOS LIVRES:");
        fretes.atualizarStatusVeiculo();
        int i = 1;
        for (Veiculo v : veiculos.getEmOrdemFabricacao()) {
            if (v.isLivre()) {
                System.out.println(i+". "+v);
                i++;
            }
        }
        System.out.println();
        sleep(1);
    }

    public static void listarHistoricoFretamentos() {
        System.out.println();
        System.out.println("HISTORICO DE FRETAMENTOS:");
        int i = 1;
        for (Fretamento f : fretes.getFretamentos()) {    
            System.out.println(i+". "+f);
            i++;
        }
        System.out.println();
        sleep(1);
    }

    public static void listarVeiculosMaisLucrativos() {
        int LIMIT = 5;
        System.out.println();
        System.out.println("TOP "+LIMIT+" VEÍCULOS MAIS LUCRATIVOS:");

        fretes.getVeiculosMaisLucrativos().stream()
            .limit(LIMIT)
            .forEach(v -> System.out.println("("+v.getKey().getPlaca()+") "+v.getKey().getModelo()+" = R$"+v.getValue()));

        System.out.println();
        sleep(1);
    }

}
