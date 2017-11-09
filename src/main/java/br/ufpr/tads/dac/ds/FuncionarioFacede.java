package br.ufpr.tads.dac.ds;

import br.ufpr.tads.dac.ds.dao.Dao;
import br.ufpr.tads.dac.ds.dao.FuncionarioDao;
import br.ufpr.tads.dac.ds.model.Funcionario;

/**
 *
 * @author Lucas
 */
public class FuncionarioFacede extends CrudFacede<Funcionario> {

    private FuncionarioDao dao;

    @Override
    protected void beforeSave(Funcionario model, Dao<Funcionario> dao) throws ValidationException {
    }

    @Override
    protected void beforeDelete(Funcionario model, Dao<Funcionario> dao) throws IllegalOperationException {
    }

    @Override
    protected Dao<Funcionario> getDao() {
        if (dao == null) {
            dao = new FuncionarioDao();
        }
        return dao;
    }

}
