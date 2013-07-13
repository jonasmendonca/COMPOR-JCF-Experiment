package br.ufcg.ppgcc.compor.jcf.experimento.fachada;

import java.util.ArrayList;
import java.util.List;

public class Fachada implements FachadaExperimento{

	GerenteTitular GerenteTitular = new GerenteTitular();
	
	
	@Override
	public void criarNovoTitular(Titular titular) {
		this.GerenteTitular.criarTitular(titular);
		//this.GerenteTitular.criarFontePagadora(titular);
	}

	@Override
	public List<Titular> listarTitulares() {
		return GerenteTitular.getTitulares();
	}

	@Override
	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		this.GerenteTitular.criarFontePagadora(titular,fonte);
		
	}

	@Override
	public Resultado declaracaoCompleta(Titular titular) {
		return this.GerenteTitular.declaracaoCompleta(titular);
	}

	@Override
	public void criarDependente(Titular titular, Dependente dependente) {
		this.GerenteTitular.adicionarDependente( titular, dependente);
		
	}

	@Override
	public List<FontePagadora> listarFontes(Titular titular) {
		return this.GerenteTitular.listarFontesPagadoras(titular);
	}

	@Override
	public List<Dependente> listarDependentes(Titular titular) {
		return this.GerenteTitular.listarDependentes(titular);
	}

	@Override
	public void criarGastoDedutivel(Titular titular, Pessoa realizador,
			GastoDedutivel gastoDedutivel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GastoDedutivel> listarGastosDedutiveis(Titular titular,
			Pessoa realizador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado relatorioSimplificado(Titular titular) {
		// TODO Auto-generated method stub
		return null;
	}

}
