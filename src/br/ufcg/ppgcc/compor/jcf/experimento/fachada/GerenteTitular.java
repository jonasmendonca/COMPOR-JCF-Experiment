package br.ufcg.ppgcc.compor.jcf.experimento.fachada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.jcf.experimento.util.CalculoImpostoRenda;

public class GerenteTitular {

	private List<Titular> titulares = new ArrayList<Titular>();
	private Map<Titular,List<FontePagadora>> fontespagadoras = new HashMap<Titular,List<FontePagadora>>();
	private Map<Titular,List<Dependente>> dependentes = new HashMap<Titular,List<Dependente>>();
	
	public List<Titular> getTitulares(){
		return this.titulares;
	}

	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		this.fontespagadoras.get(titular).add(fonte);
		
	}
	public void criarTitular(Titular titular){
		this.titulares.add(titular);
		this.fontespagadoras.put(titular, new ArrayList<FontePagadora>());
		this.dependentes.put(titular, new ArrayList<Dependente>());
	}
	
	public List<FontePagadora> listarFontesPagadoras(Titular titular){
		return this.fontespagadoras.get(titular);
	}

	public void adicionarDependente(Titular titular, Dependente dependente) {
		this.dependentes.get(titular).add(dependente);
		
	}

	public List<Dependente> listarDependentes(Titular titular) {
		return this.dependentes.get(titular);
	}

	public Resultado declaracaoCompleta(Titular titular) {
		List<FontePagadora> f = this.fontespagadoras.get(titular);
		CalculoImpostoRenda calculo = new CalculoImpostoRenda();
		double recebido = calculo.totalRecebido(f);
		recebido = calculo.descontoDependentes(recebido, this.dependentes.get(titular));
		double resultado2 = calculo.impostoDevido(recebido);
		Resultado resultado = new Resultado();
		resultado.setImpostoDevido(resultado2);
		return resultado;
		
	}
	
}
