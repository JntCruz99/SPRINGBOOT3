package br.com.farmaciaideal.FarmaciaIdeal.config;

import br.com.farmaciaideal.FarmaciaIdeal.entities.*;
import br.com.farmaciaideal.FarmaciaIdeal.entities.enums.CarrinhoStatus;
import br.com.farmaciaideal.FarmaciaIdeal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CarrinhoItemRepository carrinhoItemRepository;


    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Cliente u1 = new Cliente(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Cliente u2 = new Cliente(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        clienteRepository.saveAll(Arrays.asList(u1, u2));

        Carrinho o1 = new Carrinho(null, Instant.parse("2019-06-20T19:53:07Z"), CarrinhoStatus.PAID, u1);
        Carrinho o2 = new Carrinho(null, Instant.parse("2019-07-21T03:42:10Z"), CarrinhoStatus.WAITING_PAYMENT, u2);
        Carrinho o3 = new Carrinho(null, Instant.parse("2019-07-22T15:21:22Z"), CarrinhoStatus.WAITING_PAYMENT, u1);

        carrinhoRepository.saveAll(Arrays.asList(o1, o2, o3));

        CarrinhoItem oi1 = new CarrinhoItem(o1, p1, 2, p1.getPrice());
        CarrinhoItem oi2 = new CarrinhoItem(o1, p3, 1, p3.getPrice());
        CarrinhoItem oi3 = new CarrinhoItem(o2, p3, 2, p3.getPrice());
        CarrinhoItem oi4 = new CarrinhoItem(o3, p5, 2, p5.getPrice());

        carrinhoItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

    }
}
