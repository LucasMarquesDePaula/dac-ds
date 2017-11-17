package br.ufpr.tads.dac.ds.facede;

import br.ufpr.tads.dac.ds.dao.Dao;
import br.ufpr.tads.dac.ds.dao.EntregaDao;
import br.ufpr.tads.dac.ds.model.Entrega;

/**
 *
 * @author Lucas
 */
public class EntregaFacede extends CrudFacede<Entrega> {

    private Dao<Entrega> dao;

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
