package program.repository.Impl;

import org.springframework.stereotype.Repository;
import program.model.Product;
import program.repository.BaseRepository;
import program.repository.IProductRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select s from Product s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product getProductById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void delete(Integer id) {
        Product product = getProductById(id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public void update(Product product) {
        BaseRepository.entityManager.merge(product);
    }

    @Override
    public List<Product> getProductByName(String name) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select s " +
                "from Product s " +
                "where s.name like :ProductName", Product.class);
        typedQuery.setParameter("ProductName","%"+name+"%");
        return typedQuery.getResultList();
    }
}
