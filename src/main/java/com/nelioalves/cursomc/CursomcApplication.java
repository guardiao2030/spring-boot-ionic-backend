package com.nelioalves.cursomc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.CategoriaDomain;
import com.nelioalves.cursomc.domain.CidadeDomain;
import com.nelioalves.cursomc.domain.ClienteDomain;
import com.nelioalves.cursomc.domain.EnderecoDomain;
import com.nelioalves.cursomc.domain.EstadoDomain;
import com.nelioalves.cursomc.domain.ItemPedidoDomain;
import com.nelioalves.cursomc.domain.PagamentoComBoleto;
import com.nelioalves.cursomc.domain.PagamentoComCartao;
import com.nelioalves.cursomc.domain.PagamentoDomain;
import com.nelioalves.cursomc.domain.PedidoDomain;
import com.nelioalves.cursomc.domain.ProdutosDomain;
import com.nelioalves.cursomc.domain.enums.EstadoPagamentoEnum;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.*;


//localhost:8081/categorias/2
//localhost:8081/clientes/1
//localhost:8081/pedidos/3


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CategoriaDomain cat1 = new CategoriaDomain(null,"informática");
		CategoriaDomain cat2 = new CategoriaDomain(null,"escritório");
		CategoriaDomain cat3 = new CategoriaDomain(null,"cama mesa e banho");
		CategoriaDomain cat4 = new CategoriaDomain(null,"eletronicos");
		CategoriaDomain cat5 = new CategoriaDomain(null,"jardinagem");
		CategoriaDomain cat6 = new CategoriaDomain(null,"decoração");
		CategoriaDomain cat7 = new CategoriaDomain(null,"perfumaria");
		CategoriaDomain cat8 = new CategoriaDomain(null,"farmacia");
		
		ProdutosDomain p1 = new ProdutosDomain(null, "Computador", 2000.00);
		ProdutosDomain p2 = new ProdutosDomain(null, "Impressora", 800.00);
		ProdutosDomain p3 = new ProdutosDomain(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7,cat8));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		EstadoDomain est1 = new EstadoDomain(null,"Minas Gerais");
		EstadoDomain est2 = new EstadoDomain(null,"São Paulo");
		
		CidadeDomain c1 = new CidadeDomain(null,"Uberlândia",est1);
		CidadeDomain c2 = new CidadeDomain(null,"São Paulo",est2);
		CidadeDomain c3 = new CidadeDomain(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		ClienteDomain cli1 = new ClienteDomain(null,"Maria Silva","Maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		EnderecoDomain e1 = new EnderecoDomain(null,"Rua Flores","300","Apto 203","Jardim","38220834",cli1,c1);
		EnderecoDomain e2 = new EnderecoDomain(null,"Avenida Matos","105","Sala 800","Centro","38777012",cli1,c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		PedidoDomain ped1 = new PedidoDomain(null,sdf.parse("30/09/2017 12:32"),cli1,e1);
		PedidoDomain ped2 = new PedidoDomain(null,sdf.parse("10/10/2017 19:35"),cli1,e2);
		
		PagamentoDomain pagto1 = new PagamentoComCartao(null, EstadoPagamentoEnum.QUITADO, ped1, 6);
		
		ped1.setPagamento(pagto1);
		
		PagamentoDomain pagto2 = new PagamentoComBoleto(null, EstadoPagamentoEnum.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),null);

		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedidoDomain ip1 = new ItemPedidoDomain(ped1, p1, 0.00, 1, 2000.00); 
		ItemPedidoDomain ip2 = new ItemPedidoDomain(ped1, p3, 0.00, 2, 80.00);
		ItemPedidoDomain ip3 = new ItemPedidoDomain(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped1.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
	}

}
