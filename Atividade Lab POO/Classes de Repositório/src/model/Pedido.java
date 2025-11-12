package model;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens;
    private LocalDateTime dataHora;
    private float valorFinal;
    private String status;

    public Pedido(List<ItemPedido> itens) {
        this.itens = itens;
        this.dataHora = LocalDateTime.now();
        this.status = "Em andamento";
        calcularValorFinal();
    }

    private void calcularValorFinal() {
        float total = 0;
        for (ItemPedido item : itens) {
            total += item.getValorPedido();
        }
        this.valorFinal = total;
    }

    public String getDataHora() {
        return dataHora.toString();
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public String getStatus() {
        return status;
    }
}
