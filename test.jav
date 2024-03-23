import java.util.ArrayList;
import java.util.List;

class Empresa {
    private String cnpj;
    private double saldo;
    private List<Transacao> transacoes;

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }
}

class Cliente {
    private String cpf;

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}

class Transacao {
    private Cliente cliente;
    private Empresa empresa;
    private double valor;

    public Transacao(Cliente cliente, Empresa empresa, double valor) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public double getValor() {
        return valor;
    }
}

// Utilizando o sistema

public class Main {
    public static void main(String[] args) {
        SistemaTransacoes sistema = new SistemaTransacoes();

        Empresa empresa = new Empresa("12345678901234");
        sistema.adicionarEmpresa(empresa);

        Cliente cliente = new Cliente("98765432198");

        // Realiza uma transação de R$100 do cliente para a empresa
        sistema.realizarTransacao(cliente, empresa, 100.0);
    }
}