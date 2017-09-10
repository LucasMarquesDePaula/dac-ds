package br.ufpr.tads.dac.ds.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte ativo;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;

	private String email;

	@Lob
	private byte[] foto;

	private byte gerente;

	private String nome;

	private String senha;

	//bi-directional many-to-one association to Entrega
	@OneToMany(mappedBy="funcionario_entrega")
	private List<Entrega> entregas;

	//bi-directional many-to-one association to Entrega
	@OneToMany(mappedBy="funcionario_cancelamento")
	private List<Entrega> entregasCanceladas;

	public Funcionario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public byte getGerente() {
		return this.gerente;
	}

	public void setGerente(byte gerente) {
		this.gerente = gerente;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Entrega> getEntregas() {
		return this.entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Entrega addEntrega(Entrega entrega) {
		getEntregas().add(entrega);
		entrega.setFuncionario_entrega(this);

		return entrega;
	}

	public Entrega removeEntrega(Entrega entrega) {
		getEntregas().remove(entrega);
		entrega.setFuncionario_entrega(null);

		return entrega;
	}

	public List<Entrega> getEntregasCanceladas() {
		return this.entregasCanceladas;
	}

	public void setEntregasCanceladas(List<Entrega> entregasCanceladas) {
		this.entregasCanceladas = entregasCanceladas;
	}

	public Entrega addEntregasCancelada(Entrega entregasCancelada) {
		getEntregasCanceladas().add(entregasCancelada);
		entregasCancelada.setFuncionario_cancelamento(this);

		return entregasCancelada;
	}

	public Entrega removeEntregasCancelada(Entrega entregasCancelada) {
		getEntregasCanceladas().remove(entregasCancelada);
		entregasCancelada.setFuncionario_cancelamento(null);

		return entregasCancelada;
	}

}