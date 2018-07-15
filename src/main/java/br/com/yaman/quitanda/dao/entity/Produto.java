package br.com.yaman.quitanda.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {

	@Id
	@SequenceGenerator(schema = "QUITANDA", name = "ProdutoSeq", sequenceName = "SEQ_COD_PRODUTO", allocationSize = 1)
	@GeneratedValue(generator = "ProdutoSeq")
	@Column(name = "COD_PRODUTO")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "COD_TIPO_PRODUTO")
	private TipoProduto tipoProduto;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "CALORIAS")
	private Double calorias;

	@Column(name = "PESO_MEDIO")
	private Double pesoMedio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getCalorias() {
		return calorias;
	}

	public void setCalorias(Double calorias) {
		this.calorias = calorias;
	}

	public Double getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calorias == null) ? 0 : calorias.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pesoMedio == null) ? 0 : pesoMedio.hashCode());
		result = prime * result + ((tipoProduto == null) ? 0 : tipoProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (calorias == null) {
			if (other.calorias != null)
				return false;
		} else if (!calorias.equals(other.calorias))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pesoMedio == null) {
			if (other.pesoMedio != null)
				return false;
		} else if (!pesoMedio.equals(other.pesoMedio))
			return false;
		if (tipoProduto == null) {
			if (other.tipoProduto != null)
				return false;
		} else if (!tipoProduto.equals(other.tipoProduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", tipoProduto=" + tipoProduto + ", descricao=" + descricao
				+ ", calorias=" + calorias + ", pesoMedio=" + pesoMedio + "]";
	}

}
