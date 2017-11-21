package br.ufpr.tads.dac.ds.facede;

import br.ufpr.tads.dac.ds.dao.Dao;
import br.ufpr.tads.dac.ds.dao.EntregaDao;
import br.ufpr.tads.dac.ds.model.Entrega;
import br.ufpr.tads.dac.ds.model.Funcionario;
import java.util.Date;

/**
 *
 * @author Lucas
 */
public class EntregaFacede extends CrudFacede<Entrega> {

    private Dao<Entrega> dao;
    
    public Entrega confirmarEntrega(Integer id, Funcionario funcionario, Date dataHora) throws IllegalOperationException, NotFoundException, ValidationException {

        if (id == null) {
            throw new IllegalArgumentException("A entrega não foi informada.");
        }
        
        if (funcionario == null) {;
            throw new IllegalArgumentException("O funcionário não foi informado");
        }
        
        if (dataHora == null) {
            throw new IllegalArgumentException("A entrega não foi confirmada pois a data e hora não foram informadas.");
        }

        Entrega entrega = this.find(id);

        if (entrega.getCancelado() == 0x1) {
            throw new IllegalOperationException("A entrega está cancelada.");
        }

//        if (entrega.getEntregaFrustrada() == 0x1) {
//            throw new IllegalOperationException("A entrega não pode ser confirmada.");
//        }

        entrega.setEntregue((byte) 0x1);
        entrega.setDataHoraEntrega(dataHora);
        entrega.setFuncionarioEntrega(funcionario);

        this.save(entrega);

        return entrega;
    }
    
    public Entrega confirmarFrustracao(Integer id, String justificativa, Date dataHora) throws IllegalOperationException, NotFoundException, ValidationException {

        if (id == null) {
            throw new IllegalArgumentException("A entrega não foi informada.");
        }
        
        if (dataHora == null) {
            throw new IllegalArgumentException("A entrega não foi confirmada pois a data e hora não foram informadas.");
        }

        Entrega entrega = this.find(id);

//        if (entrega.getEntregaFrustrada() == 0x1) {
//            throw new IllegalOperationException("A entrega já está marcada como frustrada.");
//        }

        if (entrega.getEntregue() == 0x1) {
            throw new IllegalOperationException("A entrega não pode ser frustrada pois ja foi entregue.");
        }
        
        if (entrega.getCancelado() == 0x1) {
            throw new IllegalOperationException("A entrega não pode ser frustrada pois foi cancelada.");
        }

        entrega.setEntregaFrustrada((byte) 0x1);
        entrega.setDataHoraFrustracaoEntrega(dataHora);
        entrega.setJustificativaFrustracaoEntrega(justificativa);

        this.save(entrega);

        return entrega;
    }
    
    public Entrega cancelarEntrega(Integer id, Funcionario funcionario, Date dataHora) throws IllegalOperationException, NotFoundException, ValidationException {

        if (id == null) {
            throw new IllegalArgumentException("A entrega não foi informada.");
        }
        
        if (funcionario == null) {;
            throw new IllegalArgumentException("O funcionário não foi informado");
        }
        
        if (dataHora == null) {
            throw new IllegalArgumentException("A entrega não foi confirmada pois a data e hora não foram informadas.");
        }

        Entrega entrega = this.find(id);

        if (entrega.getCancelado() == 0x1) {
            throw new IllegalOperationException("A entrega já está cancelada.");
        }

        if (entrega.getEntregue() == 0x1) {
            throw new IllegalOperationException("A entrega não pode ser cancelada.");
        }

        entrega.setCancelado((byte) 0x1);
        entrega.setDataHoraCancelamento(dataHora);
        entrega.setFuncionarioCancelamento(funcionario);

        this.save(entrega);

        return entrega;
    }
    
    @Override
    protected void beforeSave(Entrega model, Dao<Entrega> dao) throws ValidationException {
    }

    @Override
    protected void beforeDelete(Entrega model, Dao<Entrega> dao) throws IllegalOperationException {
    }

    @Override
    protected Dao<Entrega> getDao() {
        if (dao == null) {
            dao = new EntregaDao();
        }
        return dao;
    }

}
