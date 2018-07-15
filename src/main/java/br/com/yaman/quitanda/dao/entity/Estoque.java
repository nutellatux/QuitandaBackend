package br.com.yaman.quitanda.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ESTOQUE")
@SequenceGenerator(name = "EstoqueSeq", sequenceName = "SEQ_COD_ESTOQUE")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EstoqueSeq")
    @Column(name = "COD_ESTOQUE")
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "COD_PRODUTO")
    private Produto produto;

    @Column(name = "QTD_DISPONIVEL")
    private Integer quantidadeDisponivel;
	
    @Column(name = "QTD_TOTAL")
    private Integer quantidadeTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public Integer getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Integer quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidadeDisponivel == null) ? 0 : quantidadeDisponivel.hashCode());
		result = prime * result + ((quantidadeTotal == null) ? 0 : quantidadeTotal.hashCode());
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
		Estoque other = (Estoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidadeDisponivel == null) {
			if (other.quantidadeDisponivel != null)
				return false;
		} else if (!quantidadeDisponivel.equals(other.quantidadeDisponivel))
			return false;
		if (quantidadeTotal == null) {
			if (other.quantidadeTotal != null)
				return false;
		} else if (!quantidadeTotal.equals(other.quantidadeTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", produto=" + produto + ", quantidadeDisponivel=" + quantidadeDisponivel
				+ ", quantidadeTotal=" + quantidadeTotal + "]";
	}
	
	
    
    
    
    
    
}
