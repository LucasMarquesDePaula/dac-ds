package br.ufpr.tads.dac.ds.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the entrega database table.
 * 
 */
@Entity
@NamedQuery(name="Entrega.findAll", query="SELECT e FROM Entrega e")
public class Entrega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte cancelado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora_cadastro")
	private Date dataHoraCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora_cancelamento")
	private Date dataHoraCancelamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora_entrega")
	private Date dataHoraEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora_frustracao_entrega")
	private Date dataHoraFrustracaoEntrega;

	private String endereco;

	@Column(name="entrega_frustrada")
	private byte entregaFrustrada;

	private byte entregue;

	@Column(name="justificativa_frustracao_entrega")
	private String justificativaFrustracaoEntrega;

	@Column(name="nome_cliente")
	private String nomeCliente;

	private String observacao;

	@Column(name="pedido_id")
	private int pedidoId;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	private Funcionario funcionario_entrega;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	private Funcionario funcionario_cancelamento;

	public Entrega() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getCancelado() {
		return this.cancelado;
	}

	public void setCancelado(byte cancelado) {
		this.cancelado = cancelado;
	}

	public Date getDataHoraCadastro() {
		return this.dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Date getDataHoraCancelamento() {
		return this.dataHoraCancelamento;
	}

	public void setDataHoraCancelamento(Date dataHoraCancelamento) {
		this.dataHoraCancelamento = dataHoraCancelamento;
	}

	public Date getDataHoraEntrega() {
		return this.dataHoraEntrega;
	}

	public void setDataHoraEntrega(Date dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public Date getDataHoraFrustracaoEntrega() {
		return this.dataHoraFrustracaoEntrega;
	}

	public void setDataHoraFrustracaoEntrega(Date dataHoraFrustracaoEntrega) {
		this.dataHoraFrustracaoEntrega = dataHoraFrustracaoEntrega;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public byte getEntregaFrustrada() {
		return this.entregaFrustrada;
	}

	public void setEntregaFrustrada(byte entregaFrustrada) {
		this.entregaFrustrada = entregaFrustrada;
	}

	public byte getEntregue() {
		return this.entregue;
	}

	public void setEntregue(byte entregue) {
		this.entregue = entregue;
	}

	public String getJustificativaFrustracaoEntrega() {
		return this.justificativaFrustracaoEntrega;
	}

	public void setJustificativaFrustracaoEntrega(String justificativaFrustracaoEntrega) {
		this.justificativaFrustracaoEntrega = justificativaFrustracaoEntrega;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getPedidoId() {
		return this.pedidoId;
	}

	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Funcionario getFuncionario_entrega() {
		return this.funcionario_entrega;
	}

	public void setFuncionario_entrega(Funcionario funcionario_entrega) {
		this.funcionario_entrega = funcionario_entrega;
	}

	public Funcionario getFuncionario_cancelamento() {
		return this.funcionario_cancelamento;
	}

	public void setFuncionario_cancelamento(Funcionario funcionario_cancelamento) {
		this.funcionario_cancelamento = funcionario_cancelamento;
	}

}