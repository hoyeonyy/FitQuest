package fitrecommend.fitquest.repository;

import fitrecommend.fitquest.domain.Sets;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SetRepository {
    private final EntityManager em;

    public void save(Sets sets){
        em.persist(sets);
    }

    public Sets findOne(Long id){
        return em.find(Sets.class, id);
    }

    public List<Sets> findAll(){
        return em.createQuery("select s from Sets s", Sets.class)
                .getResultList();
    }
}
