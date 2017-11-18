package br.ufpr.tads.dac.ds.model;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the entrega database table.
 *
 */
@Entity
@NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e")
public class Entrega extends Model<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Byte cancelado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_cadastro")
    private Date dataHoraCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_cancelamento")
    private Date dataHoraCancelamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_entrega")
    private Date dataHoraEntrega;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_frustracao_entrega")
    private Date dataHoraFrustracaoEntrega;

    private String endereco;

    @Column(name = "entrega_frustrada")
    private Byte entregaFrustrada;

    private Byte entregue;

    @Column(name = "justificativa_frustracao_entrega")
    private String justificativaFrustracaoEntrega;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    private String observacao;

    @Column(name = "pedido_id")
    private int pedidoId;

    //bi-directional many-to-one association to Funcionario
    @ManyToOne
    private Funcionario funcionarioEntrega;

    //bi-directional many-to-one association to Funcionario
    @ManyToOne
    private Funcionario funcionarioCancelamento;

    public Entrega() {
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getCancelado() {
        return this.cancelado;
    }

    public void setCancelado(Byte cancelado) {
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

    public Byte getEntregaFrustrada() {
        return this.entregaFrustrada;
    }

    public void setEntregaFrustrada(Byte entregaFrustrada) {
        this.entregaFrustrada = entregaFrustrada;
    }

    public Byte getEntregue() {
        return this.entregue;
    }

    public void setEntregue(Byte entregue) {
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

    public Funcionario getFuncionarioEntrega() {
        return this.funcionarioEntrega;
    }

    public void setFuncionarioEntrega(Funcionario funcionarioEntrega) {
        this.funcionarioEntrega = funcionarioEntrega;
    }

    public Funcionario getFuncionarioCancelamento() {
        return this.funcionarioCancelamento;
    }

    public void setFuncionarioCancelamento(Funcionario funcionarioCancelamento) {
        this.funcionarioCancelamento = funcionarioCancelamento;
    }

}
