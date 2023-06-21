package br.com.farmaciaideal.FarmaciaIdeal.entities;

import br.com.farmaciaideal.FarmaciaIdeal.entities.enums.CarrinhoStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_carrinho")
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    private Integer carrinhoStatus;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "id.carrinho")
    private Set<CarrinhoItem> items = new HashSet<>();

    public Carrinho(){
    }

    public Carrinho(Long id, Instant moment, CarrinhoStatus carrinhoStatus, Cliente cliente) {
        super();
        this.id = id;
        this.moment = moment;
        this.cliente = cliente;
        setCarrinhoStatus(carrinhoStatus);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public CarrinhoStatus getCarrinhoStatus() {
        return CarrinhoStatus.valueOf(carrinhoStatus);
    }

    public void setCarrinhoStatus(CarrinhoStatus carrinhoStatus) {
        if (carrinhoStatus != null) {
            this.carrinhoStatus = carrinhoStatus.getCode();
        }
    }
    public Set<CarrinhoItem> getItems() {
        return items;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carrinho other = (Carrinho) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
