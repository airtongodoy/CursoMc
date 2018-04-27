package br.com.airtongodoy.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.airtongodoy.cursomc.domain.Categoria;
import br.com.airtongodoy.cursomc.domain.Cidade;
import br.com.airtongodoy.cursomc.domain.Cliente;
import br.com.airtongodoy.cursomc.domain.Endereco;
import br.com.airtongodoy.cursomc.domain.Estado;
import br.com.airtongodoy.cursomc.domain.Pagamento;
import br.com.airtongodoy.cursomc.domain.PagamentoComBoleto;
import br.com.airtongodoy.cursomc.domain.PagamentoComCartao;
import br.com.airtongodoy.cursomc.domain.Pedido;
import br.com.airtongodoy.cursomc.domain.Produto;
import br.com.airtongodoy.cursomc.domain.enums.EstadoPagamento;
import br.com.airtongodoy.cursomc.domain.enums.TipoCliente;
import br.com.airtongodoy.cursomc.repositories.CategoriaRepository;
import br.com.airtongodoy.cursomc.repositories.CidadeRepository;
import br.com.airtongodoy.cursomc.repositories.ClienteRepository;
import br.com.airtongodoy.cursomc.repositories.EnderecoRepository;
import br.com.airtongodoy.cursomc.repositories.EstadoRepository;
import br.com.airtongodoy.cursomc.repositories.PagamentoRepository;
import br.com.airtongodoy.cursomc.repositories.PedidoRepository;
import br.com.airtongodoy.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired 
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProdutoRepository produtoRepositoryProxy;
	
	@Autowired
	private CidadeRepository cidadeRepositoryProxy;

	@Autowired
	private EstadoRepository estadoRepositoryProxy;
	
	@Autowired
	private ClienteRepository clienteRepositoryProxy;
	
	@Autowired
	private EnderecoRepository enderecoRepositoryProxy;
	
	@Autowired
	private PedidoRepository pedidoRepositoryProxy;
	
	@Autowired
	private PagamentoRepository pagamentoRepositoryProxy;
	
	/*@Autowired  instancia automáticamente a classe pelo Spring pelo mecanisco de Injeção de dependencias*/
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
		produtoRepositoryProxy.saveAll(Arrays.asList(p1,p2,p3));
		
		//
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo",  est2);
		Cidade c3 = new Cidade(null, "Campinas",   est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepositoryProxy.saveAll(Arrays.asList(est1, est2));
		cidadeRepositoryProxy.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("46054605", "41324132"));
		
		Endereco end1 = new Endereco(null, "Rua que sobe e desce", "300", "Apto 123", "Jardim", "32828322", cli1, c1);
		Endereco end2 = new Endereco(null, "Rua do Lado", "54", "N/A", "De Cima", "12345", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepositoryProxy.save(cli1);
		enderecoRepositoryProxy.saveAll(Arrays.asList(end1,end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepositoryProxy.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepositoryProxy.saveAll(Arrays.asList(pagto1, pagto2));
	}
	
}
