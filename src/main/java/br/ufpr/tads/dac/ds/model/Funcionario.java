package br.ufpr.tads.dac.ds.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the funcionario database table.
 *
 */
@Entity
@NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
public class Funcionario extends Model<Integer> implements Authenticable, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private byte ativo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    private String email;

    private byte gerente;

    private String nome;

    private String senha;

    //bi-directional many-to-one association to Entrega
    @OneToMany(mappedBy = "funcionarioEntrega")
    private List<Entrega> entregas;

    //bi-directional many-to-one association to Entrega
    @OneToMany(mappedBy = "funcionarioCancelamento")
    private List<Entrega> entregasCanceladas;

    public Funcionario() {
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
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
        entrega.setFuncionarioEntrega(this);

        return entrega;
    }

    public Entrega removeEntrega(Entrega entrega) {
        getEntregas().remove(entrega);
        entrega.setFuncionarioEntrega(null);

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
        entregasCancelada.setFuncionarioCancelamento(this);

        return entregasCancelada;
    }

    public Entrega removeEntregasCancelada(Entrega entregasCancelada) {
        getEntregasCanceladas().remove(entregasCancelada);
        entregasCancelada.setFuncionarioCancelamento(null);

        return entregasCancelada;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public void setUsername(String userName) {
        this.setEmail(userName);
    }

    @Override
    public String getPassword() {
        return this.getSenha();
    }

    @Override
    public void setPassword(String password) {
        this.setSenha(Authenticable.Util.generateHash(String.format("#%d~!~%s#", this.getId(), password)));
    }

}
