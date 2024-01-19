package Apps.Customers.services;

import Apps.Customers.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EntityService {
    private final HashMap<Integer, Entity> entities;

    public EntityService() {
        this.entities = new HashMap<>();

        seedEntityService();
    }

    private void seedEntityService() {
    }

    public void insertIndividualEntity(IndividualInfo info) {
        var entity = new IndividualEntity(info);
        entities.put(entity.getId(), entity);
    }

    public void insertLegalEntity(LegalInfo info) {
        var entity = new LegalEntity(info);
        entities.put(entity.getId(), entity);
    }

    public Entity getEntityById(int id) {
        return entities.get(id);
    }

    public void removeEntity(int id) {
        entities.remove(id);
    }

    public void updateIndividualEntity(int id, IndividualInfo info) {
        var entity = (IndividualEntity) getEntityById(id);
        entity.setInfo(info);
    }

    public void updateLegalEntity(int id, LegalInfo info) {
        var entity = (LegalEntity) getEntityById(id);
        entity.setInfo(info);
    }

    public Map<Integer, Entity> search(String query) {
        var result = entities
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().searchBy(query))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new HashMap<>(result);
    }
}
