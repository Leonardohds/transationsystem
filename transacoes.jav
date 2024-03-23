import java.util.HashMap;
import java.util.Map;

class SistemaTransacoes {
    private Map<String, Empresa> empresas;

    public SistemaTransacoes() {
        empresas = new HashMap<>();
    }

    public void adicionarEmpresa(Empresa empresa) {
        empresas.put(empresa.getCnpj(), empresa);
    }

    public void realizarTransacao(Cliente cliente, Empresa empresa, double valor) {
        // Verifica se a empresa existe
        if (!empresas.containsKey(empresa.getCnpj())) {
            System.out.println("Empresa não encontrada.");
            return;
        }

        // Verifica se há saldo suficiente na empresa
        if (empresa.getSaldo() < valor) {
            System.out.println("Saldo insuficiente na empresa.");
            return;
        }

        // Calcula a taxa de transação (exemplo: 5% do valor)
        double taxa = valor * 0.05;

        // Deduz o valor da taxa do saldo da empresa
        empresa.sacar(valor + taxa);

        // Adiciona a transação à empresa
        empresa.adicionarTransacao(new Transacao(cliente, empresa, valor));

        // Simula envio de callback para a empresa
        System.out.println("Callback enviado para empresa: Transação realizada");

        // Simula envio de notificação para o cliente
        System.out.println("Notificação enviada para cliente: Transação realizada");
    }
}
